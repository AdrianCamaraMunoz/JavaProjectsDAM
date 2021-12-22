package ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import enums.Sexo;
import enums.Tipo;
import models.Pokemon;
import utils.Almacen;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class AddPokemon {
	
	//Propiedades
	private JFrame frmAddPokemon;
	private JFrame parent;
	private JLabel lblUsuario;
	private JButton btnVolver;
	private JButton btnModifyPokemon;
	private JLabel lblSetImage;
	private JLabel lblAltura;
	private JLabel lblCategoria;
	private JLabel lblHabilidad;
	private JLabel lblPeso;
	private JLabel lblTipo;
	private JComboBox cbTipo;
	private JComboBox cbSexo;
	private JLabel lblFondo;
	private JLabel lblSexo;
	private JLabel lblErrorFoto;
	private JTextField tfSetAltura;
	private JTextField tfSetCategoria;
	private JTextField tfSetPeso;
	private JTextField tfSetHabilidad;
	private JTextField tfSetImage;
	private JTextField tfNombrePokemon;
	private JTextField tfNumeroPokemon;
	private JLabel lblAddPokemon;
	private JLabel lblErrorMessage;
	private JLabel lblNumeroPokedex;
	private JLabel lblNombrePokemon;

	/**
	 * Create the application.
	 */
	public AddPokemon(JFrame parent) {
		this.parent = parent;
		initialize();
		frmAddPokemon.setVisible(true);
	}

	/**
	 * Inicializa la ventana de añadir nuevos pokemons
	 * Seleccion de icono para la ventana
	 */
	private void initialize() {
		frmAddPokemon = new JFrame();
		frmAddPokemon.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmAddPokemon.setIconImage(Toolkit.getDefaultToolkit().getImage(AddPokemon.class.getResource("/utils/images/pokeball.png")));
		configureUIComponents();
		configureListener();

	}
	
	/**
	 * configuracion de los distintos elementos de la pantalla
	 */
	private void configureUIComponents() {
		frmAddPokemon.getContentPane().setLayout(null);
		frmAddPokemon.setBounds(100, 100, 900, 750);
		frmAddPokemon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		tfSetImage = new JTextField();
		tfSetImage.setBounds(44, 647, 475, 26);
		frmAddPokemon.getContentPane().add(tfSetImage);
		tfSetImage.setColumns(10);

		lblUsuario = new JLabel("Usuario: " + PokedexView.getUsername());
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(573, 545, 246, 45);
		frmAddPokemon.getContentPane().add(lblUsuario);

		btnVolver = new JButton("");
		btnVolver.setIcon(new ImageIcon(AddPokemon.class.getResource("/utils/images/VOLVER_BUTTON.png")));
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVolver.setBounds(703, 591, 120, 45);
		btnVolver.setBorderPainted(false); 
		btnVolver.setContentAreaFilled(false); 
		btnVolver.setFocusPainted(false); 
		btnVolver.setOpaque(false);
		frmAddPokemon.getContentPane().add(btnVolver);

		btnModifyPokemon = new JButton("");
		btnModifyPokemon.setIcon(new ImageIcon(AddPokemon.class.getResource("/utils/images/CREATE_BUTTON.png")));
		btnModifyPokemon.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnModifyPokemon.setBounds(573, 591, 120, 45);
		btnModifyPokemon.setBorderPainted(false); 
		btnModifyPokemon.setContentAreaFilled(false); 
		btnModifyPokemon.setFocusPainted(false); 
		btnModifyPokemon.setOpaque(false);
		frmAddPokemon.getContentPane().add(btnModifyPokemon);

		lblSetImage = new JLabel("");
		lblSetImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetImage.setBounds(44, 141, 475, 475);
		frmAddPokemon.getContentPane().add(lblSetImage);

		lblAltura = new JLabel("Altura");
		lblAltura.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAltura.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltura.setBounds(562, 212, 120, 30);
		frmAddPokemon.getContentPane().add(lblAltura);

		lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategoria.setBounds(714, 212, 120, 30);
		frmAddPokemon.getContentPane().add(lblCategoria);

		lblHabilidad = new JLabel("Habilidad");
		lblHabilidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHabilidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblHabilidad.setBounds(714, 332, 120, 30);
		frmAddPokemon.getContentPane().add(lblHabilidad);

		lblPeso = new JLabel("Peso");
		lblPeso.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPeso.setHorizontalAlignment(SwingConstants.CENTER);
		lblPeso.setBounds(562, 332, 120, 30);
		frmAddPokemon.getContentPane().add(lblPeso);

		lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo.setBounds(714, 452, 120, 30);
		frmAddPokemon.getContentPane().add(lblTipo);

		cbTipo = new JComboBox();
		cbTipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbTipo.setModel(new DefaultComboBoxModel(Tipo.values()));
		cbTipo.setBounds(714, 492, 120, 30);
		frmAddPokemon.getContentPane().add(cbTipo);

		cbSexo = new JComboBox();
		cbSexo.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbSexo.setModel(new DefaultComboBoxModel(Sexo.values()));
		cbSexo.setBounds(562, 492, 120, 30);
		frmAddPokemon.getContentPane().add(cbSexo);

		lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSexo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSexo.setBounds(562, 452, 120, 30);
		frmAddPokemon.getContentPane().add(lblSexo);

		lblErrorFoto = new JLabel("");
		lblErrorFoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorFoto.setBounds(44, 141, 475, 475);
		frmAddPokemon.getContentPane().add(lblErrorFoto);

		tfSetAltura = new JTextField();
		tfSetAltura.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfSetAltura.setHorizontalAlignment(SwingConstants.CENTER);
		tfSetAltura.setBounds(562, 255, 120, 30);
		frmAddPokemon.getContentPane().add(tfSetAltura);
		tfSetAltura.setColumns(10);

		tfSetCategoria = new JTextField();
		tfSetCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		tfSetCategoria.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfSetCategoria.setColumns(10);
		tfSetCategoria.setBounds(714, 252, 120, 30);
		frmAddPokemon.getContentPane().add(tfSetCategoria);

		tfSetPeso = new JTextField();
		tfSetPeso.setHorizontalAlignment(SwingConstants.CENTER);
		tfSetPeso.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfSetPeso.setColumns(10);
		tfSetPeso.setBounds(562, 372, 120, 30);
		frmAddPokemon.getContentPane().add(tfSetPeso);

		tfSetHabilidad = new JTextField();
		tfSetHabilidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfSetHabilidad.setHorizontalAlignment(SwingConstants.CENTER);
		tfSetHabilidad.setColumns(10);
		tfSetHabilidad.setBounds(714, 372, 120, 30);
		frmAddPokemon.getContentPane().add(tfSetHabilidad);

		lblFondo = new JLabel("");
		lblFondo.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondo.setBounds(529, 141, 340, 439);
		frmAddPokemon.getContentPane().add(lblFondo);

		tfNombrePokemon = new JTextField();
		tfNombrePokemon.setFont(new Font("Tahoma", Font.BOLD, 15));
		tfNombrePokemon.setHorizontalAlignment(SwingConstants.CENTER);
		tfNombrePokemon.setBounds(529, 71, 305, 60);
		frmAddPokemon.getContentPane().add(tfNombrePokemon);
		tfNombrePokemon.setColumns(10);

		tfNumeroPokemon = new JTextField();
		tfNumeroPokemon.setHorizontalAlignment(SwingConstants.CENTER);
		tfNumeroPokemon.setFont(new Font("Tahoma", Font.BOLD, 15));
		tfNumeroPokemon.setColumns(10);
		tfNumeroPokemon.setBounds(132, 71, 272, 60);
		frmAddPokemon.getContentPane().add(tfNumeroPokemon);

		lblAddPokemon = new JLabel("A\u00F1adir Pokemon");
		lblAddPokemon.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddPokemon.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddPokemon.setBounds(44, 10, 825, 51);
		frmAddPokemon.getContentPane().add(lblAddPokemon);

		lblErrorMessage = new JLabel("");
		lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorMessage.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblErrorMessage.setForeground(Color.RED);
		lblErrorMessage.setBounds(529, 647, 340, 26);
		frmAddPokemon.getContentPane().add(lblErrorMessage);
		
		lblNumeroPokedex = new JLabel("N\u00BA");
		lblNumeroPokedex.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroPokedex.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNumeroPokedex.setBounds(42, 71, 80, 60);
		frmAddPokemon.getContentPane().add(lblNumeroPokedex);
		
		lblNombrePokemon = new JLabel("Nombre:");
		lblNombrePokemon.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombrePokemon.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombrePokemon.setBounds(414, 70, 120, 60);
		frmAddPokemon.getContentPane().add(lblNombrePokemon);

	}
	
	/**
	 * configuracion de la activacion de los botones
	 */
	private void configureListener() {
		
		// volver a pokedex
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//mensaje de confirmacion antes de salir
				int opcion = JOptionPane.showConfirmDialog(null, "¿Seguro que quiere Volver?", "Salir",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

				if (opcion == 0) {
					frmAddPokemon.dispose();
					parent.setVisible(true);
				}
			}
		});

		//CrearNuevoPokemon
		btnModifyPokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean find = false;
				for (Pokemon p : Almacen.Pokemons) {
					// Si el Pokemon ya esta guardado
					if (tfNombrePokemon.getText().equalsIgnoreCase(p.getName())) {
						lblErrorMessage.setText("ERROR: Nombre de Pokemon Existente");
						find = true;
						break;

						// Si el numero de la Pokedex ya lo usa otro Pokemon
					} else if (tfNumeroPokemon.getText().equals(p.getNumeroPokedex())) {
						lblErrorMessage.setText("ERROR: El numero del Pokemon ya pertenece a otro Pokemon.");
						find = true;
						break;
					}
				}
				
				//si no existe ni el nombre ni el numero podemos crearlo
				if (!find) {

					// Si hay campos vacios no se puede crear
					if (tfNumeroPokemon.getText().equals("") || tfNombrePokemon.getText().equals("")
							|| tfSetAltura.getText().equals("") || tfSetPeso.getText().equals("")
							|| tfSetCategoria.getText().equals("") || tfSetHabilidad.getText().equals("")
							|| tfSetImage.getText().equals("")) {

						lblErrorMessage.setText("ERROR: No puede haber campos vacíos.");

					} else {
						
						//comprobamos que tipo ha seleccionado el usuario para el pokemon
						for (Tipo t : Tipo.values()) {
							if (t.equals(cbTipo.getSelectedItem())) {
								
								//comprobamos que sexo ha seleccionado el usuario para el pokemon
								for (Sexo s : Sexo.values()) {
									if (s.equals(cbSexo.getSelectedItem())) {
										
										try {
											//creamos el nuevo pokemon
											Almacen.Pokemons.add(new Pokemon(Integer.valueOf(tfNumeroPokemon.getText()),
													t, tfNombrePokemon.getText(), s,
													Double.valueOf(tfSetAltura.getText()),
													Double.valueOf(tfSetPeso.getText()), tfSetCategoria.getText(),
													tfSetHabilidad.getText(), tfSetImage.getText()));
											
											//mensaje de confirmacion de nuevo pokemon
											JOptionPane.showMessageDialog(btnModifyPokemon,
													"Pokemon añadido correctamente.");
											
											frmAddPokemon.setVisible(false);
											new PokedexView(PokedexView.username, frmAddPokemon);

										} catch (Exception e2) {
											//si algun campo numerico se introducen letras salta mensaje de error
											JOptionPane.showMessageDialog(btnModifyPokemon,
													"Datos inválidos, revisa que la altura, el peso y el número de la pokedex sean numéricos.");
										}
										break;
									}
								}
								break;
							}
						}
					}
				}
			}
		});
	}
	
	/**
	 * Muestra los datos del pokemon
	 */
	private void showPokemon() {

		//Establecemos numero y nombre de Pokémon.
		tfNombrePokemon.setText(Almacen.Pokemons.get(PokedexView.count).getName());
		tfNumeroPokemon.setText(Integer.toString(Almacen.Pokemons.get(PokedexView.count).getNumeroPokedex()));

		//Establecemos los atributos del Pokemon en cuestión.
		tfSetPeso.setText(Double.toString(Almacen.Pokemons.get(PokedexView.count).getPeso()));
		tfSetAltura.setText(Double.toString(Almacen.Pokemons.get(PokedexView.count).getAltura()));
		tfSetCategoria.setText(Almacen.Pokemons.get(PokedexView.count).getCategoría());
		tfSetHabilidad.setText(Almacen.Pokemons.get(PokedexView.count).getHabilidad());
		cbTipo.setSelectedItem(Almacen.Pokemons.get(PokedexView.count).getTipo());
		cbSexo.setSelectedItem(Almacen.Pokemons.get(PokedexView.count).getTipo());
		tfSetImage.setText(Almacen.Pokemons.get(PokedexView.count).getURL());

		//Establecemos la imagen del Pokemon en cuestión.
		BufferedImage img;
		
		//establece la imagen del pokemon
		try {
			img = ImageIO.read(new URL(Almacen.Pokemons.get(PokedexView.count).getURL()));
			lblSetImage.setIcon(new javax.swing.ImageIcon(img));
		} catch (IOException e) {
			//en caso de no tener imagen muestra un texto de error
			lblErrorFoto.setText("Imagen no disponible.");

		}

	}
}
