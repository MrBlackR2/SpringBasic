package com.employee.app.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.employee.app.model.EmployeeModel;

@Repository
public interface EmployeeDao extends JpaRepository<EmployeeModel, Integer>{
	
	List<EmployeeModel> findByfirstName(String searchName);
	
	//List<EmployeeModel> findByempSalaryGreaterThan(long salary);
	
	Page<EmployeeModel> findAll(Pageable pageable);
	Page<EmployeeModel> findBysex(String searchName, Pageable pageable);
	//Page<EmployeeModel> findBysex(String searchName, Pageable pageable);
	
	//Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
	
}
 