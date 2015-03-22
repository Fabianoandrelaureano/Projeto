package controllers;

import java.util.ArrayList;
import java.util.List;

import play.*;
import play.data.DynamicForm;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.*;
import views.html.*;
import models.Dica;
import models.Tema;
import models.Usuario;
import models.dao.GenericDAO;

public class Application extends Controller {
	
	private static final GenericDAO dao = new GenericDAO();

	@Transactional
    public static Result index() {
		if(session().get("user") == null){
    		return ok(login.render());
    	}    	
    	//Usuario u = new Usuario("nome","email","senha");
		
		List<Tema> temas = dao.findAllByClassName(Tema.class.getName());    	
    	
    	return ok(index.render(temas));
    }
	
	@Transactional
    public static Result dicasTema(Long id){
		List<Tema> temas = dao.findAllByClassName(Tema.class.getName());
        Tema tema = dao.findByEntityId(Tema.class, id);
        return ok(dicastema.render(id, temas));
    }
	
	@Transactional
	public static Result addDica(Long id) {
		List<Tema> temas = dao.findAllByClassName(Tema.class.getName());
		DynamicForm form = Form.form().bindFromRequest();

        String descricao = form.get("descricao");
        
        Tema tema = dao.findByEntityId(Tema.class, id);
        
        Dica dica = new Dica(descricao);
        
        tema.addDica(dica);
        
        dao.merge(tema);
		dao.flush();
		return ok(dicastema.render(id, temas));
        
        /*for(int i = 0; i < temas.size(); i++) {
			if(temas.get(i).getId().equals(id)) {
				Tema t = temas.get(i);
				 t.addDica(dica);
				 dao.merge(t);
				 dao.flush();
				 return ok(dicastema.render(id, temas));
			}
		}*/
        
        //return ok(dicastema.render(id, temas));
	}
	
	/*@Transactional
	public static Result dicasOO() {
		
		List<Dica> dicas = new ArrayList<Dica>();
		List<Tema> temas = dao.findAllByClassName(Tema.class.getName());
		
		for(int i = 0; i < temas.size(); i++) {
			if(temas.get(i).equals("OO")) {
				return ok(oo.render(temas.get(i).getDicas()));
			}
		}
		
		
		//Tema t2 = new Tema("OO");
		//Dica d1 = new Dica("dica OO");
		
		//t2.addDica(d1);
		
		//temas.add(t2);
		
		return ok(oo.render(dicas));
		
	}
	
	@Transactional
	public static Result addDicaOO() {
		List<Dica> dicas = new ArrayList<Dica>();
		List<Tema> temas = dao.findAllByClassName(Tema.class.getName());
		
		DynamicForm form = Form.form().bindFromRequest();

        String descricao = form.get("descricao");
        
        //List<Tema> temas = new ArrayList<Tema>();
		//List<Dica> dicas = new ArrayList<Dica>();

        Dica dica = new Dica(descricao);
        
        //Tema t2 = new Tema("OO");
		//Dica d1 = new Dica("dica OO");
		
		//t2.addDica(d1);
		//t2.addDica(dica);
		
		//temas.add(t2);
        
        //dao.persist(dica);
        
        for(int i = 0; i < temas.size(); i++) {
			if(temas.get(i).equals("OO")) {
				temas.get(i).getDicas().add(dica);
				return ok(oo.render(temas.get(i).getDicas()));
			}
		}

        //List<Dica> dicas = dao.findAllByClassName(Dica.class.getName());
        //return ok(index.render(dicas));
		return ok(oo.render(dicas));
	}
	
	@Transactional
	public static Result dicasGrasp() {
		
		List<Dica> dicas = new ArrayList<Dica>();
		List<Tema> temas = dao.findAllByClassName(Tema.class.getName());
		
		for(int i = 0; i < temas.size(); i++) {
			if(temas.get(i).equals("GRASP")) {
				Tema t = temas.get(i);
				return ok(grasp.render(t));
			}
		}
		
		return ok(grasp.render(t));
		
	}
	
	@Transactional
	public static Result addDicaGrasp() {
		List<Tema> temas = dao.findAllByClassName(Tema.class.getName());
		DynamicForm form = Form.form().bindFromRequest();

        String descricao = form.get("descricao");
        
        Dica dica = new Dica(descricao);
        
        //dao.persist(dica);
        
        for(int i = 0; i < temas.size(); i++) {
			if(temas.get(i).equals("GRASP")) {
				Tema t = temas.get(i);
				 t.addDica(dica);
				 dao.persist(t);
				 return ok(grasp.render(t));
			}
		}
        
        //t.addDica(dica);
        //dao.persist(t);

        //List<Dica> dicas = dao.findAllByClassName(Dica.class.getName());
        return ok(grasp.render(t));
	}*/

}
