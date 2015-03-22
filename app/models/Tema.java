package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Tema {
	
	@Id
    @GeneratedValue
    private Long id;
	
	@Column
	private String nome;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn
	private List<Dica> dicas;
	
	public Tema(String nome) {
		this.setNome(nome);
		dicas = new ArrayList<Dica>();
	}
	
	public Tema() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public List<Dica> getDicas() {
		return dicas;
	}

	public void addDica(Dica d1) {
		dicas.add(d1);		
	}

}
