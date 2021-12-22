package models;

public class Carta {
	
	//Properties
	private int numero;	//1-7, 8=sota, 9=caballo, 10=rey
	private int palo;	//0=oros, 1=copas, 2=espadas, 3=bastos
	
	//Builders
	
	/**
	 * crea una carta nueva recibiendo su numero y palo
	 * @param numero numero de la carta a crear(1-7, 8=sota, 9=caballo, 10=rey)
	 * @param palo palo de la carta a crear (0=oros, 1=copas, 2=espadas, 3=bastos)
	 */ 
	public Carta(int numero, int palo) {
		this.numero = numero;
		this.palo = palo;
	}
	
	/**
	 * crea una carta nueva recibiendo un identificador
	 * @param id identificador de la carta a crear (1-10 oros, 11-20 copas, 12-30 espadas, 31-40 bastos)
	 */
	public Carta(int id) {
		palo = ((id-1)/10);
		numero = (id - (palo*10));
	}
	
	//Methods
	public int getId() {
		return (numero+(palo*10));
	}
	
	public int getNumero() {
		return numero;
	}
	
	public int getPalo() {
		return palo;
	}
	
	public String getNombreNumero() {
		String nombre = "";
		
		switch(numero) {
		case 1:
			 nombre = "as";
			break;
		case 2:
			nombre = "dos";
			break;
		case 3:
			nombre = "tres";
			break;
		case 4:
			nombre = "cuatro";
			break;
		case 5:
			nombre = "cinco";
			break;
		case 6:
			nombre = "seis";
			break;
		case 7:
			nombre = "siete";
			break;
		case 8:
			nombre = "sota";
			break;
		case 9:
			nombre = "caballo";
			break;
		case 10:
			nombre = "rey";
			break;
		}
		
		return nombre;
	}
	
	public String getNombrePalo() {
		String nombre = "";
		
		switch(palo) {
		case 0:
			nombre = "oros";
			break;
		case 1:
			nombre = "copas";
			break;
		case 2:
			nombre = "espadas";
			break;
		case 3:
			nombre = "bastos";
			break;
		}
		
		return nombre;
	}
	
	public String getNombreCarta() {
		return (getNombreCarta() + " de " + getNombrePalo());
	}
	
	public int getValorTute() {
		int valor = 0;
		
		switch(numero) {
		case 1,2:
			valor = 1;
			break;
		case 3, 8, 9, 10:
			valor = 10;
			break;
		default:
			valor = numero;
			break;
		}
		
		return valor;
	}
	
	public double getValor7ymedia() {
		double valor = 0;
		
		switch(numero) {
		case 8, 9, 10:
			valor = 0.5;
			break;
		default:
			valor = numero;
			break;
		}
		
		return valor;
	}
	
	//String
	public String toString() {
		
		return "" + getNombreNumero() + " de " + getNombrePalo() + "";
	}
	
	
}
