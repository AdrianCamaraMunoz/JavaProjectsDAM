package models;

import java.util.ArrayList;
import enums.ModoJuego;

public abstract class AbstractGame {
	protected boolean finished;
	protected ModoJuego modo;
	protected ArrayList<AbstractPlayer> jugadores;
	protected Mesa mesa;
	protected int ronda;
	
	public abstract void bienvenida();
	
	public abstract void menuPrincipal();
	
	public abstract AbstractPlayer nextturno();
	
	public abstract void start();
	 
	public void barajar() {
		
	}
	
	/**
	 * limpia la mano de los jugadores y limpia la baraja utilizada.
	 */
	public void finish() {
		
		for(AbstractPlayer j : jugadores) {
			j.mano.lista_cartas.clear();
		}
		
		mesa.getBaraja().lista_cartas.clear();
	}

}
