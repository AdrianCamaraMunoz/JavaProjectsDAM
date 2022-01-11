package models;

import java.util.Scanner;

public class Combate {

	static Scanner sc = new Scanner(System.in);

	// Propiedades
	private Entrenador entrenador1;
	private Entrenador entrenador2;
	private Pokemon inicial1;
	private Pokemon inicial2;

	// Builder
	public Combate(Entrenador entrenador1, Entrenador entrenador2) {
		super();
		this.entrenador1 = entrenador1;
		this.entrenador2 = entrenador2;
		this.inicial1 = entrenador1.getEquipo().getEquipo().get(0);
		this.inicial2 = entrenador2.getEquipo().getEquipo().get(0);
	}

	/**
	 * realiza el combate
	 */
	public void Bienvenida() {

		System.out.println("Comencemos el combate!");
		System.out.println();

		//inicializa los pokemons del combate a sin estado
		for (Pokemon p : entrenador1.getEquipo().getEquipo()) {
			p.setEstado("SinEstado");
		}
		for (Pokemon p : entrenador2.getEquipo().getEquipo()) {
			p.setEstado("SinEstado");
		}

		do {

			if (entrenador1.getEquipo().getEquipo().size() > 0 && entrenador2.getEquipo().getEquipo().size() > 0) {

				int turno = empezarTurno();
				mostrarCombate(turno);

				if (entrenador1.getEquipo().getEquipo().size() > 0 && entrenador2.getEquipo().getEquipo().size() > 0) {
					
					//Cambio de turno
					if (turno == 1) {

						//si un pokemon pierde el turno no se cambia el turno simplemente se le pasa el efecto
						if (entrenador2.getEquipo().getEquipo().get(0).getEstado().equals("Dormido")
								|| entrenador2.getEquipo().getEquipo().get(0).getEstado().equals("Congelado")
								|| entrenador2.getEquipo().getEquipo().get(0).getEstado().equals("Paralizado")
								|| entrenador2.getEquipo().getEquipo().get(0).getEstado().equals("Atrapado")) {
							turno = 1;
							entrenador2.getEquipo().getEquipo().get(0).setEstado("SinEstado");
						} else {
							turno = 2;
						}

					} else {
						//si un pokemon pierde el turno no se cambia el turno simplemente se le pasa el efecto
						if (entrenador1.getEquipo().getEquipo().get(0).getEstado().equals("Dormido")
								|| entrenador1.getEquipo().getEquipo().get(0).getEstado().equals("Congelado")
								|| entrenador1.getEquipo().getEquipo().get(0).getEstado().equals("Paralizado")
								|| entrenador1.getEquipo().getEquipo().get(0).getEstado().equals("Atrapado")) {
							turno = 2;
							entrenador1.getEquipo().getEquipo().get(0).setEstado("SinEstado");
						} else {
							turno = 1;
						}
					}

					if (entrenador1.getEquipo().getEquipo().size() > 0 && entrenador2.getEquipo().getEquipo().size() > 0) {

						mostrarCombate(turno);

						//si algun jugador ha cambiado de pokemon establecemos cual es ahora el pokemon que va a pelear(siempre el primero del equipo)
						if (entrenador1.getEquipo().getEquipo().size() > 0 && entrenador2.getEquipo().getEquipo().size() > 0) {
							inicial1 = entrenador1.getEquipo().getEquipo().get(0);
							inicial2 = entrenador2.getEquipo().getEquipo().get(0);
						}
					}
				}
			}

		} while (entrenador1.getEquipo().getEquipo().size() > 0 && entrenador2.getEquipo().getEquipo().size() > 0);

	}

	/**
	 * finalizamos el combate y vemos el ganador
	 */
	public void isFinished() {
		System.out.println("------------------------------------------");
		if (entrenador1.getEquipo().getEquipo().size() <= 0) {
			if (entrenador2.getEquipo().getEquipo().size() <= 0) {
				System.out.println("Ambos equipos han sido derrotados al completo, empate.");
			} else {
				System.out.println("El ganador del combate es " + entrenador2.getNombre() + ".");
			}
		} else {
			if (entrenador2.getEquipo().getEquipo().size() <= 0) {
				System.out.println("El ganador del combate es " + entrenador1.getNombre() + ".");
			} else {
				System.out.println("Ambos equipos tienen aún pokemones vivos, empate.");
			}
		}
		
	}

