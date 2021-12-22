package mainapp;

import java.util.ArrayList;
import java.util.Scanner;

import models.CuentaCorriente;
import models.Persona;

public class MainAppMenu {
	static Persona p1 = new Persona( "manolo", "diaz", "12345678Z", 960, null);
	static Persona p2 = new Persona( "paco", "ramirez", "22345677Z", 1000, null);
	static Persona p3 = new Persona( "Pepe", "lopez", "32345676Z", 1050, null);
	
	static CuentaCorriente c1 = new CuentaCorriente(1, 400, p1);
	static CuentaCorriente c2 = new CuentaCorriente(2, 100, p2);
	static CuentaCorriente c3 = new CuentaCorriente(3, 800, p3);
	
	static Scanner sc = new Scanner(System.in);
	
	static ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
	static ArrayList<CuentaCorriente> listaCuentas = new ArrayList<CuentaCorriente>();
	
	public static void main(String[] args) {
		
		String opcion;
		do {
			opcion = showMenu();
			
			if(!opcion.equals("d")) {
				menuLogic(opcion);
			}else {
				System.out.println("Gracias por usar nuestros servicios, Hasta pronto. \n");
				System.exit(0);
			}
			
		}while(!opcion.equals("d"));
		
	}
	
	/**
	 * Muestra el menu principal del programa y pide que opcion se quiere realizar
	 * @return Opcion elegida por el usuario
	 */
	public static String showMenu() {
		String opc = null;
		do {
			System.out.println();
			System.out.println("----------MENU----------");
			System.out.println("a.- Añadir Persona");
			System.out.println("b.- Elegir Persona");
			System.out.println("c.- Borrar Persona");
			System.out.println("d.- Salir \n");
			System.out.println("Introduzca la opcion que desee efectuar.");
			
			opc = sc.nextLine();
			
		}while(!opc.equals("a") && !opc.equals("b") && !opc.equals("c") && !opc.equals("d"));
				
		return opc;
	}
	
