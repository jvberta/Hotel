package com.hotelcalifornia.model.dao.quarto;

import java.util.Calendar;
import java.util.List;

import com.hotelcalifornia.model.dao.GenericDao;
import com.hotelcalifornia.model.objects.Quarto;
import com.hotelcalifornia.model.objects.Reserva;
import com.hotelcalifornia.model.objects.TipoQuarto;

public interface QuartoDao extends GenericDao<Quarto, Integer>{
	
	public List<Reserva> consultaReservaAberta(Quarto quarto);
	
	public void alteraPreco(Quarto q, double novoPreco );
	
	public List<Quarto> listaQuartosReservados();
	
	public List<Quarto> listaQuartosDisponiveis(TipoQuarto tq, double preco);
		
	
	
	
}
