package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Dica {
	
	@Id
    @GeneratedValue
    private Long id;
	
	@Column
	private String descricao;
	
	public Dica(String descricao) {
		this.setDescricao(descricao);
	}
	
	public Dica() {
		
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
