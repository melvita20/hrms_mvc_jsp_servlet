package com.capstone.mvc.hrms.dao;

import java.util.List;

import com.capstone.mvc.hrms.domain.Employee;
import com.capstone.mvc.hrms.domain.UserLogin;
import com.capstone.mvc.hrms.exception.HrmsException;


public interface EmployeeDetailsDao {
	public UserLogin validateLogin(UserLogin userLogin) throws HrmsException;
	public Employee addNewEmployee(Employee employee) throws HrmsException;
	List<Employee> listAllEmployees() throws HrmsException;
	public Employee  deleteEmployee(int emloyee_id) throws HrmsException;
	public Employee editNewEmployee(Employee employee) throws HrmsException;
	public Employee findEmployee(int employee_id) throws HrmsException;
	public Employee fetchEmpDetail(int employee_id) throws HrmsException;

}
