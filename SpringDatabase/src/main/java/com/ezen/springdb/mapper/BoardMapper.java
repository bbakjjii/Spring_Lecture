package com.ezen.springdb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ezen.springdb.dto.BoardDTO;

public interface BoardMapper {
	
	// 기본키 사용
	// 컬럼이름이 무조건 같아야 한다
	// select문
	@Select("SELECT * FROM board WHERE board_id=#{id}")
	// Board 타입이 하나 리턴되는 get (mybatis가 알아서 dto타입으로 준다)
	BoardDTO get(Integer board_id);
	
	// -- SELECT 강사님 정답 추가--
	// 작성시간으로 정렬하기
	@Select("SELECT * FROM board ORDER BY write_date DESC")
	List<BoardDTO> getAll();
	
	// 자동 매핑을 컨트롤러에서 해준다. 여기서 add하고 전달만하면 끝난다
	// insert문
	@Insert("INSERT INTO board VALUES(board_id_seq.nextval,"
			+ "#{write_id}, #{write_pw}, #{write_title}, #{write_content},sysdate,0,0,0)")
	Integer add(BoardDTO board);
	
	
	// -- update --
	// @Update
	// ("UPDATE  board SET write_id = #{write_id}, write_content = #{write_content}  WHERE board_id = #{board_id} ")
	// Integer update(Board board);
	
	// -- delete
	// @Delete
	// ("DELETE FROM board WHERE board_id = #{board_id}")
	// Integer delete(Board board);
	
	// -- update, delete 강사님 정답 --
	@Update("UPDATE  board SET write_title = #{write_title}, "
			+ "write_content = #{write_content}  WHERE board_id = #{board_id} ")
	Integer update(BoardDTO board);
	
	@Delete("DELETE FROM board WHERE board_id=#{board_id}")
	Integer delete(Integer board_id);

}
