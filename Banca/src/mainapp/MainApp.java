package mainapp;

import models.CuentaCorriente;
import models.Persona;

public class MainApp {
	
	static Persona p1 = new Persona( "manolo", "diaz", "12345678Z", 960, null);
	static Persona p2 = new Persona( "paco", "ramirez", "22345677Z", 1000, null);
	static Persona p3 = new Persona( "Pepe", "lopez", "32345676Z", 1050, null);
	static Persona p4 = new Persona( "Juan", "Jimenez", "42345675Z", 330, null);
	
	static CuentaCorriente c1 = new CuentaCorriente(100, 400, p1);
	static CuentaCorriente c2 = new CuentaCorriente(200, 100, p2);
	static CuentaCorriente c3 = new CuentaCorriente(300, 800, p3);
	static CuentaCorriente c4 = new CuentaCorriente(400, 560, null);

	
	public static void main(String[] args) {
		
		p1.setCuenta(c1);
		p2.setCuenta(c2);
		p3.setCuenta(c3);
		
		System.out.println("Mostrar las personas creadas: ");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println();
		
		System.out.println("Ponemos sueldo a p2 y mostramos si ha subido: ");
		p2.setSueldo(2000);
		System.out.println(p2);
		System.out.println();
		
		System.out.println("Mostrar cuentas creadas: ");
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println();
		
		System.out.println("Asignamos titular a la cuenta 4 y cuenta a la persona 4: ");
		c4.setTitular(p4);
		p4.setCuenta(c4);
		System.out.println(p4);
		System.out.println(c4);
		System.out.println();
		
		System.out.println("Tratamos de sacar mas dinero del que hay en la cuenta1: ");
		System.out.println(c1);
		try {
			p1.sacarPasta(1000);
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println(c1);
		System.out.println();
		
		System.out.println("Sacamos dinero de la cuenta 2 y comprobamos que cambia: ");
		System.out.println(c2);
		try {
			p2.sacarPasta(10);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(c2);
		System.out.println();
		
		System.out.println("c1 antes y despues de cobrar: ");
		System.out.println(c1);
		p1.cobrarSueldo();
		System.out.println(c1);
		System.out.println();
		
		System.out.println("intentamos subir el sueldo de c4 a uno menor: ");
		System.out.println(c4);
		try {
			p4.subirSueldo(5);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(c4);
		System.out.println();
		
		System.out.println("c1 antes y despues de subir sueldo y cobrar: ");
		System.out.println(c2);
		try {
			p2.subirSueldo(1500);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		p2.cobrarSueldo();
		System.out.println(c2);
		System.out.println();
		
		System.out.println("Aumentamos saldo de la cuenta 3");
		System.out.println(c3);
		try {
			c3.SumarCantidad(50);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(c3);
		System.out.println();
		
		System.out.println("tratamos de restar mas dinero del que hay de la cuenta 4");
		System.out.println(c4);
		try {
			c4.restarCantidad(1000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(c4);
		System.out.println();
		
		System.out.println("Restamos saldo de la cuenta 4");
		System.out.println(c4);
		try {
			c4.restarCantidad(50);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(c4);
		System.out.println();
		
		
		
	}
}
