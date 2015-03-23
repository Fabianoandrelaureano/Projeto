package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public abstract class DicaG {
	
	@Id
    @GeneratedValue
    private Long id;
	
	@Column
	private String descricao;
	
	private int numLikes;
	private int numDeslikes;
	
	public DicaG(String descricao) {
		this.setDescricao(descricao);
		this.numLikes = 0;
		this.numDeslikes = 0;
	}
	
	public DicaG() {
		
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getNumLikes() {
		return numLikes;
	}

	public void setNumLikes() {
		this.numLikes += 1;
	}

	public int getNumDeslikes() {
		return numDeslikes;
	}

	public void setNumDeslikes() {
		this.numDeslikes += 1;
	}


}
