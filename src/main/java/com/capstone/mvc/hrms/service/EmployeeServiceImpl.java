package com.capstone.mvc.hrms.service;

import java.util.ArrayList;
import java.util.List;

import com.capstone.mvc.hrms.dao.EmployeeDetailsDao;
import com.capstone.mvc.hrms.dao.EmployeeDetailsDaoImpl;
import com.capstone.mvc.hrms.domain.Employee;
import com.capstone.mvc.hrms.exception.HrmsException;


public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDetailsDao employeeDetailsDao = new EmployeeDetailsDaoImpl();

	@Override
	public Employee addEmpolyee(Employee employee) {
		try {
			employee= employeeDetailsDao.addNewEmployee(employee);
		}catch(HrmsException ex){
			System.out.println(ex.getErrorCode());
			ex.printStackTrace();
		}
		return employee;
	}
	@Override
	public List<Employee> listAllEmployees() throws HrmsException {
		List<Employee> employees = new ArrayList<Employee>();
		try {
			employees= employeeDetailsDao.listAllEmployees();
		}catch(HrmsException ex){
			System.out.println(ex.getErrorCode());
			ex.printStackTrace();
		}
		return employees;
	}

	@Override
	public Employee deleteEmployee(int employee_id) throws HrmsException {
		Employee employee=new Employee();
		try {
			employee= employeeDetailsDao.deleteEmployee(employee_id);
		}catch(HrmsException ex){
			System.out.println(ex.getErrorCode());
			ex.printStackTrace();
		}
		return employee;
	}
	@Override
	public Employee editEmpolyee(Employee employee) throws HrmsException {
		try {
			employee= employeeDetailsDao.editNewEmployee(employee);
		}catch(HrmsException ex){
			System.out.println(ex.getErrorCode());
			ex.printStackTrace();
		}
		return employee;
	}
	@Override
	public Employee findEmployee(int employee_id) throws HrmsException {
		Employee employee=new Employee();
		try {
			employee= employeeDetailsDao.findEmployee(employee_id);
		}catch(HrmsException ex){
			System.out.println(ex.getErrorCode());
			ex.printStackTrace();
		}
		return employee;
	}
	@Override
	public Employee fetchEmpDetail(int employee_id) throws HrmsException {
		Employee employee=new Employee();
		try {
			employee= employeeDetailsDao.fetchEmpDetail(employee_id);
		}catch(HrmsException ex){
			System.out.println(ex.getErrorCode());
			ex.printStackTrace();
		}
		return employee;
	}

}
