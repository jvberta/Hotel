package com.hotelcalifornia.model.objects;


import java.time.LocalDateTime;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.swing.JOptionPane;


@Entity
@Table(name="reserva")
public class Reserva {
	
	@Id
	@SequenceGenerator(name = "id", sequenceName="reserva_id_seq",allocationSize= 1)
	@GeneratedValue(generator="id", strategy=GenerationType.SEQUENCE)
	private long id;
	@Temporal(TemporalType.DATE)
	@Column(name="data_entrada")
	private Calendar dataEntrada;
	@Temporal(TemporalType.DATE)
	@Column(name="data_saida",nullable=true)
	private Calendar dataSaida;
	@ManyToOne(optional=false,fetch=FetchType.EAGER,targetEntity=Cliente.class)
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	@ManyToOne(optional=false,fetch=FetchType.EAGER,targetEntity=Quarto.class)
	@JoinColumn(name="num_quarto")
	private Quarto quarto;
	@Column(name="preco_cobranca",nullable=false,precision=2)
	private double precoCobranca;
	
	public Reserva(){
		
	}
	
	public Reserva(Calendar dataEntrada,Cliente cliente,
			Quarto quarto, double precoCobranca) {
		super();
		this.dataEntrada = dataEntrada;
		this.cliente = cliente;
		this.quarto = quarto;
		this.precoCobranca = precoCobranca;
		
	}


	public boolean equals(Reserva reserva) {
		return this.quarto.equals(reserva.quarto) && this.dataEntrada.equals(reserva.dataEntrada);
	
	}
	
	
	public long calculaQtdDiarias(){
		long miliDataEntrada = this.dataEntrada.getTimeInMillis();
		long miliDataSaida = this.dataSaida.getTimeInMillis();
		
		long difDatas = miliDataSaida - miliDataEntrada;
		
		long milisEmUmDia = 24*60*60*1000;
		
		long qtdDiarias = difDatas/milisEmUmDia;
		
		return qtdDiarias; 
	}
	
	public double calculaTotal(){
		
		 return calculaQtdDiarias() * getPrecoCobranca();  
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Calendar getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Calendar dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public Calendar getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(Calendar dataSaida) {
		this.dataSaida = dataSaida;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setClientes(Cliente cliente) {
		this.cliente = cliente;
	}
	public Quarto getQuarto() {
		return quarto;
	}
	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}
	public double getPrecoCobranca() {
		return precoCobranca;
	}
	public void setPrecoCobranca(double precoCobranca) {
		this.precoCobranca = precoCobranca;
	}
	

}
