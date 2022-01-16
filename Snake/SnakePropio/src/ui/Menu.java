package ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import models.Game;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu{

	private JLabel lblTittle;
	private JButton btnFacil;
	private JButton btnIntermedio;
	private JButton btnDificil;
	private JButton btnImposible;

	private JFrame frmMenu;

	/**
	 * Create the application.
	 */
	public Menu() {
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

		btnFacil = new JButton("Facil");
		btnFacil.setBounds(235, 96, 123, 51);
		frmMenu.getContentPane().add(btnFacil);

		btnIntermedio = new JButton("Intermedio");
		btnIntermedio.setBounds(235, 157, 123, 51);
		frmMenu.getContentPane().add(btnIntermedio);

		btnDificil = new JButton("Dificil");
		btnDificil.setBounds(235, 218, 123, 51);
		frmMenu.getContentPane().add(btnDificil);

		btnImposible = new JButton("Imposible");
		btnImposible.setBounds(235, 279, 123, 51);
		frmMenu.getContentPane().add(btnImposible);
	}
	
	private void configureListener() {
		
		//elige facil
		btnFacil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMenu.setVisible(false);
				try {
				Game juego = new Game();
				juego.setDificultad(1);		
				juego.iniciar();
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		//elige intermedio
		btnIntermedio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMenu.setVisible(false);
				try {
					Game juego = new Game();
					juego.setDificultad(2);		
					juego.iniciar();
					}catch (Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		
		//elige dificil
		btnDificil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMenu.setVisible(false);
				try {
					Game juego = new Game();
					juego.setDificultad(3);		
					juego.iniciar();
					}catch (Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		
		//elige imposible
		btnImposible.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMenu.setVisible(false);
				try {
					Game juego = new Game();
					juego.setDificultad(4);		
					juego.iniciar();
					}catch (Exception e1) {
						e1.printStackTrace();
					}

			}
		});
	}
}
