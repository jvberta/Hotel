package com.hotelcalifornia.view.funcionario;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Calendar;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.hotelcalifornia.controller.funcionario.FecharReservaControl;
import com.hotelcalifornia.model.objects.Cliente;
import com.hotelcalifornia.model.objects.FormaPagamento;
import com.hotelcalifornia.model.objects.Quarto;
import com.hotelcalifornia.model.objects.Reserva;
import com.hotelcalifornia.view.ReservaTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaFecharReserva extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField cpfText;
	private JTextField numQuartoText;
	private ReservaTable reservaTable;
	private List<Reserva> reservas;
	private FecharReservaControl fecResCon;
	
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFecharReserva frame = new TelaFecharReserva();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public TelaFecharReserva() {
		
		fecResCon = new FecharReservaControl();
		reservas = fecResCon.listarReservasAbertas();
		
		reservaTable = new ReservaTable(reservas);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 855, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 113, 766, 229);
		contentPane.add(scrollPane);
		
		table = new JTable(reservaTable);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2){
					JTable target = (JTable) e.getSource();
					int row = target.getSelectedRow();
					
					Reserva res = reservaTable.getReserva(row);
					res.setDataSaida(Calendar.getInstance());
					
					int dialogResult = JOptionPane.showConfirmDialog(contentPane, "Deseja realmente encerrar a reservar?\n"
																	+"Qtd Diarias: "+res.calculaQtdDiarias()+"\n"
																	+"Valor Diaria: "+res.getPrecoCobranca()+"\n"
																	+"Total: "+res.calculaTotal());
					
					if(dialogResult == JOptionPane.YES_OPTION){
						int dialogResult2 = JOptionPane.showConfirmDialog(contentPane, "Valor foi Pago?");
						if(dialogResult2 == JOptionPane.YES_OPTION){
							if(fecResCon.fecharReserva(res, FormaPagamento.DINHEIRO)){
								JOptionPane.showMessageDialog(contentPane, "Reserva fechada com sucesso!");
								dispose();
							}
						}
					}
					
					
					
				}
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblPesquisarReservas = new JLabel("Pesquisar Reservas");
		lblPesquisarReservas.setBounds(32, 11, 103, 14);
		contentPane.add(lblPesquisarReservas);
		
		JLabel lblCpfCliente = new JLabel("Cpf cliente");
		lblCpfCliente.setBounds(73, 36, 62, 14);
		contentPane.add(lblCpfCliente);
		
		cpfText = new JTextField();
		cpfText.setBounds(144, 33, 103, 20);
		contentPane.add(cpfText);
		cpfText.setColumns(10);
		
		JLabel lblNumeroQuarto = new JLabel("Numero quarto");
		lblNumeroQuarto.setBounds(73, 68, 79, 14);
		contentPane.add(lblNumeroQuarto);
		
		numQuartoText = new JTextField();
		numQuartoText.setBounds(154, 65, 93, 20);
		contentPane.add(numQuartoText);
		numQuartoText.setColumns(10);
		
		JButton pesqClienteBtn = new JButton("Pesquisar");
		pesqClienteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = cpfText.getText();
				
				if(cpf.length() != 11){
					JOptionPane.showMessageDialog(contentPane, "Digite o cpf com 11 digitos!","Erro",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				Cliente cliente = fecResCon.pesqCliente(cpf);
				
				if(cliente == null){
					JOptionPane.showMessageDialog(contentPane, "Cliente nao localizado");
					return;
				}
					
				
				
				List<Reserva> res = fecResCon.pesqReservasPorCliente(cliente);
				
				if(!res.isEmpty()){
					reservas = res;
					reservaTable.limpar();
					reservaTable.addListaReserva(reservas);
				}else{
					JOptionPane.showMessageDialog(contentPane, "Nenhuma reserva encontrada");
				}
				
				
			}
		});
		pesqClienteBtn.setBounds(257, 32, 89, 23);
		contentPane.add(pesqClienteBtn);
		
		JButton pesqQuartoBtn = new JButton("Pesquisar");
		pesqQuartoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int numero = 0;
				try {
					numero = Integer.parseInt(numQuartoText.getText());
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(contentPane, "Digite apenas numeros","Erro!",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				Quarto quarto = fecResCon.pesqQuarto(numero);
				
				if(quarto == null){
					JOptionPane.showMessageDialog(contentPane, "Quarto nao localizado");
					return;
				}
				
				List<Reserva> res = fecResCon.pesqReservasporQuarto(quarto);
				
				if(!res.isEmpty()){
					reservas = res;
					reservaTable.limpar();
					reservaTable.addListaReserva(reservas);
				}else{
					JOptionPane.showMessageDialog(contentPane, "Nenhuma reservas localizada");
				}
				
			}
			
			
		});
		pesqQuartoBtn.setBounds(257, 64, 89, 23);
		contentPane.add(pesqQuartoBtn);
		
		JButton btnListarTodos = new JButton("Listar Todos");
		btnListarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reservas = fecResCon.listarReservasAbertas();
				reservaTable.limpar();
				reservaTable.addListaReserva(reservas);
			}
		});
		btnListarTodos.setBounds(695, 83, 103, 23);
		contentPane.add(btnListarTodos);
	}
}
