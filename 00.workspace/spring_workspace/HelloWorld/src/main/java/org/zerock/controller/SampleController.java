package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.dto.SampleDTO;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/sample/*") /* 선행 주소, 이 주소를 사용하기 위해서 views폴더에서 sample이라는 폴더를 생성해야 함 */
@Log4j2
public class SampleController {
	// return 값이 void면 주소와 같은 이름의 jsp로 이동
	/* basicGet.jsp를 views/sample/에 생성해야함 */
	@RequestMapping(value="/basicGet",method= {RequestMethod.GET,RequestMethod.POST})
	public void basicGet() {log.info("basic get...");}
	
	// get방식처리
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		System.out.println(dto);
		return "/sample/ex01";
	}
}
