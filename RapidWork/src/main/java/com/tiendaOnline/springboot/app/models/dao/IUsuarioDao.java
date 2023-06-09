package com.tiendaOnline.springboot.app.models.dao;

import java.util.List;

import com.tiendaOnline.springboot.app.models.entity.Usuario;

public interface IUsuarioDao {
	
	public List<Usuario>findAll();

	public void save(Usuario usuario);
	
	public Usuario findOne(Long id);
	
	public void delete(Long id);
	
}