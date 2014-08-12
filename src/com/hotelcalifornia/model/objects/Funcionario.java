package com.hotelcalifornia.model.objects;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Funcionario extends Usuario{

	public Funcionario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Funcionario(String nome, String cpf, String rg, String email,
			Calendar data_nasc, Endereco end, String s) {
		super(nome, cpf, rg, email, data_nasc, end, s);
		// TODO Auto-generated constructor stub
	}
	
}
