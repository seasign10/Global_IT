package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.dto.BookDTO;

@Controller
@RequestMapping("/book/*")
public class BookController {
	@GetMapping("/BookWrite")
	public void write() {}
	
	@GetMapping("/BookInfo")
	public String info(BookDTO dto, Model model) {
		System.out.println("도서명: "+dto.getTitle());
		System.out.println("저자명: "+dto.getName());
		System.out.println("가격: "+dto.getPrice());
		System.out.println("출판사명: "+dto.getPublisher());
		
		// JSP로 데이터 전송
		model.addAttribute("book", dto); 
		
		return "book/BookInfo";
	}
}
