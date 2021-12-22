package ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import enums.Sexo;
import enums.Tipo;
import models.Pokemon;
import utils.Almacen;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class ModifyPokemon {
	
	//Propiedades
	private JFrame frmModifyPokemon;
	private JLabel lblUsuario;
	private JLabel lblImage;
	private JLabel lblAltura;
	private JLabel lblCategoria;
	private JLabel lblOldHabilidad;
	private JLabel lblPeso;
	private JLabel lblTipo;
	private JLabel lblSexo;
	private JLabel lblErrorFoto;
	private JLabel lblModifyPokemon;
	private JLabel lblErrorMessage;
	private JLabel lblNombre;
	private JLabel lblNumero;
	private JButton btnVolver;
	private JButton btnModifyPokemon;
	
	private JTextField tfSetAltura;
	private JTextField tfSetCategoria;
	private JTextField tfSetPeso;
	private JTextField tfSetHabilidad;
	private JTextField tfSetNumero;
	private JTextField tfSetImage;
	private JComboBox cbSetTipo;
	private JComboBox cbSetSexo;
	private JTextField tfSetNombre;
	private JLabel lblOldNumero;
	private JLabel lblOldNombre;
	private JLabel lblOldAltura;
	private JLabel lblOldCategoria;
	private JLabel lblOldPeso;
	private JLabel lblHabilidad;
	private JLabel lblOldSexo;
	private JLabel lblOldTipo;
	private JLabel lblOldImage;
	

	/**
	 * Create the application.
	 */
	public ModifyPokemon() {
		initialize();
		this.frmModifyPokemon.setVisible(true);
	}
	
	/**
	 * Initialize the contents of the frame.
	 * Selecciona el icono de la ventana 
	 */
	private void initialize() {
		frmModifyPokemon = new JFrame();
		frmModifyPokemon.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmModifyPokemon.setIconImage(Toolkit.getDefaultToolkit().getImage(ModifyPokemon.class.getResource("/utils/images/pokeball.png")));

		configureUIComponents();
		configureListener();
		showPokemon();

	}
	
	/**
	 * configuracion de los distintos elementos de la pantalla
	 */
	private void configureUIComponents() {
		
		frmModifyPokemon.getContentPane().setLayout(null);
		frmModifyPokemon.setBounds(100, 100, 900, 750);
		frmModifyPokemon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		lblErrorMessage = new JLabel();
		lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorMessage.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblErrorMessage.setForeground(Color.RED);
		lblErrorMessage.setBounds(529, 677, 340, 26);
		frmModifyPokemon.getContentPane().add(lblErrorMessage);
		
		lblErrorFoto = new JLabel();
		lblErrorFoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorFoto.setBounds(44, 141, 475, 475);
		frmModifyPokemon.getContentPane().add(lblErrorFoto);

		lblUsuario = new JLabel("Usuario: " + PokedexView.getUsername());
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(569, 591, 246, 30);
		frmModifyPokemon.getContentPane().add(lblUsuario);

		lblImage = new JLabel("");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(44, 141, 475, 475);
		frmModifyPokemon.getContentPane().add(lblImage);

		lblAltura = new JLabel("Altura");
		lblAltura.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAltura.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltura.setBounds(562, 168, 120, 30);
		frmModifyPokemon.getContentPane().add(lblAltura);

		lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategoria.setBounds(714, 168, 120, 30);
		frmModifyPokemon.getContentPane().add(lblCategoria);

		lblPeso = new JLabel("Peso");
		lblPeso.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPeso.setHorizontalAlignment(SwingConstants.CENTER);
		lblPeso.setBounds(562, 295, 120, 30);
		frmModifyPokemon.getContentPane().add(lblPeso);

		lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo.setBounds(714, 425, 120, 30);
		frmModifyPokemon.getContentPane().add(lblTipo);

		lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSexo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSexo.setBounds(562, 425, 120, 30);
		frmModifyPokemon.getContentPane().add(lblSexo);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNombre.setBounds(447, 58, 120, 68);
		frmModifyPokemon.getContentPane().add(lblNombre);
		
		lblNumero = new JLabel("N\u00BA");
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNumero.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumero.setBounds(44, 58, 106, 68);
		frmModifyPokemon.getContentPane().add(lblNumero);

		lblModifyPokemon = new JLabel("Modificar Pokemon");
		lblModifyPokemon.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifyPokemon.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblModifyPokemon.setBounds(44, 10, 825, 51);
		frmModifyPokemon.getContentPane().add(lblModifyPokemon);
		
		lblHabilidad = new JLabel("Habilidad");
		lblHabilidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblHabilidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHabilidad.setBounds(714, 295, 120, 30);
		frmModifyPokemon.getContentPane().add(lblHabilidad);

		btnVolver = new JButton("");
		btnVolver.setIcon(new ImageIcon(ModifyPokemon.class.getResource("/utils/images/VOLVER_BUTTON.png")));
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVolver.setBounds(699, 622, 120, 45);
		btnVolver.setBorderPainted(false); 
		btnVolver.setContentAreaFilled(false); 
		btnVolver.setFocusPainted(false); 
		btnVolver.setOpaque(false);
		frmModifyPokemon.getContentPane().add(btnVolver);

		btnModifyPokemon = new JButton("");
		btnModifyPokemon.setIcon(new ImageIcon(ModifyPokemon.class.getResource("/utils/images/LOGIN_BUTTON.png")));
		btnModifyPokemon.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnModifyPokemon.setBounds(569, 622, 120, 45);
		btnModifyPokemon.setBorderPainted(false); 
		btnModifyPokemon.setContentAreaFilled(false); 
		btnModifyPokemon.setFocusPainted(false); 
		btnModifyPokemon.setOpaque(false);
		frmModifyPokemon.getContentPane().add(btnModifyPokemon);
		
		tfSetAltura = new JTextField();
		tfSetAltura.setText("0.0");
		tfSetAltura.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfSetAltura.setHorizontalAlignment(SwingConstants.CENTER);
		tfSetAltura.setBounds(562, 241, 120, 30);
		frmModifyPokemon.getContentPane().add(tfSetAltura);
		tfSetAltura.setColumns(10);
		
		tfSetCategoria = new JTextField();
		tfSetCategoria.setText("N/A");
		tfSetCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		tfSetCategoria.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfSetCategoria.setColumns(10);
		tfSetCategoria.setBounds(714, 241, 120, 30);
		frmModifyPokemon.getContentPane().add(tfSetCategoria);
		
		tfSetPeso = new JTextField();
		tfSetPeso.setText("0.0");
		tfSetPeso.setHorizontalAlignment(SwingConstants.CENTER);
		tfSetPeso.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfSetPeso.setColumns(10);
		tfSetPeso.setBounds(562, 372, 120, 30);
		frmModifyPokemon.getContentPane().add(tfSetPeso);
		
		tfSetHabilidad = new JTextField();
		tfSetHabilidad.setText("N/A");
		tfSetHabilidad.setHorizontalAlignment(SwingConstants.CENTER);
		tfSetHabilidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfSetHabilidad.setColumns(10);
		tfSetHabilidad.setBounds(714, 372, 120, 30);
		frmModifyPokemon.getContentPane().add(tfSetHabilidad);
		
		cbSetSexo = new JComboBox();
		cbSetSexo.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbSetSexo.setModel(new DefaultComboBoxModel(Sexo.values()));
		cbSetSexo.setBounds(562, 505, 120, 30);
		frmModifyPokemon.getContentPane().add(cbSetSexo);
		
		cbSetTipo = new JComboBox();
		cbSetTipo.setModel(new DefaultComboBoxModel(Tipo.values()));
		cbSetTipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbSetTipo.setBounds(714, 505, 120, 30);
		frmModifyPokemon.getContentPane().add(cbSetTipo);
		
		tfSetNumero = new JTextField();
		tfSetNumero.setText("0");
		tfSetNumero.setHorizontalAlignment(SwingConstants.CENTER);
		tfSetNumero.setFont(new Font("Tahoma", Font.BOLD, 18));
		tfSetNumero.setBounds(160, 91, 260, 40);
		frmModifyPokemon.getContentPane().add(tfSetNumero);
		tfSetNumero.setColumns(10);
		
		tfSetImage = new JTextField();
		tfSetImage.setText("N/A");
		tfSetImage.setHorizontalAlignment(SwingConstants.CENTER);
		tfSetImage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfSetImage.setColumns(10);
		tfSetImage.setBounds(44, 673, 475, 30);
		frmModifyPokemon.getContentPane().add(tfSetImage);
		
		tfSetNombre = new JTextField();
		tfSetNombre.setText("N/A");
		tfSetNombre.setFont(new Font("Tahoma", Font.BOLD, 18));
		tfSetNombre.setHorizontalAlignment(SwingConstants.CENTER);
		tfSetNombre.setBounds(573, 91, 260, 40);
		frmModifyPokemon.getContentPane().add(tfSetNombre);
		tfSetNombre.setColumns(10);
		
		lblOldNumero = new JLabel();
		lblOldNumero.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblOldNumero.setForeground(new Color(0, 0, 0));
		lblOldNumero.setHorizontalAlignment(SwingConstants.CENTER);
		lblOldNumero.setBounds(160, 61, 260, 20);
		frmModifyPokemon.getContentPane().add(lblOldNumero);
		
		lblOldNombre = new JLabel();
		lblOldNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblOldNombre.setForeground(Color.BLACK);
		lblOldNombre.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblOldNombre.setBounds(573, 61, 260, 20);
		frmModifyPokemon.getContentPane().add(lblOldNombre);
		
		lblOldAltura = new JLabel();
		lblOldAltura.setHorizontalAlignment(SwingConstants.CENTER);
		lblOldAltura.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOldAltura.setBounds(562, 208, 120, 30);
		frmModifyPokemon.getContentPane().add(lblOldAltura);
		
		lblOldCategoria = new JLabel();
		lblOldCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		lblOldCategoria.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOldCategoria.setBounds(714, 208, 120, 30);
		frmModifyPokemon.getContentPane().add(lblOldCategoria);
		
		lblOldPeso = new JLabel();
		lblOldPeso.setHorizontalAlignment(SwingConstants.CENTER);
		lblOldPeso.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOldPeso.setBounds(562, 332, 120, 30);
		frmModifyPokemon.getContentPane().add(lblOldPeso);
		
		lblOldSexo = new JLabel();
		lblOldSexo.setHorizontalAlignment(SwingConstants.CENTER);
		lblOldSexo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOldSexo.setBounds(562, 465, 120, 30);
		frmModifyPokemon.getContentPane().add(lblOldSexo);
		
		lblOldTipo = new JLabel();
		lblOldTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblOldTipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOldTipo.setBounds(714, 465, 120, 30);
		frmModifyPokemon.getContentPane().add(lblOldTipo);
		
		lblOldImage = new JLabel();
		lblOldImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblOldImage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOldImage.setBounds(44, 633, 475, 30);
		frmModifyPokemon.getContentPane().add(lblOldImage);
		
		lblOldHabilidad = new JLabel();
		lblOldHabilidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOldHabilidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblOldHabilidad.setBounds(714, 332, 120, 30);
		frmModifyPokemon.getContentPane().add(lblOldHabilidad);
		

	}
	/**
	 * configuracion de la activacion de los botones
	 */
	private void configureListener() {
		// volver a la pokedex
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//mensaje de confirmacion para salir
				int opcion = JOptionPane.showConfirmDialog(null, "¿Seguro que quiere volver?", "Salir",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				//si selecciona que si, sale de la ventana
				if (opcion == 0) {
					frmModifyPokemon.dispose();
					new PokedexView(PokedexView.username, frmModifyPokemon);
				}
			}
		});

		// Modificar Pokemon
		btnModifyPokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean find = false;
				int count2 = 0;
				showPokemon();
				
				for (Pokemon p : Almacen.Pokemons) {
					
					// Si el Pokemon ya esta guardado muestra error de que existe
					if (tfSetNombre.getText().equalsIgnoreCase(p.getName()) && PokedexView.count != count2) {
						lblErrorMessage.setText("ERROR: Nombre de Pokemon Existente");
						find = true;
						break;

						// Si el numero de la Pokedex ya lo usa otro Pokemon muestra error
					} else if (Integer.parseInt(tfSetNumero.getText()) == (p.getNumeroPokedex()) && PokedexView.count != count2 ) {
						lblErrorMessage.setText("ERROR: El numero del Pokemon ya pertenece a otro Pokemon.");
						find = true;
						break;
					}
					
					//si se encuentra en el ultimo pokemon guardado, comprueba el primero del array, sino el siguiente
					if(count2 == Almacen.Pokemons.size() - 1) {
						count2 = 0;
					}else {
						count2++;
					}

				}
				
				//si no encuentra el pokemon(no esta registrado)
				if (!find) {
						
					// Si hay campos vacios da error
					if (tfSetNombre.getText().equals("") || tfSetNombre.getText().equals("")
							|| tfSetAltura.getText().equals("") || tfSetPeso.getText().equals("")
							|| tfSetCategoria.getText().equals("") || tfSetHabilidad.getText().equals("") || tfSetImage.getText().equals("")){

						lblErrorMessage.setText("ERROR: No puede haber campos vacíos.");

					} else {
						
						//comprueba el tipo del pokemon seleccionado
						for (Tipo t : Tipo.values()) {
							if (t.equals(cbSetTipo.getSelectedItem())) {
								
								//comprueba el sexo del pokemon seleccionado
								for (Sexo s : Sexo.values()) {
									if (s.equals(cbSetSexo.getSelectedItem())) {
										try {
											
											//modifica el pokemon con los nuevos valores
											Almacen.Pokemons.set(PokedexView.count,
									                new Pokemon(
									                		Integer.valueOf(tfSetNumero.getText()), 
									                		t,
									                		tfSetNombre.getText(),
									                		s,
									                		Double.valueOf(tfSetAltura.getText()),
									                		Double.valueOf(tfSetPeso.getText()), 
									                		lblCategoria.getText(), 
									                		lblOldHabilidad.getText(),
									                		tfSetImage.getText()));	
											
										
										//mensaje de confirmacion de pokemon modificado
										JOptionPane.showMessageDialog(btnModifyPokemon,
												"Pokemon modificado correctamente.");
										
										frmModifyPokemon.setVisible(false);
										new PokedexView(PokedexView.username, frmModifyPokemon);
										
										}catch(Exception e2) {
											//error si algunos datos no son correctos, por ejemplo valores numericos rellenos con letras
											JOptionPane.showMessageDialog(btnModifyPokemon,"Datos inválidos, revisa que la altura, el peso y el número de la pokedex sean numéricos.");										}
										
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
		
		// Establecemos los atributos del Pokemon en cuestión.
		lblOldNumero.setText("Old: " + Integer.toString(Almacen.Pokemons.get(PokedexView.count).getNumeroPokedex()));
		lblOldNombre.setText("Old: " + Almacen.Pokemons.get(PokedexView.count).getName());
		lblOldPeso.setText("Old: " + Double.toString(Almacen.Pokemons.get(PokedexView.count).getPeso()));
		lblOldAltura.setText("Old: " + Double.toString(Almacen.Pokemons.get(PokedexView.count).getAltura()));
		lblOldCategoria.setText("Old: " + Almacen.Pokemons.get(PokedexView.count).getCategoría());
		lblOldHabilidad.setText("Old: " + Almacen.Pokemons.get(PokedexView.count).getHabilidad());
		lblOldTipo.setText("Old: " + Almacen.Pokemons.get(PokedexView.count).getTipo().toString());
		lblOldSexo.setText("Old: " + Almacen.Pokemons.get(PokedexView.count).getSexo().toString());
		lblOldImage.setText("Old: " + Almacen.Pokemons.get(PokedexView.count).getURL());

	}

	//La idea era mostrar en los textFields los datos ya introducidos para que el usuario los modificase pero al hacer esto luego no hacia la modificacion,
	//por este motivo utilizo label para indicar cuales eran los campos antiguos, no he encontrado la solcuion.
	//Dejo abajo el código original.
	
//	private void showPokemon() {
//		
//		tfSetNumero.setText(Integer.toString(Almacen.Pokemons.get(PokedexView.count).getNumeroPokedex()));
//		tfSetNombre.setText(Almacen.Pokemons.get(PokedexView.count).getName());
//		
//
//		// Establecemos los atributos del Pokemon en cuestión.
//		tfSetPeso.setText(Double.toString(Almacen.Pokemons.get(PokedexView.count).getPeso()));
//		tfSetAltura.setText(Double.toString(Almacen.Pokemons.get(PokedexView.count).getAltura()));
//		tfSetCategoria.setText(Almacen.Pokemons.get(PokedexView.count).getCategoría());
//		tfSetHabilidad.setText(Almacen.Pokemons.get(PokedexView.count).getHabilidad());
//		cbSetTipo.setSelectedItem(Almacen.Pokemons.get(PokedexView.count).getTipo());
//		cbSetSexo.setSelectedItem(Almacen.Pokemons.get(PokedexView.count).getSexo());
//		tfSetImage.setText(Almacen.Pokemons.get(PokedexView.count).getURL());
//
//		// Establecemos la imagen del Pokemon en cuestión.
//		BufferedImage img;
//
//		try {
//			img = ImageIO.read(new URL(Almacen.Pokemons.get(PokedexView.count).getURL()));
//			lblImage.setIcon(new javax.swing.ImageIcon(img));
//		} catch (IOException e) {
//			lblErrorFoto.setText("ERROR: Imagen no disponible.");
//
//		}
//
//	}
}
