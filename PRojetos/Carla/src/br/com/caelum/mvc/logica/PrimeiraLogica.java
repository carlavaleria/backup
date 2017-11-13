package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrimeiraLogica implements Logica{
	public String execute(HttpServletRequest req, HttpServletResponse res)throws Exception{
		System.out.println("Executando a lógica");
		System.out.println("Nome JSP");
		return "primeira-logica.jsp";
		
	}
}
