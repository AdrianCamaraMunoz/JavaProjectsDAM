package ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import models.Game;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuTamanyo {

	private JLabel lblTittle;
	private JButton btnPequeño;
	private JButton btnMediano;
	private JButton btnGrande;

	private JFrame frmMenu;
	private Game juego;

	/**
	 * Create the application.
	 * 
	 * @param juego
	 */
	public MenuTamanyo(Game juego) {
		this.juego = juego;
		initialize();
		this.frmMenu.setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		configureUIComponents();
		configureListener();
	}

	private void configureUIComponents() {
		frmMenu = new JFrame();
		frmMenu.setBounds(100, 100, 600, 400);
		frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenu.getContentPane().setLayout(null);

		lblTittle = new JLabel("SNAKE");
		lblTittle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTittle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTittle.setBounds(176, 10, 240, 72);
		frmMenu.getContentPane().add(lblTittle);

		btnPequeño = new JButton("Peque\u00F1o");
		btnPequeño.setBounds(235, 96, 123, 51);
		frmMenu.getContentPane().add(btnPequeño);

		btnMediano = new JButton("Mediano");
		btnMediano.setBounds(235, 157, 123, 51);
		frmMenu.getContentPane().add(btnMediano);

		btnGrande = new JButton("Grande");
		btnGrande.setBounds(235, 218, 123, 51);
		frmMenu.getContentPane().add(btnGrande);
	}

	private void configureListener() {

		// elige pequeño
		btnPequeño.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMenu.setVisible(false);
				try {
					juego.setTamanyo(1);
					System.out.println("ha llegado");
					juego.start();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		// elige mediano
		btnMediano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMenu.setVisible(false);
				try {
					juego.setTamanyo(2);
					juego.start();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		// elige grande
		btnGrande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMenu.setVisible(false);
				try {
					juego.setTamanyo(3);
					juego.start();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}
