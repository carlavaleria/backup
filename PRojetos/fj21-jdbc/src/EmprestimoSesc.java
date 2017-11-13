package br.com.bibliotecaltv.javabeans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.util.Calendar;

@Entity
@Table(name = "emprestimo_sesc")
public class Emprestimo_Sesc {
	
	@Id
	private String tombo;
	
	@Column(nullable = false)
	private String cdd;
	
	@Column(nullable = false)
	private String titulo;
	
	@Column(nullable = false)
	private String autor;
	
	@Column(nullable = false)
	private Calendar data_emprestimo;
	
	@Column(nullable = false)
	private Calendar data_devolucao;
	
	@ManyToOne
	private Aluno aluno;
	
	@ManyToOne
	private Professor professor;
	
	public String getTombo() {
		return tombo;
	}
	public void setTombo(String tombo) {
		this.tombo = tombo;
	}
	public String getCdd() {
		return cdd;
	}
	public void setCdd(String cdd) {
		this.cdd = cdd;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Calendar getData_emprestimo() {
		return data_emprestimo;
	}
	public void setData_emprestimo(Calendar data_emprestimo) {
		this.data_emprestimo = data_emprestimo;
	}
	public Calendar getData_devolucao() {
		return data_devolucao;
	}
	public void setData_devolucao(Calendar data_devolucao) {
		this.data_devolucao = data_devolucao;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	
	
	
}
