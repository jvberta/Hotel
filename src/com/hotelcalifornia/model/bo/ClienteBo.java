package com.hotelcalifornia.model.bo;

import java.util.Calendar;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hotelcalifornia.model.dao.cliente.ClienteDao;
import com.hotelcalifornia.model.objects.Cliente;
import com.hotelcalifornia.model.objects.Funcionario;
import com.hotelcalifornia.model.objects.Quarto;


public class ClienteBo {
	
private ClienteDao clienteDao;
	
	public ClienteBo(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		clienteDao = (ClienteDao) ctx.getBean("clienteDao");
	}
	
	public boolean cadastrar(Cliente cliente){
		
		if(clienteDao.localizarPorCpf(cliente.getCpf()) == null){
			
			clienteDao.salvar(cliente);
			return true;
		}else{
			return false;
		}
		
	}
	
	public void atualizarPerfil(Cliente cliente){
		clienteDao.alterar(cliente);
	}
	
	
	
	public void reservaOnline(Cliente cli, Quarto q, Calendar c){
		clienteDao.reservarOnline(cli, q, c);
	}
	
	public Cliente login(String cpf,String senha){
		return clienteDao.logar(cpf, senha);
	}
	
	public Cliente localizarPorCpf(String cpf){
		return clienteDao.localizarPorCpf(cpf);
	}
	
	public List<Cliente> localizaPorNome(String nome){
		return clienteDao.localizarPorNome(nome);
	}
	
	public Cliente localiza(Long id){
		return clienteDao.achar(id);
	}
	

}
