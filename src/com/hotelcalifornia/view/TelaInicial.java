package com.hotelcalifornia.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class TelaInicial {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial window = new TelaInicial();
					window.frame.setVisible(true);
					TelaLogin login = new TelaLogin();
					
					login.setVisible(true);
					login.setLocationRelativeTo(window.frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaInicial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 777, 566);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
