package com.ezen.springdb.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BoardDTO {
	
	// 컬럼이름이 무조건 같아야 한다
	private Integer board_id;
	private String write_id;
	private String write_pw;
	private String write_title;
	private String write_content;
	private Date write_date;
	private Integer write_view;
	private Integer write_recommend;
	private Integer write_not_recommend;
}
