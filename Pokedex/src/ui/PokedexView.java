package ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import enums.Sexo;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;
import enums.Tipo;
import models.Pokemon;
import utils.Almacen;
import java.awt.Color;

public class PokedexView {
	
	//Propiedades
	private JFrame frmPokedex;
	public static String username;
	private JFrame parent;
	private JLabel lblUsuario;
	private JButton btnCloseSesion;
	private JButton btnNewPokemon;
	private JButton btnModifyPokemon;
	private JButton btnDeletePokemon;
	private JButton btnAnteriorPokemon;
	private JButton btnSiguientePokemon;
	private JLabel lblSetImage;
	private JLabel lblSetNombre;
	private JLabel lblAltura;
	private JLabel lblSetAltura;
	private JLabel lblCategoria;
	private JLabel lblSetCategoria;
	private JLabel lblHabilidad;
	private JLabel lblSetHabilidad;
	private JLabel lblPeso;
	private JLabel lblSetPeso;
	private JLabel lblTipo;
	public static int count = 0;
	private JLabel lblFondo;
	private JLabel lblSexo;
	private JLabel lblErrorFoto;
	private JLabel lblSetTipo;
	private JLabel lblSetSexo;

	/**
	 * Create the application.
	 * @param username Nombre de usuario
	 * @parent Ventana padre desde la que se llama a esta para poder volver a ella.
	 */
	public PokedexView(String username, JFrame parent) {
		this.username = username;
		this.parent = parent;
		initialize();
		frmPokedex.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 * selecciona el icono de la ventana
	 */
	private void initialize() {
		frmPokedex = new JFrame();
		frmPokedex.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmPokedex.setIconImage(Toolkit.getDefaultToolkit().getImage(PokedexView.class.getResource("/utils/images/pokeball.png")));
		configureUIComponents();
		configureListener();
		showPokemon(count);

	}
	
	//getters y setters
	public static String getUsername() {
		return username;
	}
	
	public static int getCount() {
		return count;
	}

	/**
	 * configuracion de los distintos elementos de la pantalla
	 */
	private void configureUIComponents() {
		frmPokedex.getContentPane().setLayout(null);
		frmPokedex.setBounds(100, 100, 900, 750);
		frmPokedex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		lblUsuario = new JLabel("Usuario: " + PokedexView.getUsername());
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(573, 590, 246, 45);
		frmPokedex.getContentPane().add(lblUsuario);

		btnCloseSesion = new JButton("");
		btnCloseSesion.setIcon(new ImageIcon(PokedexView.class.getResource("/utils/images/LOGOUT_SESION.png")));
		btnCloseSesion.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCloseSesion.setBounds(703, 636, 120, 45);
		btnCloseSesion.setBorderPainted(false); 
		btnCloseSesion.setContentAreaFilled(false); 
		btnCloseSesion.setFocusPainted(false); 
		btnCloseSesion.setOpaque(false);
		frmPokedex.getContentPane().add(btnCloseSesion);

		btnNewPokemon = new JButton("");
		btnNewPokemon.setIcon(new ImageIcon(PokedexView.class.getResource("/utils/images/CREATE_BUTTON.png")));
		btnNewPokemon.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewPokemon.setBounds(573, 636, 120, 45);
		btnNewPokemon.setBorderPainted(false); 
		btnNewPokemon.setContentAreaFilled(false); 
		btnNewPokemon.setFocusPainted(false); 
		btnNewPokemon.setOpaque(false);
		frmPokedex.getContentPane().add(btnNewPokemon);

		btnModifyPokemon = new JButton("");
		btnModifyPokemon.setIcon(new ImageIcon(PokedexView.class.getResource("/utils/images/MODIFY_BUTTON.png")));
		btnModifyPokemon.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnModifyPokemon.setBounds(139, 636, 120, 45);
		btnModifyPokemon.setBorderPainted(false); 
		btnModifyPokemon.setContentAreaFilled(false); 
		btnModifyPokemon.setFocusPainted(false); 
		btnModifyPokemon.setOpaque(false);
		frmPokedex.getContentPane().add(btnModifyPokemon);

		btnDeletePokemon = new JButton("");
		btnDeletePokemon.setIcon(new ImageIcon(PokedexView.class.getResource("/utils/images/DELETE_BUTTON.png")));
		btnDeletePokemon.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeletePokemon.setBounds(288, 636, 120, 45);
		btnDeletePokemon.setBorderPainted(false); 
		btnDeletePokemon.setContentAreaFilled(false); 
		btnDeletePokemon.setFocusPainted(false); 
		btnDeletePokemon.setOpaque(false);
		frmPokedex.getContentPane().add(btnDeletePokemon);

		btnAnteriorPokemon = new JButton();
		btnAnteriorPokemon.setForeground(Color.LIGHT_GRAY);
		btnAnteriorPokemon.setBackground(Color.DARK_GRAY);
		btnAnteriorPokemon.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAnteriorPokemon.setBounds(25, 11, 400, 50);
		frmPokedex.getContentPane().add(btnAnteriorPokemon);
		
		btnSiguientePokemon = new JButton();
		btnSiguientePokemon.setForeground(Color.LIGHT_GRAY);
		btnSiguientePokemon.setBackground(Color.DARK_GRAY);
		btnSiguientePokemon.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSiguientePokemon.setBounds(469, 11, 400, 50);
		frmPokedex.getContentPane().add(btnSiguientePokemon);

		lblSetNombre = new JLabel("AA");
		lblSetNombre.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSetNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetNombre.setBounds(44, 71, 825, 60);
		frmPokedex.getContentPane().add(lblSetNombre);

		lblSetImage = new JLabel("");
		lblSetImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetImage.setBounds(44, 141, 475, 475);
		frmPokedex.getContentPane().add(lblSetImage);

		lblAltura = new JLabel("Altura");
		lblAltura.setForeground(Color.WHITE);
		lblAltura.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAltura.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltura.setBounds(562, 231, 120, 30);
		frmPokedex.getContentPane().add(lblAltura);

		lblSetAltura = new JLabel("10");
		lblSetAltura.setForeground(Color.WHITE);
		lblSetAltura.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblSetAltura.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetAltura.setBounds(562, 264, 120, 30);
		frmPokedex.getContentPane().add(lblSetAltura);

		lblCategoria = new JLabel("Categoria");
		lblCategoria.setForeground(Color.WHITE);
		lblCategoria.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategoria.setBounds(714, 224, 120, 45);
		frmPokedex.getContentPane().add(lblCategoria);

		lblSetCategoria = new JLabel("Prueba");
		lblSetCategoria.setForeground(Color.WHITE);
		lblSetCategoria.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblSetCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetCategoria.setBounds(714, 264, 120, 30);
		frmPokedex.getContentPane().add(lblSetCategoria);

		lblHabilidad = new JLabel("Habilidad");
		lblHabilidad.setForeground(Color.WHITE);
		lblHabilidad.setFont(new Font("Dialog", Font.BOLD, 16));
		lblHabilidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblHabilidad.setBounds(714, 344, 120, 30);
		frmPokedex.getContentPane().add(lblHabilidad);

		lblSetHabilidad = new JLabel("Prueba");
		lblSetHabilidad.setForeground(Color.WHITE);
		lblSetHabilidad.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblSetHabilidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetHabilidad.setBounds(714, 384, 120, 30);
		frmPokedex.getContentPane().add(lblSetHabilidad);

		lblPeso = new JLabel("Peso");
		lblPeso.setForeground(Color.WHITE);
		lblPeso.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPeso.setHorizontalAlignment(SwingConstants.CENTER);
		lblPeso.setBounds(562, 344, 120, 30);
		frmPokedex.getContentPane().add(lblPeso);

		lblSetPeso = new JLabel("Prueba");
		lblSetPeso.setForeground(Color.WHITE);
		lblSetPeso.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblSetPeso.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetPeso.setBounds(562, 384, 120, 30);
		frmPokedex.getContentPane().add(lblSetPeso);

		lblTipo = new JLabel("Tipo");
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo.setBounds(714, 464, 120, 30);
		frmPokedex.getContentPane().add(lblTipo);
		
		lblSexo = new JLabel("Sexo");
		lblSexo.setForeground(Color.WHITE);
		lblSexo.setFont(new Font("Dialog", Font.BOLD, 16));
		lblSexo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSexo.setBounds(562, 464, 120, 30);
		frmPokedex.getContentPane().add(lblSexo);
		
		lblErrorFoto = new JLabel("");
		lblErrorFoto.setForeground(Color.RED);
		lblErrorFoto.setBackground(Color.WHITE);
		lblErrorFoto.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblErrorFoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorFoto.setBounds(44, 141, 475, 475);
		frmPokedex.getContentPane().add(lblErrorFoto);
		
		lblSetTipo = new JLabel("");
		lblSetTipo.setForeground(Color.WHITE);
		lblSetTipo.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblSetTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetTipo.setBounds(562, 492, 120, 30);
		frmPokedex.getContentPane().add(lblSetTipo);
		
		lblSetSexo = new JLabel("");
		lblSetSexo.setForeground(Color.WHITE);
		lblSetSexo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetSexo.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblSetSexo.setBounds(714, 492, 120, 30);
		frmPokedex.getContentPane().add(lblSetSexo);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(PokedexView.class.getResource("/utils/images/POKEDEX.png")));
		lblFondo.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondo.setBounds(529, 107, 347, 445);
		frmPokedex.getContentPane().add(lblFondo);

	}
	
