package com.hotelcalifornia.model.dao.quarto;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hotelcalifornia.model.dao.BasicDao;
import com.hotelcalifornia.model.objects.Quarto;
import com.hotelcalifornia.model.objects.Reserva;
import com.hotelcalifornia.model.objects.TipoQuarto;

@Repository("quartoDao")
public class QuartoDaoImpl extends BasicDao<Quarto, Integer> implements QuartoDao {

	@Override
	public List<Reserva> consultaReservaAberta(Quarto quarto) {
		Criteria crit = currentSession().createCriteria(Reserva.class);
		crit.add(Restrictions.eq("quarto", quarto));
		crit.add(Restrictions.isNull("dataSaida"));
		return crit.list();
		
		
		
	}

	@Override
	public void alteraPreco(Quarto q, double novoPreco) {
		Quarto quarto = achar(q.getNumero());
		quarto.setValorDiaria(novoPreco);
		alterar(quarto);
		
	}

	@Override
	public List<Quarto> listaQuartosDisponiveis(TipoQuarto tp, double preco) {
		List<Quarto> quartos;
		//Criteria para listar os quartos que ainda nao possuem nenhuma reserva
		Criteria critQuartoSemRes = currentSession().createCriteria(daoType);
		critQuartoSemRes.add(Restrictions.isEmpty("reservas"));
		if(tp!=null){
			critQuartoSemRes.add(Restrictions.eq("tipoQuarto", tp));
		}
		if(preco > 0.0){
			critQuartoSemRes.add(Restrictions.le("valorDiaria", preco));
		}
		quartos = critQuartoSemRes.list();
		//Criteria para listar os quartos que possuem reservas mas j� foram finalizadas
		Criteria critQuarto = currentSession().createCriteria(daoType);
		Criteria critReserva = critQuarto.createCriteria("reservas");
		if(tp!=null){
			critQuarto.add(Restrictions.eq("tipoQuarto", tp));
		}
		if(preco > 0.0){
			critQuarto.add(Restrictions.le("valorDiaria", preco));
		}
		critReserva.add(Restrictions.or(Restrictions.isNotNull("dataSaida")));
		quartos.addAll(critQuarto.list());
		return quartos;
		
	}

	@Override
	public List<Quarto> listaQuartosReservados() {
		Criteria critQuarto = currentSession().createCriteria(daoType);
		Criteria critReserva = critQuarto.createCriteria("reservas");
		critReserva.add(Restrictions.or(Restrictions.isNull("dataSaida")));
		return critQuarto.list();
	}
	
	

}