	/**
	 * realizamos las acciones del turno
	 * @param turno indica a que entrenador le toca
	 */
	private void mostrarCombate(int turno) {
		
		//muestra que pokemons están peleando
		System.out.println("------------------------------------------");
		System.out.println(entrenador1.getEquipo().getEquipo().get(0).getNombre() + " ("
				+ entrenador1.getEquipo().getEquipo().get(0).getHP() + "/"
				+ entrenador1.getEquipo().getEquipo().get(0).getMaxHP() + ") ");
		System.out.println();
		System.out.println(entrenador2.getEquipo().getEquipo().get(0).getNombre() + " ("
				+ entrenador2.getEquipo().getEquipo().get(0).getHP() + "/"
				+ entrenador2.getEquipo().getEquipo().get(0).getMaxHP() + ") ");
		System.out.println("------------------------------------------");

		//comprueba de quien es el turno
		if (turno == 1) {
			System.out.println("----TURNO " + entrenador1.getNombre() + "----");
			String opcion = menu();
			logicamenu(opcion, turno);

		} else {
			System.out.println("----TURNO " + entrenador2.getNombre() + "----");
			String opcion = menu();
			logicamenu(opcion, turno);

		}
	}

	/**
	 * opciones que se pueden realizar en el combate
	 * @return opcion elegida por el usuario
	 */
	private String menu() {
		String opcion;
		do {
			System.out.println("A. Combatir");
			System.out.println("B. Cambiar");
			System.out.println();
			System.out.println("Selecciona la opcion que deseas realizar: ");
			opcion = sc.nextLine().toUpperCase();

			if (!opcion.equals("A") && !opcion.equals("B")) {
				System.out.println("Opcion inválida");
				System.out.println();
			}

		} while (!opcion.equals("A") && !opcion.equals("B"));

		return opcion;

	}

	/**
	 * dependiendo de la opcion elegida se ejecuta 
	 * @param opcion opcion elegida por el usuario
	 * @param turno indica a que jguador le toca
	 */
	private void logicamenu(String opcion, int turno) {
		switch (opcion) {
		//va a atacar
		case "A":
			if (turno == 1) {
				aplicarMovimiento(elegirMovimiento(entrenador1.getEquipo()), entrenador1, entrenador2);
			}

			if (turno == 2) {
				aplicarMovimiento(elegirMovimiento(entrenador2.getEquipo()), entrenador2, entrenador1);

			}
			break;
			//va a cambiar de pokemon
		case "B":
			if (turno == 1) {
				elegirPokemon(entrenador1.getEquipo());
			}

			if (turno == 2) {
				elegirPokemon(entrenador2.getEquipo());

			}
			break;
		}
	}

	/**
	 * elige con que movimiento quiere atacar
	 * @param equipo equipo atacante
	 * @return movimiento elegido por el usuario
	 */
	private Movimiento elegirMovimiento(Equipo equipo) {
		int count = 1;
		boolean find = false;
		int opcion = 0;

		System.out.println();
		System.out.println("-----Movimientos-----");
		System.out.println();

		//muestra los movimientos disponibles
		for (Movimiento m : equipo.getEquipo().get(0).getMovimientos()) {
			System.out.println(count + "- " + m.getNombre() + " (" + m.getActualPP() + "/" + m.getMaxPP() + ") ");
			count++;
		}

		System.out.println();

		do {
			try {
				find = true;
				System.out.println("Introduce el numero del movimiento que quieres elegir: ");
				opcion = Integer.parseInt(sc.nextLine());

				if (opcion > count || opcion < 1) {
					System.out.println("Error: numero no válido.");
					find = false;
				}

				//error si ese movimiento no se puede usar mas
				if (equipo.getEquipo().get(0).getMovimientos().get(opcion - 1).getActualPP() <= 0) {
					System.out.println("El movimiento seleccionado ha gastado todos los PP.");
					find = false;
					equipo.getEquipo().get(0).getMovimientos().get(opcion - 1).setActualPP(0);
				}

			} catch (Exception e) {
				System.out.println("Opcion no válida");
				find = false;
			}

		} while (!find);

		//resta un uso al movimiento
		equipo.getEquipo().get(0).getMovimientos().get(opcion - 1).setActualPP(equipo.getEquipo().get(0).getMovimientos().get(opcion - 1).getActualPP() - 1);
		return equipo.getEquipo().get(0).getMovimientos().get(opcion - 1);

	}

