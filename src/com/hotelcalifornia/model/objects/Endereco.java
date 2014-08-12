package com.hotelcalifornia.model.objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table(name="endereco")
public class Endereco {
	@Id
	@SequenceGenerator(name="id",allocationSize=1,sequenceName="endereco_id_seq" )
	@GeneratedValue(generator="id",strategy=GenerationType.SEQUENCE)
	private long id;
	@Column(nullable=false,name="tipo_end")
	private String tipo;
	@Column(nullable=false,name="log_end")
	private String logradouro;
	@Column(nullable=false,name="num_end")
	private String numero;
	@Column(nullable=false,name="bairro_end")
	private String bairro;
	@Column(nullable=false,name="cid_end")
	private String cidade;
	@Column(nullable=false,name="uf_end",length=2)
	private String uf;
	@Column(nullable=false,name="cep_end",length=8)
	private String cep;
	@OneToOne(mappedBy="endereco")
	private Usuario usuario;
	
	
	
	public Endereco(){
		
	}
	
	public Endereco(String tipo, String logradouro, String numero,
			String bairro, String cidade, String uf, String cep, Usuario usuario) {
		super();
		this.tipo = tipo;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.usuario = usuario;
		
	}
	
	
		
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
