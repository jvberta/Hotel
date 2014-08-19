package com.hotelcalifornia.view.funcionario;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import com.hotelcalifornia.controller.cliente.ReservaClienteControl;
import com.hotelcalifornia.controller.funcionario.ReservaFuncControl;
import com.hotelcalifornia.model.objects.Cliente;
import com.hotelcalifornia.model.objects.Quarto;
import com.hotelcalifornia.model.objects.TipoQuarto;
import com.hotelcalifornia.view.TableQuarto;

public class TelaReservaQuarto extends JFrame {

	private JPanel contentPane;
	private JTable tabela;
	private JScrollPane barraRolagem;
	private TableQuarto tableQuarto;
	private ReservaFuncControl resCon = new ReservaFuncControl();
	private List<Quarto> quartos;
	private Cliente cliente;
	private JPanel panel;
	private JLabel lblSelecioneUm;
	private JLabel lblPesquisarQuartos;
	private JTextField valorText;
	
	private static final String SINGLE = "Single";
	private static final String DOUBLE = "Double";
	private static final String FLAT = "Flat";
	private static final String PRESIDENCIAL = "Presidencial";
	private JButton btnReservar;
	private JLabel lblPesquisarCliente;
	private JLabel lblNewLabel;
	private JTextField cpfText;
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaReservaQuarto frame = new TelaReservaQuarto();
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
	public TelaReservaQuarto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 843, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
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
		lblCliente.setBounds(6, 51, 76, 28);
		panel.add(lblCliente);
		
		
		
		lblSelecioneUm = new JLabel("* Selecione um quarto, informe a data e clique em reservar");
		lblSelecioneUm.setBounds(10, 144, 302, 14);
		panel.add(lblSelecioneUm);
		
		lblPesquisarQuartos = new JLabel("Pesquisar Quartos.:");
		lblPesquisarQuartos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPesquisarQuartos.setBounds(16, 90, 146, 14);
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
		
		btnReservar = new JButton("Reservar");
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				Calendar c = Calendar.getInstance();
				
				if(cliente == null){
					JOptionPane.showMessageDialog(contentPane, "Selecione Um Cliente!","Erro!",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
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
						
						
						if(resCon.reservaQuarto(cliente, quarto, c)){
							JOptionPane.showMessageDialog(contentPane, "Reserva Efetuada Com sucesso");
							dispose();
						}else{
							JOptionPane.showMessageDialog(contentPane, "Não Foi possivel efetuar a reservas");
						}
						
					}
					
				}
				
			}
		});
		btnReservar.setBounds(322, 140, 89, 23);
		panel.add(btnReservar);
		
		lblPesquisarCliente = new JLabel("Pesquisar cliente:");
		lblPesquisarCliente.setBounds(10, 11, 99, 14);
		panel.add(lblPesquisarCliente);
		
		lblNewLabel = new JLabel("Cpf");
		lblNewLabel.setBounds(96, 28, 46, 14);
		panel.add(lblNewLabel);
		
		cpfText = new JTextField();
		cpfText.setBounds(129, 25, 126, 20);
		panel.add(cpfText);
		cpfText.setColumns(10);
		
		JLabel DadosClienteLabel = new JLabel("Nenhum cliente Selecionado");
		DadosClienteLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		DadosClienteLabel.setBounds(92, 51, 433, 28);
		panel.add(DadosClienteLabel);
		
		JButton pesquisarClienteBtn = new JButton("Pesquisar");
		pesquisarClienteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cpfText.getText().isEmpty()){
					JOptionPane.showMessageDialog(contentPane, "Digite um cpf!","Erro!",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if(cpfText.getText().length() != 11){
					JOptionPane.showMessageDialog(contentPane, "Digite o cpf com 11 Posicoes","Erro!",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				cliente = resCon.pesquisaCliente(cpfText.getText());
				
				if(cliente==null){
					JOptionPane.showMessageDialog(contentPane, "Cliente Não Encontrado!","Erro!",JOptionPane.ERROR_MESSAGE);
					return;
				}else{
					DadosClienteLabel.setText(cliente.getNome()+" Cpf: "+cliente.getCpf());
				}
				
				
			}
		});
		pesquisarClienteBtn.setBounds(265, 24, 89, 23);
		panel.add(pesquisarClienteBtn);
		
		
		
	}
}
