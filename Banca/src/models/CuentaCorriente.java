package models;

public class CuentaCorriente {
	//Properties
	private int numeroCuenta;
	private double saldo;
	private Persona titular;
	
	//Builders
	public CuentaCorriente(int numeroCuenta, double saldo, Persona titular) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
		this.titular = titular;
	}
	
	public CuentaCorriente(int numeroCuenta, Persona titular) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.saldo = 0;
		this.titular = titular;
	}
	
	//Getters
	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	public Persona getTitular() {
		return titular;
	}
	
	//Setters
	public void setTitular(Persona titular) {
		this.titular = titular;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	//Methods
	public void SumarCantidad(double cantidad) throws Exception {
		if(saldo < 0) {
			throw new Exception("No se puede añadir una cantidad negativa.");
		}else{
			saldo += cantidad;
		}
	}
	
	public void restarCantidad(double cantidad) throws Exception {
		if(saldo < 0) {
			throw new Exception("No se puede restar una cantidad negativa.");
		}else if(cantidad > saldo){
			throw new Exception("No se puede sacar una cantidad mayor al saldo de la que hay.");
		}else {
			saldo -= cantidad;
		}
	}

	@Override
	public String toString() {
		return "CuentaCorriente [numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + ", titular=" + titular + "]";
	}
	
	
	
	
	
	
}
