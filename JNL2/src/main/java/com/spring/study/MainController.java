package com.spring.study;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.spring.study.service.UserService;

@Controller
public class MainController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="main",method=RequestMethod.GET)
	public String main() {
		return "main";
	}
	@RequestMapping(value="json")
	public String json(String name, HttpServletRequest req, HttpServletResponse resp) throws IOException {
		return "json";
	}
	@RequestMapping(value="aa")
	public String aa() {
		return new Gson().toJson("aaa");
	}
}
