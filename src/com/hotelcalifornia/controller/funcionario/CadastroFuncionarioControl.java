package com.hotelcalifornia.controller.funcionario;

import com.hotelcalifornia.model.bo.ClienteBo;
import com.hotelcalifornia.model.bo.FuncionarioBo;
import com.hotelcalifornia.model.objects.Cliente;
import com.hotelcalifornia.model.objects.Funcionario;

public class CadastroFuncionarioControl {
	
	public boolean cadastrarFuncionario(Funcionario func){
		FuncionarioBo funcBo = new FuncionarioBo();
		try {
			funcBo.cadastrar(func);
			return true;
		} catch (Exception e) {
			return false;
		}
	
		
	}

}
