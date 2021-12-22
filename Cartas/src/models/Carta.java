package models;

public class Carta {
	private int numero;	//1-7, 8=sota, 9=caballo, 10=rey
	private int palo;	//0=oros, 1=copas, 2=espadas, 3=bastos
	
	//Builders
	public Carta(int numero, int palo) {
		this.numero = numero;
		this.palo = palo;
	}
	
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
