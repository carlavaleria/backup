package modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@NamedQueries({	
	@NamedQuery(name="Tarefa.listar", query="SELECT tarefa FROM Tarefa tarefa"),
	@NamedQuery(name="Tarefa.buscarTarefa", query="SELECT tarefa FROM Tarefa tarefa WHERE tarefa.id = :id")		
})
public class Tarefa {
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull @Size(min=5)
	private String descricao;
	private boolean finalizado;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar dataFinalizacao;
	
	@Transient
	private String dataFormatada;
	
	
	
	public String getDataFormatada() {
		
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.dataFormatada = sd.format(dataFinalizacao.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dataFormatada;
	}
	
	public void setDataFormatada(String dataFormatada) {
		Calendar date = new GregorianCalendar();
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		try {
			date.setTime(sd.parse(dataFormatada));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dataFormatada = dataFormatada;
		this.dataFinalizacao = date;
	}
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
	public boolean isFinalizado() {
		return finalizado;
	}
	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
	public Calendar getDataFinalizacao() {
		return dataFinalizacao;
	}
	
	public void setDataFinalizacao(Calendar dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}
	
	
	@Override
	public String toString() {
		return "Tarefa [id=" + id + ", descricao=" + descricao + ", finalizado=" + finalizado + ", dataFinalizacao="
				+ dataFinalizacao + "]";
	}
	
	
}
