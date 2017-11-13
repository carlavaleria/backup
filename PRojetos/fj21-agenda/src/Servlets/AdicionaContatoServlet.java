package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req,
			HttpServletResponse res)
			throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String endereco = req.getParameter("endereco");
		String dataEmTexto = req
		.getParameter("dataNascimento");
		Calendar dataNascimento = null;
		
		try {
			Date date =
			new SimpleDateFormat("dd/MM/yyyy")
			.parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
			} catch (ParseException e) {
			out.println("Erro de conversão da data");
			return;
			}

			Contato contato = new Contato();
			contato.setNome(nome);
			contato.setEmail(email);
			contato.setEndereco(endereco);
			contato.setDataNascimento(dataNascimento);
			
			Connection connection = (Connection) req
					.getAttribute("connection");
			
			ContatoDAO dao = new ContatoDAO(connection);
			dao.adiciona(contato);
			
			
			RequestDispatcher rd = req
					.getRequestDispatcher("/contato-adicionado.jsp");
					rd.forward(req,res);
			
	}
}
