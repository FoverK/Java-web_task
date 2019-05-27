package com.liqiang.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterIP implements Filter {
    
	private String FilterIP;
    
	@Override
	public void destroy() {
		
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		String remoteIP = arg0.getRemoteAddr();
		System.out.println("ip:"+remoteIP);
		if(remoteIP.contains(FilterIP)) {
			arg0.getRequestDispatcher("error.jsp").forward(arg0, arg1);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		FilterIP = arg0.getInitParameter("FilterIP");
		if(FilterIP == null) FilterIP = "";
	}

}