	/**
	 * elije un pokemon para sacarlo a combatir
	 * @param equipo equipo que va a cambiar el pokemon
	 * @return pokemon que va a combatir
	 */
	private Pokemon elegirPokemon(Equipo equipo) {
		int count = 1;
		boolean find = false;
		int opcion = 0;

		//muestra lista de pokemons del equipo
		for (Pokemon p : equipo.getEquipo()) {
			System.out.println(count + "- " + p.getNombre());
			count++;
		}

		do {
			try {

				find = true;
				System.out.println("Introduce el numero del pokemon que quieres elegir: ");
				opcion = Integer.parseInt(sc.nextLine());

				if (opcion > count || opcion < 1) {
					System.out.println("Error: numero no válido.");
					find = false;
				}
			} catch (Exception e) {
				System.out.println("Opcion inválida");
				find = false;
			}

		} while (!find);

		//cambia de posicion al pokemon elgido poniendolo el primero del equipo
		Pokemon inicial = equipo.getEquipo().get(opcion - 1);
		equipo.getEquipo().remove(opcion - 1);
		equipo.getEquipo().add(inicial);
		return inicial;

	}

	/**
	 * comprueba que pokemon es mas rapido para ver quien empieza el turno
	 * @return 1 si le toca al entrenador1 o 2 si le toca al entrenador2, en caso de ser igual de rapidos será elegido aleatoriamente
	 */
	public int empezarTurno() {
		if (inicial1.speed > inicial2.speed) {
			return 1;
		} else if (inicial1.speed < inicial2.speed) {
			return 2;
		} else {
			if ((int) Math.random() * 10 < 5) {
				return 1;
			} else {
				return 2;
			}
		}

	}

	/**
	 * ejecuta el movimiento elegido
	 * @param movimiento movimiento elegido
	 * @param atacante pokemon que ataca
	 * @param defensor pokemon que defiende
	 */
	public void aplicarMovimiento(Movimiento movimiento, Entrenador atacante, Entrenador defensor) {
		int probabilidad = (int) (Math.random() * 100);

		if (movimiento.getPrecision() * 100 >= probabilidad) {

			//modificador de tipos
			int modificador = 1;
			modificador *= getEfectividad(atacante.getEquipo().getEquipo().get(0).getTipo1(),
					defensor.getEquipo().getEquipo().get(0).getTipo1());
			modificador *= getEfectividad(atacante.getEquipo().getEquipo().get(0).getTipo1(),
					defensor.getEquipo().getEquipo().get(0).getTipo2());
			modificador *= getEfectividad(atacante.getEquipo().getEquipo().get(0).getTipo2(),
					defensor.getEquipo().getEquipo().get(0).getTipo1());
			modificador *= getEfectividad(atacante.getEquipo().getEquipo().get(0).getTipo2(),
					defensor.getEquipo().getEquipo().get(0).getTipo2());

			//mensaje del modificador de tipos
			switch (modificador) {
			case 0:
				System.out.println("Es inmune.");
				break;
			case 1:
				System.out.println("No es muy efectivo");
				break;
			case 2:
				System.out.println("Es efectivo.");
				break;
			case 4:
				System.out.println("Es muy efectivo");
				break;
			}

			//comprueba si aplica algun estado y en caso de aplicarlo comprueba si acierta
			if (!movimiento.getAplicaEstado().getNombre().equals("SinEstado")) {
				if (movimiento.getProbabilidadEstado() * 100 >= probabilidad) {
					movimiento.getAplicaEstado().getEstado(atacante.getEquipo().getEquipo().get(0),
							defensor.getEquipo().getEquipo().get(0), movimiento.getAplicaEstado().getNombre());
				}
			}

			//comprueba si el movimientoe es fisico o especial y calcula el daño aplicado
			switch (movimiento.getClase().getNombre()) {
			case "Fisico":
				int damage = 0;

				if (atacante.getEquipo().getEquipo().get(0).getEstado().equals("Quemado")) {
					damage = (int) ((((((2 * atacante.getEquipo().getEquipo().get(0).level) / 5) + 2)
							* (atacante.getEquipo().getEquipo().get(0).attack
									/ defensor.getEquipo().getEquipo().get(0).defense)
							/ 50) + 2) * modificador * 0.5);

				} else {
					damage = (((((2 * atacante.getEquipo().getEquipo().get(0).level) / 5) + 2)
							* (movimiento.getDamage()) * (atacante.getEquipo().getEquipo().get(0).attack
									/ defensor.getEquipo().getEquipo().get(0).defense)
							/ 50) + 2) * modificador;
				}

				defensor.getEquipo().getEquipo().get(0).setHP(defensor.getEquipo().getEquipo().get(0).getHP() - damage);

				//comprueba si el defensor es derrotado
				if (defensor.getEquipo().getEquipo().get(0).getHP() <= 0) {
					System.out.println(defensor.getEquipo().getEquipo().get(0).getNombre() + " ha sido derrotado.");
					defensor.getEquipo().getEquipo().remove(0);

					//comprueba si el equipo es derrotado
					if (defensor.getEquipo().getEquipo().size() > 0) {
						elegirPokemon(defensor.getEquipo());
					}
				} else {
					System.out.println(defensor.getEquipo().getEquipo().get(0).getNombre() + " ha recibido " + damage
							+ " de daño.");

				}

				break;
			case "Especial":
				damage = 0;

				if (atacante.getEquipo().getEquipo().get(0).getEstado().equals("Quemado")) {
					damage = (int) ((((((2 * atacante.getEquipo().getEquipo().get(0).level) / 5) + 2)
							* (atacante.getEquipo().getEquipo().get(0).specialAttack
									/ defensor.getEquipo().getEquipo().get(0).specialDefense)
							/ 50) + 2) * modificador * 0.5);
				} else {
					damage = (((((2 * atacante.getEquipo().getEquipo().get(0).level) / 5) + 2)
							* (movimiento.getDamage()) * (atacante.getEquipo().getEquipo().get(0).specialAttack
									/ defensor.getEquipo().getEquipo().get(0).specialDefense)
							/ 50) + 2) * modificador;
				}

				defensor.getEquipo().getEquipo().get(0).setHP(defensor.getEquipo().getEquipo().get(0).getHP() - damage);

				//comprueba si el defensor es derrotado
				if (defensor.getEquipo().getEquipo().get(0).getHP() <= 0) {
					System.out.println(defensor.getEquipo().getEquipo().get(0).getNombre() + " ha sido derrotado.");
					defensor.getEquipo().getEquipo().remove(0);
					
					//comprueba si el equipo es derrotado
					if (defensor.getEquipo().getEquipo().size() >= 0) {
						System.out.println("Sustituye al Pokemon que ha sido derrotado: ");
						elegirPokemon(defensor.getEquipo());
					} else {
						isFinished();
					}

				} else {
					System.out.println(defensor.getEquipo().getEquipo().get(0).getNombre() + " ha recibido " + damage
							+ " de daño.");
				}

			}

		} else {
			System.out.println("Has fallado");
		}

	}

