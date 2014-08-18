package com.hotelcalifornia.controller.funcionario;

import java.util.Calendar;
import java.util.List;

import com.hotelcalifornia.controller.cliente.PainelClienteControl;
import com.hotelcalifornia.model.bo.ClienteBo;
import com.hotelcalifornia.model.bo.FuncionarioBo;
import com.hotelcalifornia.model.bo.QuartoBo;
import com.hotelcalifornia.model.objects.Cliente;
import com.hotelcalifornia.model.objects.Quarto;
import com.hotelcalifornia.model.objects.TipoQuarto;

public class ReservaFuncControl {
	
	public List<Quarto> quartosDisponiveis(TipoQuarto tp, double preco){
		QuartoBo quartoBo = new QuartoBo();
		return quartoBo.quartosDisponiveis(tp, preco);
	}
	
	
	
	public Cliente pesquisaCliente(String cpf){
		ClienteBo clienteBo = new ClienteBo();
		return clienteBo.localizarPorCpf(cpf);
	}
	
	
	public boolean reservaQuarto(Cliente cli, Quarto q, Calendar c){
		FuncionarioBo funcBo = new FuncionarioBo();
		try {
			funcBo.reservar(cli, q, c);
			return true;
			
		} catch (Exception e) {
			return false;
					
		}
		
	}
	
	

}
