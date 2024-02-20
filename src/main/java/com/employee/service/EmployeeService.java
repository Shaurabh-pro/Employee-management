package com.employee.service;

import java.util.List;

import com.employee.dto.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto saveEmployee(EmployeeDto employeeDto);
	
	EmployeeDto getEmployeeById(Integer id);
	
	EmployeeDto updateEmployee(Integer id, EmployeeDto employeeDto);
	
	List<EmployeeDto> getAllEmployees();
	
	void deleteEmployee(Integer id);
	
	
}
