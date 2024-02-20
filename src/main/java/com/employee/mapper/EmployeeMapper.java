package com.employee.mapper;

import com.employee.dto.EmployeeDto;
import com.employee.entity.Employee;

public class EmployeeMapper {
	
	public static Employee mapToEmployee(EmployeeDto employeDto) {
		Employee emp = new Employee(
				employeDto.getId(),
				employeDto.getFirstName(),
				employeDto.getLastName(),
				employeDto.getEmail()
				
		);
		
		return emp;
	}
	
	public static EmployeeDto mapToEmployeeDto(Employee employee) {
		EmployeeDto employeeDto = new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail()
				
				);
		return employeeDto;
	}

}
