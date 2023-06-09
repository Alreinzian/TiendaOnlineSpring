package com.tiendaOnline.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tiendaOnline.springboot.app.models.entity.Usuario;

@Repository
public class UsuarioDaoImpl implements IUsuarioDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Usuario").getResultList();
	}

	@Override
	public Usuario findOne(Long id) {
		return em.find(Usuario.class, id);
	}

	@Override
	@Transactional
	public void save(Usuario usuario) {
		if (usuario.getId() != null && usuario.getId() > 0) {
			em.merge(usuario);
		} else {
			em.persist(usuario);
		}
	}

	@Override
	@Transactional
	public void delete(Long id) {
		em.remove(findOne(id));
	}

}