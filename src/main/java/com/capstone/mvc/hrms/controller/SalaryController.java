package com.capstone.mvc.hrms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.capstone.mvc.hrms.constants.Constants;
import com.capstone.mvc.hrms.domain.Employee;
import com.capstone.mvc.hrms.domain.Salary;
import com.capstone.mvc.hrms.domain.UserLogin;
import com.capstone.mvc.hrms.exception.ErrorCode;
import com.capstone.mvc.hrms.exception.HrmsException;
import com.capstone.mvc.hrms.service.EmployeeService;
import com.capstone.mvc.hrms.service.EmployeeServiceImpl;
import com.capstone.mvc.hrms.service.SalaryService;
import com.capstone.mvc.hrms.service.SalaryServiceImpl;
import com.mysql.cj.util.StringUtils;

/**
 * Servlet implementation class SalaryController
 */
public class SalaryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SalaryController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		UserLogin userLogin= (UserLogin) session.getAttribute("userinfo");
		Employee employee = new Employee();
		EmployeeService employeeService = new EmployeeServiceImpl();
		SalaryService salaryService= new SalaryServiceImpl();
		Salary salary=new Salary();
		RequestDispatcher rd=null;
		if(request.getParameter("action").equalsIgnoreCase("search")) {
			try {
				employee= employeeService.findEmployee(Integer.parseInt(request.getParameter("searchid")));
				if(employee.getStatus_code() !=null && employee.getStatus_code().equalsIgnoreCase(Constants.STATUS_CODE_SUCCESS)) {
					request.setAttribute("employeeDetail", employee);
					rd=request.getRequestDispatcher("/jsp/admin_view_salary.jsp");
					rd.forward(request,response);
				}else {
					request.setAttribute("exception","Employee records not present");
					rd=request.getRequestDispatcher("/jsp/admin_view_salary.jsp");
					rd.forward(request,response);
				}
			} catch (HrmsException ex) {
				request.setAttribute("exception",ex.getMessage());
				rd=request.getRequestDispatcher("/jsp/admin_view_salary.jsp");
				System.out.println(ex.getErrorCode());
				ex.printStackTrace();
			}
		}else if(request.getParameter("action").equalsIgnoreCase("generate")) {
			try {
				employee= salaryService.generatePaySlip(Integer.parseInt(request.getParameter("empid")),0);
				if(employee.getStatus_code() !=null && employee.getStatus_code().equalsIgnoreCase(Constants.STATUS_CODE_SUCCESS)) {
					request.setAttribute("SalaryDetails", employee);
					System.out.println("sala"+employee.getSalary().toString());
					rd=request.getRequestDispatcher("/jsp/generate_salary.jsp");
					rd.forward(request,response);
				}else {
					request.setAttribute("exception","Records not present");
					rd=request.getRequestDispatcher("/jsp/generate_salary.jsp");
					rd.forward(request,response);
				}

			}catch (HrmsException ex) {
				request.setAttribute("exception",ex.getMessage());
				rd=request.getRequestDispatcher("/jsp/generate_salary.jsp");
				System.out.println(ex.getErrorCode());
				ex.printStackTrace();
			}
		}else if(request.getParameter("action").equalsIgnoreCase("add")) {
			try {
				salary.setEmp_id(Integer.parseInt(request.getParameter("empid")));
				salary.setBASIC(Double.parseDouble(request.getParameter("basic")));
				salary.setHRA_percentage(Integer.parseInt(request.getParameter("hrapercent")));
				salary.setDA_percentage(Integer.parseInt(request.getParameter("dapercent")));
				salary.setIt_percentage(Integer.parseInt(request.getParameter("itpercent")));

				if(salary.getEmp_id()==0 ||salary.getHRA_percentage()==0 || salary.getDA_percentage()==0)
					throw new HrmsException("Mandatory fields", ErrorCode.SALARY_REQUIRED_FIELDS);		
				
				salary= 	salaryService.addSalaryDetails(salary);

				if(salary.getStatus_code() !=null && salary.getStatus_code().equalsIgnoreCase(Constants.STATUS_CODE_SUCCESS)) {
					request.setAttribute("status", "Salary details addes successfully");
					rd=request.getRequestDispatcher("/jsp/add_salary.jsp");
					rd.forward(request,response);
				}else {
					request.setAttribute("exception","Records not present");
					rd=request.getRequestDispatcher("/jsp/add_salary.jsp");
					rd.forward(request,response);
				}

			}catch (HrmsException ex) {
				request.setAttribute("exception",ex.getMessage());
				rd=request.getRequestDispatcher("/jsp/add_salary.jsp");
				System.out.println(ex.getErrorCode());
				ex.printStackTrace();
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
