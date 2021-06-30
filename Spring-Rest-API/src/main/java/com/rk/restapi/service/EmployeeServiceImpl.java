package com.rk.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.PageRequest;
import com.rk.restapi.model.Employee;
import com.rk.restapi.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	@Autowired
	private EmployeeRepository eRepository;
	
	@Override
	public List<Employee> getEmployees(int pageNumber , int pageSize){
		Pageable pages = PageRequest.of(pageNumber , pageSize,Direction.DESC, "id");           //PAGINATION AND SORTIN / DESC for Deserting / ASC for Ascending
		return eRepository.findAll(pages).getContent();
	}
	//SAVE DATA TO DATABASE
	@Override
	public Employee saveEmployee(Employee employee) {
		return eRepository.save(employee);
	}
	
	//FETCH SINGLE DATA FORM DATABASE
	@Override
	public Employee getSingleEmployee(Long id) {
		 Optional<Employee> employee = eRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		throw new RuntimeException("Employee is not found for the id " + id);
	}
	
	//DELETE DATA FROM DATABASE
	@Override
	public void deleteEmployee(Long id) {
		eRepository.deleteById(id);
	}
	
	//UPADATE DATA TO DATABASE
	@Override
	public Employee updateEmployee(Employee employee) {
		return eRepository.save(employee);
	}

	//FETCH DATA BY NAME
	@Override
	public List<Employee> getEmployeesByName(String name) {
		return eRepository.findByName(name);
	}

	//FETCH DATA BY NAME AND LOCATION
	@Override
	public List<Employee> getEmployeesByNameAndLocation(String name, String location) {
		return eRepository.findByNameAndLocation(name,location);
	}
	
	//FETCH DATA BY EMAIL
		@Override
		public List<Employee> getEmployeesByEmail(String email) {
			return eRepository.findByEmail(email);
		}
		
	//FECT DATA BY KEYWORD
		@Override
		public List<Employee> getEmployeesByKeyword(String name){
			Sort sort =Sort.by(Sort.Direction.DESC, "id");           //DESC for Deserting / ASC for Ascending
			return eRepository.findByNameContaining(name, sort);
		}
		
		//JPQL QUERE FOR FETCH DATA FROM DATABASE
		@Override
		public List<Employee> getEmployeesByNameOrLocation(String name, String location) {
			return eRepository.getEmployeesByNameOrLocation(name,location);
		}
		
		//JPQL QUERE FOR DELETE DATA FROM DATABASE
		@Override
		public Integer deleteEmployeeByName(String name) {
			return eRepository.deleteEmployeeByName(name);
		}
		
		
		
}
