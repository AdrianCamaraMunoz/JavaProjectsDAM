package models;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
	private Baraja baraja;
	
	public Mesa() {
		try {
			this.baraja = new Baraja(1, true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Baraja getBaraja() {
		return baraja;
	}
	
	/**
	 * roba una carta de la baraja
	 * @return carta robada
	 */ 
	public Carta robarCartaDeBaraja() {
		return this.baraja.Robar();
	}
	
	/**
	 * roba varias cartas de la baraja
	 * @param n numero de cartas a robar
	 * @return arraylist de cartas robadas
	 */
	public List<Carta> robarVariasCartas(int n){
		ArrayList<Carta> robadas = new ArrayList<Carta>();
		
		for(int i = 0; i < n; i++) {
			robadas.add(this.baraja.Robar());	
		}
		
		return robadas;
	}
	
	/**
	 * añade una carta a la baraja
	 * @param c carta que se quiere añadir
	 */
	public void addCartaABaraja(Carta c) {
		baraja.InsertaCartaFinal(c);
	}

}
