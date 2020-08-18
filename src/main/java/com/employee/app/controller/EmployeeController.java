package com.employee.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
@RequestMapping(value = "/api")
public class EmployeeController {
	@Autowired
	public EmployeeServiceImp employeeServiceImp;
	private final int pageSize = 2;

	@PostMapping("/employee")
	public ResponseEntity<EmployeeModel> createNewEmployee(@RequestBody EmployeeModel employee){
		EmployeeModel createdEmployee = employeeServiceImp.addEmployee(employee);
		return ResponseEntity.ok().body(createdEmployee);
	}
	
	@GetMapping("/employee/{employeeId}")
	public ResponseEntity<EmployeeModel> getEmployee(@PathVariable("employeeId") int employeeId){
		EmployeeModel employee = employeeServiceImp.retriveEmployee(employeeId);
		if(employee != null){
			return ResponseEntity.ok().body(employee);
		}else{
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/employee/getlist")
	public ResponseEntity<List<EmployeeModel>> getListofemp(){
		List employees = employeeServiceImp.retriveEmployees();
		if(employees != null){
			return ResponseEntity.ok().body(employees);
		}else{
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/employee/update/{employeeId}")
	public ResponseEntity<EmployeeModel> updateEmployeeDetails(@RequestBody EmployeeModel employee, 
		@PathVariable int employeeId){
		EmployeeModel updatedEmployee = employeeServiceImp.updateEmployee(employee, employeeId);
		if(updatedEmployee != null){
			return ResponseEntity.accepted().body(updatedEmployee);
		}else{
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/employee/{employeeId}")
	public ResponseEntity<EmployeeModel> employeeDelete(@PathVariable("employeeId") int employeeId){
		employeeServiceImp.deleteEmployee(employeeId);
		return ResponseEntity.noContent().build();
				//"Delete operation performed successfully";
	}
	
	@GetMapping(value = "/employee/employeeCount")
	@ResponseBody
	public String countEmp(){
		String total = "Total Number of employee is "  + employeeServiceImp.countEmp();
		return total;
	}
	
	/*@GetMapping("/search/{empSearch}")
	public List<EmployeeModel> findByempName(@PathVariable("empSearch") String empSearch){
		return employeeServiceImp.findByname(empSearch);
	}*/
	
	/*@GetMapping("/salary/{empSalary}")
	public List<EmployeeModel> findByempSalary(@PathVariable("empSalary") long empSalary){
		return employeeServiceImp.findlistempGreaterThan(empSalary);
	}*/
	
	/*@GetMapping("/employee")
	public Page<EmployeeModel> getEmpbyPage(@RequestParam(required = true) String empname, 
		@RequestParam(defaultValue = "0") int page, Pageable pageable){
		Pageable paging = PageRequest.of(page, pageSize);
		return employeeServiceImp.findempbyPage(empname, paging);
	}*/
}
