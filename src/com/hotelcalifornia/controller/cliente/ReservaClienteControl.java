package com.hotelcalifornia.controller.cliente;

import java.util.Calendar;
import java.util.List;

import com.hotelcalifornia.model.bo.ClienteBo;
import com.hotelcalifornia.model.bo.QuartoBo;
import com.hotelcalifornia.model.objects.Cliente;
import com.hotelcalifornia.model.objects.Quarto;
import com.hotelcalifornia.model.objects.Reserva;
import com.hotelcalifornia.model.objects.TipoQuarto;

public class ReservaClienteControl {
	
	public List<Quarto> quartosDisponiveis(TipoQuarto tp, double preco){
		QuartoBo quartoBo = new QuartoBo();
		return quartoBo.quartosDisponiveis(tp, preco);
	}
	
	public boolean reservaQuarto(Cliente cli, Quarto q, Calendar c){
		ClienteBo clienteBo = new ClienteBo();
		try {
			clienteBo.reservaOnline(cli, q, c);
			return true;
			
		} catch (Exception e) {
			return false;
					
		}
		
	}
	
	public Cliente clienteLogado(){
		return PainelClienteControl.clienteLogado();
	}

}
