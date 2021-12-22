package models;

public class Persona {
	
	//Properties
	private String nombre;
	private String apellidos;
	private String dni;
	private double sueldo;
	private CuentaCorriente cuenta;
	
	//Builder
	public Persona(String nombre, String apellidos, String dni, double sueldo, CuentaCorriente cuenta) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.sueldo = sueldo;
		this.cuenta = cuenta;
	}
	
	public Persona(String nombre, String apellidos, String dni, double sueldo) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.sueldo = sueldo;
		this.cuenta = null;
	}
	
	//Getters
	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getDni() {
		return dni;
	}

	public double getSueldo() {
		return sueldo;
	}
	
	public CuentaCorriente getCuenta() {
		return cuenta;
	}

	//Setters
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	
	public void setCuenta(CuentaCorriente cuenta) {
		this.cuenta = cuenta;
	}
	
	//Methods
	public void cobrarSueldo() {
		cuenta.setSaldo(cuenta.getSaldo()+sueldo);
	}
	
	public void sacarPasta( double cantidad) throws Exception {
		if(cuenta.getSaldo() >= cantidad) {
			cuenta.setSaldo(cuenta.getSaldo() - cantidad);
		}else {
			throw new Exception("ERROR: No se puede sacar tal cantidad ya que no tienes suficiente saldo");
		}
	}
	
	public void subirSueldo(double cantidad) throws Exception {
		if(cantidad <= sueldo) {
			throw new Exception("El sueldo existente es mayor al que quieres poner.");
		}else {
			sueldo = cantidad;
		}
		
	}
	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", sueldo=" + sueldo + ", NºCuenta=" + cuenta.getNumeroCuenta() + ", saldo=" + cuenta.getSaldo() + "]";
	}
	
	public String mostrarPersona() {
		return "[nombre=" + nombre + ", dni=" + dni + "]";
	}
	
	
	
	
	
	
	
}
