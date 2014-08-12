package com.hotelcalifornia.model.bo;

import java.util.Calendar;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hotelcalifornia.model.dao.quarto.QuartoDao;
import com.hotelcalifornia.model.dao.reserva.ReservaDao;
import com.hotelcalifornia.model.objects.Cliente;
import com.hotelcalifornia.model.objects.Conta;
import com.hotelcalifornia.model.objects.FormaPagamento;
import com.hotelcalifornia.model.objects.Quarto;
import com.hotelcalifornia.model.objects.Reserva;

public class ReservaBo {
	
private ReservaDao reservaDao;
	
	public ReservaBo(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		reservaDao = (ReservaDao) ctx.getBean("reservaDao");
	}
	
	public void fecharReserva(Reserva r,Calendar c,FormaPagamento fp){
		
		reservaDao.fecharReserva(r, c);
		
		ContaBo contaBo = new ContaBo();
		contaBo.pagarConta(new Conta(r.calculaTotal(),r,fp));
		
	}
	
	public List<Reserva> reservasAbertas(){
		return reservaDao.listarReservasAbertas();
	}
	
	
	public List<Reserva> reservaAbertaCliente(Cliente c){
		return reservaDao.buscarReservaAbertaCliente(c);
	}
	
	public Reserva reservaAbertaQuarto(Quarto q){
		return reservaDao.buscarReservaAbertaPorQuarto(q);
	}

	
	
	
	
	
	

}
