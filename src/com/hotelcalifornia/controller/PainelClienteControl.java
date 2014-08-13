package com.hotelcalifornia.controller;

import java.io.IOException;

import com.hotelcalifornia.model.bo.ClienteBo;
import com.hotelcalifornia.model.objects.Cliente;
import com.hotelcalifornia.util.criacaoELeituraDeArquivos;
import com.hotelcalifornia.view.PainelCliente;

public class PainelClienteControl {
	
	private ClienteBo clienteBo;
	
	public PainelClienteControl(){
		this.clienteBo = new ClienteBo();
	}
	
	public Cliente clienteLogado(){
		String id ="0";
		
		try {
			id = criacaoELeituraDeArquivos.leArquivo("usuario.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return clienteBo.localiza(Long.parseLong(id));
	}
	
	 
		
	

}
