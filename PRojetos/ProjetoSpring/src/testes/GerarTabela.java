package testes;

import javax.persistence.Persistence;

import conexao.HibernateUtil;

public class GerarTabela {

	public static void main(String[] args) {
		HibernateUtil.getSessionFactory();
		System.out.println("Criou tabela");
		HibernateUtil.getSessionFactory().close();
		System.out.println("fechou sessão");
	
	}

}
