package com.task.employee.bo;

import java.util.List;

import com.task.employee.model.EmployeeDto;
import com.task.employee.model.HealthCheck;

public interface EmployeeBo {
	public EmployeeDto addEmployeeDto(EmployeeDto employeeDto);

	public List<EmployeeDto> getEmployeeDto();



	public HealthCheck healthcheck();
	
}
