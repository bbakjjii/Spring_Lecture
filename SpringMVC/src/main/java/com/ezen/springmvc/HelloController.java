package com.ezen.springmvc;

import org.apache.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.springmvc.model.Book;

// -- 1 --
//@Controller를 달면 이게 Controller라는 것을 안다
//@RequestMapping : hello라는 주소로 들어올 때 이 컨트롤러로 달아주세요.
@ RequestMapping("/hello") 
@Controller
public class HelloController {
	
	// -- 4 --
	// new Book 안해도 됨. Context에서 알아서 찾아서 준다.
	// Book b1 = new Book(); // new를 여러번 실행하면 괜한 메모리 낭비가 된다
	
	// Sysout 대신 Log4j로 로그 찍기
	// 1. Logger 생성(log4j 2 임)
	// Log4j
	private static Logger log = Logger.getLogger(HelloController.class);
	
	// Log4j2
	private static org.apache.logging.log4j.Logger log2 =
			org.apache.logging.log4j.LogManager.getLogger(HelloController.class);
	
	@Autowired
	Book b2, b3;
	@Autowired
	Book b4;
	
	@RequestMapping("/log")
	String log() {
		// 2. 로그를 Logger에 추가하기
		log.fatal("Fatal level log message.");
		log.error("Error level log message.");
		log.warn("Warn level log message.");
		log.info("Info level log message.");
		log.debug("Debug level log message.");
		log.trace(" level log message.");
		
		return "hello/index";
	}
	
	@RequestMapping("/log2")
	String log2() {
		// 2. 로그를 Logger에 추가하기
		log2.fatal("Fatal level log message.");
		log2.error("Error level log message.");
		log2.warn("Warn level log message.");
		log2.info("Info level log message.");
		log2.debug("Debug level log message.");
		log2.trace("Trace level log message.");
		
		return "hello/index";
	}
	
	// String 타입의 index라는 메서드를 생성
	// hello 밑에 index
	@RequestMapping("/index")
	String index() {

		// // 2. 로그를 Logger에 추가하기 
		// -- test용 --
		 log.info(b2);
		 log.info("안녕하세요~!");
		 log.warn(b3);
		 log.debug(b4);
		
		// -- test용 --
		// System.out.println(b1);
		// System.out.println(b2);
		// System.out.println(b3);
		// System.out.println(b4);
		
		// static스럽게 도착한다. 인스턴스라고 착각하지 말아야 한다.
		// -- test용 --
		b2.setAuthor("조앤K롤링");
		System.out.println(b2.getAuthor());
		System.out.println(b3.getAuthor());
		System.out.println(b4.getAuthor());
		
		// 다음 뷰의 위치를 String 타입으로 리턴한다
		// /WEB-INF/views/ + 리턴값 + .jsp
		return "hello/index";
	}

}
