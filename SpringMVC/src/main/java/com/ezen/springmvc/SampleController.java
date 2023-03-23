package com.ezen.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ezen.springmvc.model.Employee;

@Controller
public class SampleController {
	
	// 로거 만들기 (log4j2를 이용한 방식)
	private static Logger log = LogManager.getLogger(SampleController.class);
	
	@RequestMapping(value = "/sample", 
			method = {RequestMethod.GET, RequestMethod.POST})
	public String index() {
		
		// /WEB-INF/vies/ 아래의 경로를 리턴해야 한다
		return "sample/index";
	}
	
//	@GetMapping(value = {"/sample/get"})
//	public String get() {
//		return "sample/get";
//	}
	
	@GetMapping(value = {"/sample/get"})
	public String get() {
		return "sample/form";
	}
	
	// 콘솔창에 1, Smith, King이 나온다.
	@PostMapping("/sample/post")
	public String post(HttpServletRequest request) {
		log.info(request.getParameter("employee_id"));
		log.info(request.getParameter("first_name"));
		log.info(request.getParameter("last_name"));
		
		// 이런식으로 꺼내서 보여준다.
		// Employee e = new Employee();
		// e.setEmployee_id(request.getParameter("employee_id"));
		// request.setAttribute("employee",  e);
		
		return "sample/result";
	}
	
	@PostMapping("/sample/post2")
	// Employee 타입의 emp를 받는다
	public String post2(Employee emp) {
			log.info(emp);
		
		return "sample/result";
	}
	
	// -- 16 --
//	@PostMapping("/sample/post3")
//	public String post3(Integer employee_id, String first_name, String last_name) {
//			log.info(employee_id);
//			log.info(first_name);
//			log.info(last_name);
//		
//		return "sample/result";
//	}
	
	// -- 18 -- @ModelAttribute로 하나씩 받기
	@PostMapping("/sample/post3")
	public String post3(
			@ModelAttribute("employee_id") Integer emp_id, 
			@ModelAttribute("first_name") String f_name, 
			@ModelAttribute("last_name") String l_name) {
		
			log.info(emp_id);
			log.info(f_name);
			log.info(l_name);
		
		return "sample/result";
	}
	
	// -- 20 ② --
	// 리턴 타입이 없을 때 다음뷰로 가는 방법
	//	@GetMapping("/sample/find/void")
	//	public void orange(Employee e) {
	//	}
	
	// -- 21 --
	@GetMapping("/sample/find/void")
	public void orange(Employee e) {
		log.info(e);
	}
}
