package com.ezen.springdb.board.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.springdb.dto.BoardDTO;

@Mapper
// -- 4 --
// Mapper는 테이블 또는 DTO 단위로 작성
public interface ServiceBoardMapper {
	
	// -- 9 --
	BoardDTO get(Integer board_id);
	
	// -- 11 --
	Integer plusView(Integer board_id);

}
