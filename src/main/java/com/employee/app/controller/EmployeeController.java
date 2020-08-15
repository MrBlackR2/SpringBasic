package com.employee.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.app.model.EmployeeModel;
import com.employee.app.service.EmployeeServiceImp;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	public EmployeeServiceImp empService;
	private final int pageSize = 2;

	/* Create Operation */
	@PostMapping
	public EmployeeModel newEmployee(@RequestBody EmployeeModel emp){
		empService.addEmp(emp);
		return emp;
		
	}
	
	/* Request Operation by Id */
	@GetMapping("{empId}")
	public EmployeeModel getEmpbyId(@PathVariable("empId") int empId){
		return empService.getEmp(empId);
	}
	
	// Request Operation
	/*
	@GetMapping
	public List<EmployeeModel> getListofemp(){
		
		return empService.getAllEmp();
	}*/
	
	/* Update Operation */
	@PutMapping
	public EmployeeModel UpdateEmp(@RequestBody(required = true) EmployeeModel emp){
		EmployeeModel empUpdate = empService.UpdateEmp(emp);
		 return empUpdate;
	}
	
	/* Delete Operation */
	@DeleteMapping("{empId}")
	public String DeleteEmp(@PathVariable("empId") int empId){
		empService.DelEmp(empId);
		return "Delete operation performed successfully";
	}
	
	/* Count total Employee */
	@GetMapping(value = "/empTotal", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String countEmp(){
		String total = "Total Number of employee is "  + empService.countEmp();
		return total;
	}
	
	/* Serach employee by name */
	@GetMapping("/search/{empSearch}")
	public List<EmployeeModel> findByempName(@PathVariable("empSearch") String empSearch){
		return empService.findByname(empSearch);
	}
	
	/* Search employee by salary */
	@GetMapping("/salary/{empSalary}")
	public List<EmployeeModel> findByempSalary(@PathVariable("empSalary") long empSalary){
		return empService.findlistempGreaterThan(empSalary);
	}
	
	/* Paging and sorting */
	@GetMapping
	public Page<EmployeeModel> getEmpbyPage(@RequestParam(required = true) String empname, @RequestParam(defaultValue = "0") int page, Pageable pageable){
		
		Pageable paging = PageRequest.of(page, pageSize);
		return empService.findempbyPage(empname, paging);
	}
}
