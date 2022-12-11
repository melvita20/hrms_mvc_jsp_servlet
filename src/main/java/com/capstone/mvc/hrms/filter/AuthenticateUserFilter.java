package com.capstone.mvc.hrms.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthenticateUserFilter
 */
public class AuthenticateUserFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public AuthenticateUserFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		  if (!(req instanceof HttpServletRequest)) {
	            throw new ServletException("Can only process HttpServletRequest");
	        }

	        if (!(res instanceof HttpServletResponse)) {
	            throw new ServletException("Can only process HttpServletResponse");
	        }

	        HttpServletRequest request = (HttpServletRequest) req;
	        HttpServletResponse response = (HttpServletResponse) res;

	        HttpSession session=request.getSession(false);
	        System.out.println("SESSION::"+session);
	        String loginURI = request.getContextPath() + "/LoginController";
	        boolean loggedIn = session != null && session.getAttribute("userinfo") != null;
	        boolean loginRequest = request.getRequestURI().equals(loginURI);
	
	        if (loggedIn || loginRequest) {
	            chain.doFilter(req, res);
	        } else {
	        	System.out.println("path::"+request.getContextPath()+"/jsp/login.jsp");

	    		RequestDispatcher rd=null;
	    		rd=request.getRequestDispatcher("/jsp/login.jsp");
	    		rd.forward(request,response);
	        }
	        	

		

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
