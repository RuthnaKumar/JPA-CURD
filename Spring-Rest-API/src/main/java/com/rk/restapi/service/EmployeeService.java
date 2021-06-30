package com.rk.restapi.service;

import java.util.List;
import com.rk.restapi.model.Employee;
public interface EmployeeService {
	
	List<Employee> getEmployees(int pageNumber , int pageSize);
	//SAVE DATA TO DATABASE
	Employee saveEmployee (Employee employee);
	//FETCH SINGLE DATA FROM DATABASE
	Employee getSingleEmployee(Long id);
	//DELETE DATA FROM DATABASE
	void deleteEmployee(Long id);
	//UPDATE DATA TO DATABASE
	Employee updateEmployee(Employee employee);
	//FETCH DATA BY NAME
	List<Employee> getEmployeesByName(String name);
	//FETCH DATA BY NAME AND LOCATION
	List<Employee> getEmployeesByNameAndLocation(String name,String location);
	//FETCH DATA BY EMAIL
	List<Employee> getEmployeesByEmail(String email);
	//FETCH DATA BY KEYWORD
	List<Employee> getEmployeesByKeyword(String name);
	//JPQL QUERY FOR FETCH DATA FROM DATABASE
	List<Employee> getEmployeesByNameOrLocation(String name,String location);
	//JPQL QUERY FOR DELETE DATA FROM DATABASE
	Integer deleteEmployeeByName(String name);
	
}
