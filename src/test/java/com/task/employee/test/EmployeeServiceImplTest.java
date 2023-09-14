package com.task.employee.test;

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
import com.task.employee.bo.EmployeeBo;
import com.task.employee.mapper.EmployeeMapper;
import com.task.employee.model.EmployeeVo;
import com.task.employee.model.HealthCheck;

@AutoConfigureMockMvc
@SpringBootTest
public class EmployeeServiceImplTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeMapper employeeMapper;
	@MockBean
	private EmployeeBo employeeBo;
	private ObjectMapper object = new ObjectMapper();

	@Test
	void addEmployeeVoTest() throws Exception {
		EmployeeVo employeeVos = new EmployeeVo(1, "Arun", "arun@cg.com");
		System.out.println("service class ----->" + employeeVos);
		String json = object.writeValueAsString(employeeVos);

		when(employeeMapper.employeeDtoToEmployeeVo(
				employeeBo.addEmployeeDto(employeeMapper.employeeVoToEmployeeDto(employeeVos))))
				.thenReturn(employeeVos);

		mockMvc.perform(post("/empdetails/addEmployee").content(json).contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());

	}

	@Test
	void getEmployeeVoTest() throws Exception {
		List<EmployeeVo> getEmpServList = new ArrayList<EmployeeVo>();
		EmployeeVo getemployeeVos1 = new EmployeeVo(1, "Arun", "arun@cg.com");
		EmployeeVo getemployeeVos2 = new EmployeeVo(2, "Kumar", "kumar@cg.com");
		EmployeeVo getemployeeVos3 = new EmployeeVo(3, "Reddy", "reddy@cg.com");

		getEmpServList.add(getemployeeVos1);
		getEmpServList.add(getemployeeVos2);
		getEmpServList.add(getemployeeVos3);
		System.out.println("service class----->" + getEmpServList);

		when(employeeMapper.toEmployeeVos(employeeBo.getEmployeeDto())).thenReturn(getEmpServList);

		mockMvc.perform(get("/empdetails/getEmployee")).andDo(print()).andExpect(status().isOk());

	}
	   @Test
       void healthCheck()  throws Exception{
   	   HealthCheck healthCheck=new HealthCheck("check table is available in db","Success","table is available");
   	   String json=object.writeValueAsString(healthCheck);
   	   when(employeeBo.healthcheck()).thenReturn(healthCheck);
   	   mockMvc.perform(get("/empdetails/healthcheck").content(json)
      		    .contentType(MediaType.APPLICATION_JSON_VALUE)
                  .accept(MediaType.APPLICATION_JSON))
                  .andDo(print())
                  .andExpect(status().isOk());
      }
}
