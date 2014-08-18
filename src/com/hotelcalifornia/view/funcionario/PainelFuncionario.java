package com.hotelcalifornia.view.funcionario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.hotelcalifornia.view.TelaLogin;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PainelFuncionario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PainelFuncionario frame = new PainelFuncionario();
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
	public PainelFuncionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 855, 418);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPerfil = new JMenu("Perfil");
		menuBar.add(mnPerfil);
		
		JMenuItem mntmAlterarPerfil = new JMenuItem("Alterar Perfil");
		mnPerfil.add(mntmAlterarPerfil);
		
		JMenuItem mntmCadstrarFuncionario = new JMenuItem("Cadstrar Funcionario");
		mntmCadstrarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroFuncionario cadastro = new CadastroFuncionario();
				cadastro.setVisible(true);
				cadastro.setLocationRelativeTo(contentPane);
				
			}
		});
		mnPerfil.add(mntmCadstrarFuncionario);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Logoff");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaLogin login = new TelaLogin();
				login.setVisible(true);
				dispose();
			}
		});
		mnPerfil.add(mntmNewMenuItem);
		
		JMenu mnNewMenu = new JMenu("Quarto");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmCadastrarQuarto = new JMenuItem("Cadastrar Quarto");
		mntmCadastrarQuarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroQuarto cadQuarto = new CadastroQuarto();
				cadQuarto.setVisible(true);
				cadQuarto.setLocationRelativeTo(contentPane);
				
			}
		});
		mnNewMenu.add(mntmCadastrarQuarto);
		
		JMenu mnReserva = new JMenu("Reserva");
		menuBar.add(mnReserva);
		
		JMenuItem mntmFazerReserva = new JMenuItem("Fazer Reserva");
		mntmFazerReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaReservaQuarto reserva = new TelaReservaQuarto();
				reserva.setVisible(true);
				reserva.setLocationRelativeTo(contentPane);
			}
		});
		mnReserva.add(mntmFazerReserva);
		
		JMenuItem mntmFecharReserva = new JMenuItem("Fechar Reserva");
		mntmFecharReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaFecharReserva fecharReserva = new TelaFecharReserva();
				fecharReserva.setVisible(true);
				fecharReserva.setLocationRelativeTo(contentPane);
				
			}
		});
		mnReserva.add(mntmFecharReserva);
		
		JMenuItem mntmConsultarReservas = new JMenuItem("Consultar Reservas");
		mnReserva.add(mntmConsultarReservas);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
