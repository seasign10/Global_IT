package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {
	// where bno>0은 pk에 설정된 index사용을 유도하기 위해.
//	@Select("select * from tbl_board where bno>0")
//	public List<BoardVO> getList();
	
	//목록
	public List<BoardVO> getList();
	//등록
	public void insert(BoardVO board);
	//등록. sequence로 만들어진 bno값을 구해서 처리
	public void insertSelectKey(BoardVO board);
	//상세보기
	public BoardVO read(Long bno);
}
