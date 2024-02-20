package com.employee.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.employee.dto.EmployeeDto;
import com.employee.entity.Employee;
import com.employee.mapper.EmployeeMapper;
import com.employee.repository.EmpRepository;
import com.employee.service.EmployeeService;

@Service
public class EmployeeserviceImpl implements EmployeeService {
	
	private EmpRepository empRepository;
	
	public EmployeeserviceImpl(EmpRepository empRepository) {
		super();
		this.empRepository = empRepository;
	}



	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee saveEmployee = empRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(saveEmployee);
	}



	@Override
	public EmployeeDto getEmployeeById(Integer id) {
		Employee employee = empRepository
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exist"));
			     return EmployeeMapper.mapToEmployeeDto(employee);
	}



	@Override
	   public EmployeeDto updateEmployee(Integer id, EmployeeDto employeeDto) {
        Employee employee = empRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee with ID " + id + " not found"));
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        Employee updatedEmployee = empRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }



	@Override
	public List<EmployeeDto> getAllEmployees() {
	    List<Employee> employees = empRepository.findAll();
	    return employees.stream()
	            .map(employee -> EmployeeMapper.mapToEmployeeDto(employee))
	            .collect(Collectors.toList());
	}



	@Override
	public void deleteEmployee(Integer id) {
		Employee employee = empRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee with ID " + id + " not found"));
		empRepository.deleteById(id);
		
	}
	
	
	
	
	
	
}