	/**
	 * Controla los diferentes casos dependiendo de la opcion elegida por el usuario.
	 * @param String opcion Opcion del menu que ha elegido el usuario.
	 */
	private static void menuLogic(String opcion) {
		switch(opcion) {
		case "a":
			try {
				addPersona();
				addCuenta();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "b":
			if(listaPersonas.size()>0) {
				opcion = showSubmenu();
				try {
					subMenuLogic(opcion);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}else {
				System.out.println("No hay personas en el sistema.");
			}
			break;
		case "c":
			if(listaPersonas.size()>0) {
				try {
					deletePersona();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}else {
			System.out.println("No hay personas en el sistema.");
		}
			break;
		}
		
	}
	
	/**
	 * Añade una persona nueva a la lista
	 * @throws Exception Si la persona que se quiere crear ya existe o si el sueldo no es un numero o no es mayor a 0
	 */
	private static void addPersona() throws Exception {
		
		boolean esNumero = true;
		
		System.out.println("Introduce Nombre: ");
		String nombre = sc.nextLine();
		System.out.println("Introduce Apellidos: ");
		String apellidos = sc.nextLine();
		System.out.println("Introduce DNI: ");
		String dni = sc.nextLine();
		double sueldo = -1;
		
		do {
			try {
				System.out.println("Introduce Sueldo: ");
				sueldo = Double.parseDouble(sc.nextLine());
				if(sueldo <= 0) {
					esNumero = false;
				}
			}catch(Exception e) {
				esNumero = false;
				throw new Exception("El sueldo debe ser un numero y debe ser mayor a 0");
			}
		}while(!esNumero);
		
		if(!existPersona(dni)) {
			listaPersonas.add(new Persona(nombre, apellidos, dni, sueldo));
			System.out.println("La persona ha sido añadida correctamente. ");
			
		}else {
			throw new Exception("La persona ya existe.");
		}
		
	}
	
	/**
	 * Crea una cuenta nueva a la lista para la persona creada y le asigna su titular
	 */
	private static void addCuenta() {
		int i = listaCuentas.size(); //ultima cuenta creada para que la nueva sea un numero de cuenta superior.
		Persona titular = listaPersonas.get(listaPersonas.size() - 1); //titular será la ultima persona creada.
		listaCuentas.add(new CuentaCorriente(i+1, titular));	
		CuentaCorriente cuenta = listaCuentas.get(i);
		titular.setCuenta(cuenta);
		
		System.out.println("La persona ha sido creada y se le ha asignado una cuenta nueva correctamente.");
	}
	
	/**
	 * Borrar una persona de la lista.
	 */
	private static void deletePersona(){
		
		try {
			listaPersonas.remove(elegirPersona());
			System.out.println("La persona ha sido borrada correctamente.");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	/**
	 * Comprueba que la persona buscada por su dni existe en la lista
	 * @param dni String con el dni de la persona buscada
	 * @return True si la persona existe, False si no existe
	 */
	private static boolean existPersona(String dni) {
		for(Persona p : listaPersonas) {
			if(dni.equals(p.getDni())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Muestra el subMenu de la opcion B del menu principal
	 * @return String con la opcion elegida por el usuario
	 */
	private static String showSubmenu() {
		String opc = null;
		do {
			System.out.println();
			System.out.println("----------MENU----------");
			System.out.println("I.- Cobrar Sueldo");
			System.out.println("II.- Sacar Pasta");
			System.out.println("III.- Subir Sueldo");
			System.out.println("IV.- Mostrar detalles de la Persona");
			System.out.println("V.- Volver \n");
			System.out.println("Introduzca la opcion que desee efectuar.");
			
			opc = sc.nextLine();
			
		}while(!opc.equals("I") && !opc.equals("II") && !opc.equals("III") && !opc.equals("IV") && !opc.equals("V"));	
		
		return opc;
	}
	
	/**
	 * Controla los diferentes casos dependiendo de la opcion elegida por el usuario.
	 * @param opcion String con la opcion elegida por el usuario 
	 */
	private static void subMenuLogic(String opcion){
		int numPersona;
		if(opcion.equals("V")) {
			showMenu();
			
		}else{
			try {
				numPersona = elegirPersona();
				Persona p = listaPersonas.get(numPersona);
				switch(opcion) {
				case "I":
					p.cobrarSueldo();
					System.out.println("El sueldo ha sido cobrado.");
					break;
				case "II":
					sacarDinero(p);
					break;
				case "III":
					subirSueldo(p);
					break;
				case "IV":
					System.out.println(listaPersonas.get(numPersona));
					break;
				}	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * Sube el sueldo de una persona
	 * @param p Persona a la que subir el sueldo
	 * @throws Exception Si el sueldo que se quiere asignar es menor a 0
	 */
	private static void subirSueldo(Persona p) throws Exception  {
		double cantidad = -1;
		
		do {
			System.out.println("Introduzca el sueldo que desea asignar a la persona elegida: ");
			cantidad = Double.parseDouble(sc.nextLine());
			
			if(cantidad < 0) {
				throw new Exception("No se puede poner un sueldo menor a 0.");
			}else {
				
				try {
					p.subirSueldo(cantidad);
					System.out.println("El sueldo ha sido actualizado.");
					
				}catch(Exception e) {
					cantidad = -1;	//para que vuelva a pedir la cantidad si ha introducido un sueldo menor al de la persona.
					System.out.println(e.getMessage());
				}
			}
			
		
			
		}while(cantidad < 0);
	}
	
	/**
	 * Saca dinero de la cuenta de una persona
	 * @param Persona de la que se quiere comprobar su cuenta para sacar dinero
	 * @throws Exception La cantidad que se quiere sacar no puede ser menor a 0
	 */
	private static void sacarDinero(Persona p) throws Exception {
		double cantidad = -1;
		
		do {
			System.out.println("Introduzca la cantidad que desea sacar de la cuenta: ");
			cantidad = Double.parseDouble(sc.nextLine());
			if(cantidad < 0) {
				throw new Exception("No se puede sacar una cantidad de dinero menor a 0.");
			}else {
				try {
					p.sacarPasta(cantidad);
					System.out.println("La pasta ha sido sacada de su cuenta.");
					
				}catch(Exception e) {
					cantidad = -1;	//para que vuelva a pedir la cantidad si ha introducido una mayor al saldo de la cuenta.
					System.out.println(e.getMessage());
				}
			}
			
		}while(cantidad < 0);
		
	}
	
	/**
	 * Elije una persona para poder trabajar con ella y su cuenta
	 * @return Posicion de la persona en la lista
	 * @throws Exception Si la persona no existe
	 */
	private static int elegirPersona() throws Exception {
		int contador = 1;
		int num = -1;
		
		for(Persona p : listaPersonas) {
			System.out.println(contador + "- " + p.mostrarPersona());
			contador++;
		}
		
		do {
			System.out.println();
			System.out.println("Introduce el numero de la persona que deseas elegir: ");
			num = Integer.parseInt(sc.nextLine());
			
			if(num > contador) {
				throw new Exception("La persona indicada no existe.");
			}else {
				System.out.println("La persona ha sido seleccionada correctamente.");
			}
			
		}while(num > contador);
		
		return (num-1);
	}

}
