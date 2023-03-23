package com.ezen.springmvc.model;

import lombok.Data;

@Data // @Data → Lombok 선택하면 자동으로 메서드가 생성된다.
public class Employee {
	// SampleController에 있는 변수명과 form에 있는 name이 같아야 자동으로 mapping이 된다.
	private Integer employee_id;
	private String first_name;
	private String last_name;
}
