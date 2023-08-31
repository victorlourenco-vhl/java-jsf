package com.curso.jsf.repositories;

import java.io.Serializable;
import java.util.List;

import com.curso.jsf.entities.Empresa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class EmpresaRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	public EmpresaRepository() {
		
	}
	
	public EmpresaRepository(EntityManager manager) { 
		this.manager = manager;
	}
	
	public Empresa buscarPorId(Long id) {
		return manager.find(Empresa.class, id);
	}
	
	public List<Empresa> buscarPorNome(String nome) {
		TypedQuery<Empresa> query = manager.createQuery("FROM Empresa WHERE nomeFantasia LIKE :nomeFantasia", Empresa.class);
		query.setParameter("nomeFantasia", nome + "%");
		return query.getResultList();
	}
	
	public Empresa cadastrarEAtulizar(Empresa empresa) {
		return manager.merge(empresa);
	}
	
	public void remover(Empresa empresa) {
		empresa = buscarPorId(empresa.getId());
		manager.remove(empresa);
	}

}
