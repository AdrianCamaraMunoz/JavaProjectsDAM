package models;

import java.util.Scanner;

public class HumanPlayer extends AbstractPlayer {

	public HumanPlayer(String nombre, Mesa mesa) {
		super(nombre, mesa);
	}
	
	static Scanner sc = new Scanner (System.in);

	@Override
	/**
	 * partida a 7ymedio de un jugador
	 */
	void jugarTurno() {	
		boolean repeat = true;
		Carta carta;
		
		do {
			repeat = true;
			System.out.println();
			System.out.println("----------TURNO " + this.nombre.toUpperCase() + "----------");
			System.out.println();
			if (seguir()) {
				carta = mesa.getBaraja().Robar();
				mano.InsertaCartaFinal(carta);
				System.out.println("Tu carta robada es: " + carta);
				this.puntos += carta.getValor7ymedia();
				int c = comprobarPuntos(this.puntos);
				if (c == 1 || c == 2) {
					repeat = false;
				}

			} else {
				repeat = false;
			}

		} while (repeat);

		if (this.puntos > 0) {
			System.out.println("Tu puntuación final es: " + this.puntos);
		}
	}
	
	/**
	 * pregunta al usuario si quiere robar una nueva carta
	 * @return true si quiere seguir jugando, false si quiere plantarse
	 */
	private static boolean seguir() {
		boolean seguir = true;
		String opcion = "";

		do {
			System.out.println("¿Quieres una carta? (S-N)");
			opcion = sc.nextLine();

			if (opcion.equalsIgnoreCase("N")) {
				System.out.println("De acuerdo, gracias por jugar.");
				seguir = false;
			} else if (opcion.equalsIgnoreCase("S")) {
				System.out.println("De acuerdo, vamos a por una carta.");
				seguir = true;
			} else {
				System.out.println("ERROR: Debe introducir 'S' si desea otra carta o 'N' si desea plantarse.");
			}

		} while (!opcion.equalsIgnoreCase("S") && !opcion.equalsIgnoreCase("N"));

		return seguir;

	}
	
	/**
	 * comprueba si los puntos obtenidos se han pasado de 7.5, ha acertado 7.5 o es menor a 7.5
	 * @param puntuacion puntuacion actual del jugador
	 * @return devuelve 0 si puede seguir jugando, 1 si se ha pasado de 7.5 y 2 si ha conseguido 7.5 exacto
	 */
	private static int comprobarPuntos(double puntuacion) {

		if (puntuacion == 7.5) {
			System.out.println("Maxima Puntuacion! 7 y medio!");
			return 2;
		} else if (puntuacion > 7.5) {
			System.out.println("Te pasaste wey");
			return 1;
		} else {
			System.out.println("Puntuacion actual: " + puntuacion);
		}

		return 0;
	}


}
