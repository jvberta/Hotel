package com.hotelcalifornia.view.cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.hotelcalifornia.controller.CadastroClienteControl;
import com.hotelcalifornia.controller.cliente.AtualizarClienteControl;
import com.hotelcalifornia.model.objects.Cliente;
import com.hotelcalifornia.model.objects.Endereco;
import com.hotelcalifornia.view.funcionario.PainelFuncionario;

public class AlterarPerfilCliente extends JFrame {
	private AtualizarClienteControl altPerfil = new AtualizarClienteControl();
	private Cliente cliente;
	private JPanel contentPane;
	private JTextField nomeText;
	private JTextField cpfText;
	private JTextField emailText;
	private JTextField rgText;
	private JTextField telText;
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
					AlterarPerfilCliente frame = new AlterarPerfilCliente();
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
	public AlterarPerfilCliente() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		lblDataNasc.setBounds(70, 165, 75, 14);
		contentPane.add(lblDataNasc);
		
		JLabel lblEmail = new JLabel("Email.:");
		lblEmail.setBounds(262, 115, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblTel = new JLabel("Tel.:");
		lblTel.setBounds(262, 140, 46, 14);
		contentPane.add(lblTel);
		
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
		
		this.cliente = altPerfil.clienteLogado();
		
		nomeText = new JTextField();
		nomeText.setBounds(114, 89, 461, 20);
		contentPane.add(nomeText);
		nomeText.setColumns(10);
		nomeText.setText(cliente.getNome());
		
		cpfText = new JTextField();
		cpfText.setEditable(false);
		cpfText.setBounds(114, 112, 138, 20);
		contentPane.add(cpfText);
		cpfText.setColumns(10);
		cpfText.setText(cliente.getCpf());
		
		emailText = new JTextField();
		emailText.setBounds(299, 112, 276, 20);
		contentPane.add(emailText);
		emailText.setColumns(10);
		emailText.setText(cliente.getEmail());
		
		rgText = new JTextField();
		rgText.setBounds(114, 137, 138, 20);
		contentPane.add(rgText);
		rgText.setColumns(10);
		rgText.setText(cliente.getRg());
		
				
		diaNascText = new JTextField();
		diaNascText.setBounds(132, 162, 27, 20);
		contentPane.add(diaNascText);
		diaNascText.setColumns(10);
		diaNascText.setText(Integer.toString(cliente.getData_nasc().get(Calendar.DAY_OF_MONTH)));
		
		mesNascText = new JTextField();
		mesNascText.setBounds(169, 162, 27, 20);
		contentPane.add(mesNascText);
		mesNascText.setColumns(10);
		mesNascText.setText(Integer.toString(cliente.getData_nasc().get(Calendar.MONTH)));
		
		anoNascText = new JTextField();
		anoNascText.setBounds(206, 162, 46, 20);
		contentPane.add(anoNascText);
		anoNascText.setColumns(10);
		anoNascText.setText(Integer.toString(cliente.getData_nasc().get(Calendar.YEAR)));
		
		tipoEndText = new JTextField();
		tipoEndText.setBounds(111, 228, 86, 20);
		contentPane.add(tipoEndText);
		tipoEndText.setColumns(10);
		tipoEndText.setText(cliente.getEndereco().getTipo());
		
		logEndText = new JTextField();
		logEndText.setBounds(272, 228, 354, 20);
		contentPane.add(logEndText);
		logEndText.setColumns(10);
		logEndText.setText(cliente.getEndereco().getLogradouro());
		
		numEndText = new JTextField();
		numEndText.setBounds(114, 256, 46, 20);
		contentPane.add(numEndText);
		numEndText.setColumns(10);
		numEndText.setText(cliente.getEndereco().getNumero());
		
		bairroEndText = new JTextField();
		bairroEndText.setBounds(207, 253, 158, 20);
		contentPane.add(bairroEndText);
		bairroEndText.setColumns(10);
		bairroEndText.setText(cliente.getEndereco().getBairro());
		
		cidEndText = new JTextField();
		cidEndText.setBounds(431, 253, 195, 20);
		contentPane.add(cidEndText);
		cidEndText.setColumns(10);
		cidEndText.setText(cliente.getEndereco().getCidade());
		
		cepEndText = new JTextField();
		cepEndText.setBounds(110, 281, 86, 20);
		contentPane.add(cepEndText);
		cepEndText.setColumns(10);
		cepEndText.setText(cliente.getEndereco().getCep());
		
		ufEndText = new JTextField();
		ufEndText.setBounds(243, 278, 37, 20);
		contentPane.add(ufEndText);
		ufEndText.setColumns(10);
		ufEndText.setText(cliente.getEndereco().getUf());
		
		JButton cadastrarBtn = new JButton("Salvar");
		cadastrarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliente.setNome(nomeText.getText());
				cliente.setRg( rgText.getText());
				cliente.setEmail(emailText.getText());
				Calendar dt_nasc = Calendar.getInstance();
				dt_nasc.set(Calendar.YEAR, Integer.parseInt(anoNascText.getText()));
				dt_nasc.set(Calendar.MONTH, Integer.parseInt(mesNascText.getText()));
				dt_nasc.set(Calendar.DAY_OF_MONTH, Integer.parseInt(diaNascText.getText()));
				cliente.setData_nasc(dt_nasc);
				
				
				cliente.getEndereco().setTipo(tipoEndText.getText());
				cliente.getEndereco().setLogradouro(logEndText.getText());
				cliente.getEndereco().setNumero(numEndText.getText());
				cliente.getEndereco().setBairro(bairroEndText.getText());
				cliente.getEndereco().setCidade(cidEndText.getText());
				cliente.getEndereco().setUf(ufEndText.getText());
				cliente.getEndereco().setCep(cepEndText.getText());
				
				
				
				
				
				if(altPerfil.atualizarCliente(cliente)){
					JOptionPane.showMessageDialog(contentPane, "Alterado com sucesso!");
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
