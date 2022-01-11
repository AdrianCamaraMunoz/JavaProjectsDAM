package models;

public class TipoClase {
	// Propiedades
	private String nombre;

	// Builder
	public TipoClase(String nombre) {
		super();
		this.nombre = nombre;
	}

	// Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
