package com.task.employee.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.task.employee.model.EmployeeDto;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	Logger logger = LoggerFactory.getLogger(EmployeeDao.class);

	@Override
	public EmployeeDto addEmployeeDto(EmployeeDto employeeDto) {
		// EmployeeDto dd=new EmployeeDto(2, "oho", "oho@gmail.com");
		//employeeDto =null;
		System.out.println(employeeDto);
		String query = "INSERT INTO EmployeeDetails (EmpId,EmpName,EmpEmail) VALUES ('" + employeeDto.getEmpId() + "','"
				+ employeeDto.getEmpName() + "','" + employeeDto.getEmpEmail() + "')";
		jdbcTemplate.update(query);
		logger.info("adding emp details");
		System.out.println("EmployeeDaoImpl class -> " +employeeDto);
		return employeeDto;
	}

	@Override
	public List<EmployeeDto> getEmployeeDto() {
		logger.info("retrieving employee details");
		String query = "SELECT * FROM EmployeeDetails";
		List<EmployeeDto> employeeDtoList = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(EmployeeDto.class));
		return employeeDtoList;
	}




	}