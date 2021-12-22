package models;

import java.util.ArrayList;
import java.util.Scanner;

public class Sieteymedia extends AbstractGame {

	static Scanner sc = new Scanner(System.in);

	@Override
	/**
	 * explica el funcionamiento de 7ymedia y pide el modo de juego
	 */
	public void bienvenida() {
		System.out.println("Bienvenido a Siete y media!");
		System.out.println(
				"El juego consiste en ir robando cartas hasta acercarte lo máximo posible a la suma de 7 y medio sin pasarse.");
		System.out.println(
				"Para ello cada carta tendrá su valor propio y las figuras, sota, caballo y rey, valdrán 0.5.");
		System.out.println();

		menuPrincipal();
	}

	@Override
	/**
	 * Elije el modo de juego y comienza el juego
	 */
	public void menuPrincipal() {
		String opcion;

		do {
			System.out.println();
			System.out.println("-----MODO JUEGO-----");
			System.out.println(" a. Solitario");
			System.out.println(" b. vs CPU");
			System.out.println(" c. PvP");
			System.out.println("--------------------");
			System.out.println();

			System.out.println("Seleccione el modo de juego elegido: ");
			opcion = sc.nextLine();
			
			if(!opcion.equalsIgnoreCase("a") && !opcion.equalsIgnoreCase("b") && !opcion.equalsIgnoreCase("c")) {
				System.out.println();
				System.out.println("ERROR: Introduzca una opcion válida.");
			}

		} while (!opcion.equalsIgnoreCase("a") && !opcion.equalsIgnoreCase("b") && !opcion.equalsIgnoreCase("c"));

		logicaModoJuego(opcion);

	}

	/**
	 * dependiendo del modo de juego recibido gestiona que debe hacer el programa
	 * 
	 * @param opcion recibe el modo de juego seleccionado
	 */
	private void logicaModoJuego(String opcion) {
		String name1;
		String name2;
		HumanPlayer jugador1;
		HumanPlayer jugador2;
		CPUPlayer cpu;

		this.jugadores = new ArrayList<AbstractPlayer>();

		switch (opcion) {
		case "a":
			System.out.println("Introduce tu nombre: ");
			name1 = sc.nextLine();
			this.mesa = new Mesa();
			jugador1 = new HumanPlayer(name1, this.mesa);
			this.jugadores.add(jugador1);
			start();
			break;

		case "b":
			System.out.println("Introduce tu nombre: ");
			name1 = sc.nextLine();
			this.mesa = new Mesa();
			jugador1 = new HumanPlayer(name1, this.mesa);
			cpu = new CPUPlayer("cpu", this.mesa);
			this.jugadores.add(jugador1);
			this.jugadores.add(cpu);
			start();
			break;

		case "c":
			System.out.println("Introduce nombre jugador1: ");
			name1 = sc.nextLine();
			System.out.println("Introduce nombre jugador2: ");
			name2 = sc.nextLine();
			this.mesa = new Mesa();
			jugador1 = new HumanPlayer(name1, this.mesa);
			jugador2 = new HumanPlayer(name2, this.mesa);
			this.jugadores.add(jugador1);
			this.jugadores.add(jugador2);
			start();
			break;
		}

	}

	@Override
	/**
	 * devuelve siempre null (no usado)
	 */
	public AbstractPlayer nextturno() {
		return null;
	}

	@Override
	public void start() {
		
		if(this.jugadores.size() == 1) {
			logicaPvP();
		} else if (this.jugadores.size() > 1) {
			for (AbstractPlayer a : this.jugadores) {
				if (a.nombre.equals("cpu")) {
					logicaVsCpu();
					break;
				}
			}
			logicaPvP();

		}

	}

