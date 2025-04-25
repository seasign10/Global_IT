package org.zerock.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
		try {
			// 파일의 content type을 구함
			String contentType=Files.probeContentType(file.toPath());
			// 이미지파일은 content type이 'image'로 시작. 'image'로 시작하면 true
			return contentType.startsWith("image");
		}catch(Exception e) {e.printStackTrace();};
		return false;
	}
	
	
	@PostMapping("/uploadAjaxAction")
	@ResponseBody
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
			log.info("File Info================================================");
			log.info("Upload File Name : "+multipartFile.getOriginalFilename());
			log.info("Upload File Name : "+multipartFile.getSize());
			
			
			//AttachFileDTO객체 생성
			AttachFileDTO attachDTO=new AttachFileDTO();
			list.add(attachDTO);
			
			//원본파일명
			String uploadFileName=multipartFile.getOriginalFilename();
			
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
}
