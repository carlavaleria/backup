package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import dao.UsuarioDao;
import modelo.Usuario;

@Controller
public class LoginController {
	
	private final UsuarioDao dao;
	
	@Autowired
	public LoginController(UsuarioDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("loginForm")
	public String loginForm() {
		return "formulario-login";
	}
	
	
	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usuario , HttpSession session) {
		if (dao.existeUsuario(usuario)) {
			session.setAttribute("usuarioLogado", usuario);
			return "menu";
		}
		return "formulario-login";
	}

	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
	session.invalidate();
	return "redirect:loginForm";
	}
}
