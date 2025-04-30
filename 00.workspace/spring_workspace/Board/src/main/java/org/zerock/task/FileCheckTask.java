package org.zerock.task;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.zerock.domain.BoardAttachVO;
import org.zerock.mapper.BoardAttachMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Component
public class FileCheckTask {
	@Setter(onMethod_ = {@Autowired})
	private BoardAttachMapper attachMapper;
	
	//어제날짜폴더 구하는 함수
	private String getFolderYesterDay() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE, -1); //어제날짜구하기
		String str=sdf.format(cal.getTime());
		log.info("★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
		log.info(str.replace("-", File.separator));
		log.info("★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
		return str.replace("-", File.separator); // 최종 형식은 2025\\04\\28
	}
	
	//스케쥴링
	@Scheduled(cron="0 28 12 * * *")
	public void checkFiles() throws Exception{
		//테이블에 저장된 어제파일목록
		List<BoardAttachVO> fileList=attachMapper.getOldFiles();
		
		//원본파일 저장경로 추가
		List<Path> fileListPaths=fileList.stream()
				.map(vo->Paths.get("C:\\upload",vo.getUploadPath(),vo.getUuid()+"_"+vo.getFileName()))
				.collect(Collectors.toList());
		
		//썸네일 저장경로 추가
		fileList.stream().filter(vo->vo.isFileType()==true)
				.map(vo->Paths.get("C:\\upload", vo.getUploadPath(),"s_"+vo.getUuid()+"_"+vo.getFileName()))
				.forEach(p->fileListPaths.add(p));
		
		//어제날짜폴더
		File targetDir=Paths.get("C:\\upload",getFolderYesterDay()).toFile();
		
		//삭제할 파일목록 생성. 테이블의 파일목록과 어제날짜폴더의 파일목록을 비교해서 처리.
		File[] removeFiles=targetDir.listFiles(file->fileListPaths.contains(file.toPath())==false);
		
		//삭제할 파일목록에서 하나씩 삭제
		for(File file : removeFiles) {
			file.delete();
		}
	}
}
