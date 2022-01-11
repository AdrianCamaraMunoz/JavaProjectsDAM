package models;

public class Entrenador {
	//Propiedades
	private String nombre;
	private Equipo equipo;
	
	//Builder
	public Entrenador(String nombre) {
		super();
		this.nombre = nombre;
		this.equipo = null;
	}

	public Entrenador(String nombre, Equipo equipo) {
		super();
		this.nombre = nombre;
		this.equipo = equipo;
	}
	
	//Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}


	
	
	
}
