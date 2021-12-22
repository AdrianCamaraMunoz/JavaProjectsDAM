package tesoro;

import java.util.Scanner;

public class BusquedaTesoro {
	
	public static void mostrarMapa(String[][]m) {
		
		// mostramos el mapa
		System.out.println("-------------------MAPA-------------------");
		System.out.println("");

		for (int h = 0; h < m.length; h++) {
			System.out.print("\t" + h);
		}

		System.out.println(" ");
		System.out.println(" ");

		for (int k = 0; k < m.length; k++) {
			System.out.print(k + "\t");

			for (int l = 0; l < m[0].length; l++) {
				System.out.print(m[k][l] + "\t");
			}

			System.out.println(" ");
			System.out.println(" ");
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean tesoro = false;
		boolean coordenadas = false;
		boolean esNumero = true;
		String cord1 = "";
		String cord2 = "";
		String bombas = "";

		boolean vivo = true;
		boolean winner = false;

		boolean arriba = true;
		boolean abajo = true;
		boolean derecha = true;
		boolean izquierda = true;

		int num1 = 0;
		int num2 = 0;
		int x = 0;
		int y = 0;
		int numBomb = 0;
		int maxBombs = 0;

		do {
			
			esNumero = true;
			System.out.println("Introduce cuantas filas quieres que tenga: ");
			cord1 = sc.nextLine();

			try {
				num1 = Integer.parseInt(cord1);
			} catch (Exception e) {
				esNumero = false;
				System.out.println("ERROR: formato de numero no reconocible.");
				System.out.println(" ");
			}

			if (esNumero) {
				System.out.println("Introduce cuantas columnas quieres que tenga: ");
				cord2 = sc.nextLine();

				try {
					num2 = Integer.parseInt(cord2);
				} catch (Exception e) {
					esNumero = false;
					System.out.println("ERROR: formato de numero no reconocible.");
					System.out.println(" ");
				}

				if (esNumero) {

					if (num1 < 0 || num2 < 0) {
						System.out.println("ERROR: Las columnas y las filas deben ser mayor que 0");
						esNumero = false;
					}
				}

			}

		} while (!esNumero);

		String[][] matriz = new String[num1][num2];
		String[][] mapa = new String[num1][num2];
		final int filas = matriz.length;
		final int cols = matriz[0].length;

		//numero de bombas
		do {

			maxBombs = (filas * cols) - 1;

			System.out.println("Introduce el numero de bombas que quieres que haya: ");
			bombas = sc.nextLine();
			esNumero = true;
			System.out.println("");

			try {
				numBomb = Integer.parseInt(bombas);
			} catch (Exception e) {
				esNumero = false;
				System.out.println("ERROR: formato de numero no reconocible.");
				System.out.println(" ");
			}

			if (esNumero && (numBomb <= 0)) {
				System.out.println("ERROR: El numero de bombas debe ser mayor que 0");
				System.out.println("");
				esNumero = false;
			}

			if (esNumero && (numBomb > maxBombs)) {
				System.out.println("ERROR: El numero de bombas no puede ser mayor a " + maxBombs);
				System.out.println(" ");
				esNumero = false;
			}

		} while (!esNumero);

		// asignar vacio
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = "o";
				mapa[i][j] = "o";
			}
		}

		// asignar bombas
		for (int i = 0; i < numBomb; i++) {
			int a = (int) (Math.random() * filas);
			int b = (int) (Math.random() * cols);

			if (matriz[a][b].equals("@")) {
				i--;
			} else {
				matriz[a][b] = "@";
			}
		}

		// asignar tesoro
		do {

			int a = (int) (Math.random() * matriz.length);
			int b = (int) (Math.random() * matriz[0].length);

			if (matriz[a][b].equals("@")) {
				tesoro = false;
			} else {
				matriz[a][b] = "$";
				tesoro = true;
			}

		} while (!tesoro);

		do {
			mostrarMapa(matriz);
			mostrarMapa(mapa);

			// leer coordenadas de busqueda
			do {
				System.out.println("Introduce unas coordenadas para buscar en ellas.");
				System.out.println("Introduce la coordenada x: ");
				cord1 = sc.nextLine();
				esNumero = true;

				try {
					x = Integer.parseInt(cord1);
				} catch (Exception e) {
					esNumero = false;
					System.out.println("ERROR: formato de numero no reconocible.");
					System.out.println(" ");
				}

				if (esNumero && (x < 0 || x >= filas)) {

					System.out.println("ERROR: El valor introducido no se puede encontrar en el mapa.");
					System.out.println("");
					coordenadas = false;

				} else if (esNumero) {

					System.out.println("Introduce la coordenada y: ");
					cord2 = sc.nextLine();
					esNumero = true;

					try {
						y = Integer.parseInt(cord2);
					} catch (Exception e) {
						esNumero = false;
						System.out.println("ERROR: formato de numero no reconocible.");
						System.out.println(" ");
					}

					if (esNumero && (y < 0 || y >= cols)) {
						System.out.println("ERROR: El valor introducido no se puede encontrar en el mapa.");
						System.out.println("");
						coordenadas = false;

					} else if (esNumero) {
						coordenadas = true;
					}

					if (coordenadas && esNumero && mapa[x][y].equals("x")) {
						System.out.println("ERROR: La coordenada introducida ya ha sido comprobada anteriormnente.");
						System.out.println("");
						coordenadas = false;

					}
				}

			} while (!coordenadas || !esNumero);

			// comprobar que hay en la coordenada seleccionada

			if (matriz[x][y].equals("@")) {
				System.out.println(" ");
				System.out.println("GAME OVER: Has explotado una bomba.");
				System.out.println(" ");
				vivo = false;
				
				mostrarMapa(matriz);
				
			}

			if (matriz[x][y].equals("$")) {
				System.out.println("ENHORABUENA: Has encontrado el tesoro.");
				winner = true;
			}

			if (matriz[x][y].equals("o")) {

				izquierda = true;
				derecha = true;
				abajo = true;
				arriba = true;

				// borde superior
				if (x == 0) {
					arriba = false;

					if (y == 0) {
						izquierda = false;

					} else if (y == cols-1) {
						derecha = false;
					}
				}

				// borde inferior
				if (x == filas-1) {
					abajo = false;

					if (y == 0) {
						izquierda = false;

					} else if (y == cols-1) {
						derecha = false;
					}
				}

				// borde izquierdo
				if (y == 0) {
					izquierda = false;

					if (x == 0) {
						arriba = false;

					} else if (x == filas-1) {
						abajo = false;
					}
				}

				// borde derecho
				if (y == cols-1) {
					derecha = false;

					if (x == 0) {
						arriba = false;

					} else if (x == filas-1) {
						abajo = false;
					}
				}

				// dibujamos
				if (arriba) {
					if (matriz[x - 1][y].equals("@")) {
						mapa[x][y] = "!";
					}
				}

				if (abajo && !mapa[x][y].equals("!")) {
					if (matriz[x + 1][y].equals("@")) {
						mapa[x][y] = "!";
					}
				}

				if (izquierda && !mapa[x][y].equals("!")) {
					if (matriz[x][y - 1].equals("@")) {
						mapa[x][y] = "!";
					}
				}

				if (derecha && !mapa[x][y].equals("!")) {
					if (matriz[x][y + 1].equals("@")) {
						mapa[x][y] = "!";
					}
				}

				if (mapa[x][y].equals("o")) {
					mapa[x][y] = "x";
				}

			}

		} while (vivo && !winner);

		sc.close();
	}
}
