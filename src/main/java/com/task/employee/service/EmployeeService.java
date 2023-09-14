package com.task.employee.service;

import java.util.List;

import com.task.employee.model.EmployeeVo;
import com.task.employee.model.HealthCheck;

public interface EmployeeService {
	public EmployeeVo addEmployeeVo(EmployeeVo employeeVo);

	public List<EmployeeVo> getEmployeeVo();

	 public HealthCheck healthcheck();
	
}
