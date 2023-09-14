package com.task.employee.test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.employee.eo.EmployeeEo;
import com.task.employee.model.EmployeeDto;
import com.task.employee.model.HealthCheck;

@AutoConfigureMockMvc
@SpringBootTest
public class EmployeeBoImplTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private EmployeeEo employeeEo;
	private ObjectMapper object = new ObjectMapper();

	@Test
	void addEmployeeDtoTest() throws Exception {
		EmployeeDto employeeDto = new EmployeeDto(1, "Arun", "arun@cg.com");
		String json = object.writeValueAsString(employeeDto);
		System.out.println("boimpl class----->" + employeeDto);

		when(employeeEo.addEmployeeDto(any())).thenReturn(employeeDto);

		mockMvc.perform(post("/empdetails/addEmployee").content(json).contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());

	}

	@Test
	void getEmployeeVoDtoTest() throws Exception {
		List<EmployeeDto> getEmpBoList = new ArrayList<EmployeeDto>();
		EmployeeDto getemployeeVos1 = new EmployeeDto(1, "Arun", "arun@cg.com");
		EmployeeDto getemployeeVos2 = new EmployeeDto(2, "Kumar", "kumar@cg.com");
		EmployeeDto getemployeeVos3 = new EmployeeDto(3, "Reddy", "reddy@cg.com");

		getEmpBoList.add(getemployeeVos1);
		getEmpBoList.add(getemployeeVos2);
		getEmpBoList.add(getemployeeVos3);
		System.out.println("controller class----->" + getEmpBoList);

		when(employeeEo.getEmployeeDto()).thenReturn(getEmpBoList);

		mockMvc.perform(get("/empdetails/getEmployee")).andDo(print()).andExpect(status().isOk());

	}
	
	


	 @Test
   public void healthCheck()  throws Exception{
	   HealthCheck healthCheck=new HealthCheck("Checking for table in databse","success","table found");
	   String json=object.writeValueAsString(healthCheck);
	   when(employeeEo.healthcheck()).thenReturn(healthCheck);
	   mockMvc.perform(get("/empdetails/healthcheck").content(json)
   		    .contentType(MediaType.APPLICATION_JSON_VALUE)
               .accept(MediaType.APPLICATION_JSON))
               .andDo(print())
               .andExpect(status().isOk());
	  when(employeeEo.getEmployeeDto()).thenReturn(null);

	     mockMvc.perform(get("/empdetails/healthcheck")
	             .contentType(MediaType.APPLICATION_JSON_VALUE)
	             .accept(MediaType.APPLICATION_JSON))
	             .andDo(print())
	             .andExpect(status().isBadRequest());
   }

	


}
