package com.tiendaOnline.springboot.app.models.dao;

import java.util.List;

import com.tiendaOnline.springboot.app.models.entity.Cliente;

//import org.springframework.data.repository.CrudRepository;

//import com.bolsadeideas.springboot.app.models.entity.Cliente;

//public interface IClienteDao extends CrudRepository<Cliente, Long> {

//}

public interface IClienteDao{
	public List<Cliente>findAll();
	
	public void save(Cliente cliente);
	
	public Cliente findOne(Long id);
	
	public void delete (Long id);
	
}