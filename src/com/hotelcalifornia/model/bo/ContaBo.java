package com.hotelcalifornia.model.bo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hotelcalifornia.model.dao.conta.ContaDao;
import com.hotelcalifornia.model.dao.quarto.QuartoDao;
import com.hotelcalifornia.model.objects.Conta;
import com.hotelcalifornia.model.objects.Reserva;

public class ContaBo {
	
private ContaDao contaDao;
	
	public ContaBo(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		contaDao = (ContaDao) ctx.getBean("contaDao");
	}
	
	public void pagarConta(Conta conta){
		contaDao.salvar(conta);
	}

}
