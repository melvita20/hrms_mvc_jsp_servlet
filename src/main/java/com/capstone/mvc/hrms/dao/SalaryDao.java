package com.capstone.mvc.hrms.dao;

import java.util.List;

import com.capstone.mvc.hrms.domain.Employee;
import com.capstone.mvc.hrms.domain.Salary;
import com.capstone.mvc.hrms.exception.HrmsException;



public interface SalaryDao {
	public Salary addSalaryDetails(Salary salary) throws HrmsException;
	public Salary editSalaryDetails(Salary salary) throws HrmsException;
	public Employee generatePaySlip(int emp_id, int no_of_days) throws HrmsException; 
}
