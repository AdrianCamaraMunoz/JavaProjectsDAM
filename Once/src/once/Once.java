package once;

import java.util.Scanner;

public class Once {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double premio = 0;
		String premiado = "";
		String repeat = "";
		boolean otraVez = false;
		boolean esNumero = true;
		
		// premio aleatorio 5 digitos
		do {
			
			for (int i = 0; i < 5; i++) {
				int n = (int) (Math.random() * 10);
	
				premiado = premiado + String.valueOf(n);
			}
	
			// leer num 5 digitos
			String boleto = "0";
	
			do {
				System.out.println("Introduce tu número de boleto: ");
				boleto = sc.nextLine();
				esNumero = true;
	
				if (boleto.length() != 5) {
					System.out.println("ERROR: El número introducido debe ser de 5 cifras.");
				}
				
				try {
					Integer.parseInt(boleto);
				}catch (Exception e) {
					esNumero = false;
					System.out.println("ERROR: formato de numero no reconocible.");
				}
	
			} while (!esNumero || boleto.length() != 5);
	
			// comparar numeros
			// ultima cifra 1.5€
			if (boleto.charAt(4) == premiado.charAt(4)) {
				premio = 1.5;
	
				// 2 ultimas 6€
	
				if (boleto.charAt(3) == premiado.charAt(3)) {
					premio = 6;
	
					// 3 ultimas 20€
	
					if (boleto.charAt(2) == premiado.charAt(2)) {
						premio = 20;
	
						// 4 ultimas 200€
	
						if (boleto.charAt(1) == premiado.charAt(1)) {
							premio = 200;
	
							// num entero 35000€
	
							if (boleto.charAt(0) == premiado.charAt(0)) {
								premio = 35000;
							}
						}
					}
				}
	
				System.out.println("Su premio es de " + premio);
	
			} else if (boleto.charAt(0) == premiado.charAt(0)) {
				// primera cifra 1.5€
	
				premio = 1.5;
				System.out.println("Su premio es de " + premio);
	
			} else {
				System.out.println("No tiene premio.");
			}
			
			do {
				System.out.println("¿Desea jugar de nuevo? (S-N)");
				repeat = sc.nextLine();
				
				if(repeat.equals("S")){
					otraVez = true;
				}else if (repeat.equals("N")) {
					System.out.println("De acuerdo, gracias por jugar.");
					otraVez = false;
				}else {
					System.out.println("ERROR: Introducir S para jugar de nuevo o N si no quiere jugar más");
				}
				
			}while(!repeat.equals("S") && !repeat.equals("N"));
			
		}while(otraVez);

		sc.close();
	}
}