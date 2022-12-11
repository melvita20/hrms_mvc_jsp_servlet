package com.capstone.mvc.hrms.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capstone.mvc.hrms.constants.Constants;
import com.capstone.mvc.hrms.domain.Department;
import com.capstone.mvc.hrms.domain.Employee;
import com.capstone.mvc.hrms.domain.UserLogin;
import com.capstone.mvc.hrms.exception.ErrorCode;
import com.capstone.mvc.hrms.exception.HrmsException;
import com.capstone.mvc.hrms.service.DepartmentService;
import com.capstone.mvc.hrms.service.DepartmentServiceImpl;
import com.capstone.mvc.hrms.service.EmployeeService;
import com.capstone.mvc.hrms.service.EmployeeServiceImpl;
import com.capstone.mvc.hrms.service.SalaryService;
import com.capstone.mvc.hrms.service.SalaryServiceImpl;
import com.mysql.cj.util.StringUtils;

/**
 * Servlet implementation class DepartmentController
 */
public class DepartmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DepartmentController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DepartmentService departmentService=new DepartmentServiceImpl();


		HttpSession session = request.getSession();
		UserLogin userLogin= (UserLogin) session.getAttribute("userinfo");
		Department department=new Department();

		RequestDispatcher rd=null;
		if(request.getParameter("action").equalsIgnoreCase("listdepartments")) {
			try {
				List<Department> departments= departmentService.listAllDepartments();
				request.setAttribute("departmentsList", departments);
				rd=request.getRequestDispatcher("/jsp/admin_view_dept.jsp");
				rd.forward(request,response);
			} catch (HrmsException ex) {
				System.out.println(ex.getErrorCode());
				ex.printStackTrace();
			}
		}else if(request.getParameter("action").equalsIgnoreCase("delete")) {
			try {
				department= departmentService.deleteDepartment(Integer.parseInt(request.getParameter("departmentid")));
				if(department.getStatus().equalsIgnoreCase(Constants.STATUS_DEACTIVATED)) {
					request.setAttribute("deptstatus", "Department is deleted");
					List<Department> departments= departmentService.listAllDepartments();
					request.setAttribute("departmentsList", departments);
				}
				rd=request.getRequestDispatcher("/jsp/admin_view_dept.jsp");
				rd.forward(request,response);
			} catch (HrmsException ex) {
				// TODO Auto-generated catch block
				System.out.println(ex.getErrorCode());
				ex.printStackTrace();
			}
		}else if(request.getParameter("action").equalsIgnoreCase("add")) {
			try {
				department.setDepartment_id(Integer.parseInt(request.getParameter("deptid")));
				department.setDep_name(request.getParameter("deptname"));
				department.setDep_location(request.getParameter("deptloc"));

				if(department.getDepartment_id()==0 || StringUtils.isNullOrEmpty(department.getDep_name()) || StringUtils.isNullOrEmpty(department.getDep_location()))
					throw new HrmsException("Mandatory fields", ErrorCode.DEPARTMENT_REQUIRED_FIELDS);

				department=departmentService.addDepartment(department);
				if(department.getStatus() !=null && department.getStatus().equalsIgnoreCase(Constants.STATUS_CODE_SUCCESS)) {
					List<Department> departments= departmentService.listAllDepartments();
					request.setAttribute("departmentsList", departments);
					request.setAttribute("status", "Department is added successfully.");
					rd=request.getRequestDispatcher("/jsp/admin_view_dept.jsp");
					rd.forward(request,response);
				}else {
					request.setAttribute("exception","Error occurred while adding department");
					rd=request.getRequestDispatcher("/jsp/add_department.jsp");
					rd.forward(request,response);
				}
			}catch(HrmsException ex) {
				request.setAttribute("exception", ex.getMessage());
				rd=request.getRequestDispatcher("/jsp/add_department.jsp");
				rd.forward(request,response);
				System.out.println(ex.getErrorCode());
				ex.printStackTrace();
			}
		}	else if(request.getParameter("action").equalsIgnoreCase("edit")) {
			try {
				department.setDepartment_id(Integer.parseInt(request.getParameter("deptid")));
				department.setDep_name(request.getParameter("deptname"));
				department.setDep_location(request.getParameter("deptloc"));

				if(department.getDepartment_id()==0 || StringUtils.isNullOrEmpty(department.getDep_name()) || StringUtils.isNullOrEmpty(department.getDep_location()))
					throw new HrmsException("Mandatory fields", ErrorCode.DEPARTMENT_REQUIRED_FIELDS);

				department=departmentService.editDepartment(department);
				if(department.getStatus() !=null && department.getStatus().equalsIgnoreCase(Constants.STATUS_CODE_SUCCESS)) {
					List<Department> departments= departmentService.listAllDepartments();
					request.setAttribute("departmentsList", departments);
					request.setAttribute("status", "Department is modified successfully.");
					rd=request.getRequestDispatcher("/jsp/admin_view_dept.jsp");
					rd.forward(request,response);
				}else {
					request.setAttribute("exception","Error occurred while adding department");
					rd=request.getRequestDispatcher("/jsp/edit_department.jsp");
					rd.forward(request,response);
				}
			}catch(HrmsException ex) {
				request.setAttribute("exception", ex.getMessage());
				rd=request.getRequestDispatcher("/jsp/edit_department.jsp");
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
