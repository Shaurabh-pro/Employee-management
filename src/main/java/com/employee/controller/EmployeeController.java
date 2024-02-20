package com.employee.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.EmployeeDto;
import com.employee.service.EmployeeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	//ADD EMPLOYEE
	@PostMapping
	public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto){
		return new ResponseEntity<>(employeeService.saveEmployee(employeeDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Integer id){
		EmployeeDto employeeDto = employeeService.getEmployeeById(id);
		return ResponseEntity.ok(employeeDto);
	}
	
	//GET ALL EMPLOYEE
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
	 List<EmployeeDto> employeeDto = 	employeeService.getAllEmployees();
	 return ResponseEntity.ok(employeeDto);
	}
	
	//UPDATE EMPLOYEE
	@PutMapping("/update/{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Integer id,@RequestBody EmployeeDto employeeDto){
	EmployeeDto updateEmployee = employeeService.updateEmployee(id, employeeDto);
	return ResponseEntity.ok(updateEmployee);
	}
	
	//DELETE EMPLOYEE
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer id){
		employeeService.deleteEmployee(id);
		return ResponseEntity.ok("employee deleted successfully");
	}
	
	

}
