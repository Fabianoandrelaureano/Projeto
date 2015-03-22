import play.*;
import models.dao.GenericDAO;
import play.db.jpa.JPA;
import views.html.main;
import models.*;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;

public class Global extends GlobalSettings {
	
	private static GenericDAO dao = new GenericDAO();;

	@Override
	public void onStart(Application app) {
		Logger.info("Aplicação inicializada...");
		
		JPA.withTransaction(new play.libs.F.Callback0() {
			
			@Override
			public void invoke() throws Throwable {
				
				povoarBD();
                dao.flush();   
				
			}
					    			    		
		});
		
	}
	
	public void povoarBD() throws FileNotFoundException {
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
		
		dao.persist(t1);
		dao.persist(t2);
		dao.persist(t3);
		
		temas.add(t1);
		temas.add(t2);
		temas.add(t3);
		
	}
	
	@Override
	public void onStop(Application app) {
		JPA.withTransaction(new play.libs.F.Callback0() {
		    @Override
		    public void invoke() throws Throwable {
		        Logger.info("Aplicação finalizando...");
		        List<Tema> temas = dao.findAllByClassName(Tema.class.getName());

		        for (Tema tema:temas) {
		        	dao.removeById(Tema.class, tema.getId());
		       } 
		    }
		}); 
	}
	
}



