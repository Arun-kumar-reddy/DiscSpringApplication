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
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.employee.model.EmployeeDto;
@AutoConfigureMockMvc
@SpringBootTest
public class EmployeeDaoImplTest {
	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
	JdbcTemplate jdbcTemplate;
	private ObjectMapper object=new ObjectMapper();
	
	
	@Test
    void addEmployeeDto() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto(1, "Arun", "arun@cg.com");
        String json = object.writeValueAsString(employeeDto);

        when(jdbcTemplate.update("INSERT INTO EmployeeDetails (EmpId,EmpName,EmpEmail) VALUES ('" + employeeDto.getEmpId() + "','"
        		+ employeeDto.getEmpName() + "','" + employeeDto.getEmpEmail() + "')"))
        .thenReturn(1);
 
        System.out.println("dao class----->" + employeeDto);

        mockMvc.perform(post("/empdetails/addEmployee")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
                
    }
	@Test
	void getEmployeeDto() throws Exception {
		List<EmployeeDto> getEmpDaoList = new ArrayList<EmployeeDto>();
		EmployeeDto getemployeeVos1 = new EmployeeDto(1, "Arun", "arun@cg.com");
		EmployeeDto getemployeeVos2 = new EmployeeDto(2, "Kumar", "kumar@cg.com");
		EmployeeDto getemployeeVos3 = new EmployeeDto(3, "Reddy", "reddy@cg.com");
		
		getEmpDaoList.add(getemployeeVos1);
		getEmpDaoList.add(getemployeeVos2);
		getEmpDaoList.add(getemployeeVos3);
		System.out.println("controller class----->" + getEmpDaoList);

		String query = "SELECT * FROM EmployeeDetails";
		when(jdbcTemplate.query(query, new BeanPropertyRowMapper<>(EmployeeDto.class)))
        .thenReturn(getEmpDaoList);

		mockMvc.perform(get("/empdetails/getEmployee"))
		        .andDo(print())
		        .andExpect(status().isOk());
				
	}



}
