package com.tiendaOnline.springboot.app.models.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tiendaOnline.springboot.app.models.entity.Cliente;

@Repository
public class ClienteDaoImpl implements IClienteDao {
    @PersistenceContext
	private EntityManager em;
    
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Cliente> findAll(){
		// TODO Auto-generated method stub
		return em.createQuery("from Cliente").getResultList();
	}
	@Override
	public Cliente findOne(Long id) {
		return em.find(Cliente.class, id);
	}
	
	@Override
	@Transactional
	public void save(Cliente cliente) {
		if(cliente.getIdCliente()!= null && cliente.getIdCliente()>0){
			em.merge(cliente);
		}else {
			em.persist(cliente);
			
		}
		
	}

	@Override
	@Transactional
	public void delete(Long id) {
		em.remove(findOne(id));
		
	}

}