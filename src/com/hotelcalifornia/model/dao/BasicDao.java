package com.hotelcalifornia.model.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
public abstract class BasicDao<E,K extends Serializable> implements GenericDao<E, K> {
	
	private SessionFactory sessionFactory;
	protected Class<? extends E> daoType;
	
	@SuppressWarnings("unchecked")
	public BasicDao(){
		this.daoType = ((Class<E>) ((ParameterizedType) getClass().getGenericSuperclass())
												.getActualTypeArguments()[0]);
	}
	
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void salvar(E entity) {
		currentSession().save(entity);
		
	}

	@Override
	public void alterar(E entity) {
		currentSession().saveOrUpdate(entity);
		
	}

	@Override
	public E achar(K id) {
		// TODO Auto-generated method stub
		return (E) currentSession().get(daoType, id);
	}

	@Override
	public List<E> listar() {
		// TODO Auto-generated method stub
		return currentSession().createCriteria(daoType).list();
	}

}
