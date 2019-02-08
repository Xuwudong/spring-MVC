package com.xwd.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloMVCController {
	@RequestMapping("/main")
	public String helloMvc() {
		return "main";
	}
}
