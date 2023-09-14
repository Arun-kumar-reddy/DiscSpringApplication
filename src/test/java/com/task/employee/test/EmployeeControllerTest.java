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
import com.task.employee.model.EmployeeVo;
import com.task.employee.model.HealthCheck;
import com.task.employee.service.EmployeeService;

@AutoConfigureMockMvc
@SpringBootTest
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeService employeeService;
	private ObjectMapper object = new ObjectMapper();

//	@Test
//	void addEmployeeVo() throws Exception {
//		EmployeeVo addemployeeVos = new EmployeeVo(1, "Arun", "arun@cg.com");
//		System.out.println("controller class----->" + addemployeeVos);
//
//		String json = object.writeValueAsString(addemployeeVos);
//		
//		when(employeeService.addEmployeeVo(any())).thenReturn(addemployeeVos);
//			
//
//		mockMvc.perform(post("/empdetails/addEmployee").content(json).contentType(MediaType.APPLICATION_JSON_VALUE)
//				.accept(MediaType.APPLICATION_JSON))
//		        .andDo(print())
//		        .andExpect(status().isOk());
//			
//			when(employeeService.addEmployeeVo(any())).thenReturn(null);
//				
//
//			mockMvc.perform(post("/empdetails/addEmployee").content(json).contentType(MediaType.APPLICATION_JSON_VALUE)
//					.accept(MediaType.APPLICATION_JSON))
//			        .andDo(print())
//			        .andExpect(status().isBadRequest());
//		}
		
		
	@Test
	void addEmployeeVo() throws Exception {
		EmployeeVo addemployeeVos = new EmployeeVo(1, "Arun", "arun@cg.com");
		System.out.println("controller class----->" + addemployeeVos);

		String json = object.writeValueAsString(addemployeeVos);
		
		when(employeeService.addEmployeeVo(any()))
		.thenReturn(addemployeeVos)
		.thenReturn(null);
			

		mockMvc.perform(post("/empdetails/addEmployee").content(json).contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON))
		        .andDo(print())
		        .andExpect(status().isOk());
				  
		mockMvc.perform(post("/empdetails/addEmployee").content(json).contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON))
		        .andDo(print())
		        .andExpect(status().isBadRequest());
		}
		
	
	@Test
	void getEmployeeVo() throws Exception {
		List<EmployeeVo> getEmpContList = new ArrayList<EmployeeVo>();
		EmployeeVo getemployeeVos1 = new EmployeeVo(1, "Arun", "arun@cg.com");
		EmployeeVo getemployeeVos2 = new EmployeeVo(2, "Kumar", "kumar@cg.com");
		EmployeeVo getemployeeVos3 = new EmployeeVo(3, "Reddy", "reddy@cg.com");
		
		getEmpContList.add(getemployeeVos1);
		getEmpContList.add(getemployeeVos2);
		getEmpContList.add(getemployeeVos3);
		System.out.println("controller class----->" + getEmpContList);

		when(employeeService.getEmployeeVo()).thenReturn(getEmpContList);

		mockMvc.perform(get("/empdetails/getEmployee"))
		        .andDo(print())
		        .andExpect(status().isOk());
				
	}
    @Test
    void healthCheck()  throws Exception{
 	   HealthCheck healthCheck=new HealthCheck("Check table is available in db","Success","Table is available");
 	   String json=object.writeValueAsString(healthCheck);
 	   when( employeeService.healthcheck()).thenReturn(healthCheck);
 	   mockMvc.perform(get("/empdetails/healthcheck").content(json)
    		    .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
	
}
