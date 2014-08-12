package com.hotelcalifornia.model.dao.reserva;

import java.util.Calendar;
import java.util.List;
import com.hotelcalifornia.model.dao.GenericDao;
import com.hotelcalifornia.model.objects.Cliente;
import com.hotelcalifornia.model.objects.Quarto;
import com.hotelcalifornia.model.objects.Reserva;

public interface ReservaDao extends GenericDao<Reserva, Long> {
	
	public List<Reserva> listarReservasAbertas();
	
	public List<Reserva> buscarReservaAbertaCliente(Cliente cliente);
	
	public Reserva buscarReservaAbertaPorQuarto(Quarto quarto);
	
	public void fecharReserva(Reserva reserva, Calendar calendar);
	
	
		
	
}
