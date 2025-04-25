package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService {
	// 자동주입. @AllArgsConstructor 때문에 가능
	private ReplyMapper mapper;
	// 자동 주입
	private BoardMapper boardMapper;
	
	@Transactional
	@Override
	public int register(ReplyVO vo) {
		boardMapper.updateReplyCnt(vo.getBno(), 1); // 댓글 갯수 +1
		return mapper.insert(vo);
  }

  @Override
  public ReplyVO get(Long rno) {
    return mapper.read(rno);

  }

  @Override
  public int modify(ReplyVO vo) {
    return mapper.update(vo);

  }

  @Transactional
  @Override
  public int remove(Long rno) {
	  // vo를 만들어서 bno 추출
	  ReplyVO vo=mapper.read(rno);
	  boardMapper.updateReplyCnt(vo.getBno(), -1); // 댓글 갯수 -1
	  
	  return mapper.delete(rno);
  }

  @Override
  public List<ReplyVO> getList(Criteria cri, Long bno) {
    return mapper.getListWithPaging(cri, bno);
  }
  
  @Override
  public ReplyPageDTO getListPage(Criteria cri, Long bno) {
    return new ReplyPageDTO(
        mapper.getCountByBno(bno), 
        mapper.getListWithPaging(cri, bno));
  }

}

