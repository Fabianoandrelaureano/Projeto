package controllers;

import play.*;
import play.db.jpa.Transactional;
import play.mvc.*;
import views.html.*;
import models.Usuario;
import models.dao.GenericDAO;

public class Application extends Controller {
	
	private static final GenericDAO dao = new GenericDAO();

	@Transactional
    public static Result index() {
    	if(session().get("user") == null){
    		return ok(login.render());
    	}    	
    	Usuario u = new Usuario("nome","email","senha");
    	return ok(index.render("Your new application is ready."));
    }

}
