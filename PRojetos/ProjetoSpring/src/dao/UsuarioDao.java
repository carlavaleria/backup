package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import conexao.HibernateUtil;
import modelo.Tarefa;
import modelo.Usuario;

@Repository
public class UsuarioDao {
	public void adicionar (Usuario usuario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		
		try {
			transacao = sessao.beginTransaction();
			sessao.save(usuario);
			transacao.commit();

		} catch(RuntimeException e) {
			if(transacao != null){
				transacao.rollback();
			}

		}finally {

			sessao.close();
		}

	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Usuario> usuarios = null;

		try {
			
			Query consulta = sessao.getNamedQuery("Usuario.listar");
			usuarios = consulta.list();
			
		} catch(RuntimeException e) {
			throw e;

		}finally {
			sessao.close();

		}
		return usuarios;

	}

	public Usuario buscarUsuario(Long id){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Usuario usuario = null;

		try {
			Query consulta = sessao.getNamedQuery("Usuario.buscarUsuario");
			consulta.setLong("id", id);

			usuario =  (Usuario) consulta.uniqueResult(); 



		} catch(RuntimeException e) {
			throw e;

		}finally {
			sessao.close();

		}
		return usuario;

	}

	public void remover(Usuario usuario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;


		try {
			transacao = sessao.beginTransaction();
			sessao.delete(usuario);
			transacao.commit();

		} catch(RuntimeException e) {
			if(transacao != null){
				transacao.rollback();
			}

		}finally {

			sessao.close();
		}

	}

		
	public void alterar(Usuario usuario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;


		try {
			
			transacao = sessao.beginTransaction();
			sessao.update(usuario);
			transacao.commit();

		} catch(RuntimeException e) {
			if(transacao != null){
				transacao.rollback();
			}

		}finally {

			sessao.close();
		}

	}

	public boolean existeUsuario(Usuario usuario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Usuario user = null;

		
		try {
			Query consulta = sessao.getNamedQuery("Usuario.verificarUsuario");
			consulta.setString("login", usuario.getLogin());
			consulta.setString("senha", usuario.getSenha());
			user = (Usuario) consulta.uniqueResult();

		} catch(RuntimeException e) {
			throw e;
		}
		finally {
			sessao.close();
		}
		if(user != null){
			return true;
		}
		else {
			return false;
		}
	}
}


