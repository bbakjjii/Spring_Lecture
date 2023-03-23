package com.ezen.springdb.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@RequiredArgsConstructor //-- 13 --
@AllArgsConstructor
@Data
public class Employee {
	
	private Integer employee_id;
	private String first_name;
	@NonNull //-- 13 ---
	private String last_name;
	@NonNull //-- 13 ---
	private String email; //-- 13 ---
	private String phone_number; //--20 --
	@NonNull //-- 13 ---
	private Date hire_date; //-- 13 ---
	private Integer department_id;
	@NonNull //-- 13 ---
	private String job_id;
	private Integer salary; // -- 11 --
	private Double commission_pct; // -- 20--
	private Integer manager_id; //--20--

}
