package com.hotelcalifornia.model.objects;

import java.time.LocalDate;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="conta")
public class Conta {
	
	@Id
	@SequenceGenerator(name = "id", sequenceName="usuario_id_seq",allocationSize= 1)
	@GeneratedValue(generator="id", strategy=GenerationType.SEQUENCE)
	private long id;
	@Column(name="valor",precision=2)
	private double valor;
	@OneToOne
	private Reserva reserva;
	@Enumerated(EnumType.STRING)
	@Column(name="forma_pagamento")
	private FormaPagamento formaPagamento;
	
	
	public Conta(){
		
	}
	
	
	public Conta(double valor, Reserva reserva,
			FormaPagamento formaPagamento) {
		super();
		
		this.valor = valor;
		this.reserva = reserva;
		this.formaPagamento = formaPagamento;
	}
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Reserva getReserva() {
		return reserva;
	}
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	
	
	
	
	
	
}
