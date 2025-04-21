package org.zerock.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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
	
	@GetMapping("/ex02")
	/* @RequestParam 없이도 값을 받아올 수 있다. */
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info("name"+name);
		log.info("age"+age);
		
		return "/sample/ex02";
	}
	
	// @ModelAttribute("page")는 model.addAttribute("page",page)와 같은 역할
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page, Model model) {
		log.info("dto:"+dto);
		log.info("page:"+page);
		
		// request.setAttribute()와 같은 역할
		model.addAttribute("dto", dto);
		return "sample/ex04";
	}
	
	@GetMapping("/ex05")
	public String ex05() {
		// 주소변경. controller의 주소를 적어야함.
		return "redirect:/sample/basicGet";
	}
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");
		
		return dto; // dto가 json형태로 변환돼서 front end로 전달됨
	}
	
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07(){
		String msg="{\"name\":\"홍길동\"}";
		
		HttpHeaders header=new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<>(msg, header, HttpStatus.OK);
	}
	
	@GetMapping("exUpload")
	public void exUpload() {}
	
	// post방식처리
	@PostMapping("exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		files.forEach(file->{
			log.info("-----------------------------------");
			log.info("name: "+file.getOriginalFilename());
			log.info("size: "+file.getSize());
		});
	}
	
}
