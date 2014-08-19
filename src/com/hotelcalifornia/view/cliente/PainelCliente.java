package com.hotelcalifornia.view.cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;

import javax.swing.Action;

import com.hotelcalifornia.controller.cliente.PainelClienteControl;
import com.hotelcalifornia.model.objects.Cliente;
import com.hotelcalifornia.view.TelaLogin;
import com.hotelcalifornia.view.funcionario.PainelFuncionario;

import java.awt.event.ActionListener;

public class PainelCliente extends JFrame {

	private JPanel contentPane;
	
	private PainelClienteControl painelControl = new PainelClienteControl();
	
	private Cliente cliente;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PainelCliente frame = new PainelCliente();
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
	public PainelCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 966, 590);
		
			
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPerfil = new JMenu("Perfil");
		menuBar.add(mnPerfil);
		
		JMenuItem mntmAlterarPerfil = new JMenuItem("Alterar Perfil");
		mntmAlterarPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AlterarPerfilCliente altPerfil = new AlterarPerfilCliente();
				
				altPerfil.setVisible(true);
				altPerfil.setLocationRelativeTo(contentPane);
			}
		});
		mnPerfil.add(mntmAlterarPerfil);
		
		JMenuItem mntmLogoff = new JMenuItem("Logoff");
		mntmLogoff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin telaLogin = new TelaLogin();
				telaLogin.setVisible(true);
				dispose();
			}
		});
		mnPerfil.add(mntmLogoff);
		
		JMenu mnReservas = new JMenu("Reservas");
		menuBar.add(mnReservas);
		
		JMenuItem mntmReservarQuarto = new JMenuItem("Reservar Quarto");
		mntmReservarQuarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaReservaCliente tReserva = new TelaReservaCliente();
				tReserva.setVisible(true);
				tReserva.setLocationRelativeTo(contentPane);
			}
		});
		mnReservas.add(mntmReservarQuarto);
		
		JMenuItem mntmConsultarReservas = new JMenuItem("Consultar Reservas ");
		mntmConsultarReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaConsultaReservasCliente tReservas = new TelaConsultaReservasCliente();
				tReservas.setVisible(true);
				tReservas.setLocationRelativeTo(contentPane);
			}
		});
		mnReservas.add(mntmConsultarReservas);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		cliente = painelControl.clienteLogado();
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PainelFuncionario.class.getResource("/image/logo.jpg")));
		lblNewLabel.setBounds(10, 0, 940, 531);
		contentPane.add(lblNewLabel);
		
		
	}

	
	
}
