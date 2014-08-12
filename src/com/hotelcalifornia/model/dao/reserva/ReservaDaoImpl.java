package com.hotelcalifornia.model.dao.reserva;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hotelcalifornia.model.dao.BasicDao;
import com.hotelcalifornia.model.objects.Cliente;
import com.hotelcalifornia.model.objects.Quarto;
import com.hotelcalifornia.model.objects.Reserva;


@Repository("reservaDao")
public class ReservaDaoImpl extends BasicDao<Reserva, Long> implements ReservaDao {

	@Override
	public List<Reserva> listarReservasAbertas() {
		Criteria criteria = currentSession().createCriteria(daoType);
		criteria.add(Restrictions.isNull("dataSaida"));
		return criteria.list();
	}

	@Override
	public List<Reserva> buscarReservaAbertaCliente(Cliente cliente) {
		
		Criteria criteria = currentSession().createCriteria(daoType);
		criteria.add(Restrictions.eq("cliente", cliente));
		criteria.add(Restrictions.and(Restrictions.isNull("dataSaida")));
		return criteria.list(); 
				
	}

	@Override
	public Reserva buscarReservaAbertaPorQuarto(Quarto quarto) {
		Criteria criteria = currentSession().createCriteria(daoType);
		criteria.add(Restrictions.eq("quarto", quarto));
		criteria.add(Restrictions.and(Restrictions.isNull("dataSaida")));
		List<Reserva> reservas = criteria.list(); 
		if(reservas.isEmpty()){
			return null;
		}
		
		return reservas.get(0);
	}

	@Override
	public void fecharReserva(Reserva reserva, Calendar calendar) {
		Reserva r = achar(reserva.getId());
		r.setDataSaida(calendar);
		alterar(r);
		
	}

}
