package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.BoardAttachVO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardAttachMapper;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class BoardServiceImpl implements BoardService{
	//주입
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	//주입
	@Setter(onMethod_=@Autowired)
	private BoardAttachMapper attachMapper;

	@Transactional
	@Override
	public void register(BoardVO board) {
		mapper.insertSelectKey(board); // mapper의 insert 메서드 호출	
		
		//첨부파일이 없으면 중지
		if(board.getAttachList()==null || board.getAttachList().size()<=0) {
			return;
		}
		//첨부파일목록에서 하나씩 처리
		board.getAttachList().forEach(attach->{
			attach.setBno(board.getBno());
			attachMapper.insert(attach);
		});
	}

	@Override
	public BoardVO get(Long bno) {
		return mapper.read(bno);
	}

	@Transactional
	@Override
	public boolean modify(BoardVO board) {
		//첨부파일목록을 일단 모두 삭제
		attachMapper.deleteAll(board.getBno());
		//부모글 수정
		boolean modifyResult=mapper.update(board)==1;// 리턴값은 영향을 받은 행의 수
		//부모글 수정이 성공하고 첨부파일목록이 있으면 첨부파일 등록
		if(modifyResult && board.getAttachList() != null && board.getAttachList().size() > 0) {
			board.getAttachList().forEach(attach->{
				attach.setBno(board.getBno());
				attachMapper.insert(attach);
			});
		}
		
		return modifyResult; 
	}

	@Transactional
	@Override
	public boolean remove(Long bno) {
		
		//첨부파일목록삭제
		attachMapper.deleteAll(bno);
		
		return mapper.delete(bno)==1; // 리턴값은 영향을 받은 행의 수
	}

	@Override
	public List<BoardVO> getList() {
		return mapper.getList();
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotalCount(cri);
	}

	@Override
	public List<BoardAttachVO> getAttachList(Long bno) {
		return attachMapper.findByBno(bno);
	}

}
