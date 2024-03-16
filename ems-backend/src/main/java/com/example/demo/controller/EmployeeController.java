package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

//below annotation handles..HTTP requests
@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	//Request body converts JSON to Dto
	
	//Build Add Employee REST API
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		
		Employee savedEmployee= employeeService.createEmployee(employee);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}
	
	//Build Get Employee REST API
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long employeeId) {
		Employee employee= employeeService.getEmployeeById(employeeId);
		return ResponseEntity.ok(employee);
	}
	
	//Build Get All Employee REST API
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees= employeeService.getAllEmployees();
		return ResponseEntity.ok(employees);
	}
	
	//Build Update Employee REST API
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long employeeId, 
												   @RequestBody EmployeeDto updatedEmployee) {
		Employee employee= employeeService.updateEmployee(employeeId, updatedEmployee);
		return ResponseEntity.ok(employee);
	}
	
	//Build Delete Employee REST API
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {
		employeeService.deleteEmployee(employeeId);
		return ResponseEntity.ok("Employee deleted successfully");
	}
}
