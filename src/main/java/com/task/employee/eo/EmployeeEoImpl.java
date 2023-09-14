package com.task.employee.eo;


import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.task.employee.dao.EmployeeDao;
import com.task.employee.model.EmployeeDto;
import com.task.employee.model.HealthCheck;
@Component
public class EmployeeEoImpl implements EmployeeEo {
	@Autowired
	private EmployeeDao employeeDao;

	Logger logger=LoggerFactory.getLogger(EmployeeEo.class);
	//for 1st application method use
//	@Override
//	public EmployeeDto addEmployeeDto(EmployeeDto employeeDto) {
//		logger.info("adding employee details");
//		System.out.println("EmployeeEoImpl class -> " +employeeDto);
//		return employeeDao.addEmployeeDto(employeeDto);
//	}

	
//	//for jaxb task method
	@Override
	public EmployeeDto addEmployeeDto(EmployeeDto employeeDto) {
 
		logger.info("adding employee details");

		try {
			JAXBContext context = JAXBContext.newInstance(EmployeeDto.class);

			Marshaller marshaller = context.createMarshaller();

			StringWriter writer = new StringWriter();

			marshaller.marshal(employeeDto, writer);

			String xml = writer.toString();

			Unmarshaller unmarshaller = context.createUnmarshaller();

			EmployeeDto unmarshalledEmployeeDto = (EmployeeDto) unmarshaller.unmarshal(new StringReader(xml));

			EmployeeDto saveEmployeeDto = employeeDao.addEmployeeDto(unmarshalledEmployeeDto);

			return saveEmployeeDto;

		} catch (JAXBException e) {

			logger.error("Error while marshalling/unmarshalling EmployeeDto: " + e.getMessage());

			return null;

		}

	}

	@Override
	public List<EmployeeDto> getEmployeeDto() {
	    logger.info("get all employees details");
	    List<EmployeeDto> employeeDtoList = employeeDao.getEmployeeDto();
	    return employeeDtoList;
	}

	@Override
	public HealthCheck healthcheck() {
		// TODO Auto-generated method stub
		return null;
	}

	
	}
	
	

