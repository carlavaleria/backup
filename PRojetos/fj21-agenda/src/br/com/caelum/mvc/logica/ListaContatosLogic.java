package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class ListaContatosLogic implements Logica{
	public String execute(HttpServletRequest req,  HttpServletResponse res) throws Exception{
		
		Connection connection = (Connection) req
				.getAttribute("connection");
		
		ContatoDAO dao = new ContatoDAO(connection);
		
		List<Contato> contatos = new ContatoDAO(connection).getLista();
		
		req.setAttribute("contatos", contatos);
		return "lista-contatos.jsp";
	}
}
