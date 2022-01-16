package models;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controler.ControlTeclado;
import ui.MyButtonListener;
import ui.MySnakeFrame;

public class Game extends Thread {
	private int contador;
	private MySnakeFrame frame;
	private JPanel mainPanel;
	private TableroJuego tablero;
	private JPanel botonera;
	private JLabel puntos;
	private JLabel puntosNum;
	private JButton start;
	private JButton pause;
	private ControlTeclado miControlador;
	private int dificultad;
	private int tamanyo;

	public Game() {
	}

	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}

	public int getDificultad() {
		return dificultad;
	}

	public void setTamanyo(int tamanyo) {
		this.tamanyo = tamanyo;
	}

	public int getTamanyo() {
		return tamanyo;
	}

	public void initialize() {
		configureUIComponents();
		configureListener();
		iniciar();
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void run() {
		frame = new MySnakeFrame(tamanyo);
		try {
			configureUIComponents();
			configureListener();
			iniciar();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void configureUIComponents() {
		// 1. Crear el frame.
		frame = new MySnakeFrame(tamanyo);

		// asignamos el tamaño a nuestra ventana, y hacemos que se cierre cuando nos
		// pulsan
		// la X de cerrar la ventana

		switch (tamanyo) {
		case 1:
			frame.setSize(400, 400);
			break;
		case 2:
			frame.setSize(600, 600);
			break;
		case 3:
			frame.setSize(800, 800);
			break;
		}

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 3. Ahora creamos los componentes y los ponemos en la frame (ventana).

		// El panel de fondo. Rellena el frame, y sirve de contenedor del tablero y de
		// la botonera.
		mainPanel = new JPanel(new BorderLayout());

		// Ahora creamos el tablero. Recordamos: no deja de ser un panel un poquito
		// "especial"
		tablero = new TableroJuego();

		// Les damos las propiedades a nuestro tablero. Su color, tamaño y borde
		tablero.setBorder(BorderFactory.createLineBorder(Color.black));
		tablero.setBackground(new java.awt.Color(171, 215, 235));
		switch (tamanyo) {
		case 1:
			tablero.setSize(400, 400);
			break;
		case 2:
			tablero.setSize(600, 600);
			break;
		case 3:
			tablero.setSize(800, 800);
			break;
		}

		// Le damos un enlace al tablero para que sepa quién es su frame (ventana) y
		// así
		// sepa
		// quién contiene la serpiente y quién controla el juego...
		tablero.setSnakeFrame(frame);

		// Ahora el turno de la botonera. Tendrá los dos botones y las etiquetas de
		// texto
		botonera = new JPanel();
		botonera.setBorder(BorderFactory.createLineBorder(Color.black));
		botonera.setBackground(new java.awt.Color(150, 150, 150));

		// Ahora definimos las dos etiquetas para los puntos.
		puntos = new JLabel();
		puntos.setText("Puntos: ");
		puntos.setBackground(new java.awt.Color(190, 190, 190));

		puntosNum = new JLabel();
		puntosNum.setText("0");
		puntosNum.setBackground(new java.awt.Color(190, 190, 190));

		// turno de los botones de empezar y pausar/continuar
		start = new JButton();
		start.setSize(50, 20);
		start.setText("Start");

		pause = new JButton();
		pause.setSize(50, 20);
		pause.setText("Pause");

		// Preparamos el control del teclado
		miControlador = new ControlTeclado();
		miControlador.setSnakeFrame(frame); // le damos al controlador de teclado un enlace el frame principal
		tablero.addKeyListener(miControlador); // le decimos al tablero que el teclado es cosa de nuestro controlador
		tablero.setFocusable(true); // permitimos que el tablero pueda coger el foco.

		// Añadimos los componentes uno a uno, cada uno en su contenedor, y al final el
		// panel principal
		// se añade al frame principal.
		botonera.add(start);
		botonera.add(pause);
		botonera.add(puntos);
		botonera.add(puntosNum);

		mainPanel.add(botonera, BorderLayout.PAGE_END);
		mainPanel.add(tablero, BorderLayout.CENTER);
		frame.add(mainPanel);

		frame.setVisible(true); // activamos la ventana principal para que sea "pintable"

		contador = 0; // nuestro control de los pasos del tiempo. Cada vez que contador cuenta un
						// paso, pasan 10ms

	}

	private void configureListener() {
		start.addActionListener(new MyButtonListener(frame, tablero));

		pause.addActionListener(new MyButtonListener(frame, tablero));

	}

	public void iniciar() {

		while (true) {

			// actualizamos el estado del juego
			if (contador % 20 == 0) { // cada 200ms nos movemos o crecemos...
				if(contador == 60) {
					contador = 0;
					
					if(frame.comprobarComida()) {
						frame.tocaCrecer();
						// hemos crecido... actualizamos puntos.
						puntosNum.setText(Integer.toString(frame.getSerpiente().getPuntos()));
						frame.comprobarEstado(tablero.getHeight(), tablero.getWidth(), frame); // comprobamos si hemos muerto o si ha salido de los limites
					}
				}else {
					if(frame.comprobarComida()) {
						frame.tocaCrecer();
						// hemos crecido... actualizamos puntos.
						puntosNum.setText(Integer.toString(frame.getSerpiente().getPuntos()));
					}
					contador++;
					frame.tocaMoverse();
				}
				frame.comprobarEstado(tablero.getHeight(), tablero.getWidth(), frame); // comprobamos si hemos muerto o si ha salido de los limites

			}else {
				contador++;

			}

			// hemos terminado?? mostramos msg
			if (frame.mostrarFin()) {
				JOptionPane.showMessageDialog(frame,
						"Se acabo vaquero, has conseguido " + puntosNum.getText() + " puntos");
			}

			// Repintamos
			tablero.repaint();

			// Esperamos para dar tiempo al thread de repintado a pintar.
			try {
				switch (dificultad) {
				case 1:
					Thread.sleep(20);
					break;
				case 2:
					Thread.sleep(10);
					break;
				case 3:
					Thread.sleep(5);
					break;
				case 4:
					Thread.sleep(1);
					break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	
}
