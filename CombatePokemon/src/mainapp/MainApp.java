package mainapp;

import java.util.ArrayList;
import java.util.Scanner;

import models.Almacen;
import models.Combate;
import models.Entrenador;
import models.Equipo;
import models.Pokemon;

public class MainApp {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		do {
			//Iniciamos el almacen donde estan guardados los Pokemons, Movimientos, Tipos, etc.
			Almacen.Iniciar();
			ArrayList<Pokemon> equipo = new ArrayList<Pokemon>();

			// Creamos primer equipo con su entrenador

			System.out.println("-----Jugador 1-----");

			String nameEntrenador = NuevoEntrenador();
			Entrenador entrenador1 = new Entrenador(nameEntrenador);

			Equipo equipo1 = new Equipo();
			equipo = NuevoEquipo();

			equipo1.setEquipo(equipo);
			equipo1.setEntrenador(entrenador1);
			entrenador1.setEquipo(equipo1);

			// Creamos segundo equipo con su entrenador

			System.out.println();
			System.out.println("-----Jugador 2-----");

			nameEntrenador = NuevoEntrenador();
			Entrenador entrenador2 = new Entrenador(nameEntrenador);

			Equipo equipo2 = new Equipo();
			equipo = NuevoEquipo();

			equipo2.setEquipo(equipo);
			equipo2.setEntrenador(entrenador2);
			entrenador2.setEquipo(equipo2);

			// Elegimos los pokemons iniciales y comenzamos el combate

			System.out.println(entrenador1.getNombre() + ", elige tu inicial: ");
			Pokemon inicial1 = elegirInicial(equipo1);

			equipo1.getEquipo().add(0, inicial1);

			System.out.println(entrenador2.getNombre() + ", elige tu inicial: ");
			Pokemon inicial2 = elegirInicial(equipo2);

			equipo2.getEquipo().add(0, inicial2);

			Combate combate = new Combate(entrenador1, entrenador2);
			combate.Bienvenida();
			combate.isFinished();

			//preguntamos si quieren jugar otro combate y en caso de querer repetimos
		} while (again());
		
		//si no quieren mas combates cerramos el programa
		System.out.println("Gracias por jugar.");
		System.exit(0);
	}

	/**
	 * elegir pokemon de tu equipo que saldrá primero a pelear
	 * @param equipo equipo del que se va a elegir el pokemon
	 * @return pokemon elegido
	 */
	private static Pokemon elegirInicial(Equipo equipo) {
		int count = 1;
		boolean find = false;
		int opcion = 0;

		System.out.println();
		System.out.println("-----POKEMONS-----");
		System.out.println();

		for (Pokemon p : equipo.getEquipo()) {
			System.out.println(count + "- " + p.getNombre());
			count++;
		}

		System.out.println();

		do {
			try {
				find = true;
				System.out.println("Introduce el numero del pokemon que quieres elegir como inicial: ");
				System.out.println();
				opcion = Integer.parseInt(sc.nextLine());

				if (opcion > count || opcion < 1) {
					System.out.println("Error: numero no válido.");
					find = false;
				}
			} catch (Exception e) {
				System.out.println("Opcion no válida");
				find = false;
			}

		} while (!find);

		Pokemon inicial = equipo.getEquipo().get(opcion - 1);
		equipo.getEquipo().remove(opcion - 1);
		return inicial;

	}

	/**
	 * Crea entrenador para el combate
	 */
	private static String NuevoEntrenador() {
		System.out.println("Introduce el nombre del entrenador: ");
		String name = sc.nextLine();
		return name;
	}
	
	/**
	 * Crea equipo para un entrenador
	 * @return equipo creado
	 */ 
	private static ArrayList<Pokemon> NuevoEquipo() {
		int count = 1;
		int opcion = 0;
		boolean find = false;
		ArrayList<Pokemon> equipo = new ArrayList<Pokemon>();

		System.out.println();
		System.out.println("-----POKEMONS-----");
		System.out.println();

		//mostramos los pokemons que se pueden elegir
		for (Pokemon p : Almacen.lista_Pokemons) {
			System.out.println(count + "- " + p.getNombre());
			count++;
		}

		do {

			do {
				try {
					find = false;
					System.out.println();
					System.out.println("Introduce el numero del pokemon que quieres añadir a tu equipo: ");
					opcion = Integer.parseInt(sc.nextLine());

					if (opcion > count || opcion < 1) {
						System.out.println("Error: numero no válido.");
						System.out.println();
					} else {
						for (Pokemon p : equipo) {
							if (Almacen.lista_Pokemons.get(opcion - 1).getNombre().equals(p.getNombre())) {
								System.out.println("Error: Ese pokemon ya pertenece a tu equipo.");
								find = true;
							}

						}
					}
				} catch (Exception e) {
					System.out.println("Opcion no válida");
				}

			} while (opcion > count || opcion < 1 || find);

			equipo.add(Almacen.lista_Pokemons.get(opcion - 1));

			// TODO
			// Cambiar tamaño equipos
		} while (equipo.size() < 2);

		return equipo;

	}

	/**
	 * Pregunta al usuario si quiere jugar una partida nueva
	 * @return true si el usuario quiere jugar de nuevo, false si quiere dejar de jugar
	 */
	private static boolean again() {
		String opcion;
		do {
			System.out.println("¿Quieres jugar otro combate? (S-N)");
			opcion = sc.nextLine();
			if (!opcion.equalsIgnoreCase("S") && !opcion.equalsIgnoreCase("N")) {
				System.out.println("Debe introducir S si quiere jugar de nuevo o N si quiere dejar de jugar.");
			}
		} while (!opcion.equalsIgnoreCase("S") && !opcion.equalsIgnoreCase("N"));

		if (opcion.equalsIgnoreCase("S")) {
			return true;
		}

		return false;

	}
}
