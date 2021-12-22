package mainapp;

import java.util.Scanner;

import models.Sieteymedia;

public class MainApp {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		boolean repetir = true;

		do {
			String opcion = menu();
			System.out.println();

			logicaMenu(opcion);

			repetir = volverAJugar();
			
			if(repetir == true) {
				repetir = true;
			}else {
				repetir = false;
				System.out.println("Gracias por usar nuestro programa!");
			}
			
		} while (repetir);
		
		System.exit(0);

	}
	
	/**
	 * pregunta al usuario si quiere jugar otra partida
	 * @return true si quiere jugar otra partida, false si quiere dejar de jugar
	 */
	private static boolean volverAJugar() {
		String repetir;
		do {
			System.out.println("¿Quieres jugar a otro juego? (S-N)");
			repetir = sc.nextLine();
			
			if(!repetir.equalsIgnoreCase("S") && !repetir.equalsIgnoreCase("N")) {
				System.out.println("ERROR: Introduzca S o N para saber si quiere jugar a otro juego o desea Salir.");
			}
			
		}while(!repetir.equalsIgnoreCase("S") && !repetir.equalsIgnoreCase("N"));
		
		if(repetir.equalsIgnoreCase("S")) {
			return true;
		}else {
			return false;
		}
				
	}

	/**
	 * istancia al juego que quiera jugar el usuario o cierra el programa si quiere salir
	 * @param opcion juego elegido por el usuario
	 */
	private static void logicaMenu(String opcion) {

		if (opcion.equalsIgnoreCase("a")) {
			Sieteymedia sieteymedia = new Sieteymedia();
			sieteymedia.bienvenida();

		} else if (opcion.equalsIgnoreCase("b")) {
			System.out.println("Gracias por usar nuestro programa!");
			System.exit(0);
		}
	}
	
	/**
	 * Menu con los posibles juegos a los que se puede jugar
	 * @return opcion elegida por el usuario
	 */
	public static String menu() {
		System.out.println();
		System.out.println("--------MENU--------");
		System.out.println(" a. 7 y Media");
		System.out.println(" b. Salir");
		System.out.println("--------------------");
		System.out.println();

		System.out.println("¿A que quieres jugar?");
		return sc.nextLine();
	}
}
