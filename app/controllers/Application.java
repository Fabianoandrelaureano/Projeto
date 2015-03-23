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
	private static Form<Dica> dicaForm = Form.form(Dica.class);

	@Transactional
    public static Result index() {
		if(session().get("user") == null){
    		return ok(login.render());
    	}    	
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

	}
	
	@Transactional
	public static Result addDificuldade(Long id) {
		List<Tema> temas = dao.findAllByClassName(Tema.class.getName());
		DynamicForm form = Form.form().bindFromRequest();

        String dificuldade = form.get("dificuldade");
        
        Tema tema = dao.findByEntityId(Tema.class, id);
        tema.setDificuldade(dificuldade);
        dao.merge(tema);
		dao.flush();
		return ok(index.render(temas));
	}
	
	@Transactional
	public static Result like(Long id, Dica dica) {
		List<Tema> temas = dao.findAllByClassName(Tema.class.getName());
		DynamicForm form = Form.form().bindFromRequest();

		Tema tema = dao.findByEntityId(Tema.class, id);
			
		return redirect(routes.Application.index());
	}

}
