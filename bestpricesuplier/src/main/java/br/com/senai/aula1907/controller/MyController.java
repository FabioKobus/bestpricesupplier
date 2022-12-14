package br.com.senai.aula1907.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.senai.aula1907.orm.Categoria;
import br.com.senai.aula1907.service.CategoriaService;

@Controller
public class MyController {
	
	@Autowired
	private CategoriaService servico;
	
	@GetMapping({"/categoria", "/"})
	public String listarGrupo(Model modelo) {
		modelo.addAttribute("categoria", servico.listarCategorias());
		return "categoria"; //mostrar a página grupo.html
	}
	
	@GetMapping({"/categoria/{id}"})
	public String apagarCategoria(@PathVariable Integer id) {
		servico.apagarCategoria(id);
		return "redirect:/categoria"; //mostrar a página grupo.html
	}
	
	@GetMapping("/categoria/adicionar")
	public String adicionarCategoria(Model modelo) {
		Categoria categoria = new Categoria();
		modelo.addAttribute("categoria", categoria);
		return "formCategoria";
	}
	
	@PostMapping("/categoria")
	public String salvarCategoria(@ModelAttribute("categoria") Categoria categoria) {
		servico.salvarCategoria(categoria);
		return "redirect:/categoria";
	}
	
	@GetMapping({"/categoria/editar/{id}"})
	public String editarCategoria(@PathVariable Integer id, Model modelo) {
		modelo.addAttribute("categoria", servico.consultarCategoriaId(id));
		return "editarCategoria";
	}
	
	@PostMapping("/categoria/{id}")
	public String atualizarCategoria(@PathVariable Integer id, @ModelAttribute("categoria") Categoria categoria, Model modelo) {
		Categoria cat = servico.consultarCategoriaId(id);
		cat.setId(id);
		cat.setDescricao(categoria.getDescricao());
		cat.setAtivo(categoria.getAtivo());
		servico.atualizarCategoria(cat);
		return "redirect:/categoria";
	}
}







