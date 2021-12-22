package models;

import java.util.ArrayList;
import java.util.Collections;

public class Baraja {
	private ArrayList<Carta> lista_cartas;
	
	
	//Builders
	public Baraja() {
		lista_cartas = new ArrayList<Carta>();
	}
	
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
	public void Barajar(){
//		ArrayList<Carta> new_baraja = new ArrayList<Carta>(lista_cartas.size());
//		
//		for(Carta c: lista_cartas) {
//			int num = (int) (Math.random()*lista_cartas.size()-1);
//				
//			new_baraja.add(num, c);
//			lista_cartas.remove(num);
//		
//		}
//		return new_baraja;
		
		Collections.shuffle(lista_cartas);

	}
	
	public void Cortar(int posicion){
		
		for(int i = 0; i < posicion; i++) {
			lista_cartas.add(lista_cartas.get(0));
			lista_cartas.remove(lista_cartas.get(0));
		}
	}

	public Carta Robar() {
		Carta robada = lista_cartas.get(0);
		lista_cartas.remove(0);
		return robada;
	}
	
	public void InsertaCartaFinal (int id) {
		lista_cartas.add(new Carta (id));
	}
	
	public void InsertarCartaPrincipio(int id) {
		lista_cartas.add(0, new Carta(id));
	}
	
	public void InsertaCartaFinal(Carta carta) {
		lista_cartas.add(carta);
	}
	
	public void InsertaCartaPrincipio(Carta carta) {
		lista_cartas.add(0, carta);
	}
	
	public void getNumeroCartas() {
		System.out.println(lista_cartas.size());

	}

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
