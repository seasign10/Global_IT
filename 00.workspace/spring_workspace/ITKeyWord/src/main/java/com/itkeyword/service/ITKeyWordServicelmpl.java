package com.itkeyword.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itkeyword.domain.Criteria;
import com.itkeyword.domain.ITKeyWordVO;
import com.itkeyword.mapper.ITKeyWordMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Service
@AllArgsConstructor
public class ITKeyWordServicelmpl implements ITKeyWordService {
	//주입
	@Setter(onMethod_ = @Autowired)
	private ITKeyWordMapper mapper;

	@Override
	public void register(ITKeyWordVO keyword) {
		mapper.insertSelectKey(keyword); // mapper의 insert 메서드 호출		
	}

	@Override
	public ITKeyWordVO get(Long bno) {
		return mapper.read(bno);
	}

	@Override
	public boolean modify(ITKeyWordVO keyword) {
		return mapper.update(keyword)==1; // 리턴값은 영향을 받은 행의 수
	}

	@Override
	public boolean remove(Long bno) {
		return mapper.delete(bno)==1; // 리턴값은 영향을 받은 행의 수
	}

	@Override
	public List<ITKeyWordVO> getList() {
		return mapper.getList();
	}

	@Override
	public List<ITKeyWordVO> getList(Criteria cri) {
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotalCount(cri);
	}
}
