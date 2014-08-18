package com.hotelcalifornia.view.funcionario;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.hotelcalifornia.controller.CadastroClienteControl;
import com.hotelcalifornia.controller.funcionario.CadastroFuncionarioControl;
import com.hotelcalifornia.model.objects.Cliente;
import com.hotelcalifornia.model.objects.Endereco;
import com.hotelcalifornia.model.objects.Funcionario;
import com.hotelcalifornia.view.TelaCadastroCliente;
import com.hotelcalifornia.view.TelaLogin;

public class CadastroFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField nomeText;
	private JTextField cpfText;
	private JTextField emailText;
	private JTextField rgText;
	
	private JPasswordField senhaText;
	private JTextField diaNascText;
	private JTextField mesNascText;
	private JTextField anoNascText;
	private JTextField tipoEndText;
	private JTextField logEndText;
	private JTextField numEndText;
	private JTextField bairroEndText;
	private JTextField cidEndText;
	private JTextField cepEndText;
	private JTextField ufEndText;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente frame = new TelaCadastroCliente();
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
	public CadastroFuncionario() {
		setTitle("Cadastro Funcionario");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 669, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro Cliente");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(71, 24, 167, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome.:");
		lblNome.setBounds(71, 92, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("Cpf.:");
		lblCpf.setBounds(71, 115, 46, 14);
		contentPane.add(lblCpf);
		
		JLabel lblRg = new JLabel("Rg.:");
		lblRg.setBounds(71, 140, 46, 14);
		contentPane.add(lblRg);
		
		JLabel lblDataNasc = new JLabel("Data Nasc.:");
		lblDataNasc.setBounds(262, 140, 75, 14);
		contentPane.add(lblDataNasc);
		
		JLabel lblEmail = new JLabel("Email.:");
		lblEmail.setBounds(262, 115, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblSenha = new JLabel("Senha.:");
		lblSenha.setBounds(71, 165, 46, 14);
		contentPane.add(lblSenha);
		
		JLabel lblEndereco = new JLabel("Endereco:");
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEndereco.setBounds(71, 206, 100, 14);
		contentPane.add(lblEndereco);
		
		JLabel lblTipo = new JLabel("Tipo.:");
		lblTipo.setBounds(71, 231, 37, 14);
		contentPane.add(lblTipo);
		
		JLabel lblLogradouro = new JLabel("Logradouro.:");
		lblLogradouro.setBounds(207, 231, 80, 14);
		contentPane.add(lblLogradouro);
		
		JLabel lblNum = new JLabel("Num.:");
		lblNum.setBounds(71, 256, 46, 14);
		contentPane.add(lblNum);
		
		JLabel lblBairro = new JLabel("Bairro.:");
		lblBairro.setBounds(170, 256, 46, 14);
		contentPane.add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade.:");
		lblCidade.setBounds(375, 256, 46, 14);
		contentPane.add(lblCidade);
		
		JLabel lblUf = new JLabel("UF.:");
		lblUf.setBounds(217, 281, 46, 14);
		contentPane.add(lblUf);
		
		JLabel lblCep = new JLabel("CEP.:");
		lblCep.setBounds(71, 281, 46, 14);
		contentPane.add(lblCep);
		
		nomeText = new JTextField();
		nomeText.setBounds(114, 89, 461, 20);
		contentPane.add(nomeText);
		nomeText.setColumns(10);
		
		cpfText = new JTextField();
		cpfText.setBounds(114, 112, 138, 20);
		contentPane.add(cpfText);
		cpfText.setColumns(10);
		
		emailText = new JTextField();
		emailText.setBounds(299, 112, 276, 20);
		contentPane.add(emailText);
		emailText.setColumns(10);
		
		rgText = new JTextField();
		rgText.setBounds(114, 137, 138, 20);
		contentPane.add(rgText);
		rgText.setColumns(10);
		
			
		senhaText = new JPasswordField();
		senhaText.setBounds(114, 162, 138, 20);
		contentPane.add(senhaText);
		
		diaNascText = new JTextField();
		diaNascText.setBounds(331, 137, 27, 20);
		contentPane.add(diaNascText);
		diaNascText.setColumns(10);
		
		mesNascText = new JTextField();
		mesNascText.setBounds(368, 137, 27, 20);
		contentPane.add(mesNascText);
		mesNascText.setColumns(10);
		
		anoNascText = new JTextField();
		anoNascText.setBounds(405, 137, 46, 20);
		contentPane.add(anoNascText);
		anoNascText.setColumns(10);
		
		tipoEndText = new JTextField();
		tipoEndText.setBounds(111, 228, 86, 20);
		contentPane.add(tipoEndText);
		tipoEndText.setColumns(10);
		
		logEndText = new JTextField();
		logEndText.setBounds(272, 228, 354, 20);
		contentPane.add(logEndText);
		logEndText.setColumns(10);
		
		numEndText = new JTextField();
		numEndText.setBounds(114, 256, 46, 20);
		contentPane.add(numEndText);
		numEndText.setColumns(10);
		
		bairroEndText = new JTextField();
		bairroEndText.setBounds(207, 253, 158, 20);
		contentPane.add(bairroEndText);
		bairroEndText.setColumns(10);
		
		cidEndText = new JTextField();
		cidEndText.setBounds(431, 253, 195, 20);
		contentPane.add(cidEndText);
		cidEndText.setColumns(10);
		
		cepEndText = new JTextField();
		cepEndText.setBounds(110, 281, 86, 20);
		contentPane.add(cepEndText);
		cepEndText.setColumns(10);
		
		ufEndText = new JTextField();
		ufEndText.setBounds(243, 278, 37, 20);
		contentPane.add(ufEndText);
		ufEndText.setColumns(10);
		
		JButton cadastrarBtn = new JButton("Cadastrar");
		cadastrarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = nomeText.getText();
				String cpf = cpfText.getText();
				String rg = rgText.getText();
				String email = emailText.getText();
				String senha = "";
				for(char c : senhaText.getPassword()){
					senha += c;
				}
				Calendar dt_nasc = Calendar.getInstance();
				dt_nasc.set(Calendar.YEAR, Integer.parseInt(anoNascText.getText()));
				dt_nasc.set(Calendar.MONTH, Integer.parseInt(mesNascText.getText())-1);
				dt_nasc.set(Calendar.DAY_OF_MONTH, Integer.parseInt(diaNascText.getText()));
				
				Funcionario func =  new Funcionario(nome,cpf,rg,email,dt_nasc,null,senha);
				
				String tipo = tipoEndText.getText();
				String log = logEndText.getText();
				String num = numEndText.getText();
				String bairro = bairroEndText.getText();
				String cid = cidEndText.getText();
				String uf = ufEndText.getText();
				String cep = cepEndText.getText();
				
				func.setEndereco(new Endereco(tipo, log, num, bairro, cid, uf, cep,func));
				
				CadastroFuncionarioControl cadastro = new CadastroFuncionarioControl();
				
				if(cadastro.cadastrarFuncionario(func)){
					JOptionPane.showMessageDialog(contentPane, "Cadastrado com sucesso");
					dispose();
				}else{
					JOptionPane.showMessageDialog(contentPane, "Não foi possiovel efetuar o cadastro!","Erro",JOptionPane.ERROR_MESSAGE);
				}
					
				
				
			}
		});
		cadastrarBtn.setBounds(111, 312, 89, 23);
		contentPane.add(cadastrarBtn);
		
		JButton voltarBtn = new JButton("Voltar");
		voltarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		voltarBtn.setBounds(227, 312, 89, 23);
		contentPane.add(voltarBtn);
	}

}
