package com.rk.restapi.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rk.restapi.model.Employee;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
	//FETCH DATA BY NAME
	List<Employee> findByName(String name);

	//FETCH DATA BY NAME AND LOCATION = (SELECT *FROM table WHERE name="rk" AND location="india")
	List<Employee> findByNameAndLocation(String name,String location);
	
	//FETCH DATA BY EMAIL
	List<Employee> findByEmail(String email);
	
	//SELECR * FROM table WHERE name LIKE "%rk%"
	List<Employee> findByNameContaining(String keyword,Sort sort);
	
	//JPQL QUERY FOR FETCH DATA FROM DATABASE
	@Query("FROM Employee WHERE name = :name OR location =:location")
	List<Employee> getEmployeesByNameOrLocation(String name ,String location);
	
	//JPQL QUERY FOR DELETE DATA FROM DATABASE
	@Transactional                                              // FOR JPQL CREATE,DELETE,UPDATE
	@Modifying                                                 //FOR JPQL CREATE,DELETE,UPDATE
	@Query("DELETE FROM Employee WHERE name =:name")
	Integer deleteEmployeeByName(String name);                 //DETETE will have return type so Integer(no.of time query will hits)
	
}
