package models;

import java.util.ArrayList;
import java.util.Collections;

public class Baraja {
	
	//Properties
	protected ArrayList<Carta> lista_cartas;
	
	
	//Builders
	
	/**
	 * crea una baraja vacia
	 */
	public Baraja() {
		lista_cartas = new ArrayList<Carta>();
	}
	
	/**
	 * crea una baraja de 40 u 80 cartas segun se le indique
	 * @param tipobaraja 1 para crear baraja de 40 cartas y 2 para crear baraja de 80 cartas
	 * @throws Exception se introduce un valor distinto de 1 o 2
	 */
	public Baraja(int tipobaraja) throws Exception {
		
		switch(tipobaraja) {
		case 1:
			lista_cartas = new ArrayList<Carta>();
			for(int i = 1; i <= 40; i++) {
				lista_cartas.add(new Carta(i));
			}
			break;
		case 2:
			lista_cartas = new ArrayList<Carta>();
			for(int i = 0; i < 2; i++) {
				for(int j = 1; j <= 40; j++) {
					lista_cartas.add(new Carta(j));
				}
			}
			break;
		default:
			throw new Exception("ERROR: Tipo de baraja no conocido.");
		}
		
	}
	
	/**
	 * Crea una baraja de 40 u 80 cartas segun se le indique y además la baraja
	 * @param tipobaraja tipobaraja 1 para crear baraja de 40 cartas y 2 para crear baraja de 80 cartas
	 * @param barajar true si se quiere barajar, false si no.
	 * @throws Exception Exception se introduce un valor distinto de 1 o 2
	 */
	public Baraja(int tipobaraja, boolean barajar) throws Exception {		
		switch(tipobaraja) {
		case 1:
			lista_cartas = new ArrayList<Carta>();
			for(int i = 1; i <= 40; i++) {
				lista_cartas.add(new Carta(i));
			}
			break;
		case 2:
			lista_cartas = new ArrayList<Carta>();
			for(int i = 0; i < 2; i++) {
				for(int j = 1; j <= 40; j++) {
					lista_cartas.add(new Carta(j));
				}
			}
			break;
		default:
			throw new Exception("ERROR: Tipo de baraja no conocido.");
		}
		
		if(barajar) {
			Barajar();
		}
		
	}
	
	//Methods
	
	/**
	 * reordena la baraja
	 */
	public void Barajar(){		
		Collections.shuffle(lista_cartas);

	}
	
	/**
	 * corta la baraja por la posicion indicada
	 * @param posicion posicion de la baraja por la cual se quiere cortar
	 */
	public void Cortar(int posicion){
		
		for(int i = 0; i < posicion; i++) {
			lista_cartas.add(lista_cartas.get(0));
			lista_cartas.remove(lista_cartas.get(0));
		}
	}

	/**
	 * roba una carta de la baraja
	 * @return carta robada
	 */
	public Carta Robar() {
		Carta robada = lista_cartas.get(0);
		lista_cartas.remove(0);
		return robada;
	}
	
	/**
	 * inserta una carta al final de la baraja
	 * @param id id de la carta a insertar
	 */
	public void InsertaCartaFinal (int id) {
		lista_cartas.add(new Carta (id));
	}
	
	/**
	 * inserta una carta al principio de la baraja
	 * @param id id de la carta a insertar
	 */
	public void InsertarCartaPrincipio(int id) {
		lista_cartas.add(0, new Carta(id));
	}
	
	/**
	 * inserta una carta al final de la baraja
	 * @param c carta a insertar
	 */
	public void InsertaCartaFinal(Carta c) {
		lista_cartas.add(c);
	}
	
	/**
	 * inserta una carta al principio de la baraja
	 * @param c carta a insertar
	 */
	public void InsertaCartaPrincipio(Carta c) {
		lista_cartas.add(0, c);
	}
	
	/**
	 * muestra por pantalla el numero de cartas que quedan en la baraja
	 */
	public void getNumeroCartas() {
		System.out.println(lista_cartas.size());

	}

	/**
	 * comprueba si a la baraja le queda alguna carta
	 * @return true si está vacía, false si le quedan cartas
	 */
	public boolean isVacia() {
		if (lista_cartas.size() < 0) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "Baraja [lista_cartas=" + lista_cartas + "]";
	}
	
	
	
}
