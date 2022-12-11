package com.capstone.mvc.hrms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capstone.mvc.hrms.service.EmployeeService;
import com.capstone.mvc.hrms.service.EmployeeServiceImpl;
import com.capstone.mvc.hrms.domain.Salary;
import com.capstone.mvc.hrms.service.SalaryService;
import com.capstone.mvc.hrms.service.SalaryServiceImpl;
import com.mysql.cj.util.StringUtils;
import com.capstone.mvc.hrms.constants.Constants;
import com.capstone.mvc.hrms.domain.Department;
import com.capstone.mvc.hrms.domain.Employee;
import com.capstone.mvc.hrms.domain.UserLogin;
import com.capstone.mvc.hrms.exception.ErrorCode;
import com.capstone.mvc.hrms.exception.HrmsException;

/**
 * Servlet implementation class EmployeeController
 */
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmployeeService employeeService= new EmployeeServiceImpl();
		SalaryService salaryService=new SalaryServiceImpl();
		Employee employee=new Employee();

		HttpSession session = request.getSession();
		UserLogin userLogin= (UserLogin) session.getAttribute("userinfo");

		RequestDispatcher rd=null;
		if(request.getParameter("action").equalsIgnoreCase("viewprofile")) {
			employee.setEmpId(Integer.parseInt(userLogin.getUser_name()));
			try {
				employee = employeeService.fetchEmpDetail(employee.getEmpId());
				request.setAttribute("employeeObj", employee);
				rd=request.getRequestDispatcher("/jsp/empdetails.jsp");
				rd.forward(request,response);

			} catch (HrmsException e) {
				e.printStackTrace();
			}
		}else if(request.getParameter("action").equalsIgnoreCase("viewsalary")) {
			Salary salary=new Salary();
			salary.setEmp_id(Integer.parseInt(userLogin.getUser_name()));
			try {
				employee=salaryService.generatePaySlip(salary.getEmp_id(),salary.getNo_of_days());
				request.setAttribute("employeeObj", employee);
				rd=request.getRequestDispatcher("/jsp/emppayslip.jsp");
				rd.forward(request,response);
			} catch (HrmsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(request.getParameter("action").equalsIgnoreCase("listemployee")) {
			try {
				List<Employee> employees= employeeService.listAllEmployees();
				request.setAttribute("employeeList", employees);
				rd=request.getRequestDispatcher("/jsp/admin_view_emp.jsp");
				rd.forward(request,response);
			} catch (HrmsException ex) {
				System.out.println(ex.getErrorCode());
				ex.printStackTrace();
			}
		}else if(request.getParameter("action").equalsIgnoreCase("delete")) {
			try {
				employee= employeeService.deleteEmployee(Integer.parseInt(request.getParameter("employeeid")));
				System.out.println("in delete:"+ employee.getEmployee_status());
				if(employee.getEmployee_status().equalsIgnoreCase(Constants.STATUS_DEACTIVATED)) {
					request.setAttribute("empstatus", "Employee is deleted");
					List<Employee> employees= employeeService.listAllEmployees();
					request.setAttribute("employeeList", employees);
				}
				rd=request.getRequestDispatcher("/jsp/admin_view_emp.jsp");
				rd.forward(request,response);
			} catch (HrmsException ex) {
				// TODO Auto-generated catch block
				System.out.println(ex.getErrorCode());
				ex.printStackTrace();
			}
		}else if(request.getParameter("action").equalsIgnoreCase("add")) {
			employee.setEmpId(Integer.parseInt(request.getParameter("empid")));
			employee.setFname(request.getParameter("fname"));
			employee.setMname(request.getParameter("mname"));
			employee.setLname(request.getParameter("lname"));
			employee.setGender(request.getParameter("gender"));
			employee.setEmail(request.getParameter("email"));
			employee.setDOB(request.getParameter("dob"));
			employee.setHomeaddress_line1(request.getParameter("address1"));
			employee.setHomeaddress_line2(request.getParameter("address2"));
			employee.setHomeaddress_street(request.getParameter("street"));
			employee.setHomeaddress_city(request.getParameter("city"));
			employee.setHomeaddress_state(request.getParameter("state"));
			employee.setZip(request.getParameter("zip"));
			employee.setDesignation(request.getParameter("designation"));
			employee.setRole(Integer.parseInt(request.getParameter("role")));
			employee.setDepartment_id(Integer.parseInt(request.getParameter("deptid")));
			employee.setPhonenumber(request.getParameter("contno"));
			employee.setWork_location(request.getParameter("workloc"));
			employee.setHire_date(request.getParameter("hiredate"));

			try {
				if( StringUtils.isNullOrEmpty(employee.getFname()) || StringUtils.isNullOrEmpty(employee.getGender()) ||  StringUtils.isNullOrEmpty(employee.getDOB()) ||  StringUtils.isNullOrEmpty(employee.getEmail()) ||  StringUtils.isNullOrEmpty(employee.getPhonenumber())
						||  StringUtils.isNullOrEmpty(employee.getHire_date()) || employee.getDepartment_id()==0 ||  StringUtils.isNullOrEmpty(employee.getHomeaddress_line1()) ||  StringUtils.isNullOrEmpty(employee.getHomeaddress_city())
						||  StringUtils.isNullOrEmpty(employee.getDesignation()) || employee.getRole()==0 ||  StringUtils.isNullOrEmpty(employee.getWork_location()) ||  StringUtils.isNullOrEmpty(employee.getZip())) 
					throw new HrmsException("Required fields", ErrorCode.REQUIRED_FIELDS);
			
				employee= employeeService.addEmpolyee(employee);
				if(employee.getStatus_code() !=null && employee.getStatus_code().equalsIgnoreCase(Constants.STATUS_CODE_SUCCESS)) {
					List<Employee> employees= employeeService.listAllEmployees();
					request.setAttribute("employeeList", employees);
					request.setAttribute("status", "Employee is added successfully.");
					rd=request.getRequestDispatcher("/jsp/admin_view_emp.jsp");
					rd.forward(request,response);
				}else {
					request.setAttribute("exception","Error occurred while adding Employee");
					rd=request.getRequestDispatcher("/jsp/add_employee.jsp");
					rd.forward(request,response);
				}
			}catch(HrmsException ex) {
				request.setAttribute("exception", ex.getMessage());
				rd=request.getRequestDispatcher("/jsp/add_employee.jsp");
				rd.forward(request,response);
				System.out.println(ex.getErrorCode());
				ex.printStackTrace();
			}
		}else if(request.getParameter("action").equalsIgnoreCase("edit")) {
			employee.setEmpId(Integer.parseInt(request.getParameter("empid")));
			employee.setFname(request.getParameter("fname"));
			employee.setMname(request.getParameter("mname"));
			employee.setLname(request.getParameter("lname"));
			employee.setGender(request.getParameter("gender"));
			employee.setEmail(request.getParameter("email"));
			employee.setDOB(request.getParameter("dob"));
			employee.setHomeaddress_line1(request.getParameter("address1"));
			employee.setHomeaddress_line2(request.getParameter("address2"));
			employee.setHomeaddress_street(request.getParameter("street"));
			employee.setHomeaddress_city(request.getParameter("city"));
			employee.setHomeaddress_state(request.getParameter("state"));
			employee.setZip(request.getParameter("zip"));
			employee.setDesignation(request.getParameter("designation"));
			employee.setRole(Integer.parseInt(request.getParameter("role")));
			employee.setDepartment_id(Integer.parseInt(request.getParameter("deptid")));
			employee.setPhonenumber(request.getParameter("contno"));
			employee.setWork_location(request.getParameter("workloc"));
			employee.setHire_date(request.getParameter("hiredate"));

			try {
				if( StringUtils.isNullOrEmpty(employee.getFname()) || StringUtils.isNullOrEmpty(employee.getGender()) ||  StringUtils.isNullOrEmpty(employee.getDOB()) ||  StringUtils.isNullOrEmpty(employee.getEmail()) ||  StringUtils.isNullOrEmpty(employee.getPhonenumber())
						||  StringUtils.isNullOrEmpty(employee.getHire_date()) || employee.getDepartment_id()==0 ||  StringUtils.isNullOrEmpty(employee.getHomeaddress_line1()) ||  StringUtils.isNullOrEmpty(employee.getHomeaddress_city())
						||  StringUtils.isNullOrEmpty(employee.getDesignation()) || employee.getRole()==0 ||  StringUtils.isNullOrEmpty(employee.getWork_location()) ||  StringUtils.isNullOrEmpty(employee.getZip())) 
					throw new HrmsException("Required fields", ErrorCode.REQUIRED_FIELDS);
			
				employee= employeeService.editEmpolyee(employee);
				if(employee.getStatus_code() !=null && employee.getStatus_code().equalsIgnoreCase(Constants.STATUS_CODE_SUCCESS)) {
					List<Employee> employees= employeeService.listAllEmployees();
					request.setAttribute("employeeList", employees);
					request.setAttribute("status", "Employee is modified successfully.");
					rd=request.getRequestDispatcher("/jsp/admin_view_emp.jsp");
					rd.forward(request,response);
				}else {
					request.setAttribute("exception","Error occurred while editing Employee details");
					rd=request.getRequestDispatcher("/jsp/edit_employee.jsp");
					rd.forward(request,response);
				}
			}catch(HrmsException ex) {
				request.setAttribute("exception", ex.getMessage());
				rd=request.getRequestDispatcher("/jsp/edit_employee.jsp");
				rd.forward(request,response);
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