	/**
	 * en caso de elegir solitario o PvP se juega el turno de todos los jugadores y
	 * se comprueba su puntuacion final
	 */
	private void logicaPvP() {

		for (AbstractPlayer a : this.jugadores) {
			a.jugarTurno();
		}

		try {

			if (this.jugadores.size() > 1) {

				System.out.println();
				System.out.println("-----PUNTUACION-----");
				System.out.println();

				int campeon = 0;

				for (int i = 0; i < this.jugadores.size(); i++) {
					if (this.jugadores.get(i).puntos > this.jugadores.get(campeon).puntos
							&& this.jugadores.get(i).puntos < 8) {
						campeon = i;
					}
				}

				int count = 0;
				if (this.jugadores.get(campeon).puntos < 8) {
					for (AbstractPlayer c : jugadores) {
						if (c.puntos == this.jugadores.get(campeon).puntos) {
							count++;
						}
					}

					if (count > 1) {
						System.out.println("Habeis ganado " + count + " juagadores con "
								+ this.jugadores.get(campeon).puntos + " puntos.");
						for (AbstractPlayer c : jugadores) {
							if (c.puntos == this.jugadores.get(campeon).puntos) {
								System.out.println("Uno de los ganadores es: " + c.nombre);
							}
						}
					} else {
						System.out.println("El campeón es: " + this.jugadores.get(campeon).nombre + " con "
								+ this.jugadores.get(campeon).puntos + " puntos.");

					}
				} else {
					System.out.println("Todos os habeis pasado de 7.5, no hay ganadores.");
				}
			} else {
				System.out.println();
				if (this.jugadores.get(0).puntos == 7.5) {
					System.out.println("ENHORABUENA: Has conseguido 7.5");
				} else if (this.jugadores.get(0).puntos > 7.5) {
					System.out.println("Has perdido, prueba suerte la próxima");
				} else {
					System.out.println("Bien! has conseguido no pasarte, intenta llegar a 7.5 la próxima!");
				}
			}

			if (!jugarAgain()) {
				finish();
			} else {
				menuPrincipal();
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * en caso de elegir vsCPU se juega el turno del jugador, luego juega el
	 * ordenador y se comprueba su puntuacion final
	 */
	private void logicaVsCpu() {

		for (AbstractPlayer a : this.jugadores) {
			a.jugarTurno();
		}

		try {

			System.out.println();
			System.out.println("-----PUNTUACION-----");
			System.out.println();
			ganador(this.jugadores.get(0).puntos, this.jugadores.get(1).puntos);

			if (!jugarAgain()) {
				finish();
			} else {
				menuPrincipal();
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void ganador(double puntuacion, double puntuacionOrdenador) {

		System.out.println("Puntuacion Jugador: " + puntuacion);
		System.out.println("Puntuacion Ordenador: " + puntuacionOrdenador);
		System.out.println();

		if (puntuacion < 8 && puntuacionOrdenador < 8) {
			if (puntuacion > puntuacionOrdenador) {
				System.out.println("Enhorabuena! Victoria del Jugador!");
			} else if (puntuacionOrdenador > puntuacion) {
				System.out.println("Mala Suerte, Victoria del Ordenador. Suerte en la próxima!");
			} else {
				System.out.println("Ha habido un empate en puntos! Victoria del ordenador. Suerte en la próxima!");
			}

		} else {
			if (puntuacion > 7.5 && puntuacionOrdenador > 7.5) {
				System.out.println(
						"Mala suerte, os habeis pasado ambos de 7 y medio, Victoria del Ordenador. Suerte en la próxima.");
			} else if (puntuacionOrdenador > 7.5) {
				System.out.println("Has tenido suerte, el ordenador se ha pasado de 7 y medio. Victoria del jugador.");
			} else if (puntuacion > 7.5) {
				System.out.println(
						"Te has pasado, intenta no superar 7 y medio la próxima! Victoria del Ordenador. Suerte en la próxima.");
			}
		}
	}

	/**
	 * comprueba si se quiere volver a jugar una partida
	 * 
	 * @return true si se quiere volver a jugar, false si no se quiere volver a
	 *         jugar
	 */
	private static boolean jugarAgain() {
		boolean seguir = true;
		String opcion = "";

		do {
			System.out.println("¿Quieres volver a jugar? (S-N)");
			opcion = sc.nextLine();

			if (opcion.equalsIgnoreCase("N")) {
				System.out.println("De acuerdo, gracias por jugar.");
				seguir = false;
			} else if (opcion.equalsIgnoreCase("S")) {
				System.out.println("De acuerdo, vamos a por otra partida.");
				seguir = true;
			} else {
				System.out.println("ERROR: Debe introducir 'S' si desea otra partida o 'N' si desea dejar de jugar.");
			}

		} while (!opcion.equalsIgnoreCase("S") && !opcion.equalsIgnoreCase("N"));

		return seguir;

	}

}