	/**
	 * Comprueba el modificador de daño segun tipos
	 * @param user  tipo del pokemon del usuario
	 * @param rival tipo del pokemon rival
	 * @return -1 si no ha encontrado el tipo del atacante (no tiene), 1, 0.5 o 2 de
	 *         duplicador de daño segun tipos
	 */
	public double getEfectividad(TipoPokemon user, TipoPokemon rival) {
		switch (user.getNombre()) {
		case "Normal":
			switch (rival.getNombre()) {
			case "Acero":
				return 0.5;
			case "Roca":
				return 0.5;
			case "Fantasma":
				return 0;
			default:
				return 1;
			}
		case "Fuego":
			switch (rival.getNombre()) {
			case "Planta":
				return 2;
			case "Acero":
				return 2;
			case "Bicho":
				return 2;
			case "Hielo":
				return 2;
			case "Fuego":
				return 0.5;
			case "Agua":
				return 0.5;
			case "Roca":
				return 0.5;
			case "Dragón":
				return 0.5;
			default:
				return 1;
			}
		case "Agua":
			switch (rival.getNombre()) {
			case "Fuego":
				return 2;
			case "Tierra":
				return 2;
			case "Roca":
				return 2;
			case "Planta":
				return 0.5;
			case "Agua":
				return 0.5;
			case "Dragón":
				return 0.5;
			default:
				return 1;
			}
		case "Planta":
			switch (rival.getNombre()) {
			case "Agua":
				return 2;
			case "Tierra":
				return 2;
			case "Roca":
				return 2;
			case "Fuego":
				return 0.5;
			case "Planta":
				return 0.5;
			case "Volador":
				return 0.5;
			case "Veneno":
				return 0.5;
			case "Bicho":
				return 0.5;
			case "Dragón":
				return 0.5;
			case "Acero":
				return 0.5;
			default:
				return 1;
			}
		case "Eléctrico":
			switch (rival.getNombre()) {
			case "Agua":
				return 2;
			case "Volador":
				return 2;
			case "Planta":
				return 0.5;
			case "Electrico":
				return 0.5;
			case "Dragón":
				return 0.5;
			case "Tierra":
				return 0;
			default:
				return 1;
			}
		case "Hielo":
			switch (rival.getNombre()) {
			case "Planta":
				return 2;
			case "Tierra":
				return 2;
			case "Volador":
				return 2;
			case "Dragón":
				return 2;
			case "Fuego":
				return 0.5;
			case "Agua":
				return 0.5;
			case "Hielo":
				return 0.5;
			case "Acero":
				return 0.5;
			default:
				return 1;
			}
		case "Lucha":
			switch (rival.getNombre()) {
			case "Normal":
				return 2;
			case "Hielo":
				return 2;
			case "Roca":
				return 2;
			case "Siniestro":
				return 2;
			case "Acero":
				return 2;
			case "Veneno":
				return 0.5;
			case "Volador":
				return 0.5;
			case "Psíquico":
				return 0.5;
			case "Bicho":
				return 0.5;
			case "Hada":
				return 0.5;
			case "Fantasma":
				return 0;
			default:
				return 1;
			}
		case "Veneno":
			switch (rival.getNombre()) {
			case "Planta":
				return 2;
			case "Hada":
				return 2;
			case "Veneno":
				return 0.5;
			case "Tierra":
				return 0.5;
			case "Roca":
				return 0.5;
			case "Fantasma":
				return 0.5;
			case "Acero":
				return 0;
			default:
				return 1;
			}
		case "Tierra":
			switch (rival.getNombre()) {
			case "Fuego":
				return 2;
			case "Eléctrico":
				return 2;
			case "Veneno":
				return 2;
			case "Roca":
				return 2;
			case "Acero":
				return 2;
			case "Planta":
				return 0.5;
			case "Bicho":
				return 0.5;
			case "Volador":
				return 0;
			default:
				return 1;
			}
		case "Volador":
			switch (rival.getNombre()) {
			case "Planta":
				return 2;
			case "Lucha":
				return 2;
			case "Veneno":
				return 2;
			case "Eléctrico":
				return 0.5;
			case "Roca":
				return 0.5;
			case "Acero":
				return 0.5;
			default:
				return 1;
			}
		case "Psíquico":
			switch (rival.getNombre()) {
			case "Lucha":
				return 2;
			case "Veneno":
				return 2;
			case "Psíquico":
				return 0.5;
			case "Acero":
				return 0.5;
			case "Siniestro":
				return 0;
			default:
				return 1;
			}
		case "Bicho":
			switch (rival.getNombre()) {
			case "Planta":
				return 2;
			case "Psíquico":
				return 2;
			case "Siniestro":
				return 2;
			case "Fuego":
				return 0.5;
			case "Lucha":
				return 0.5;
			case "Veneno":
				return 0.5;
			case "Volador":
				return 0.5;
			case "Fantasma":
				return 0.5;
			case "Acero":
				return 0.5;
			case "Hada":
				return 0.5;
			default:
				return 1;
			}
		case "Roca":
			switch (rival.getNombre()) {
			case "Fuego":
				return 2;
			case "Hielo":
				return 2;
			case "Volador":
				return 2;
			case "Bicho":
				return 2;
			case "Lucha":
				return 0.5;
			case "Tierra":
				return 0.5;
			case "Acero":
				return 0.5;
			default:
				return 1;
			}
		case "Fantasma":
			switch (rival.getNombre()) {
			case "Psíquico":
				return 2;
			case "Fantasma":
				return 2;
			case "Siniestro":
				return 0.5;
			case "Normal":
				return 0;
			default:
				return 1;
			}
		case "Dragón":
			switch (rival.getNombre()) {
			case "Dragón":
				return 2;
			case "Acero":
				return 0.5;
			case "Hada":
				return 0;
			default:
				return 1;
			}
		case "Siniestro":
			switch (rival.getNombre()) {
			case "Psíquico":
				return 2;
			case "Fantasma":
				return 2;
			case "Lucha":
				return 0.5;
			case "Siniestro":
				return 0.5;
			case "Hada":
				return 0.5;
			default:
				return 1;
			}
		case "Acero":
			switch (rival.getNombre()) {
			case "Hielo":
				return 2;
			case "Roca":
				return 2;
			case "Hada":
				return 2;
			case "Fuego":
				return 0.5;
			case "Agua":
				return 0.5;
			case "Eléctrico":
				return 0.5;
			case "Acero":
				return 0.5;
			default:
				return 1;
			}
		case "Hada":
			switch (rival.getNombre()) {
			case "Lucha":
				return 2;
			case "Dragón":
				return 2;
			case "Siniestro":
				return 2;
			case "Fuego":
				return 0.5;
			case "Veneno":
				return 0.5;
			case "Acero":
				return 0.5;
			default:
				return 1;
			}
		}

		return -1;
	}
}
