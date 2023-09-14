package com.task.employee.dao;

import java.util.List;

import com.task.employee.model.EmployeeDto;

public interface EmployeeDao {

	EmployeeDto addEmployeeDto(EmployeeDto employeedto);

	List<EmployeeDto> getEmployeeDto();
	
	
}
