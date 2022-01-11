package models;

public class TipoPokemon {
	//Propiedades
	private String nombre;
	
	//Builder
	public TipoPokemon(String nombre) {
		super();
		this.nombre = nombre;
	}

	
	//Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
