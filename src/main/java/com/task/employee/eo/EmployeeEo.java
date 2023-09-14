package com.task.employee.eo;

import java.util.List;



import com.task.employee.model.EmployeeDto;
import com.task.employee.model.HealthCheck;

public interface EmployeeEo {
	public EmployeeDto addEmployeeDto(EmployeeDto employeeDto);

	public List<EmployeeDto> getEmployeeDto();

	public HealthCheck healthcheck();

	

}
