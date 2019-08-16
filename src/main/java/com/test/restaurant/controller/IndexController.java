package com.test.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/{resource}.html")
	public String login(@PathVariable String resource) {
		return resource;
	}
	
	@RequestMapping("/login/{resource}.html")
	public String managerindex(@PathVariable String resource) {
		return "/login/"+resource;
	}
	
	@RequestMapping("/error-404")
	public String toPage404() {
		return "/error/404";
	}

}
