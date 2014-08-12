package com.hotelcalifornia.model.dao.funcionario;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hotelcalifornia.model.dao.BasicDao;
import com.hotelcalifornia.model.objects.Cliente;
import com.hotelcalifornia.model.objects.Funcionario;
import com.hotelcalifornia.model.objects.Quarto;
import com.hotelcalifornia.model.objects.Reserva;

@Repository("funcionarioDao")
public class FuncionarioDaoImpl extends BasicDao<Funcionario, Long> implements FuncionarioDao{

	@Override
	public Funcionario logar(String cpf, String senha) {
		Criteria c = currentSession().createCriteria(daoType);
		List<Funcionario> result = c.add(Restrictions.eq("cpf", cpf))
									.add(Restrictions.eq("senha", senha)).list();
		
		if(!result.isEmpty()){
			return result.get(0);
		}else{
			return null;
		}
		
	}

	@Override
	public void reservar(Cliente cli,Quarto q, Calendar c) {
		Quarto quarto = (Quarto) currentSession().get(Quarto.class, q.getNumero());
		Cliente cliente = (Cliente) currentSession().get(Cliente.class, cli.getId());
		Reserva reserva = new Reserva(c,cliente,quarto,quarto.getValorDiaria());
		
		currentSession().save(reserva);
	}
	
}
