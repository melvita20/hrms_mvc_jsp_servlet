package com.capstone.mvc.hrms.service;

import java.util.List;

import com.capstone.mvc.hrms.domain.Employee;
import com.capstone.mvc.hrms.exception.HrmsException;



public interface EmployeeService {
	
	public Employee addEmpolyee(Employee employee) throws HrmsException;
	public List<Employee> listAllEmployees() throws HrmsException;
	public Employee deleteEmployee(int employee_id) throws HrmsException;
	public Employee editEmpolyee(Employee employee) throws HrmsException;
	public Employee findEmployee(int employee_id) throws HrmsException;
	public Employee fetchEmpDetail(int employee_id) throws HrmsException;

}
