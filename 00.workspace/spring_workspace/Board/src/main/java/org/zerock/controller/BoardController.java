package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	//주입. 자동주입. 생성자 의존성 주입	
	private BoardService service;
	//등록화면
	@GetMapping("/register")
	public void register() {}
	//목록
	@GetMapping("/list")
	public void list(Model model) {
		// request.setAttribute("list", service.getList()); 와 같은 역할
		model.addAttribute("list", service.getList());
	}
	//등록
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		service.register(board);
		rttr.addFlashAttribute("result", board.getBno());
		
		return "redirect:/board/list";
	}
	//상세보기. 수정화면
	@GetMapping({"/get","/modify"})
	public void get(Long bno, Model model) {
		model.addAttribute("board", service.get(bno));
	}
}
