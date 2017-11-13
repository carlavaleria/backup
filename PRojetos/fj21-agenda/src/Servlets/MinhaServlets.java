package Servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MinhaServlets {
	public void init(ServletConfig config) throws ServletException {
		init(config);
		
	}
	
	public void destroy() {
		destroy();
	}
	
	private void service(HttpServletRequest req,
			HttpServletResponse res) 
			throws IOException, ServletException {
		
	}
}
