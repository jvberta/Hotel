package com.hotelcalifornia.view.cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.hotelcalifornia.controller.cliente.ConsultaReservasControl;
import com.hotelcalifornia.model.objects.Cliente;
import com.hotelcalifornia.model.objects.Reserva;
import com.hotelcalifornia.view.ReservaTable;
import javax.swing.JLabel;
import java.awt.Font;

public class TelaConsultaReservasCliente extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ReservaTable rTable;
	private List<Reserva> reservas;
	private Cliente clienteLogado;
	private ConsultaReservasControl rControl;
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaReservasCliente frame = new TelaConsultaReservasCliente();
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
	public TelaConsultaReservasCliente() {
		
		rControl = new ConsultaReservasControl();
		clienteLogado = rControl.clienteLogado();
		reservas =  rControl.listaReservasCliente(clienteLogado);
		rTable = new ReservaTable(reservas);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 809, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 793, 427);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 117, 680, 267);
		panel.add(scrollPane);
		
		table = new JTable(rTable);
		scrollPane.setViewportView(table);
		
		JLabel lblNo = new JLabel("");
		lblNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNo.setBounds(71, 52, 403, 25);
		lblNo.setText(clienteLogado.getNome());
		panel.add(lblNo);
	}
}
