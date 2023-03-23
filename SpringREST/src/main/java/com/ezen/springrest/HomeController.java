package com.ezen.springrest;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;

// -- 7 --
@Log4j
@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
	//public String home(Locale locale, Model model) {
		
		return "home";
	}
	
	// -- 47 --
	@GetMapping("/gonggong")
	public String gonggong() {
		return "/gonggong";
	}
	
	// -- 21 --
	@RequestMapping(value = "/error/wrong", method = RequestMethod.GET)
	public String errorCode400() {
		log.info("에러 발생시 하고싶은 일 적는 곳");
		
		return "errorpage/400";
	}
}
