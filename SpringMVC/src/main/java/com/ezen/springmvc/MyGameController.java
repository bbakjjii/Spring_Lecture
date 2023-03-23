package com.ezen.springmvc;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// -- 2 --
@RequestMapping("/mygame")
@ControllerAdvice
public class MyGameController {
	
	@GetMapping("/index")
	public void index() {
		
	}	
	
	// -- 4 --
	@PostMapping("/index")
	public String index2(String user, HttpServletResponse response) {

		
		// 쿠키를 response에 실어보내야 함
		if (user != null && user != "") {
			Cookie cookie = new Cookie("user", user);
			
			cookie.setMaxAge(604800); // 일주일(초) 로그인 유지
			
			response.addCookie(cookie);
		}
		// 컨트롤러에서 리다이렉트 하는 방법 (ContextPath 알아서 붙여줌)
		return "redirect:/mygame/index";
	}
	
	// -- 24 --
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		
		// 쿠키에는 하나만 딱 꺼내는 기능이 없다
		// 유저 쿠키 삭제
		Cookie[] cookies = request.getCookies();
		
		for (Cookie cookie : cookies) {
			// 이름이 user인 쿠키를 꺼낸다.
			if (cookie.getName().equals("user")) {
				// 해당 쿠키의 setMaxAge를 0으로 만든다
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
		
		return "redirect:/mygame/index";
	}
	// -- 24 --
}
