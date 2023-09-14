package com.task.employee.mapper;

import com.task.employee.model.EmployeeDto;
import com.task.employee.model.EmployeeVo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-13T11:11:50+0530",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.1.jar, environment: Java 17.0.2 (Eclipse Adoptium)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeDto employeeVoToEmployeeDto(EmployeeVo employeeVo) {
        if ( employeeVo == null ) {
            return null;
        }

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setEmpId( employeeVo.getEmpId() );
        employeeDto.setEmpName( employeeVo.getEmpName() );
        employeeDto.setEmpEmail( employeeVo.getEmpEmail() );

        return employeeDto;
    }

    @Override
    public EmployeeVo employeeDtoToEmployeeVo(EmployeeDto employeeDto) {
        if ( employeeDto == null ) {
            return null;
        }

        EmployeeVo employeeVo = new EmployeeVo();

        employeeVo.setEmpId( employeeDto.getEmpId() );
        employeeVo.setEmpName( employeeDto.getEmpName() );
        employeeVo.setEmpEmail( employeeDto.getEmpEmail() );

        return employeeVo;
    }

    @Override
    public List<EmployeeVo> toEmployeeVos(List<EmployeeDto> list) {
        if ( list == null ) {
            return null;
        }

        List<EmployeeVo> list1 = new ArrayList<EmployeeVo>( list.size() );
        for ( EmployeeDto employeeDto : list ) {
            list1.add( employeeDtoToEmployeeVo( employeeDto ) );
        }

        return list1;
    }

    @Override
    public List<EmployeeDto> toEmployeeDtos(List<EmployeeVo> list) {
        if ( list == null ) {
            return null;
        }

        List<EmployeeDto> list1 = new ArrayList<EmployeeDto>( list.size() );
        for ( EmployeeVo employeeVo : list ) {
            list1.add( employeeVoToEmployeeDto( employeeVo ) );
        }

        return list1;
    }
}
