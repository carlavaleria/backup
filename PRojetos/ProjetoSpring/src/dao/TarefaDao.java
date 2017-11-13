package dao;



import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import conexao.HibernateUtil;
import modelo.Tarefa;

@Repository
public class TarefaDao {

	public void adicionar (Tarefa tarefa) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		
		try {
			transacao = sessao.beginTransaction();
			sessao.save(tarefa);
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
	public List<Tarefa> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Tarefa> tarefas = null;

		try {
			
			Query consulta = sessao.getNamedQuery("Tarefa.listar");
			tarefas = consulta.list();
			
		} catch(RuntimeException e) {
			throw e;

		}finally {
			sessao.close();

		}
		return tarefas;

	}

	public Tarefa buscarTarefa(Long id){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Tarefa tarefa = null;

		try {
			Query consulta = sessao.getNamedQuery("Tarefa.buscarTarefa");
			consulta.setLong("id", id);

			tarefa =  (Tarefa) consulta.uniqueResult(); 



		} catch(RuntimeException e) {
			throw e;

		}finally {
			sessao.close();

		}
		return tarefa;

	}

	public void remover(Tarefa tarefa) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;


		try {
			transacao = sessao.beginTransaction();
			sessao.delete(tarefa);
			transacao.commit();

		} catch(RuntimeException e) {
			if(transacao != null){
				transacao.rollback();
			}

		}finally {

			sessao.close();
		}

	}

		
	public void alterar(Tarefa tarefa) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;


		try {
			
			transacao = sessao.beginTransaction();
			sessao.update(tarefa);
			transacao.commit();

		} catch(RuntimeException e) {
			if(transacao != null){
				transacao.rollback();
			}

		}finally {

			sessao.close();
		}

	}

	

}
