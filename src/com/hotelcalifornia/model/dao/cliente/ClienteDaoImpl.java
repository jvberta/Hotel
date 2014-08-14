package com.hotelcalifornia.model.dao.cliente;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hotelcalifornia.model.dao.BasicDao;
import com.hotelcalifornia.model.objects.Cliente;
import com.hotelcalifornia.model.objects.Quarto;
import com.hotelcalifornia.model.objects.Reserva;

@Repository("clienteDao")
public class ClienteDaoImpl extends BasicDao<Cliente, Long> implements ClienteDao{

	@Override
	public void salvar(Cliente entity) {
		currentSession().save(entity.getEndereco());
		super.salvar(entity);
	}
	
	@Override
	public void alterar(Cliente entity) {
		currentSession().saveOrUpdate(entity.getEndereco());
		super.alterar(entity);
	}
	
	
	@Override
	public void reservarOnline(Cliente c,Quarto q, Calendar dt) {
		Quarto quarto = (Quarto) currentSession().get(Quarto.class, q.getNumero());
		Cliente cliente = (Cliente) achar(c.getId());
		Reserva reserva = new Reserva(dt,cliente,quarto,quarto.getValorDiaria());
		
		currentSession().save(reserva);
		
	}

	@Override
	public Cliente logar(String cpf, String senha) {
		Criteria c = currentSession().createCriteria(daoType);
		List<Cliente> result = c.add(Restrictions.eq("cpf", cpf))
									.add(Restrictions.eq("senha", senha)).list();
		
		if(!result.isEmpty()){
			return result.get(0);
		}else{
			return null;
		}
		
	}

	@Override
	public Cliente localizarPorCpf(String cpf) {
		Criteria crit = currentSession().createCriteria(daoType);
		crit.add(Restrictions.eq("cpf",cpf));
		List<Cliente> cliente = crit.list();
		if(cliente.isEmpty()){
			return null;
		}
		
		return cliente.get(0);
		
	}

	@Override
	public List<Cliente> localizarPorNome(String nome) {
		Criteria crit = currentSession().createCriteria(daoType);
		crit.add(Restrictions.ilike("nome",nome));
		return  crit.list();
		
	}

}

