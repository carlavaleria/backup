package br.com.caelum.tarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TarefasController {

	@RequestMapping("/novaTarefa")
	public String form() {
		System.out.println("executando formulario");
		return "tarefa/formulario";
	}

}


