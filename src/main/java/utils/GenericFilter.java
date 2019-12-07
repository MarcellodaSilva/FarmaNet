package utils;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/*
@WebFilter(filterName = "GenericFilter", urlPatterns = "/*")
public class GenericFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 	HttpSession sess = ((HttpServletRequest) request).getSession(true);
	        String newCurrentPage = ((HttpServletRequest) request).getServletPath();
	  
	       if (sess.getAttribute("currentPage") == null) {
	           sess.setAttribute("lastPage", newCurrentPage);
	           sess.setAttribute("currentPage", newCurrentPage);
	       } else {
	  
	           String oldCurrentPage = sess.getAttribute("currentPage").toString();
	           if (!oldCurrentPage.equals(newCurrentPage)) {
	             sess.setAttribute("lastPage", oldCurrentPage);
	             sess.setAttribute("currentPage", newCurrentPage);
	           }
	       }
	  
	       chain.doFilter(request, response);
	  
	}

	
}
*/