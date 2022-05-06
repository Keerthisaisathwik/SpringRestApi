package com.sathwikProjects.SpringRestApi.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sathwikProjects.SpringRestApi.model.Employee;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

	List<Employee> findByName(String name);
	
	//SELECT * FROM table WHERE name="sathwik" AND location = "India"
	List<Employee> findByNameAndLocation(String name, String location);
	
	//SELECT * FROM table WHERE name LIKE %ram%
	List<Employee> findByNameContaining(String keyword, Sort sort);
	//List<Employee> findByNameLike(String keyword); //where keyword = ("%"+keyword+"%")
	
	//When you can't use finder methods (or) query methods, we use jpql query method
	//coloum name equals to ":" + variable name. I intentionally wrote "namee" for variable name to understand better.
	@Query("FROM Employee WHERE name= :namee OR location= :location")
	List<Employee> getEmployeesByNameOrLocation(String namee, String location);
	//List<Employee> getEmployeesByNameOrLocation(@Param("name") String abc, String location);
	//@Param used when name is not matched with variable name.
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Employee WHERE name= :name")
	Integer deleteEmployeesByName(String name);
}
