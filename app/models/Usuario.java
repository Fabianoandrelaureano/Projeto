package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Usuario")
public class Usuario {
	
	@Id
	@GeneratedValue//(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private String email;
	
	@Column
	private String senha;

	public Usuario(){
		this.senha = null;
		this.email = null;
		this.nome = null;
	}
	
	public Usuario(String nome, String email, String senha) {
		this.setNome(nome);
		this.setEmail(email);
		this.setSenha(senha);
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Usuario)){
			return false;
		}else{
			Usuario pessoa = (Usuario)obj;
			return (pessoa.getEmail().equals(this.email));
		}
	}

}
