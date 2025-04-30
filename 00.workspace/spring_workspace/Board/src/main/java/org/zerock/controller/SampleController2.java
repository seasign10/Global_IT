package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@RequestMapping("/sample/*")
@Log4j
@Controller // =>jsp
public class SampleController2 {
	
	//모든 user접속
	@GetMapping("/all")
	public void doAll() {}
	
	//member role 접속
	@GetMapping("/member")
	public void doMember() {}
	
	//admin role 접속
	@GetMapping("/admin")
	public void doAdmin() {}
}
