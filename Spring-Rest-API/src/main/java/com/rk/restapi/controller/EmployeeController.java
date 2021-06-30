package com.rk.restapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rk.restapi.model.Employee;
import com.rk.restapi.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService eService;

	
	/* For Application Details
	 * @Value("${app.name}") private String appName;
	 * 
	 * @Value("${app.version}") private String appVersion;
	 * 
	 * 
	 * @GetMapping("/version") public String getAppDetails () { return appName+ "-"
	 * +appVersion; }
	 */
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees(@RequestParam Integer pageNumber , @RequestParam Integer pageSize) {           //ResponseEntity for HttpStatus code
		return new ResponseEntity<List<Employee>>(eService.getEmployees(pageNumber,pageSize),HttpStatus.OK);
	}
	
	//FETCH SINGLE DATA FROM DATABASE
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) {
		return new ResponseEntity<Employee>(eService.getSingleEmployee(id),HttpStatus.OK);
	}
	
	//SAVE DATA TO DATABASE
	@PostMapping("/employees")
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
		return new ResponseEntity<Employee>(eService.saveEmployee(employee),HttpStatus.CREATED);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable ("id") Long id,@RequestBody Employee employee) {
		employee.setId(id);
		return new ResponseEntity<Employee>(eService.updateEmployee(employee), HttpStatus.OK);
	}
	
	@DeleteMapping("/employees")
	public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam("id") Long id) {
		return new  ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);     //eService.deleteEmployee(id);
	}
	
	//FETCH DATA BY NAME
	@GetMapping("/employees/filterByName")
	public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name){
		return new ResponseEntity<List<Employee>> (eService.getEmployeesByName(name),HttpStatus.OK);
		
	}
	
	
	//FETCH DATA BY NAME AND LOCATION
	@GetMapping("/employees/filterByNameAndLocation")
	public ResponseEntity<List<Employee>> getEmployeesByNameAndLocation(@RequestParam String name , @RequestParam String location){
		return new ResponseEntity<List<Employee>> (eService.getEmployeesByNameAndLocation(name,location),HttpStatus.OK);
		
	}
	
	//FETCH DATA BY EMAIL
	@GetMapping("/employees/filterByEmail")
	public ResponseEntity<List<Employee>> getEmployeesByEmail(@RequestParam String email){
		return new ResponseEntity<List<Employee>> (eService.getEmployeesByEmail(email),HttpStatus.OK);
		
	}
	
	//FETCH DATA BY KEYWORD
		@GetMapping("/employees/filterByKeyword")
		public ResponseEntity<List<Employee>> getEmployeesByKeyword(@RequestParam String name ){
			return new ResponseEntity<List<Employee>> (eService.getEmployeesByKeyword(name),HttpStatus.OK);
			
		}
		
	//JPQL QUERY FOR FETCH DATA FROM DATABASE
			@GetMapping("/employees/{name}/{location}")
			public ResponseEntity<List<Employee>> getEmployeesByNameOrLocation(@PathVariable String name,@PathVariable String location ){
				return new ResponseEntity<List<Employee>> (eService.getEmployeesByNameOrLocation(name,location),HttpStatus.OK);
					
		}
			
			
	//JPQL QUERY FOR DELETE DATA FROM DATABASE
			@DeleteMapping("/employees/delete/{name}")
			public ResponseEntity<String> deleteEmployeeByName(@PathVariable String name){
				return new ResponseEntity<String> (eService.deleteEmployeeByName(name)+"No.of Records Deleted",HttpStatus.OK);
					
			}
			
			
			
	
}
