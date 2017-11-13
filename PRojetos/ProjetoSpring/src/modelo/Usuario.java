package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({	
	@NamedQuery(name="Usuario.listar", query="SELECT usuario FROM Usuario usuario"),
	@NamedQuery(name="Usuario.buscarUsuario", query="SELECT usuario FROM Usuario usuario WHERE usuario.id = :id"),
	@NamedQuery(name="Usuario.verificarUsuario", query="SELECT usuario FROM Usuario usuario WHERE usuario.login = :login and usuario.senha = :senha")
						/*	 SELECT usuario FROM Usuario usuario WHERE usuario.id = :id*/
})
public class Usuario {
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull @Size(min=8)
	private String login;
	@NotNull @Size(min=9)
	private String senha;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
}
