package com.capstone.mvc.hrms.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.capstone.mvc.hrms.dao.DepartmentDao;
import com.capstone.mvc.hrms.dao.DepartmentDaoImpl;
import com.capstone.mvc.hrms.domain.Department;
import com.capstone.mvc.hrms.exception.HrmsException;



public class DepartmentServiceImpl implements DepartmentService{

	DepartmentDao departmentDao = new DepartmentDaoImpl();

	@Override
	public Department addDepartment(Department dept) throws HrmsException {
		try {
			dept= departmentDao.addDepartment(dept);
		}catch(HrmsException ex){
			System.out.println(ex.getErrorCode());
			ex.printStackTrace();
		}
		return dept;		

	}

	@Override
	public List<Department> listAllDepartments() throws HrmsException {
		List<Department> departments = new ArrayList<Department>();
		try {
			departments=departmentDao.listAllDepartments();
		}catch(HrmsException ex){
			System.out.println(ex.getErrorCode());
			ex.printStackTrace();
		}
		return departments;
	}

	@Override
	public Department deleteDepartment(int dept_id) throws HrmsException {
		Department department=new Department();
		try {
			department= departmentDao.deleteDepartment(dept_id);	
		}catch(HrmsException ex){
			System.out.println(ex.getErrorCode());
			ex.printStackTrace();
		}
		return department;
	}

	@Override
	public Department editDepartment(Department dept) throws HrmsException {
		try {
			dept= departmentDao.editDepartment(dept);
		}catch(HrmsException ex){
			System.out.println(ex.getErrorCode());
			ex.printStackTrace();
		}
		return dept;		
	}

}
