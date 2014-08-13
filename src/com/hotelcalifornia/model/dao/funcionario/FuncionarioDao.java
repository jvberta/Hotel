package com.hotelcalifornia.model.dao.funcionario;

import java.util.Calendar;

import com.hotelcalifornia.model.dao.GenericDao;
import com.hotelcalifornia.model.objects.Cliente;
import com.hotelcalifornia.model.objects.Funcionario;
import com.hotelcalifornia.model.objects.Quarto;

public interface FuncionarioDao extends GenericDao<Funcionario, Long>{
	
	public Funcionario logar(String cpf, String senha);
	
	public void reservar(Cliente cliente,Quarto q, Calendar c);
	
	

}
