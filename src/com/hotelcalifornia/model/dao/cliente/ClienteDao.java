package com.hotelcalifornia.model.dao.cliente;

import java.util.Calendar;
import java.util.List;

import com.hotelcalifornia.model.dao.GenericDao;
import com.hotelcalifornia.model.objects.Cliente;
import com.hotelcalifornia.model.objects.Quarto;

public interface ClienteDao extends GenericDao<Cliente, Long> {
	
	public void reservarOnline(Cliente cliente,Quarto quarto, Calendar dt);
	
	public Cliente logar(String email,String senha);
	
	public Cliente localizarPorCpf(String cpf);
	
	public List<Cliente> localizarPorNome(String nome);
	
}
