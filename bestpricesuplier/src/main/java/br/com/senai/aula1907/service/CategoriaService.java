package br.com.senai.aula1907.service;


import java.util.List;

import br.com.senai.aula1907.orm.Categoria;

public interface CategoriaService {
	public List<Categoria> listarCategorias();
	
	public void apagarCategoria(Integer id);
	
	public Categoria salvarCategoria(Categoria categoria);
	
	public Categoria consultarCategoriaId(Integer id);
	
	public Categoria atualizarCategoria(Categoria categoria);
}