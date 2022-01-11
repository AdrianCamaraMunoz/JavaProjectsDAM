package models;

import java.util.ArrayList;

public class Equipo {
	//Propiedades
	protected ArrayList<Pokemon> equipo;
	private Entrenador entrenador;
	
	//Builder
	public Equipo() {
		equipo = new ArrayList<Pokemon>();
	}
	
	//Getters y Setters
	public ArrayList<Pokemon> getEquipo() {
		return equipo;
	}

	public void setEquipo(ArrayList<Pokemon> equipo) {
		this.equipo = equipo;
	}

	public Entrenador getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}

	//Methods
	/**
	 * muestra por pantalla el numero de Pokemons que quedan en el equipo
	 */
	public void getNumeroPokemons() {
		System.out.println(equipo.size());

	}

	/**
	 * comprueba si a al equipo le queda algun Pokemon
	 * @return true si está vacío, false si le quedan Pokemons
	 */
	public boolean isVacio() {
		if (equipo.size() < 0) {
			return true;
		} else {
			return false;
		}
	}

	
	

}
