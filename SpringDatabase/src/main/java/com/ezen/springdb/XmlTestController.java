package com.ezen.springdb;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ezen.springdb.dto.Employee;
import com.ezen.springdb.mapper.EmployeeXmlMapper;
import lombok.extern.java.Log;

@Log
@RequestMapping("/xml")
@Controller
public class XmlTestController {
	
	@Autowired
	EmployeeXmlMapper emp_mapper;
	
	@GetMapping("/employee/list")
	public String employeeList(Model model) {
		model.addAttribute("employees", emp_mapper.getAll());
		
		return "xml/emp_list";
	}
	
	// -- 1. -- 하나만 가져오기
	@GetMapping("/employee/get")
	public String getEmployee(Model model, Integer employee_id) { // int는 null이 없기(구분하기 어렵기) 때문에 Integer로 함
		if (employee_id != null) {
			
			// -- 4 --
			model.addAttribute("employee", emp_mapper.get(employee_id));
		}
		
		return "xml/emp";
	}
	
	// -- 6 --
	@GetMapping("/employee/where")
	public String getWhere(Model model) {
		// -- 9 --
		model.addAttribute("employees", emp_mapper.getLessSalary(8000));
		return "xml/emp_list";
	}
	
	// -- 15 --
	@GetMapping("/employee/insert")
	public String insert(Model model) {
		
		// -- 20 --
		Integer last_id = emp_mapper.getLastId(); // 이메일이 겹치는 것을 방지
		
		Employee e = new Employee("Test", "EMAIL" + last_id, new Date(), "IT_PROG"); // 이메일은 계속 바꾸면서 INSERT 한다
		
		// -- 25 --
		log.info("before insert(employee_id가 비어있음): " + e);
		
		Integer row = emp_mapper.insert(e);
		
		log.info(row + "행이 업데이트 되었습니다..");
		
		// -- 25 --
		log.info("after insert(employee_id가 채워져있음, <selectkey>의 기능): " + e);
		
		// -- 23, 25 --
		// 받아온 id로 다시한번 select해서 모델에 실어놓음
		 model.addAttribute("employee", emp_mapper.get(e.getEmployee_id()));
	
		return "xml/emp";
	}

}
