package com.itkeyword.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ITKeyWordVO {
	private long no;
	private String keyword;
	private String description;
	private Date regdate;
}
