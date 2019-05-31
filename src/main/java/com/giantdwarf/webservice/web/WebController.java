package com.giantdwarf.webservice.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class WebController {
	
	/*
	 * handlebars-spring-boot-starter 덕분에 컨트롤러에서 문자열을 반환할때 앞의 path와 뒤의 파일 확장자는 자동으로 지정
	 * (prefix: src/main/resources/templates, suffix: .hbs) 즉 main -> src/main/resources/templates/main.hbs로 전환되어 View Resolver가 처리하게
	 */
	
	@GetMapping("/")
	public String main() {
		return "main";
	}

}
