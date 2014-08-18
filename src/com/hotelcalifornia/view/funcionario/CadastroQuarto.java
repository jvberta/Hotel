package com.hotelcalifornia.view.funcionario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import com.hotelcalifornia.controller.funcionario.CadastroQuartoControl;
import com.hotelcalifornia.model.objects.Quarto;
import com.hotelcalifornia.model.objects.TipoQuarto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroQuarto extends JFrame {

	private JPanel contentPane;
	private JTextField numQuartoTxt;
	private JTextField precoDiariaTxt;
	private CadastroQuartoControl cadControl;
	private static final String SINGLE = "Single";
	private static final String DOUBLE = "Double";
	private static final String FLAT = "Flat";
	private static final String PRESIDENCIAL = "Presidencial";

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroQuarto frame = new CadastroQuarto();
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
	public CadastroQuarto() {
		cadControl = new CadastroQuartoControl();
		
		setTitle("Cadastro Quarto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 356, 289);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNumeroQuarto = new JLabel("Numero Quarto");
		lblNumeroQuarto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNumeroQuarto.setBounds(32, 44, 111, 32);
		contentPane.add(lblNumeroQuarto);
		
		numQuartoTxt = new JTextField();
		numQuartoTxt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		numQuartoTxt.setBounds(153, 48, 86, 26);
		contentPane.add(numQuartoTxt);
		numQuartoTxt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Pre\u00E7o Diaria");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(32, 93, 95, 26);
		contentPane.add(lblNewLabel);
		
		precoDiariaTxt = new JTextField();
		precoDiariaTxt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		precoDiariaTxt.setBounds(153, 94, 86, 26);
		contentPane.add(precoDiariaTxt);
		precoDiariaTxt.setColumns(10);
		
		JLabel lblTipoQuarto = new JLabel("Tipo Quarto");
		lblTipoQuarto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTipoQuarto.setBounds(32, 130, 95, 26);
		contentPane.add(lblTipoQuarto);
		
		JComboBox tipoQuartoSel = new JComboBox();
		tipoQuartoSel.setBounds(153, 131, 86, 20);
		tipoQuartoSel.addItem(SINGLE);
		tipoQuartoSel.addItem(DOUBLE);
		tipoQuartoSel.addItem(FLAT);
		tipoQuartoSel.addItem(PRESIDENCIAL);
		
		contentPane.add(tipoQuartoSel);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int num;
				double preco;
				TipoQuarto tq = null;
				try {
					num = Integer.parseInt(numQuartoTxt.getText());
					preco = Double.parseDouble(precoDiariaTxt.getText());
										
				} catch (Exception e) {
					JOptionPane.showMessageDialog(contentPane, "Digite apenas numeros!","Erro!",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
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
				
				if(cadControl.cadastraQuarto(new Quarto(num, tq, preco))){
					JOptionPane.showMessageDialog(contentPane, "Quarto cadastrado com sucesso!");
					dispose();
				}else{
					JOptionPane.showMessageDialog(contentPane, "Não foi possivel cadastrar o quarto!","Erro!",JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		btnSalvar.setBounds(150, 177, 89, 23);
		contentPane.add(btnSalvar);
	}
}
