package com.employee.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.app.model.EmployeeModelEntity;
import com.employee.app.service.EmployeeServiceImp;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	public EmployeeServiceImp empService;

	@PostMapping
	public EmployeeModelEntity newEmployee(@RequestBody EmployeeModelEntity emp){
		empService.addEmp(emp);
		return emp;
		
	}
	
	@GetMapping("{empId}")
	public EmployeeModelEntity getEmpbyId(@PathVariable int empId){
		return empService.getEmp(empId);
	}
	
	@GetMapping
	public List<EmployeeModelEntity> getListofemp(){
		
		return empService.getAllEmp();
	}
	
	@PutMapping("{empId}")
	public String UpdateEmp(@PathVariable("empId") int empId){
		 empService.UpdateEmp(empId);
		 
		 return "Employee has been updated ";
	}
	
	@DeleteMapping("{empId}")
	public String DeleteEmp(@PathVariable("empId") int empId){
		System.out.println("Delete operation calling");
		empService.DelEmp(empId);
		return "Delete operation performed successfully";
	}
	
	@GetMapping("/empTotal")
	public String countEmp(){
		String total = "Total Number of employee is "  + empService.countEmp();
		return total;
	}
	
	@GetMapping("/search/{empSearch}")
	public List<EmployeeModelEntity> findByfirstOrLastname(@PathVariable("empSearch") String empSearch){
		return empService.FindByfirstOrlastName(empSearch);
	}
}
