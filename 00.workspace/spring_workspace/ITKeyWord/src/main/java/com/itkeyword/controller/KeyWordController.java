package com.itkeyword.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itkeyword.domain.ITKeyWordVO;

@Controller
@RequestMapping("/keyword/*")
public class KeyWordController {
	@GetMapping("/addKeyWord")
	public void addPage() {}
	
	@GetMapping("/add")
	public String addWord(ITKeyWordVO vo) {
		System.out.println("no: "+vo.getNo());
		System.out.println("keyword: "+vo.getKeyword());
		System.out.println("discription: "+vo.getDescription());
		System.out.println("regdate: "+vo.getRegdate());
		return "/keyword/addKeyWord";
	}
} 
