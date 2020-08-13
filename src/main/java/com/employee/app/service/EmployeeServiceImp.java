package com.employee.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.app.dao.EmployeeDao;
import com.employee.app.model.EmployeeModelEntity;


@Service
public class EmployeeServiceImp {

	@Autowired
	public EmployeeDao RepoDao;
	
	public void addEmp(EmployeeModelEntity emp) {
			//RepoDao.findByLastname(String lastname);
			RepoDao.save(emp);
	}

	public EmployeeModelEntity getEmp(int empId) {
		Optional<EmployeeModelEntity> getimp = RepoDao.findById(empId);
		return getimp.get();
	}
	
	public List<EmployeeModelEntity> getAllEmp(){
		//List listEmp = new ArrayList<employee>(); 
		List listEmp = (List<EmployeeModelEntity>) RepoDao.findAll();
		return listEmp; 
	}
	
	public void UpdateEmp(int empId){
		EmployeeModelEntity empRetrive = getEmp(empId);
		empRetrive.setEmpDept("update");
		RepoDao.save(empRetrive);
	}
	
	public void DelEmp(int empId){
		//employee empRetrive = getEmp(empId);
		RepoDao.deleteById(empId);	
	}
	
	public long countEmp(){
		long totalEmployee = RepoDao.count();
		return totalEmployee;
	}

	
	public List<EmployeeModelEntity> FindByfirstOrlastName(String str){
		List<EmployeeModelEntity> listemp = RepoDao.findByempName(str);
		System.out.println(listemp);
		//RepoDao.
		return listemp;
	}

}
