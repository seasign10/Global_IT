package org.zerock.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.AttachFileDTO;

import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;

@Controller
@Log4j
public class UploadController {
	@GetMapping("/uploadForm")
	public void uploadForm() {}
	
	@PostMapping("/uploadFormAction")
	public void uploadFormPost(MultipartFile[] uploadFile, Model model) {
		// 업로드폴더 경로
		String uploadFolder = "C:\\upload\\temp";
	    File uploadPath = new File(uploadFolder);
	    
	    if (!uploadPath.exists()) {
	        uploadPath.mkdirs(); // 자동으로 생성
	    }
		
		for(MultipartFile multipartFile : uploadFile) {
			log.info("File Info================================================");
			log.info("Upload File Name : "+multipartFile.getOriginalFilename());
			log.info("Upload File Name : "+multipartFile.getSize());
			
			File saveFile=new File(uploadFolder, multipartFile.getOriginalFilename());
			
			try {
				multipartFile.transferTo(saveFile);
			}catch(Exception e) {e.printStackTrace();};
		}
	}
	@GetMapping("/uploadAjax")
	public void uploadAjax() {}
	
	//년월일 형식을 구하는 메서드
	private String getFolder() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		String str=sdf.format(date);
		return str.replace("-", File.separator);
	}
	
	//이미지여부 체크하는 메서드
	private boolean checkImageType(File file) {
		if (file == null || !file.exists()) {
	        System.out.println("파일이 null이거나 존재하지 않습니다: " + file);
	        return false;
	    }
		try {
			// 파일의 content type을 구함
			String contentType=Files.probeContentType(file.toPath());
			
			if (contentType == null) {
	            log.warn("파일의 contentType이 null입니다: " + file.getName());
	            return false;
	        }
			
			// 이미지파일은 content type이 'image'로 시작. 'image'로 시작하면 true
			return contentType.startsWith("image");
		}catch(Exception e) {e.printStackTrace();};
		return false;
	}
		
	// Upload with ajax
	@PostMapping("/uploadAjaxAction")
	@ResponseBody
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<AttachFileDTO>> uploadAjaxPost(MultipartFile[] uploadFile) {
		// 첨부파일 목록
		List<AttachFileDTO> list=new ArrayList();
		
		// 업로드폴더 경로
		String uploadFolder = "C:\\upload";
		
		// 임시폴더경로 (C:\\upload\\temp) 가 없을경우 처리
		String tempFolder = "C:\\upload\\temp";
		File tempPath = new File(tempFolder);
		if (!tempPath.exists()) {
			tempPath.mkdirs(); // 자동으로 생성
		}

		// 오늘날짜 폴더 생성
		String uploadFolderPath=getFolder();
		File uploadPath=new File(uploadFolder,uploadFolderPath);
		if(uploadPath.exists()==false) {
			uploadPath.mkdirs(); // 2025/04/25형태로 폴더를 연속적으로 생성
		}
		
		for(MultipartFile multipartFile : uploadFile) {
			if (multipartFile.isEmpty()) {
		        log.warn("빈 파일입니다. 스킵합니다: " + multipartFile.getOriginalFilename());
		        continue;
		    }
			log.info("File Info================================================");
			log.info("Upload File Name : "+multipartFile.getOriginalFilename());
			log.info("Upload File Name : "+multipartFile.getSize());
			
			
			//AttachFileDTO객체 생성
			AttachFileDTO attachDTO=new AttachFileDTO();
			list.add(attachDTO);
			
			//원본파일명
			String uploadFileName=multipartFile.getOriginalFilename();
			if (uploadFileName == null || uploadFileName.trim().isEmpty()) {
			    log.warn("업로드 파일 이름이 없습니다. 이 파일은 건너뜁니다.");
			    continue; // 이 파일은 스킵
			}
			
			//AttachDTO에 uploadFileName저장
			attachDTO.setFileName(uploadFileName);
			
			//UUID생성
			UUID uuid=UUID.randomUUID();
			uploadFileName=uuid.toString()+"_"+uploadFileName; // 중복되지않도록 uuid사용
			
			File saveFile=new File(uploadPath,uploadFileName);
			//File saveFile=new File(uploadFolder, multipartFile.getOriginalFilename());
			
			try {
				//원본파일 저장
				multipartFile.transferTo(saveFile);
				
				//uuid,uploadFolderPath를 attachDTO에 저장
				attachDTO.setUuid(uuid.toString());
				attachDTO.setUploadPath(uploadFolderPath);
				
				//이미지파일이면 thumbnails도 생성
				if(checkImageType(saveFile)) {
					//imag여부. true
					attachDTO.setImage(true);
					
					//썸네일명은 '_s'로 시작
					FileOutputStream thumbnail=new FileOutputStream(new File(uploadPath,"s_"+uploadFileName));
					//썸네일의 크기는 원본이미지의 가로세로 비율에 맞게 최대 100pixel로 생성
					Thumbnailator.createThumbnail(multipartFile.getInputStream(),thumbnail, 100, 100);
					thumbnail.close();
				}
			}catch(Exception e) {e.printStackTrace();};
		}
		// list리턴
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	//썸네일 출력
	@GetMapping("/display")
	@ResponseBody // jsp로 이동하지 않고 데이터를 클라이언트로 보냄
	public ResponseEntity<byte[]> getFile(String fileName){
		File file=new File("c:\\upload\\"+fileName);
		ResponseEntity<byte[]> result=null;//이미지 파일을 저장하는 변수
		try {
			HttpHeaders header=new HttpHeaders();
			header.add("Content-Type", Files.probeContentType(file.toPath()));
			// image파일을 byte[]로 변환해서 프론트엔드로 보냄
			result=new ResponseEntity<>(FileCopyUtils.copyToByteArray(file),header,HttpStatus.OK);
		}catch(IOException e) {e.printStackTrace();};
		return result;
	}
	
	// 파일다운로드
	// browser가 iamge, pdf를 다운로드 하면 viewer로 동작. 이작업이 일어나지 않게 MediaType.APPLICATION_OCTET_STEAM_VALUE설정
	@GetMapping(value="/download", produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<Resource> downloadFile(@RequestHeader("User-Agent") String userAgent, String fileName){
		Resource resource=new FileSystemResource("c:\\upload\\"+fileName);
		if(resource.exists()==false) { // 파일이 존재하지 않으면
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // not found
		}
		String resourceName=resource.getFilename();
		//원본파일명추출. '_' 뒷부분이 원본 파일명
		String resourceOriginalName=resourceName.substring(resourceName.indexOf("_")+1);
		
		HttpHeaders headers=new HttpHeaders();
		try {
			String downloadName=null;
			//한글파일명 깨지지 않게
			downloadName=new String(resourceOriginalName.getBytes("UTF-8"),"ISO-8859-1");
			//header에 원본파일명 기록
			headers.add("Content-Disposition", "attachment; filename="+downloadName);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Resource>(resource,headers,HttpStatus.OK);
	}
	
	// 파일 삭제
	@PostMapping("/deleteFile")
	@ResponseBody
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<String> deleteFile(String fileName, String type) {
		log.info("deleteFile: " + fileName);
		File file;
		try {
			file = new File("c:\\upload\\" + URLDecoder.decode(fileName, "UTF-8"));
			file.delete();
			if (type.equals("image")) {
				String largeFileName = file.getAbsolutePath().replace("s_", "");
				log.info("largeFileName: " + largeFileName);
				file = new File(largeFileName);
				file.delete();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}
}
