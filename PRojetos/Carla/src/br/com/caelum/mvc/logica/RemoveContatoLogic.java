package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class RemoveContatoLogic implements Logica{
	
	public String execute(HttpServletRequest req , HttpServletResponse res)throws Exception{
		
			long id = Long.parseLong(req.getParameter("id"));
			Contato contato = new Contato();
			contato.setId(id);
			
			Connection connection = (Connection) req
					.getAttribute("connection");
			
			ContatoDAO dao = new ContatoDAO(connection);
			dao.remove(contato);
			System.out.println("Excluindo contato... ");
			return "mvc?logica=ListaContatosLogic";
		
		
	}
}
