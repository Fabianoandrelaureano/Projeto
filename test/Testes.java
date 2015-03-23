import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import models.Usuario;


public class Testes {
	
private Usuario u1, u2, u3;
	
	@Before
	public void setUp() {
		u1 = new Usuario("fabiano", "f@gmail.com", "0");
		u2 = new Usuario("fab", "fab@gmail.com", "1");
		u3 = new Usuario("fabiano", "f@gmail.com", "0");
	}
	
	@Test
	public void testeDoEquals() {
		Assert.assertEquals(u1.equals(u3), true);
		Assert.assertEquals(u1.equals(u2), false);
	}

}
