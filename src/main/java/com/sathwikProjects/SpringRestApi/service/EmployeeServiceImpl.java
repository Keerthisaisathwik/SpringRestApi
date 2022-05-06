package com.sathwikProjects.SpringRestApi.service;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.sathwikProjects.SpringRestApi.model.Employee;
import com.sathwikProjects.SpringRestApi.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository eRepository;
	
	@Override
	public List<Employee> getEmployees(int pageNumber,int pageSize) {
		Pageable pages = PageRequest.of(pageNumber, pageSize, Direction.DESC,"id","name" );
		return eRepository.findAll(pages).getContent();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return eRepository.save(employee);
	}

	@Override
	public Employee getSingleEmployee(Long id) {
		Optional<Employee> employee = eRepository.findById(id);
		if(employee.isPresent())
			return employee.get();
		throw new RuntimeException("Employee not found for the given id: "+id);
	}

	@Override
	public void deleteEmployee(Long id) {
		eRepository.deleteById(id);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return eRepository.save(employee);
	}

	@Override
	public List<Employee> getEmployeesByName(String name) {
		return eRepository.findByName(name);
	}

	@Override
	public List<Employee> getEmployeesByNameAndLocation(String name, String location) {
		return eRepository.findByNameAndLocation(name, location);
	}

	@Override
	public List<Employee> getEmployeesByKeyword(String name) {
		Sort sort = Sort.by(Sort.Direction.ASC,"id");
		return eRepository.findByNameContaining(name,sort);
	}

	@Override
	public List<Employee> getEmployeesByNameOrLocation(String name, String location) {
		return eRepository.getEmployeesByNameOrLocation(name, location);
	}

	@Override
	public Integer deleteEmployeeByName(String name) {
		return eRepository.deleteEmployeesByName(name);
	}

}
