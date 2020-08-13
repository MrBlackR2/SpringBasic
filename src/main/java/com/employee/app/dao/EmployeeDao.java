package com.employee.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.employee.app.model.EmployeeModelEntity;

@Repository
//public interface empDAO extends CrudRepository<employee, Integer> {
public interface EmployeeDao extends JpaRepository<EmployeeModelEntity, Integer>{
	
	//@Query("FROM employee WHERE empName = ?1")
	//List<employee> findByFirstname(String searchName);
	List<EmployeeModelEntity> findByempName(String searchName);
	
}
 