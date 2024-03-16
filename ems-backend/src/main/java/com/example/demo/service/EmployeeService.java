package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;

public interface EmployeeService {
	Employee createEmployee(Employee employeeDto);
	Employee getEmployeeById(Long employeeId);
	List<Employee> getAllEmployees();
	Employee updateEmployee(Long employeeId, EmployeeDto updatedEmployee);
	void deleteEmployee(Long employeeId);
}
