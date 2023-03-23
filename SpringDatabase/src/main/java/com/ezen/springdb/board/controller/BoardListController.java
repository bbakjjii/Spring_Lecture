package com.ezen.springdb.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.springdb.board.service.BoardListService;

@RequestMapping("/service/board/list") // -- 15 --
@Controller
// -- 2 --
public class BoardListController {
	
	// -- 15 --
	@Autowired
	BoardListService service; // BoardListService의 service를 가져다 쓴다
	
	@GetMapping("/title") // 타이틀을 눌렀을 때 게시판 번호가 같이 온다 
	public String clickTitle(Model model, Integer board_id,
			// -- 19 --
			HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("board", service.clickTitle(board_id, request, response));
		
		return "test/board_detail";
	}
	
}
