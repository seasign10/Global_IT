package org.zerock.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class CommonController {
	//권한이 없을 때 에러페이지
	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		model.addAttribute("msg", "Access Denied");
	}
	
	//커스텀 로그인화면
	@GetMapping("/customLogin")
	public void loginInput(String error, String logout, Model model) {
		if(error!=null) {
			
			model.addAttribute("error", "로그인이 실패하였습니다.");
		}
		if(logout!=null) {
			model.addAttribute("logout", "로그아웃 되었습니다.");
		}
	}
	
	//로그아웃 화면
	@GetMapping("/customLogout")
	public void logoutGET() {}
	//로그아웃 처리
	@PostMapping("/customLogout")
	public void logoutPOST() {}
}
