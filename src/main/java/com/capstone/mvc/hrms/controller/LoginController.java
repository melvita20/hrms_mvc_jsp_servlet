package com.capstone.mvc.hrms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capstone.mvc.hrms.constants.Constants;
import com.capstone.mvc.hrms.domain.UserLogin;
import com.capstone.mvc.hrms.exception.ErrorCode;
import com.capstone.mvc.hrms.exception.HrmsException;
import com.capstone.mvc.hrms.service.UserLoginService;
import com.capstone.mvc.hrms.service.UserLoginServiceImpl;
import com.mysql.cj.util.StringUtils;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserLogin userLogin=new UserLogin();
		UserLoginService userLoginService=new UserLoginServiceImpl();
		RequestDispatcher rd=null;
		if(request.getParameter("action").equalsIgnoreCase("login")) {
			userLogin.setUser_name(request.getParameter("username"));
			userLogin.setPassword(request.getParameter("password"));
			HttpSession session = request.getSession();

			try {
				if(StringUtils.isNullOrEmpty(userLogin.getUser_name()) || StringUtils.isNullOrEmpty(userLogin.getPassword()))
					throw new HrmsException(ErrorCode.USERNAME_NULL);

				Pattern p=Pattern.compile(Constants.valid_password_regex);
				Matcher m = p.matcher(userLogin.getPassword());
				if (m.matches()) {
					userLogin= userLoginService.validateLogin(userLogin);
					if(userLogin.getStatus_Message().equalsIgnoreCase(Constants.STATUS_CODE_SUCCESS)) {
						session.setAttribute("userinfo", userLogin);
						rd=request.getRequestDispatcher("/jsp/login_success.jsp");
						rd.forward(request,response);
					}else {
						request.setAttribute("exception", ErrorCode.INVALID_CREDENTIALS);
						rd=request.getRequestDispatcher("/jsp/login.jsp");
						rd.forward(request,response);
					}
				}else
					throw new HrmsException(ErrorCode.PASSWORD_INVALID);
			}catch(HrmsException ex) {
				request.setAttribute("exception", ex.getMessage());
				rd=request.getRequestDispatcher("/jsp/login.jsp");
				rd.forward(request,response);
				System.out.println(ex.getMessage());
				ex.printStackTrace();
			}
		}else if(request.getParameter("action").equalsIgnoreCase("logout")){
			HttpSession session = request.getSession(false);
	        if (session != null) {
	            session.invalidate();
	        }
	        request.setAttribute("loggedOut", true);
	    	rd=request.getRequestDispatcher("/jsp/logout.jsp");
			rd.forward(request,response);	}
}

/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
}

}
