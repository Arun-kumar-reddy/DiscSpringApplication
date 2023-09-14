package com.task.employee.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.task.employee.bo.EmployeeBo;
import com.task.employee.mapper.EmployeeMapper;
import com.task.employee.model.EmployeeDto;
import com.task.employee.model.EmployeeVo;
import com.task.employee.model.HealthCheck;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeBo employeeBo;

	@Autowired
	private EmployeeMapper employeeMapper;

	Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Override
	public EmployeeVo addEmployeeVo(EmployeeVo employeeVo) {
		EmployeeDto employeeDto = employeeMapper.employeeVoToEmployeeDto(employeeVo);
		EmployeeDto addedEmployeeDto = employeeBo.addEmployeeDto(employeeDto);
		if (addedEmployeeDto != null) {
			logger.info("adding EmployeeServiceImpl employee");
			System.out.println("EmployeeServiceImpl class -> " + addedEmployeeDto);
			return employeeMapper.employeeDtoToEmployeeVo(addedEmployeeDto);
		}
		return employeeVo;
	}

	@Override
	public List<EmployeeVo> getEmployeeVo() {
		logger.info("Retrieving employee details");
		return employeeMapper.toEmployeeVos(employeeBo.getEmployeeDto());
	}

	@Override
	public HealthCheck healthcheck() {
		logger.info("Healthcheck in progress");
		return employeeBo.healthcheck();
	}

}
