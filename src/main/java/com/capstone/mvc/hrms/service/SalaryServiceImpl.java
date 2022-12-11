package com.capstone.mvc.hrms.service;

import com.capstone.mvc.hrms.dao.SalaryDao;
import com.capstone.mvc.hrms.dao.SalaryDaoImpl;
import com.capstone.mvc.hrms.domain.Employee;
import com.capstone.mvc.hrms.domain.Salary;
import com.capstone.mvc.hrms.exception.HrmsException;

public class SalaryServiceImpl implements SalaryService{

	SalaryDao salDao=new SalaryDaoImpl();

	@Override
	public Salary addSalaryDetails(Salary salary) throws HrmsException {
		try {
			salary= salDao.addSalaryDetails(salary);
		}catch(HrmsException ex){
			System.out.println(ex.getErrorCode());
			ex.printStackTrace();
		}
		return salary;
	}

	@Override
	public Salary editSalaryDetails(Salary salary) throws HrmsException {
		try {
			salary= salDao.editSalaryDetails(salary);
		}catch(HrmsException ex){
			System.out.println(ex.getErrorCode());
			ex.printStackTrace();
		}
		return salary;
	}

	@Override
	public Employee generatePaySlip(int emp_id, int no_of_days) throws HrmsException {
		Employee employee= new Employee();
		try {
			employee= salDao.generatePaySlip(emp_id,no_of_days);
		}catch(HrmsException ex){
			System.out.println(ex.getErrorCode());
			ex.printStackTrace();	
		}
		return employee;
	}
}
