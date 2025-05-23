package org.zerock.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Criteria {
	private int pageNum; // 페이지번호
	private int amount; // 한페이지에 출력되는 게시글 수
	
	// 검색을 위한 변수
	private String type;
	private String keyword;
	
	public Criteria() {
		this(1,10); // 기본값 설정 - pageNum 1, amount 10
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum=pageNum;
		this.amount=amount;
	}
	
	public String[] getTypeArr() {
		return type==null? new String[] {}:type.split(""); // 구분자가 없으므로 빈문자열로 구분
	}
	
	public String getListLink() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
			.queryParam("pageNum", this.pageNum)
			.queryParam("amount", this.getAmount())
			.queryParam("type", this.getType())
			.queryParam("keyword", this.getKeyword());
		return builder.toUriString(); // ?pageNum=1&about=10&type=c&keyword=spring 형식의 문자열 리턴
	}
}
