package com.itkeyword.mapper;

import java.util.List;

import com.itkeyword.domain.Criteria;
import com.itkeyword.domain.ITKeyWordVO;

public interface ITKeyWordMapper {
	//목록
	public List<ITKeyWordVO> getList();
	
	// 목록 with page
	public List<ITKeyWordVO> getListWithPaging(Criteria cri);

	//등록
	public void insert(ITKeyWordVO keyword);

	//등록. sequence로 만들어진 no값을 구해서 처리
	public Integer insertSelectKey(ITKeyWordVO keyword);
	
	//상세보기	
	public ITKeyWordVO read(Long no);

	//삭제
	public int delete(Long no);

	//수정
	public int update(ITKeyWordVO keyword);

	//전체글수
	public int getTotalCount(Criteria cri);
}
