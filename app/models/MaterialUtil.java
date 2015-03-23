package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class MaterialUtil extends DicaG {
	
	@Id
    @GeneratedValue
    private Long id;
	
	@Column
	private String descricao;
	
	private String url;
	
	private int numLikes;
	private int numDeslikes;
	
	public MaterialUtil(String descricao, String url) {
		super(descricao);
	}
	
	public MaterialUtil() {
		
	}
	
	private boolean verificaAutenticidadeDoMaterial(String url){
        if (url.startsWith("http://") && (url.startsWith(".com", url.length()-4) || url.startsWith(".com.br", url.length()-7)
                || url.startsWith(".edu", url.length()-4)
                || url.startsWith(".edu.br", url.length()-7))){
            return true;
        }
        return false;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) throws Exception {
		if (!verificaAutenticidadeDoMaterial(url)){
            throw new Exception("URL n começa com http:// e acaba com .com, .com.br, .edu ou .edu.br");
        }
        this.url = url;
	}
	
}
