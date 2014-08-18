package com.hotelcalifornia.controller.funcionario;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.hotelcalifornia.model.bo.ClienteBo;
import com.hotelcalifornia.model.bo.QuartoBo;
import com.hotelcalifornia.model.bo.ReservaBo;
import com.hotelcalifornia.model.objects.Cliente;
import com.hotelcalifornia.model.objects.FormaPagamento;
import com.hotelcalifornia.model.objects.Quarto;
import com.hotelcalifornia.model.objects.Reserva;

public class FecharReservaControl {
	private ReservaBo reservaBo;
	private ClienteBo clienteBo;
	private QuartoBo quartoBo;
	
	public FecharReservaControl(){
		this.reservaBo = new ReservaBo();
		this.clienteBo = new ClienteBo();
		this.quartoBo = new QuartoBo();
	}
	
	
	public Cliente pesqCliente(String cpf){
		return clienteBo.localizarPorCpf(cpf);
	}
	
	public Quarto pesqQuarto(int num){
		return quartoBo.achar(num);
	}
	
	
	public List<Reserva> listarReservasAbertas(){
		return reservaBo.reservasAbertas();
	}
	
	public List<Reserva> pesqReservasporQuarto(Quarto q){
		return reservaBo.reservaAbertaQuarto(q);
	}
	
	public List<Reserva> pesqReservasPorCliente(Cliente c){
		return reservaBo.reservaAbertaCliente(c);
	}
	
	
	public boolean fecharReserva(Reserva r, FormaPagamento fp){
		try {
			reservaBo.fecharReserva(r, Calendar.getInstance(), fp);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

}
 