package com.capstone.mvc.hrms.service;

import java.util.HashMap;
import java.util.List;

import com.capstone.mvc.hrms.domain.Department;
import com.capstone.mvc.hrms.exception.HrmsException;



public interface DepartmentService {
	public Department addDepartment(Department dept) throws HrmsException;
	public List<Department> listAllDepartments() throws HrmsException;
	public  Department deleteDepartment(int employee_id) throws HrmsException;
	public Department editDepartment(Department dept) throws HrmsException;
}
