package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import Conexao.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDAO {
	private Connection connection;

	public ContatoDAO() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Contato contato) {
		String sql= "INSERT INTO contatos" +
				"(nome,email,endereco,dataNAscimento)"+
				"values(?,?,?,?)";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			stmt.setString(1,contato.getNome());
			stmt.setString(2,contato.getEmail());
			stmt.setString(3,contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException (e);
		}
	}

	public List<Contato> getLista(){
		try {
			List<Contato> contatos = new ArrayList<Contato>();			
			PreparedStatement stmt = (PreparedStatement) this.connection.
					prepareStatement("select * from contatos");	
			ResultSet rs = stmt.executeQuery();

			while(rs.next()){
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);

				contatos.add(contato);
			}

			rs.close();
			stmt.close();
			return contatos;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public void altera(Contato contato) {
		String sql= "UPDATE contatos set nome=?, email=?,"
				+ " endereco=?, dataNascimento=? where id=?";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			stmt.setString(1,contato.getNome());
			stmt.setString(2,contato.getEmail());
			stmt.setString(3,contato.getEndereco());
			stmt.setDate(4, (java.sql.Date) new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5,contato.getId());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException (e);
		}
	}


	public void remove(Contato contato) {
		try {
			PreparedStatement stmt = (PreparedStatement) connection.
					prepareStatement("delete from contatos where id=?");
			stmt.setLong(1,contato.getId());
			
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException (e);
		}
	}


}







