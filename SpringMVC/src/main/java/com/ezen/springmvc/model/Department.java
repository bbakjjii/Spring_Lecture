package com.ezen.springmvc.model;

import lombok.Getter;
import lombok.Setter;

public class Department {
	
	@Getter // deaprtment_id에만 getter 생성
	private Integer department_id;
	
	@Setter // department_name에만 setter 생성
	@Getter // deaprtment_name에만 getter 생성
	private String department_name;

}
