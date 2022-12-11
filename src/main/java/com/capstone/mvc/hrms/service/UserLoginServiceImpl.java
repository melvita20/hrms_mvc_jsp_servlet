package com.capstone.mvc.hrms.service;

import com.capstone.mvc.hrms.dao.EmployeeDetailsDao;
import com.capstone.mvc.hrms.dao.EmployeeDetailsDaoImpl;
import com.capstone.mvc.hrms.domain.UserLogin;
import com.capstone.mvc.hrms.exception.HrmsException;

public class UserLoginServiceImpl implements UserLoginService {

	EmployeeDetailsDao employeeDetailsDao = new EmployeeDetailsDaoImpl();
	@Override
	public UserLogin validateLogin(UserLogin userLogin) {
		// TODO Auto-generated method stub
		try {
			userLogin= employeeDetailsDao.validateLogin(userLogin);
		}catch(HrmsException ex){
			System.out.println(ex.getErrorCode());
        	ex.printStackTrace();
		}
		return userLogin;
	}
	
}
