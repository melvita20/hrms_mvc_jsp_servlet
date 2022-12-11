package com.capstone.mvc.hrms.service;

import com.capstone.mvc.hrms.domain.UserLogin;
import com.capstone.mvc.hrms.exception.HrmsException;

public interface UserLoginService {
	
	public UserLogin validateLogin(UserLogin userLogin) throws HrmsException;


}
