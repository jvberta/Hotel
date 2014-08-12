package com.hotelcalifornia.model.objects;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="usuario")
public abstract class Usuario {
	@Id
	@SequenceGenerator(name = "id", sequenceName="usuario_id_seq",allocationSize= 1)
	@GeneratedValue(generator="id", strategy=GenerationType.SEQUENCE)
	protected long id;
	@Column(nullable=false,name="nome_usuario")
	protected String nome;
	@Column(nullable=false,name="cpf_usuario",length=11,unique=true)
    protected String cpf;
	@Column(nullable=false,name="rg_usuario",unique=true)
    protected String rg;
	@Column(nullable=false,name="email_usuario")
    protected String email;
	@Temporal(TemporalType.DATE)
	@Column(nullable=false,name="data_nasc_usuario")
    protected Calendar data_nasc;
	@OneToOne
	@JoinColumn(name="endereco_id")
    protected Endereco endereco;
	@Column(name="senha_usuario")
    protected String senha;
	
	public Usuario(){
		
	}
	
	public Usuario(String nome,String cpf,
					String rg,String email,Calendar data_nasc,Endereco end,String s){
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.email = email;
		this.data_nasc = data_nasc;
		this.endereco = end;
		this.senha = s;
	}
    
    
    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Calendar getData_nasc() {
		return data_nasc;
	}
	public void setData_nasc(Calendar data_nasc) {
		this.data_nasc = data_nasc;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
    
    
    
    
    
}
