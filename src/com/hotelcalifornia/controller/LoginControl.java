package com.hotelcalifornia.controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import com.hotelcalifornia.model.bo.ClienteBo;
import com.hotelcalifornia.model.bo.FuncionarioBo;
import com.hotelcalifornia.model.objects.Cliente;
import com.hotelcalifornia.model.objects.Funcionario;
import com.hotelcalifornia.util.criacaoELeituraDeArquivos;

public class LoginControl {
	
	public boolean loginFuncionario(String cpf, String senha){
		FuncionarioBo funcBo = new FuncionarioBo();
		
		Funcionario func = funcBo.login(cpf, senha);
		
		if(func != null){
			try {
				criacaoELeituraDeArquivos.escreveArquivo("usuario.txt",""+func.getId());
				return true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
			
	}
	
	
	public boolean loginCliente(String cpf, String senha){
		ClienteBo clienteBo = new ClienteBo();
		
		Cliente cliente = clienteBo.login(cpf, senha);
		
		if(cliente != null){
			try {
				criacaoELeituraDeArquivos.escreveArquivo("usuario.txt",""+cliente.getId());
				return true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
			
	}


}
