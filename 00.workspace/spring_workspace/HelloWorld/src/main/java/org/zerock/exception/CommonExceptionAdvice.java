package org.zerock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j2;

@ControllerAdvice
@Log4j2
public class CommonExceptionAdvice {
	@ExceptionHandler(Exception.class)
	public String except(Exception ex, Model model) {
		//예외가 발생했을 때 처리할 일 작성
		// 1. 에러메세지를 로그에 기록
		// 2. 관리에게 메일을 보냄
		model.addAttribute("exception", ex);
		
		return "error_page";
	}
	
	// 404 에러처리
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handle404(NoHandlerFoundException ex){
		return "custom404";
	}
}
