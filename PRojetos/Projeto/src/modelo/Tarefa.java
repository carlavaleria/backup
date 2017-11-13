package modelo;

import java.util.Calendar;
public class Tarefa {
	
	private Long id; 
	private String descricao;
	private boolean finalizacao;
	private Calendar dataFinalizacao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isFinalizacao() {
		return finalizacao;
	}
	public void setFinalizacao(boolean finalizacao) {
		this.finalizacao = finalizacao;
	}
	public Calendar getDataFinalizacao() {
		return dataFinalizacao;
	}
	public void setDataFinalizacao(Calendar dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}
	
	
}
