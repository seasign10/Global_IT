package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {
	//목록
	public List<BoardVO> getList();
	
	// 목록 with page
	public List<BoardVO> getListWithPaging(Criteria cri);

	//등록
	public void insert(BoardVO board);

	//등록. sequence로 만들어진 bno값을 구해서 처리
	public Integer insertSelectKey(BoardVO board);

	//상세보기
	public BoardVO read(Long bno);

	//삭제
	public int delete(Long bno);

	//수정
	public int update(BoardVO board);

	//전체글수
	public int getTotalCount(Criteria cri);
	
	//댓글수 업데이트
	public void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);
}
