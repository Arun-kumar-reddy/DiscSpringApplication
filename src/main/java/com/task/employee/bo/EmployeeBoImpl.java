package com.task.employee.bo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.employee.eo.EmployeeEo;
import com.task.employee.exception.EmployeeDataNotFoundException;
import com.task.employee.model.EmployeeDto;
import com.task.employee.model.HealthCheck;

@Service

public class EmployeeBoImpl implements EmployeeBo {
	@Autowired
	private EmployeeEo employeeEo;

	Logger logger = LoggerFactory.getLogger(EmployeeBoImpl.class);

	@Override
	public EmployeeDto addEmployeeDto(EmployeeDto employeeDto) {
		logger.info("saving the employee details");
		System.out.println("EmployeeBoImpl class -> " + employeeDto);
		return employeeEo.addEmployeeDto(employeeDto);
	}

	@Override
	public List<EmployeeDto> getEmployeeDto() {
		logger.info("retrieving employee details");
		return employeeEo.getEmployeeDto();
	}




	

@Override
public HealthCheck healthcheck() {
    HealthCheck healthcheck = new HealthCheck();
    healthcheck.setHealthComment("Checking for table in databse");

    try {
        if (getEmployeeDto()!=null) {
            healthcheck.setCodeStatus("success");
            healthcheck.setHealthDescription("table found");
        } else {
            throw new EmployeeDataNotFoundException("table not present");
        }
    } catch (Exception ex) {
        healthcheck.setCodeStatus("failure");
        healthcheck.setHealthDescription("error when checking for table");
    }

    return healthcheck;
}



}
