package com.hotelcalifornia.model.dao;

import java.util.List;



public interface GenericDao <E,K> {

	public void salvar(E entity);
		
	public void alterar(E entity);
	
	public E achar(K id);
	
	public List<E> listar();
		
	
}
