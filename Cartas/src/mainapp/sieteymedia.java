package mainapp;

import java.util.Scanner;

import models.Baraja;
import models.Carta;

public class sieteymedia {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			boolean play = true;

			do {
				Baraja mazo = new Baraja(1, true);

				Carta carta;

				double puntuacion = 0;
				boolean repeat = true;

				do {
					if (seguir()) {
						carta = mazo.Robar();
						System.out.println("Tu carta robada es: " + carta);
						puntuacion += carta.getValor7ymedia();
						int c = comprobarPuntos(puntuacion);
						if (c == 1 || c == 2) {
							repeat = false;
						}

					} else {
						repeat = false;
					}

				} while (repeat);

				if (puntuacion > 0) {
					System.out.println("Tu puntuación final es: " + puntuacion);
				}

				if (!jugarAgain()) {
					play = false;
				}

			} while (play);

			System.exit(0);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static int comprobarPuntos(double puntuacion) {

		if (puntuacion == 7.5) {
			System.out.println("Ganaste wey");
			return 2;
		} else if (puntuacion > 7.5) {
			System.out.println("Perdiste wey");
			return 1;
		} else {
			System.out.println("Tu puntuacion actual es: " + puntuacion);
		}

		return 0;
	}

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
				System.out.println("De acuerdo, vamos a por otra carta.");
				seguir = true;
			} else {
				System.out.println("ERROR: Debe introducir 'S' si desea otra carta o 'N' si desea plantarse.");
			}

		} while (!opcion.equalsIgnoreCase("S") && !opcion.equalsIgnoreCase("N"));

		return seguir;

	}

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
