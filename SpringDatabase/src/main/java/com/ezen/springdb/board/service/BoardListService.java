package com.ezen.springdb.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.springdb.dto.BoardDTO;

// -- 7 --
public interface BoardListService {
	
	
	BoardDTO clickTitle(Integer board_id,
			// -- 18 --
			HttpServletRequest request, HttpServletResponse response);
}