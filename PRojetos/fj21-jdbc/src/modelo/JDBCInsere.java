package modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;

import com.mysql.jdbc.PreparedStatement;

import Conexao.ConnectionFactory;

public class JDBCInsere {
	public static void main(String[] args) throws SQLException {
		Connection con = null;

		try{
			con = new ConnectionFactory().getConnection();
			
			String sql = "insert into contatos" +
					" (nome,email,endereco,dataNascimento)" +
					" values (?,?,?,?)";
					PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
					
					
					stmt.setString(1, "Carla");
					stmt.setString(2, "carla@outlook.com");
					stmt.setString(3, "R. xxx Conj. xxx cxxx");
					stmt.setDate(4, new java.sql.Date(
					Calendar.getInstance().getTimeInMillis()));
					
					
					stmt.execute();
					stmt.close();
					System.out.println("Gravado!");
			
			
		} finally {
			con.close();
		}
	}
}
