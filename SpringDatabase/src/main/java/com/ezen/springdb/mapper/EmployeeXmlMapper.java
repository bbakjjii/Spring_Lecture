package com.ezen.springdb.mapper;

import java.util.List;
import com.ezen.springdb.dto.Employee;

public interface EmployeeXmlMapper {

	public List<Employee> getAll();
	
	// -- 2 --
	public Employee get(Integer employee_id);
	
	// -- 7 --
	public List<Employee> getLessSalary(Integer salary); //월급을 이것보다 더 적게 받는 사람을 구하고 싶다

	// -- 16 --
	public Integer insert(Employee emp);
	
	// -- 18 --
	public Integer getLastId();

}
