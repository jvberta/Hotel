package com.hotelcalifornia.model.objects;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Cliente extends Usuario{
	
	@OneToMany(mappedBy="cliente",fetch=FetchType.LAZY)
	private List<Reserva> reservas;
	
	

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(String nome, String cpf, String rg, String email,
			Calendar data_nasc, Endereco end, String s) {
		super(nome, cpf, rg, email, data_nasc, end, s);
		// TODO Auto-generated constructor stub
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

}
