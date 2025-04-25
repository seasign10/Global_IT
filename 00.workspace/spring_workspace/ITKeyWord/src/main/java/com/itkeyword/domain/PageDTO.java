package com.itkeyword.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	private int startPage; //1,2,3...10에서 시작페이지 1
	private int endPage; //1,2,3...10에서 끝페이지 10
	private boolean prev,next; // 이전, 다음 구간 존재여부
	private int total; // 전체글수
	private Criteria cri;
	
	public PageDTO(Criteria cri,int total) {
		this.cri=cri;
		this.total=total;
		
		this.endPage=(int)(Math.ceil(cri.getPageNum()/10.0))*10;
		this.startPage=this.endPage-9;
		int realEnd=(int)(Math.ceil((total*1.0)/cri.getAmount())); // 실제 마지막페이지
		//마지막페이지(realEnd)보다 계산으로 구한 endPage가 크면 endPage를 realEnd로 변경
		if(realEnd<=this.endPage) {
			this.endPage=realEnd;
		}
		
		//시작페이지가 1보다 커야 prev가 존재
		this.prev=this.startPage>1;
		//끝페이지보다 실제 마지막페이지가 더 커야 next가 존재
		this.next=this.endPage<realEnd;		
	}
}
