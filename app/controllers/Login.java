package controllers;

import static play.data.Form.form;

import java.util.List;

import models.Usuario;
import models.dao.GenericDAO;
import play.mvc.Controller;
import play.mvc.Result;
import play.data.DynamicForm;
import play.data.Form;
import play.db.jpa.Transactional;
import views.html.login;

public class Login extends Controller {
	
	private static final GenericDAO dao = new GenericDAO();
	private static Form<Usuario> loginForm = form(Usuario.class).bindFromRequest();

	
    public static Result show() {
//		if (session().get("user") != null) {
//			return redirect(routes.Application.index());
//		}
        return ok(login.render());
    }
	
    @Transactional
	public static Result logout() {
		session().clear();
		return ok(login.render());
	}
    
	@Transactional
	public static Result authenticate() {
		
		DynamicForm requestData = Form.form().bindFromRequest();
		
		//Usuario u = loginForm.bindFromRequest().get();
		
		List<Usuario> usuarios = dao.findAllByClassName(Usuario.class.getName());
    	
    	String email = requestData.get("email");
		String senha = requestData.get("pass");

        if (!validate(email, senha)) {
        	flash("fail", "Email ou Senha Inválidos");
        	return badRequest(login.render());
        } else {
        	
        	Usuario u = null;
        	
        	for (int i = 0; i < usuarios.size(); i++) {
        		if (usuarios.get(i).getEmail().equals(email)) {
        			u = usuarios.get(i);
        		}
        	}
        	//Usuario user = controlador.getUsuario(email);
            session().clear();
            session("user", u.getNome());
            session("email",u.getEmail());
            return redirect(
                routes.Application.index()
            );
        }
    }
	
	@Transactional
	private static boolean validate(String email, String senha) {
		
		List<Usuario> usuarios = dao.findAllByClassName(Usuario.class.getName());
    	
    	Usuario u = null;
    	
    	for (int i = 0; i < usuarios.size(); i++) {
    		if (usuarios.get(i).getEmail().equals(email)) {
    			u = usuarios.get(i);
    		}
    	}
		
		if(u == null) return false;
		return u.getSenha().equals(senha);
	}
}
