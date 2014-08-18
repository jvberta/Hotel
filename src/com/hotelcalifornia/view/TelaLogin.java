package com.hotelcalifornia.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.hotelcalifornia.controller.LoginControl;
import com.hotelcalifornia.view.cliente.PainelCliente;
import com.hotelcalifornia.view.funcionario.PainelFuncionario;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.security.acl.Group;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField cpfText;
	private JPasswordField senhaText;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setTitle("Login");
		setAlwaysOnTop(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 338, 266);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCpf = new JLabel("Cpf.:");
		lblCpf.setBounds(61, 60, 25, 14);
		contentPane.add(lblCpf);
		
		cpfText = new JTextField();
		cpfText.setBounds(109, 57, 166, 20);
		cpfText.setColumns(20);
		contentPane.add(cpfText);
		
		
		JLabel lblSenha = new JLabel("Senha.:");
		lblSenha.setBounds(61, 95, 38, 14);
		contentPane.add(lblSenha);
		
		senhaText = new JPasswordField();
		senhaText.setBounds(109, 88, 166, 20);
		senhaText.setColumns(20);
		contentPane.add(senhaText);
		
		JRadioButton rdbtnCliente = new JRadioButton("Cliente");
		rdbtnCliente.setSelected(true);
		rdbtnCliente.setMnemonic('c');
		rdbtnCliente.setVerticalAlignment(SwingConstants.TOP);
		rdbtnCliente.setBounds(109, 115, 70, 23);
		contentPane.add(rdbtnCliente);
		
		JRadioButton rdBtnFuncionario = new JRadioButton("Funcionario");
		rdBtnFuncionario.setMnemonic('f');
		rdBtnFuncionario.setVerticalAlignment(SwingConstants.TOP);
		rdBtnFuncionario.setBounds(194, 115, 99, 23);
		contentPane.add(rdBtnFuncionario);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdBtnFuncionario);
		group.add(rdbtnCliente);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String senha = "";
				String cpf = cpfText.getText();
				for(char c : senhaText.getPassword()){
					senha+=c;
				}
				
				if(cpf.isEmpty() || senha.isEmpty()){
					JOptionPane.showMessageDialog(contentPane, "Preencha os campos","Erro!",JOptionPane.ERROR_MESSAGE);
				}else{
					if(cpf.length() != 11){
						JOptionPane.showMessageDialog(contentPane, "O cpf possui 11 digitos!","Erro!",JOptionPane.ERROR_MESSAGE);
					}else{
						LoginControl login = new LoginControl();
						if(rdbtnCliente.isSelected()){
							if(login.loginCliente(cpf, senha)){
								JOptionPane.showMessageDialog(contentPane, "Logado com sucesso!");
								PainelCliente painel = new PainelCliente();
								painel.setVisible(true);
								dispose();
							}else{
								JOptionPane.showMessageDialog(contentPane, "Cpf ou senha Invalidos","Erro!",JOptionPane.ERROR_MESSAGE);
							}
						}else{
							if(login.loginFuncionario(cpf, senha)){
								JOptionPane.showMessageDialog(contentPane, "Logado com sucesso!");
								PainelFuncionario painel = new PainelFuncionario();
								painel.setVisible(true);
								dispose();
							}else{
								JOptionPane.showMessageDialog(contentPane, "Cpf ou senha Invalidos","Erro!",JOptionPane.ERROR_MESSAGE);
							}
						}
						
					}
						
				}
					
			}
		});
		loginBtn.setBounds(109, 145, 70, 23);
		contentPane.add(loginBtn);
		
		JButton cadastraBtn = new JButton("Cadastro de Clientes");
		cadastraBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroCliente cadCliente = new TelaCadastroCliente();
				cadCliente.setVisible(true);
				dispose();
			}
		});
		cadastraBtn.setBounds(186, 145, 136, 23);
		contentPane.add(cadastraBtn);
		
		
	}
}
