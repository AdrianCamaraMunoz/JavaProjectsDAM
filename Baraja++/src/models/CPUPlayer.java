package models;

public class CPUPlayer extends AbstractPlayer{

	public CPUPlayer(String nombre, Mesa mesa) {
		super(nombre, mesa);
	}

	@Override
	/**
	 * partida a 7ymedio del ordenador
	 */
	void jugarTurno() {
		System.out.println();
		System.out.println("----------TURNO ORDENADOR----------");
		System.out.println();
		
		Carta carta;
		boolean repeat = true;

		if (this.puntos <= 5) {
			do {
				carta = mesa.getBaraja().Robar();
				mano.InsertaCartaFinal(carta);
				System.out.println("La carta robada es: " + carta);
				this.puntos += carta.getValor7ymedia();
				int c = comprobarPuntos(this.puntos);
				if (c == 1 || c == 2) {
					repeat = false;
				}

			} while (repeat);
		} else {
			repeat = false;
		}


		if (this.puntos > 0) {
			System.out.println("La puntuación final del ordenador es: " + this.puntos);
		}		
	}
	
	/**
	 * comprueba si los puntos obtenidos se han pasado de 7.5, ha acertado 7.5 o es menor a 7.5
	 * @param puntuacion puntuacion actual del jugador
	 * @return devuelve 0 si puede seguir jugando, 1 si se ha pasado de 7.5 y 2 si ha conseguido 7.5 exacto
	 */
	private static int comprobarPuntos(double puntuacion) {

		if (puntuacion == 7.5) {
			System.out.println("Maxima Puntuacion! 7 y medio!");
			return 2;
		} else if (puntuacion > 7.5) {
			System.out.println("Te pasaste wey");
			return 1;
		} else {
			System.out.println("Puntuacion actual: " + puntuacion);
		}

		return 0;
	}

}
