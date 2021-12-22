package models;

public abstract class AbstractPlayer {
	
	protected String nombre;
	protected double puntos;
	
	protected Mano mano;
	protected Mesa mesa;
	
	public AbstractPlayer(String nombre, Mesa mesa) {
		super();
		this.nombre = nombre;
		this.mano = new Mano();
		this.mesa = mesa;
		this.puntos = 0;
	}
	
	abstract void jugarTurno();
}
