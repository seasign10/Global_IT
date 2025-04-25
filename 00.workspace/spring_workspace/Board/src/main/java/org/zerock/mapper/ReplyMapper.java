package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

public interface ReplyMapper {
	//등록
	public int insert(ReplyVO vo);
	//상세보기
	public ReplyVO read(Long bno);
	//삭제
	public int delete(Long rno);
	//수정
	public int update(ReplyVO reply);
	//목록 width pageing
	public List<ReplyVO> getListWithPaging(@Param("cri") Criteria cri, @Param("bno") Long bno);
	//댓글수
	public int getCountByBno(Long bno);
}
