package ui;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import models.Usuario;
import utils.Almacen;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class LoginView {
	
	//Propiedades
	private JFrame frmLogin;
	private JTextField tfUser;
	private JButton btnLogin;
	private JButton btnRegister;
	private JLabel lblUser;
	private JLabel lblPasswd;
	private JLabel lblTitulo;
	private JPasswordField pfPassword;
	private JLabel lblErrorMessage;

	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();
		this.frmLogin.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		configureUIComponents();
		configureListener();
	}
	
	/**
	 * configuracion de los distintos elementos de la pantalla
	 */
	private void configureUIComponents() {
		frmLogin = new JFrame();
		frmLogin.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmLogin.setIconImage(Toolkit.getDefaultToolkit().getImage(LoginView.class.getResource("/utils/images/pokeball.png")));
		frmLogin.setBounds(100, 100, 900, 750);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		this.btnLogin = new JButton("");
		btnLogin.setIcon(new ImageIcon(LoginView.class.getResource("/utils/images/LOGIN_BUTTON.png")));	
		btnLogin.setBounds(449, 449, 138, 67);
		btnLogin.setBorderPainted(false); 
        btnLogin.setContentAreaFilled(false); 
        btnLogin.setFocusPainted(false); 
        btnLogin.setOpaque(false);
		frmLogin.getContentPane().add(btnLogin);
		
		btnRegister = new JButton("");
		btnRegister.setIcon(new ImageIcon(LoginView.class.getResource("/utils/images/REGISTER_BUTTON.png")));
		btnRegister.setBackground(Color.WHITE);
		btnRegister.setBounds(286, 449, 138, 67);
		btnRegister.setBorderPainted(false); 
        btnRegister.setContentAreaFilled(false); 
        btnRegister.setFocusPainted(false); 
        btnRegister.setOpaque(false);
		frmLogin.getContentPane().add(btnRegister);
		
		tfUser = new JTextField();
		tfUser.setFont(new Font("Tahoma", Font.BOLD, 15));
		tfUser.setHorizontalAlignment(SwingConstants.CENTER);
		tfUser.setForeground(new Color (56,109,185));
		tfUser.setBackground(Color.WHITE);
		tfUser.setBounds(458, 300, 179, 38);
		frmLogin.getContentPane().add(tfUser);
		tfUser.setColumns(10);
		
		lblUser = new JLabel("User");
		lblUser.setForeground(Color.DARK_GRAY);
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblUser.setBounds(286, 297, 108, 38);
		frmLogin.getContentPane().add(lblUser);
		
		lblPasswd = new JLabel("Password");
		lblPasswd.setForeground(Color.DARK_GRAY);
		lblPasswd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPasswd.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPasswd.setBounds(235, 341, 162, 38);
		frmLogin.getContentPane().add(lblPasswd);
		
		lblTitulo = new JLabel("");
		lblTitulo.setIcon(new ImageIcon(LoginView.class.getResource("/utils/images/LOGIN.png")));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTitulo.setBounds(10, 99, 866, 124);
		frmLogin.getContentPane().add(lblTitulo);
		
		pfPassword = new JPasswordField();
		pfPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		pfPassword.setHorizontalAlignment(SwingConstants.CENTER);
		pfPassword.setForeground(new Color (56,109,185));
		pfPassword.setBackground(Color.WHITE);
		pfPassword.setBounds(458, 348, 179, 38);
		frmLogin.getContentPane().add(pfPassword);
		
		lblErrorMessage = new JLabel("");
		lblErrorMessage.setForeground(Color.RED);
		lblErrorMessage.setBounds(106, 233, 351, 24);
		frmLogin.getContentPane().add(lblErrorMessage);
	}
	
	/**
	 * configuracion de la activacion de los botones
	 */
	private void configureListener() {
		//boton login para acceder a la pokedex
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				checkLogin();
			}
		});
		
		//Enter tras poner user para ir al campo contraseña
		tfUser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					pfPassword.requestFocus();
               }
			}
		});
		
		//Enter tras poner contraseña para acceder a la pokedex
		pfPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					checkLogin();
				}
			}
		});
		
		//vamos a la pagina de registro para crear una cuenta nueva
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogin.setVisible(false);
				new RegisterView(frmLogin);
			}
		});
	}
	
	/**
	 * comprueba si el usuario y la contraseña son correctos
	 */
	private void checkLogin() {
		String username = tfUser.getText();
		String password = new String (pfPassword.getPassword());
		boolean find = false;
		
		//busca el usuario
		for(Usuario u : Almacen.Users) {
			//si usuario y contraseña coinciden accede a la pokedex
			if(username.equals(u.getUsername()) && password.equals(u.getPasswd())) {
				frmLogin.dispose();
				new PokedexView(username, frmLogin);
				find = true;
				break;
			}
			
			//si el usuario existe pero la contraseña no coincide muestra texto de error
			if(username.equals(u.getUsername()) && !password.equals(u.getPasswd())) {
				lblErrorMessage.setText("ERROR: Contraseña incorrecta.");
				find = true;
				break;
			}
			
		}
		
		//si no encuentra al usuario muestra texto de error
		if(!find) {
			lblErrorMessage.setText("ERROR: El usuario no existe.");
		}
				
	}
}
