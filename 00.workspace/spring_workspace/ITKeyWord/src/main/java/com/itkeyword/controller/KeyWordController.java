package com.itkeyword.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itkeyword.domain.Criteria;
import com.itkeyword.domain.ITKeyWordVO;
import com.itkeyword.domain.PageDTO;
import com.itkeyword.service.ITKeyWordService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/keyword/*")
@AllArgsConstructor
public class KeyWordController {
	//주입. 자동주입. 생성자 의존성 주입	
	private ITKeyWordService service;
	//등록화면
	@GetMapping("/register")
	public void register() {}
	
	//목록
	@GetMapping("/list")
	public void list(Criteria cri,Model model) {
		model.addAttribute("list", service.getList(cri));
		
		int total=service.getTotal(cri); //전체글수
		model.addAttribute("pageMaker", new PageDTO(cri,total)); // 1.2.3...10 페이지번호 생성
	}
	
	//등록
	@PostMapping("/register")
	public String register(ITKeyWordVO keyword, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		service.register(keyword);
		rttr.addFlashAttribute("result", keyword.getNo());
		
		return "redirect:/keyword/list";
	}
	
	//상세보기. 수정화면
	@GetMapping({"/get","/modify"})
	public void get(Long no, @ModelAttribute("cri") Criteria cri, Model model) {
		model.addAttribute("keyword", service.get(no));
	}
	
	//수정
	@PostMapping("/modify")
	public String modify(ITKeyWordVO keyword, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		if(service.modify(keyword)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/keyword/list";
	}
	
	//삭제
	@PostMapping("/remove")
	public String remove(Long no, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		if(service.remove(no)) {
			rttr.addFlashAttribute("result", "success");
		}
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		return "redirect:/keyword/list";
	}
	
} 
