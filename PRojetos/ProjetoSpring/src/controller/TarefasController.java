package controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.TarefaDao;
import modelo.Tarefa;



@Controller
public class TarefasController {
	private final TarefaDao dao;

	@Autowired
	public TarefasController(TarefaDao dao) {
		this.dao = dao;
	}

	@RequestMapping("novaTarefa")
	public String form() {
		System.out.println("Executando Spring");
		return "tarefa/formulario";
	}


	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) {

		if(result.hasFieldErrors("descricao")) {
			return "tarefa/formulario";
		}
		dao.adicionar(tarefa);
		return "tarefa/adicionada";

	}


	@RequestMapping("listaTarefas")
	public String lista(Model model) {
		model.addAttribute("tarefas", dao.listar());
		return "tarefa/lista";
	}


	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa) {
		dao.remover(tarefa);
		return "redirect:listaTarefas";
	}

	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model model) {
		model.addAttribute("tarefa", dao.buscarTarefa(id));
		return "tarefa/mostra";
	}

	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa) {
		dao.alterar(tarefa);
		return "redirect:listaTarefas";

	}

	@RequestMapping("finalizaTarefa")
	public void finaliza(Long id, HttpServletResponse response) throws IOException {
		Tarefa tarefa = dao.buscarTarefa(id); 
		tarefa.setFinalizado(true);
		String data = Calendar.getInstance().getTime().toString();
		tarefa.setDataFormatada(data);
		dao.alterar(tarefa);
		response.getWriter().write(tarefa.getDataFormatada());
	}
}



