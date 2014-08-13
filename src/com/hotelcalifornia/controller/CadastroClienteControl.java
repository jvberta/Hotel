package com.hotelcalifornia.controller;

import com.hotelcalifornia.model.bo.ClienteBo;
import com.hotelcalifornia.model.objects.Cliente;


public class CadastroClienteControl {
	
	public boolean cadastrarCliente(Cliente cliente){
		ClienteBo clienteBo = new ClienteBo();
		
		if(clienteBo.cadastrar(cliente)){
			return true;
		}
		
		return false;
	}

}
