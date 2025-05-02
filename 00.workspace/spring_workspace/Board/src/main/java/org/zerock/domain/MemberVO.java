package org.zerock.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class MemberVO {
	private String userid;
	private String userpw;
	private String username;
	private boolean enabled; // 계정사용 여부
	
	private Date regDate;
	private Date updateDate;
	private List<AuthVO> authList; // 권한목록
}
