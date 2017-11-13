package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/primeiraservlet")
public class PrimeiraServlets extends HttpServlet{
	protected void service (HttpServletRequest req,
			HttpServletResponse res)
			throws ServletException, IOException {
			PrintWriter out = res.getWriter();
	
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>Primeira Servlet</h1>");
			out.println("</body>");
			out.println("</html>");
			}
}
