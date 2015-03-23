import java.util.ArrayList;
import java.util.List;

import models.Dica;
import models.Tema;

import org.junit.Assert;
import org.junit.Test;


public class TestesTemaeDica {
	
	@Test
	public void deveAdicionarUmaDicaEmUmTema() {
		List<Tema> temas = new ArrayList<Tema>();
		
		Dica d1 = new Dica("Dica1");
		Tema t1 = new Tema("Análise x Design");
		t1.addDica(d1);
		
		Dica d2 = new Dica("Dica2");
		Tema t2 = new Tema("OO");
		t2.getDicas().add(d2);
		
		Dica d3 = new Dica("Dica3");
		Tema t3 = new Tema("GRASP");
		t3.getDicas().add(d3);
		
		temas.add(t1);
		temas.add(t2);
		temas.add(t3);
		
		Assert.assertEquals(t1.getDicas().contains(d1), true);
		Assert.assertEquals(t2.getDicas().contains(d2), true);
		Assert.assertEquals(t3.getDicas().contains(d3), true);
		
	}
	
	@Test
	public void dicaNaoDeveTerLikesNemDeslikes() {
		Dica d1 = new Dica("Dica1");
		
		Assert.assertEquals(d1.getNumLikes(), 0);
		Assert.assertEquals(d1.getNumDeslikes(), 0);
	}
	
	@Test
	public void deveReceberUmLikeeUmDeslike() {
		Dica d1 = new Dica("Dica1");
		
		d1.setNumLikes();
		d1.setNumDeslikes();
		
		Assert.assertEquals(d1.getNumLikes(), 1);
		Assert.assertEquals(d1.getNumDeslikes(), 1);
	}

}
