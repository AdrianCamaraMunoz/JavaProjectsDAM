package ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import models.Usuario;
import utils.Almacen;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class RegisterView {

	//Propiedades
	private JFrame frmRegister;
	private JLabel lblRegistro;
	private JButton btnVolver;
	private JFrame parent;
	private JTextField textUsername;
	private JLabel lblUsername;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldConfirm;
	private JLabel lblPassword;
	private JLabel lblPasswordConfirm;
	private JButton btnRegister;
	private JLabel lblErrorMessage;
	
	/**
	 * Create the application.
	 */
	public RegisterView(JFrame parent) {
		this.parent = parent;
		initialize();
		frmRegister.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 * selecciona el icono de la ventana
	 */
	private void initialize() {
		frmRegister = new JFrame();
		frmRegister.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmRegister.setIconImage(Toolkit.getDefaultToolkit().getImage(RegisterView.class.getResource("/utils/images/pokeball.png")));
		configureUIComponents();
		configureListener();	
	}
	
	/**
	 * configuracion de los distintos elementos de la pantalla
	 */
	private void configureUIComponents() {
		frmRegister.setBounds(100, 100, 900, 750);
		frmRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegister.getContentPane().setLayout(null);
		
		lblRegistro = new JLabel("");
		lblRegistro.setIcon(new ImageIcon(RegisterView.class.getResource("/utils/images/REGISTER.png")));
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblRegistro.setBounds(10, 60, 866, 123);
		frmRegister.getContentPane().add(lblRegistro);
		
		btnVolver = new JButton("");
		btnVolver.setIcon(new ImageIcon(RegisterView.class.getResource("/utils/images/VOLVER_BUTTON.png")));
		btnVolver.setBounds(268, 508, 146, 61);
		btnVolver.setBorderPainted(false); 
        btnVolver.setContentAreaFilled(false); 
        btnVolver.setFocusPainted(false); 
        btnVolver.setOpaque(false);
		frmRegister.getContentPane().add(btnVolver);
		
		textUsername = new JTextField();
		textUsername.setForeground(new Color (56,109,185));
		textUsername.setHorizontalAlignment(SwingConstants.CENTER);
		textUsername.setFont(new Font("Tahoma", Font.BOLD, 18));
		textUsername.setBackground(Color.WHITE);
		textUsername.setBounds(446, 277, 180, 31);
		frmRegister.getContentPane().add(textUsername);
		textUsername.setColumns(10);
		
		lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.DARK_GRAY);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblUsername.setBounds(255, 277, 159, 31);
		frmRegister.getContentPane().add(lblUsername);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color (56,109,185));
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 18));
		passwordField.setBackground(Color.WHITE);
		passwordField.setBounds(446, 326, 180, 31);
		frmRegister.getContentPane().add(passwordField);
		
		lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.DARK_GRAY);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPassword.setBounds(255, 326, 159, 31);
		frmRegister.getContentPane().add(lblPassword);
		
		passwordFieldConfirm = new JPasswordField();
		passwordFieldConfirm.setForeground(new Color (56,109,185));
		passwordFieldConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		passwordFieldConfirm.setFont(new Font("Tahoma", Font.BOLD, 18));
		passwordFieldConfirm.setBackground(Color.WHITE);
		passwordFieldConfirm.setBounds(446, 377, 180, 31);
		frmRegister.getContentPane().add(passwordFieldConfirm);
		
		lblPasswordConfirm = new JLabel("Confirm Password");
		lblPasswordConfirm.setForeground(Color.DARK_GRAY);
		lblPasswordConfirm.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPasswordConfirm.setBounds(137, 377, 277, 31);
		frmRegister.getContentPane().add(lblPasswordConfirm);
		
		btnRegister = new JButton("");
		btnRegister.setIcon(new ImageIcon(RegisterView.class.getResource("/utils/images/REGISTER_BUTTON.png")));
		btnRegister.setBounds(480, 508, 146, 61);
		btnRegister.setBorderPainted(false); 
        btnRegister.setContentAreaFilled(false); 
        btnRegister.setFocusPainted(false); 
        btnRegister.setOpaque(false);
		frmRegister.getContentPane().add(btnRegister);
		
		lblErrorMessage = new JLabel("");
		lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorMessage.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblErrorMessage.setForeground(Color.RED);
		lblErrorMessage.setBounds(137, 445, 596, 42);
		frmRegister.getContentPane().add(lblErrorMessage);
	}
	
	/**
	 * configuracion de la activacion de los botones
	 */
	private void configureListener() {
		
		//Enter para ir a Passwd desde user
		textUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					passwordField.requestFocus();
               }
			}
		});
		
		//Enter para ir a confirmar passwd desde passwd
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					passwordFieldConfirm.requestFocus();
               }
			}
		});
		
		//Registrarse al pulsar enter desde confirmPasswd
		passwordFieldConfirm.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					checkRegister();
				}
			}
		});
		
		//Volver a iniciar sesión
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRegister.setVisible(false);
				parent.setVisible(true);
			}
		});
		
		//registrar nuevo usuario
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkRegister();
			}
		});

	}
	
	/**
	 * registrar nuevo usuario
	 */
	private void checkRegister() {
		String passwd  = new String(passwordField.getPassword());
		String confirmPasswd = new String(passwordFieldConfirm.getPassword());	
		String username = textUsername.getText();
		boolean find = false;
		
		//comprueba si el usuario ya existe, muestra error en ese caso
		for(Usuario u : Almacen.Users) {
			if(u.getUsername().equals(username)) {
				lblErrorMessage.setText("ERROR: El usuario ya existe.");
				find = true;
				break;
			}
		}
		
		//comprueba si el campo usuario esta vacio y muestra error en ese caso
		if(username.equals("")) {
			lblErrorMessage.setText("ERROR: El usuario no puede estar vacio.");
		
		//comprueba que las contraseñas no esten vacias, muestra error en caso de estarlas
		}else if(passwd.equals("") || confirmPasswd.equals("")){
			lblErrorMessage.setText("ERROR: Las contraseñas no puede estar vacia.");
			
		//comprueba si las contraseñas coinciden, muestra error en caso de no coincidir
		}else if(!find && !passwd.equals(confirmPasswd)){
			lblErrorMessage.setText("ERROR: Las contraseñas no coinciden.");
			
		//en caso de no existir el usuario y coincidir las contraseñas registra al usuario, muestra mensaje de confirmacion del registro
		}else if(!find && passwd.equals(confirmPasswd)){
			lblErrorMessage.setText("Usuario Creado Correctamente.");
			Almacen.Users.add(new Usuario(username, passwd));
			frmRegister.dispose();
			parent.setVisible(true);
		}
	}
}
