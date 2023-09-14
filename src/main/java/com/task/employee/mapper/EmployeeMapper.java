package com.task.employee.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.task.employee.model.EmployeeDto;
import com.task.employee.model.EmployeeVo;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
	Logger Logger = LoggerFactory.getLogger("mapper is mapping vo to dto");
	EmployeeMapper MAPPER = Mappers.getMapper(EmployeeMapper.class);

	EmployeeDto employeeVoToEmployeeDto(EmployeeVo employeeVo);

	EmployeeVo employeeDtoToEmployeeVo(EmployeeDto employeeDto);

	List<EmployeeVo> toEmployeeVos(List<EmployeeDto> list);

	List<EmployeeDto> toEmployeeDtos(List<EmployeeVo> list);
	

}
