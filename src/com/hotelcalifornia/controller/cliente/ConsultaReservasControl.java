package com.hotelcalifornia.controller.cliente;


import java.util.List;

import com.hotelcalifornia.model.bo.ReservaBo;
import com.hotelcalifornia.model.objects.Cliente;
import com.hotelcalifornia.model.objects.Reserva;

public class ConsultaReservasControl {
	
	private ReservaBo reservaBo;
	
	public ConsultaReservasControl(){
		this.reservaBo = new ReservaBo();
	}
	
	
	public List<Reserva> listaReservasCliente(Cliente c){
		return reservaBo.reservaAbertaCliente(c);
	}
	
	
	public Cliente clienteLogado(){
		return PainelClienteControl.clienteLogado();
	}
	
	

}
