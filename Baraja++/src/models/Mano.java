package models;

import java.util.Scanner;

public class Mano extends Baraja {

	public Baraja mano;
	
	public Mano() {
		super();
	}
	
	/**
	 * muestra la mano de cartas
	 */
	public void listarCartas() {
		for(Carta c : this.lista_cartas) {
			System.out.println(c);
		}
	}
	
	/**
	 * selecciona una carta de la mano mostrada
	 * @return devuelve la carta elegida
	 */
	public Carta elegirCarta() {
		Scanner sc = new Scanner(System.in);
		boolean esCarta = false;
		Carta elegida;

		do {
			listarCartas();
			System.out.println("Introduce el numero que quieres elgir: ");
			int numelegido = Integer.parseInt(sc.nextLine());
			System.out.println("Introduce el palo de la carta que quieres elegir: ");
			int paloelegido = Integer.parseInt(sc.nextLine());

			elegida = new Carta(numelegido, paloelegido);

			for (int i = 0; i < this.lista_cartas.size(); i++) {
				if (elegida.equals(lista_cartas.get(i))) {
					esCarta = true;
				}
			}
			
			if(!esCarta) {
				System.out.println("Carta no encontrada en la mano, introduzca una válida: ");
			}
		} while (!esCarta);
		
		sc.close();
		return elegida;
	}
}
