package com.employee.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.employee.app.dao.EmployeeDao;
import com.employee.app.model.EmployeeModel;

@Service
public class EmployeeServiceImp {
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	UpdateEmployeeDetails updateEmployee;
	
	public EmployeeModel addEmployee(EmployeeModel employee) {
		EmployeeModel newEmployee = employeeDao.save(employee);
			return newEmployee;
	}

	public EmployeeModel retriveEmployee(int employeeId) {
		Optional<EmployeeModel> employee = employeeDao.findById(employeeId);
		
		if(employee.isPresent()){
			return employee.get();	
		}
		else{
			return null;
		}
	}
	
	public List<EmployeeModel> retriveEmployees(){
		List employees = (List<EmployeeModel>) employeeDao.findAll();
		return employees; 
	}
	
	public EmployeeModel updateEmployee(EmployeeModel employee, int employeeId){
		EmployeeModel employeeModel = retriveEmployee(employeeId);
		if(employeeModel != null){
			EmployeeModel employeeUpdate = updateEmployee.update(employee, employeeModel);
			return employeeDao.save(employeeUpdate);
		}else{
			return null;
		}
	}
	
	public void deleteEmployee(int employeeId){
		employeeDao.deleteById(employeeId);	
	}
	
	public long countEmp(){
		long totalEmployee = employeeDao.count();
		return totalEmployee;
	}

	public Page<EmployeeModel> pagingEmpoyee (Pageable pageable){
		Page<EmployeeModel> pageEmployee = employeeDao.findAll(pageable);
				//findByempName(empName, pageable);		
		return pageEmployee;
	}
	
	/*public List<EmployeeModel> findByname(String str){
		List<EmployeeModel> listEmp = employeeDao.findByempName(str);
		return listEmp;
	}*/

	/*public List<EmployeeModel> findlistempGreaterThan(long salary){
		List<EmployeeModel> listEmp = employeeDao.findByempSalaryGreaterThan(salary);
		return listEmp;
	}*/
	

}
