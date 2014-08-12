package com.hotelcalifornia.view;

import java.time.LocalDate;
import java.time.Month;





import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hotelcalifornia.model.bo.ReservaBo;
import com.hotelcalifornia.model.dao.cliente.ClienteDao;
import com.hotelcalifornia.model.dao.quarto.QuartoDao;
import com.hotelcalifornia.model.dao.reserva.ReservaDao;
import com.hotelcalifornia.model.objects.Cliente;
import com.hotelcalifornia.model.objects.Endereco;
import com.hotelcalifornia.model.objects.FormaPagamento;
import com.hotelcalifornia.model.objects.Quarto;
import com.hotelcalifornia.model.objects.Reserva;
import com.hotelcalifornia.model.objects.TipoQuarto;



public class Teste {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

		ClienteDao clienteDao = (ClienteDao) ctx.getBean("clienteDao");
		QuartoDao quartoDao = (QuartoDao) ctx.getBean("quartoDao");
		ReservaDao reservaDao = (ReservaDao) ctx.getBean("reservaDao");
		
		ReservaBo reservaBo = new ReservaBo();
		
		Endereco endereco = new Endereco();
		endereco.setBairro("bairro");
		endereco.setCep("57013332");
		endereco.setCidade("maceio");
		endereco.setLogradouro("fdf");
		endereco.setNumero("143");
		endereco.setTipo("rua");
		endereco.setUf("al");
		
		//enderecoDao.salvar(endereco);
		
		
		
		Cliente cliente = new Cliente();
		cliente.setNome("berta");
		cliente.setCpf("04684597430");
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR,1993);
		c.set(Calendar.MONTH, Calendar.AUGUST);
		c.set(Calendar.DAY_OF_MONTH,6);
		cliente.setData_nasc(c);
		cliente.setEmail("berta@email.com");
		cliente.setEndereco(endereco);
		cliente.setRg("23233432");
		cliente.setSenha("14324");
		cliente.setId(1);
		
		Quarto quarto = new Quarto(124, TipoQuarto.SINGLE, 100.00);
		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.YEAR, 2014);
		c2.set(Calendar.MONTH, Calendar.SEPTEMBER);
		c2.set(Calendar.DAY_OF_MONTH,1);
		
		//clienteDao.cadastrar(cliente);
		
		//clienteDao.reservarOnline(cliente, quarto, c2);
		
		Cliente cli = clienteDao.logar("berta@email.com", "14324");
		
		if(cli!=null){
			System.out.println("Logou");
			System.out.println(cli.getNome());
		}else{
			System.out.println("Nao Logou");
		}
		
		if(quartoDao.consultaReservaAberta(quarto).isEmpty()){
			System.out.println("disponivel");
		}else{
			System.out.println("reservado");
		}
		
		
		for(Quarto q : quartoDao.listaQuartosReservados()){
			System.out.println(q.getNumero());
		}
		
		
		
		List<Reserva> r = reservaDao.buscarReservaAbertaCliente(cliente);
		
		for(Reserva res : r){
			System.out.println(res.getDataEntrada().getTime());
		}
		
		long id = 3;
		Reserva res = reservaDao.achar(id);
		
		Calendar c4 = Calendar.getInstance();
		c4.set(Calendar.YEAR, 2014);
		c4.set(Calendar.MONTH, Calendar.SEPTEMBER);
		c4.set(Calendar.DAY_OF_MONTH,5);
		
		//reservaBo.fecharReserva(res, c4, FormaPagamento.DINHEIRO);
		
	}

}
