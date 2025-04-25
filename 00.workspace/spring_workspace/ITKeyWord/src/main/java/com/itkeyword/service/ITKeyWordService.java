package com.itkeyword.service;

import java.util.List;

import com.itkeyword.domain.Criteria;
import com.itkeyword.domain.ITKeyWordVO;

public interface ITKeyWordService {
	//등록
	public void register(ITKeyWordVO board);
	//상세보기
	public ITKeyWordVO get(Long bno);
	//수정
	public boolean modify(ITKeyWordVO board);
	//삭제
	public boolean remove(Long bno);
	//목록
	public List<ITKeyWordVO> getList();
	//목록 with paging
    public List<ITKeyWordVO> getList(Criteria cri);
	//전체글수
	public int getTotal(Criteria cri);
}
