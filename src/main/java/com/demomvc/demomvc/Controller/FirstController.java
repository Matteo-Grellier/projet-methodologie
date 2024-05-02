package com.demomvc.demomvc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FirstController {

	@GetMapping("/hello")
	@ResponseBody
	public String information() {
		return "first/hello";
	}
}
