package com.hotelcalifornia.model.dao.conta;

import org.springframework.stereotype.Repository;

import com.hotelcalifornia.model.dao.BasicDao;
import com.hotelcalifornia.model.objects.Conta;
import com.hotelcalifornia.model.objects.Reserva;

@Repository("contaDao")
public class ContaDaoImpl extends BasicDao<Conta, Long> implements ContaDao {
	
	public void pagarConta(Conta c){
		Reserva reserva = (Reserva)currentSession().get(Reserva.class, c.getReserva().getId());
		
		Conta conta = new Conta(c.getValor(),reserva,c.getFormaPagamento());
		
		salvar(conta);
	}
}
