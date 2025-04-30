package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardAttachVO;

public interface BoardAttachMapper {
	//등록
	public void insert(BoardAttachVO vo);
	//목록
	public List<BoardAttachVO> findByBno(Long bno);
	//첨부파일목록삭제 by bno
	public void deleteAll(Long bno);
	//어제날짜 첨부파일 목록
	public List<BoardAttachVO> getOldFiles();
}
