package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long employeeId) {
		Employee employee= employeeRepository.findById(employeeId)
			.orElseThrow(() 
					-> new ResourceNotFoundException("Employee is not exist with given id: "+employeeId));
		
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees= employeeRepository.findAll();
		return employees;
	}

	@Override
	public Employee updateEmployee(Long employeeId, EmployeeDto empUpdatedData) {
		Employee employee= employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee is not exists with give id"));
		employee.setFirstName(empUpdatedData.getFirstName());
		employee.setLastName(empUpdatedData.getLastName());
		employee.setEmail(empUpdatedData.getEmail());
		
		employeeRepository.save(employee);
		return employee;
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		
		Employee employee= employeeRepository.findById(employeeId).orElseThrow(
							() -> new ResourceNotFoundException("Employee is not exist with given id: "+employeeId)
		);
		employeeRepository.deleteById(employeeId);
	}
	
}
