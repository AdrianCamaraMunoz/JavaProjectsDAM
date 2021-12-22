package mainapp;

import java.util.Scanner;

import models.Baraja;
import models.Carta;

public class MainApp {

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
					System.out.println();
					System.out.println("----------TURNO JUGADOR----------");
					System.out.println();
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
				
				System.out.println();
				System.out.println("----------TURNO ORDENADOR----------");
				System.out.println();
				double puntuacionOrdenador = jugarOrdenador(mazo);
				
				if (puntuacionOrdenador > 0) {
					System.out.println("La puntuación final del ordenador es: " + puntuacionOrdenador);
				}
				
				
				System.out.println();
				System.out.println("----------PUNTUACION----------");
				System.out.println();
				ganador(puntuacion, puntuacionOrdenador);

				if (!jugarAgain()) {
					play = false;
				}

			} while (play);

			System.exit(0);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void ganador(double puntuacion, double puntuacionOrdenador) {
		
		System.out.println("Puntuacion Jugador: " + puntuacion);
		System.out.println("Puntuacion Ordenador: " + puntuacionOrdenador);
		System.out.println();
		
		if(puntuacion < 8 && puntuacionOrdenador < 8) {
			if(puntuacion > puntuacionOrdenador) {
				System.out.println("Enhorabuena! Victoria del Jugador!");
			}else if (puntuacionOrdenador > puntuacion) {
				System.out.println("Mala Suerte, Victoria del Ordenador. Suerte en la próxima!");
			}else {
				System.out.println("Ha habido un empate en puntos! Victoria del ordenador. Suerte en la próxima!");
			}
			
		}else {
			if(puntuacion > 7.5 && puntuacionOrdenador > 7.5){
				System.out.println("Mala suerte, os habeis pasado ambos de 7 y medio, Victoria del Ordenador. Suerte en la próxima.");
			}else if(puntuacionOrdenador > 7.5) {
				System.out.println("Has tenido suerte, el ordenador se ha pasado de 7 y medio. Victoria del jugador.");
			}else if(puntuacion > 7.5) {
				System.out.println("Te has pasado, intenta no superar 7 y medio la próxima! Victoria del Ordenador. Suerte en la próxima.");
			}
		}
	}

	private static double jugarOrdenador(Baraja mazo) {
		double puntuacion = 0;
		Carta carta;
		boolean repeat = true;

		if (puntuacion <= 5) {
			do {
				carta = mazo.Robar();
				System.out.println("Tu carta robada es: " + carta);
				puntuacion += carta.getValor7ymedia();
				int c = comprobarPuntos(puntuacion);
				if (c == 1 || c == 2) {
					repeat = false;
				}
				
			} while (repeat);
		}else {
			repeat = false;
		}
		
		return puntuacion;
	}

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