	/**
	 * configuracion de la activacion de los botones
	 */
	private void configureListener() {
		// cerrar sesion y volver a login
		btnCloseSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//mensaje de confirmacion para salir
				int opcion = JOptionPane.showConfirmDialog(null, "¿Seguro que quiere Salir?", "Cerrar Sesión", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);	
				
				//en caso de decir que si sale de la ventana y vuelve a login
				if(opcion == 0) {
					frmPokedex.dispose();
					new LoginView();
				}

			}
		});

		// Crear un nuevo pokemon
		btnNewPokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPokedex.setVisible(false);
				new AddPokemon(frmPokedex);
			}
		});

		// Modificar Pokemon existente
		btnModifyPokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPokedex.setVisible(false);
				new ModifyPokemon();
			}
		});

		// Eliminar Pokemon existente
		btnDeletePokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcion = JOptionPane.showConfirmDialog(null, "¿Realmente desea eliminar este Pokemon?", "Eliminar Pokemon", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);	
				
				if(opcion == 0) {
					Almacen.Pokemons.remove(count);
					showPokemon(count);
				}
			}
		});

		// Ver Anterior Pokemon de la lista
		btnAnteriorPokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//en caso de ser el primero de la lista, el anterior será el último
				if(count == 0) {
					count = Almacen.Pokemons.size() - 1;
				
				//si no es el primero de la lista, muestra el anterior
				}else {
					count--;
				}
				
				showPokemon(count);

			}
		});

		// Ver Siguiente Pokemon de la lista
		btnSiguientePokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//en caso de ser el ultimo de la lista, el siguiente será el primero
				if(count == Almacen.Pokemons.size() - 1) {
					count = 0;
					
				//si no es el ultimo de la lista, muestra el siguiente
				}else {
					count++;
				}
				
				showPokemon(count);
				
			}
		});

	}
	
	/**
	 * muestra los datos del pokemon
	 * @param count posicion del pokemon a mostrar
	 */
	private void showPokemon(int count) {
		
		//si no hay pokemons en la lista muestra la pantalla vacia
		if(Almacen.Pokemons.size() == 0) {
			mostrarVacio();
		
		//si hay pokemons registrados muestra el pokemon en cuestion
		}else {
			
			btnAnteriorPokemon.setVisible(true);
			btnSiguientePokemon.setVisible(true);
			btnModifyPokemon.setVisible(true);
			btnDeletePokemon.setVisible(true);
			lblSetImage.setVisible(true);
			
		
		//Boton Anterior Pokemon (muestra el nombre del pokemon que mostrará al hacer click)
		if(count == 0) {
			btnAnteriorPokemon.setText("nº" + Almacen.Pokemons.get(Almacen.Pokemons.size()-1).getNumeroPokedex() + " " + Almacen.Pokemons.get(Almacen.Pokemons.size()-1).getName());
		}else {
			btnAnteriorPokemon.setText("nº" + Almacen.Pokemons.get(count - 1).getNumeroPokedex() + " " + Almacen.Pokemons.get(count - 1).getName());
		}
		
		//Boton Siguiente Pokemon (muestra el nombre del pokemon que mostrará al hacer click)
		if(count == Almacen.Pokemons.size()-1) {
			btnSiguientePokemon.setText("nº" + Almacen.Pokemons.get(0).getNumeroPokedex() + " " + Almacen.Pokemons.get(0).getName());
		}else {
			btnSiguientePokemon.setText("nº" + Almacen.Pokemons.get(count + 1).getNumeroPokedex() + " " + Almacen.Pokemons.get(count + 1).getName());

		}
		
		// Establecemos numero y nombre de Pokémon.
		lblSetNombre.setText("nº" + Almacen.Pokemons.get(count).getNumeroPokedex() + " " + Almacen.Pokemons.get(count).getName());

		// Establecemos los atributos del Pokemon en cuestión.
		lblSetPeso.setText(Double.toString(Almacen.Pokemons.get(count).getPeso()));
		lblSetAltura.setText(Double.toString(Almacen.Pokemons.get(count).getAltura()));
		lblSetCategoria.setText(Almacen.Pokemons.get(count).getCategoría());
		lblSetHabilidad.setText(Almacen.Pokemons.get(count).getHabilidad());
		lblSetTipo.setText(Almacen.Pokemons.get(count).getTipo().toString());
		lblSetSexo.setText(Almacen.Pokemons.get(count).getSexo().toString());

		// Establecemos la imagen del Pokemon en cuestión.
		BufferedImage img;
		try {
			lblSetImage.setVisible(true);
			img = ImageIO.read(new URL(Almacen.Pokemons.get(count).getURL()));
			lblSetImage.setIcon(new javax.swing.ImageIcon(img));
		} catch (IOException e) {
			
			//en caso de no tener imagen mostrará un texto de error
			lblSetImage.setVisible(false);
			lblErrorFoto.setText("Imagen no disponible.");
		}

		}
	}
	
	/**
	 * en caso de no haber pokemons guardados en la pokedex mostrará la pantalla vacia indicando que no hay ningun pokemon y solo permitirá crear uno nuevo o salir.
	 */
	private void mostrarVacio() {
		lblSetNombre.setText("");
		lblSetPeso.setText("N/A");
		lblSetAltura.setText("N/A");
		lblSetCategoria.setText("N/A");
		lblSetHabilidad.setText("N/A");
		lblSetTipo.setText("N/A");
		lblSetSexo.setText("N/A");
		lblErrorFoto.setText("No hay Pokemons registrados.");
		lblSetImage.setVisible(false);
		btnAnteriorPokemon.setVisible(false);
		btnSiguientePokemon.setVisible(false);
		btnModifyPokemon.setVisible(false);
		btnDeletePokemon.setVisible(false);
	}
}
