package com.hotelcalifornia.model.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.hotelcalifornia.model.dao.quarto.QuartoDao;
import com.hotelcalifornia.model.objects.Quarto;
import com.hotelcalifornia.model.objects.TipoQuarto;



public class QuartoBo {

	private QuartoDao quartoDao;
	
	public QuartoBo(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		quartoDao = (QuartoDao) ctx.getBean("quartoDao");
	}
	
	
	public boolean salvar(Quarto quarto){
		if(quartoDao.achar(quarto.getNumero()) == null){
			quartoDao.salvar(quarto);
			return true;
		}
		
		return false;
		
		
	}
	
	public Quarto achar(int numero){
		return quartoDao.achar(numero);
	}
	
	public void alterarPreco(Quarto q,double novoPreco){
		quartoDao.alteraPreco(q, novoPreco);
	}
	
	public boolean consultaDisponibilidade(Quarto q){
		if (quartoDao.consultaReservaAberta(q).isEmpty()){
			return true;
		}
		
		return false;
	}
	
	public List<Quarto> quartosDisponiveis(TipoQuarto tp, double preco){
		return quartoDao.listaQuartosDisponiveis(tp,preco);
	}
	
	public List<Quarto> quartosReservados(){
		return quartoDao.listaQuartosReservados();
	}
	
	
}
