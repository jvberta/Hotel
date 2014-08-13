package com.hotelcalifornia.model.bo;

import java.util.Calendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hotelcalifornia.model.dao.conta.ContaDao;
import com.hotelcalifornia.model.dao.funcionario.FuncionarioDao;
import com.hotelcalifornia.model.objects.Cliente;
import com.hotelcalifornia.model.objects.FormaPagamento;
import com.hotelcalifornia.model.objects.Funcionario;
import com.hotelcalifornia.model.objects.Quarto;
import com.hotelcalifornia.model.objects.Reserva;

public class FuncionarioBo {
	
private FuncionarioDao funcDao;
	
	public FuncionarioBo(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		funcDao = (FuncionarioDao) ctx.getBean("funcionarioDao");
	}
	
	public void cadastrar(Funcionario func){
		funcDao.salvar(func);
	}
	
	public void reservar(Cliente cli,Quarto q, Calendar c){
		funcDao.reservar(cli, q, c);
	}
	
	public void fecharConta(Reserva r, FormaPagamento fp){
		ReservaBo resBo = new ReservaBo();
		resBo.fecharReserva(r, Calendar.getInstance(), fp);
	}
	
	public boolean CadastrarQuarto(Quarto quarto){
		QuartoBo quartoBo = new QuartoBo();
		
		if(quartoBo.achar(quarto.getNumero())==null){
			quartoBo.salvar(quarto);
			return true; 
		}
		
		return false;
	}
	
	public Funcionario login(String cpf,String senha){
		return funcDao.logar(cpf, senha);
	}
	

}
