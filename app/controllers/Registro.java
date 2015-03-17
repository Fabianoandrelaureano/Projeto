package controllers;

import static play.data.Form.form;

import java.util.List;

import models.Usuario;
import models.dao.GenericDAO;
import play.data.DynamicForm;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.registro;

public class Registro extends Controller {	
	
	private static final GenericDAO dao = new GenericDAO();

    public static Result show() {
        return ok(registro.render());
    }
    
    @Transactional
	public static Result registrar() throws Exception {
		DynamicForm requestData = Form.form().bindFromRequest();
    	
		String nome = requestData.get("nome");
		String email = requestData.get("email");
		String senha = requestData.get("pass");
		
		Usuario u;
		u = new Usuario(nome, email,senha);
		//registroForm.bindFromRequest().get();
    	
		if (!validate(u.getEmail())) {
			flash("fail", "Email já está em uso");
            return badRequest(registro.render());
        } else {
        	dao.persist(u);
            return redirect(
                routes.Application.index()
            );
        }
    }
	
    @Transactional
	private static boolean validate(String email) {
    	List<Usuario> usuarios = dao.findAllByClassName(Usuario.class.getName());
    	
    	Usuario u = null;
    	
    	for (int i = 0; i < usuarios.size(); i++) {
    		if (usuarios.get(i).getEmail().equals(email)) {
    			u = usuarios.get(i);
    		}
    	}
    	
    	return u == null;
    	
	}

}
