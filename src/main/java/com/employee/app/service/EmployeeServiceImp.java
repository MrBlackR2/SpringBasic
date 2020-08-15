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
	private EmployeeDao empRepoIns;
	
	public void addEmp(EmployeeModel emp) {
			//empRepoIns.findByLastname(String lastname);
			empRepoIns.save(emp);
	}

	public EmployeeModel getEmp(int empId) {
		Optional<EmployeeModel> getimp = empRepoIns.findById(empId);
		return getimp.get();
	}
	
	public List<EmployeeModel> getAllEmp(){
		List listEmp = (List<EmployeeModel>) empRepoIns.findAll();
		return listEmp; 
	}
	
	public EmployeeModel UpdateEmp(EmployeeModel emp){
		EmployeeModel empRetrive = getEmp(emp.getEmpId());
		empRetrive.setEmpDept(emp.getEmpDept());
		//empRetrive.setEmpSalary(emp.getEmpSalary() + 9999);		
		return empRepoIns.save(empRetrive);
	}
	
	public void DelEmp(int empId){
		empRepoIns.deleteById(empId);	
	}
	
	public long countEmp(){
		long totalEmployee = empRepoIns.count();
		return totalEmployee;
	}

	
	public List<EmployeeModel> findByname(String str){
		List<EmployeeModel> listEmp = empRepoIns.findByempName(str);
		return listEmp;
	}

	public List<EmployeeModel> findlistempGreaterThan(long salary){
		List<EmployeeModel> listEmp = empRepoIns.findByempSalaryGreaterThan(salary);
		return listEmp;
	}
	
	public Page<EmployeeModel> findempbyPage(String empName, Pageable pageable){
		Page<EmployeeModel> listEmp = empRepoIns.findByempName(empName, pageable);
		return listEmp;
	}
}
