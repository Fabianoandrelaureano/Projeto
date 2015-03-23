package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class DisciplinasAnteriores extends DicaG {
	
	
	@Id
    @GeneratedValue
    private Long id;
	
	@Column
	private String descricao;
	
	@Column
	private String razao;
	
	private int numLikes;
	private int numDeslikes;
	
	public DisciplinasAnteriores(String descricao, String razao) {
		super(descricao);
		this.setRazao(razao);
	}
	
	public DisciplinasAnteriores() {
		
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

	public String getRazao() {
		return razao;
	}

	public void setRazao(String razao) {
		this.razao = razao;
	}

}
