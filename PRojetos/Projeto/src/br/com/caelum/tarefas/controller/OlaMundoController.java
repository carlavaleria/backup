package br.com.caelum.tarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OlaMundoController {
	
	@RequestMapping("/a")
	public String execute() {
		System.out.println("J� deu certo mvc");
		return "ok";
	}
}
