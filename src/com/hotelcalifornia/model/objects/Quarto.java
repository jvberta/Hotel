package com.hotelcalifornia.model.objects;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="quarto")
public class Quarto {
	@Id
	@Column(name="num_quarto")
	private int numero;
	@Enumerated(EnumType.STRING)
	@Column(name="tipo_quarto",nullable=false)
	private TipoQuarto tipoQuarto;
	@Column(name="valor_quarto",nullable=false,precision=2)
	private double valorDiaria;
	@OneToMany(mappedBy="quarto",fetch=FetchType.LAZY)
	private List<Reserva> reservas;
	
	
	public Quarto(){
		
	}
	
	public Quarto(int numero, TipoQuarto tipoQuarto, double valorDiaria) {
		super();
		this.numero = numero;
		this.tipoQuarto = tipoQuarto;
		this.valorDiaria = valorDiaria;
	}



	public boolean equals(Quarto quarto) {
		// TODO Auto-generated method stub
		return this.numero == quarto.numero;
	}
	
	

	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public TipoQuarto getTipoQuarto() {
		return tipoQuarto;
	}
	public void setTipoQuarto(TipoQuarto tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}
	public double getValorDiaria() {
		return valorDiaria;
	}
	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	
	
	
	
}
