package com.task.employee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.employee.model.EmployeeVo;
import com.task.employee.model.HealthCheck;
import com.task.employee.service.EmployeeService;

@RestController
@RequestMapping("/empdetails")

public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@PostMapping(value = "/addEmployee", produces = "application/json")
	public ResponseEntity<EmployeeVo> addEmployeeVo(@RequestBody EmployeeVo employeeVo) {
		EmployeeVo employeeVos = employeeService.addEmployeeVo(employeeVo);
		if (employeeVos != null) {
			logger.info("Employee added successfully");
			System.out.println("Controller class -> " + employeeVos);
			return ResponseEntity.status(HttpStatus.OK).body(employeeVos);
		} else {
			logger.info("Details Insertion Error");
			return new ResponseEntity<EmployeeVo>(HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping("/getEmployee")
	public ResponseEntity<List<EmployeeVo>> getEmployeeVo() {
		List<EmployeeVo> employeeVo = employeeService.getEmployeeVo();
		logger.info("Fetching List of Employeee details");
		return ResponseEntity.ok(employeeVo);
	}


	@GetMapping("/healthcheck")
	public ResponseEntity<HealthCheck> healthcheck() {
		HealthCheck healthcheck = employeeService.healthcheck();
		return ResponseEntity.status(HttpStatus.OK).body(healthcheck);
	}
	

}
