package models;

public class Usuario {
	//Propiedades
	protected String username;
	protected String passwd;
	
	//Builders
	
	/**
	 * Constructor del usuario
	 * @param username Nombre del usuario
	 * @param passwd Contraseña del usuario
	 */
	public Usuario(String username, String passwd) {
		super();
		this.username = username;
		this.passwd = passwd;
	}
	
	//Getters y Setters
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	
}
