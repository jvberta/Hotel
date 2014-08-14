package com.hotelcalifornia.controller;

import com.hotelcalifornia.model.bo.ClienteBo;
import com.hotelcalifornia.model.objects.Cliente;

public class AtualizarClienteControl {
	
	public boolean atualizarCliente(Cliente cliente){
		ClienteBo clienteBo = new ClienteBo();
		
		try {
			clienteBo.atualizarPerfil(cliente);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public Cliente clienteLogado(){
		return PainelClienteControl.clienteLogado();
	}

}
