package com.hotelcalifornia.view.cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Calendar;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import org.hibernate.mapping.Table;

import com.hotelcalifornia.controller.cliente.ReservaClienteControl;
import com.hotelcalifornia.model.objects.Cliente;
import com.hotelcalifornia.model.objects.Quarto;
import com.hotelcalifornia.model.objects.TipoQuarto;
import com.hotelcalifornia.view.TableQuarto;

import java.awt.FlowLayout;

import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaReservaCliente extends JFrame {

	private JPanel contentPane;
	private JTable tabela;
	private JScrollPane barraRolagem;
	private TableQuarto tableQuarto;
	private ReservaClienteControl resCon = new ReservaClienteControl();
	private List<Quarto> quartos;
	private Cliente clienteLogado;
	private JPanel panel;
	private JLabel lblSelecioneUm;
	private JLabel lblPesquisarQuartos;
	private JTextField valorText;
	
	private static final String SINGLE = "Single";
	private static final String DOUBLE = "Double";
	private static final String FLAT = "Flat";
	private static final String PRESIDENCIAL = "Presidencial";
	private JTextField diaTxt;
	private JLabel lblData;
	private JTextField mesTxt;
	private JTextField anoTxt;
	private JButton btnReservar;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaReservaCliente frame = new TelaReservaCliente();
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
	public TelaReservaCliente() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 835, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		quartos = resCon.quartosDisponiveis(null, 0.0);
		tableQuarto = new TableQuarto(quartos);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 814, 444);
		
		contentPane.add(panel);
		panel.setLayout(null);
		tabela = new JTable(tableQuarto);
		
		
		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(10, 169, 794, 275);
		barraRolagem.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(barraRolagem);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCliente.setBounds(10, 30, 76, 28);
		panel.add(lblCliente);
		
		JLabel labelDadosCliente = new JLabel("");
		labelDadosCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelDadosCliente.setBounds(91, 30, 467, 25);
		panel.add(labelDadosCliente);
		
		clienteLogado = resCon.clienteLogado();
		labelDadosCliente.setText(clienteLogado.getNome()+" Cpf.: "+clienteLogado.getCpf());
		
		lblSelecioneUm = new JLabel("* Selecione um quarto, informe a data e clique em reservar");
		lblSelecioneUm.setBounds(10, 144, 302, 14);
		panel.add(lblSelecioneUm);
		
		lblPesquisarQuartos = new JLabel("Pesquisar Quartos.:");
		lblPesquisarQuartos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPesquisarQuartos.setBounds(10, 79, 146, 14);
		panel.add(lblPesquisarQuartos);
		
		JComboBox tipoQuartoSel = new JComboBox();
		tipoQuartoSel.setBounds(91, 104, 65, 20);
		panel.add(tipoQuartoSel);
		tipoQuartoSel.addItem("");
		tipoQuartoSel.addItem(SINGLE);
		tipoQuartoSel.addItem(DOUBLE);
		tipoQuartoSel.addItem(FLAT);
		tipoQuartoSel.addItem(PRESIDENCIAL);
		
		JLabel lblTipoQuarto = new JLabel("Tipo Quarto.:");
		lblTipoQuarto.setBounds(20, 104, 91, 14);
		panel.add(lblTipoQuarto);
		
		JLabel lblValorMaximo = new JLabel("Valor Maximo.:");
		lblValorMaximo.setBounds(174, 107, 81, 14);
		panel.add(lblValorMaximo);
		
		valorText = new JTextField();
		valorText.setBounds(250, 104, 86, 20);
		panel.add(valorText);
		valorText.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double preco = 0.0;
				String precoSt = valorText.getText();
				if(!precoSt.isEmpty()){
					
					try {
						preco = Double.parseDouble(precoSt);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(contentPane, "Digite Apenas Numeros","Erro!",JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					
				}
				
				TipoQuarto tq = null; 
				String tipoSel = tipoQuartoSel.getSelectedItem().toString();
				
				if(tipoSel.equals(SINGLE)){
					tq = TipoQuarto.SINGLE;
				}else if(tipoSel.equals(DOUBLE)){
					tq = TipoQuarto.DOUBLE;
				}else if(tipoSel.equals(FLAT)){
					tq = TipoQuarto.FLAT;
				}else if(tipoSel.equals(PRESIDENCIAL)){
					tq = TipoQuarto.PRESIDENCIAL;
				}
							
				quartos = resCon.quartosDisponiveis(tq, preco);
				tableQuarto.limpar();
				tableQuarto.addListaDeQuartos(quartos);
				
				
			}
		});
		btnPesquisar.setBounds(356, 103, 89, 23);
		panel.add(btnPesquisar);
		
		diaTxt = new JTextField();
		diaTxt.setBounds(366, 141, 37, 20);
		panel.add(diaTxt);
		diaTxt.setColumns(10);
		
		lblData = new JLabel("Data:");
		lblData.setBounds(338, 144, 37, 14);
		panel.add(lblData);
		
		mesTxt = new JTextField();
		mesTxt.setBounds(413, 141, 37, 20);
		panel.add(mesTxt);
		mesTxt.setColumns(10);
		
		anoTxt = new JTextField();
		anoTxt.setBounds(460, 141, 65, 20);
		panel.add(anoTxt);
		anoTxt.setColumns(10);
		
		btnReservar = new JButton("Reservar");
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(diaTxt.getText().isEmpty()||mesTxt.getText().isEmpty()||anoTxt.getText().isEmpty()){
					JOptionPane.showMessageDialog(contentPane, "Digite uma data","Erro!",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				String dia = diaTxt.getText();
				String mes = mesTxt.getText();
				String ano = anoTxt.getText();
				
				Calendar c = Calendar.getInstance();
				c.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dia));
				c.set(Calendar.MONTH, Integer.parseInt(mes)-1);
				c.set(Calendar.YEAR, Integer.parseInt(ano));
				
				if(tabela.getSelectedRow() == -1){
					JOptionPane.showMessageDialog(contentPane, "Selecione Um Quarto!","Erro!",JOptionPane.ERROR_MESSAGE);
					return;
				}else{
					int row = tabela.getSelectedRow();
					Quarto quarto = tableQuarto.getQuarto(row);
					
					int dialogResult = JOptionPane.showConfirmDialog(contentPane, "Confirma a reserva?\n"+
																			"Quarto: " + quarto.getNumero()+
																			"Valor: " + quarto.getValorDiaria());
					
					if(dialogResult == JOptionPane.YES_OPTION){
						if(resCon.reservaQuarto(clienteLogado, quarto, c)){
							JOptionPane.showMessageDialog(contentPane, "Reserva Efetuada Com sucesso");
							dispose();
						}else{
							JOptionPane.showMessageDialog(contentPane, "Não Foi possivel efetuar a reservas");
						}
						
					}
					
				}
				
			}
		});
		btnReservar.setBounds(544, 140, 89, 23);
		panel.add(btnReservar);
		
		
		
	}
}
