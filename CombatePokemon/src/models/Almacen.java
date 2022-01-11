package models;

import java.util.ArrayList;

public class Almacen {

	// Properties
	public static ArrayList<Pokemon> lista_Pokemons = new ArrayList<Pokemon>();

	//methods
	
	/**
	 * inicializa las clases, tipos, pokemons y movimientos
	 */
	public static void Iniciar() {
		// TipoClase
		TipoClase Estado = new TipoClase("Estado");
		TipoClase Fisico = new TipoClase("Fisico");
		TipoClase Especial = new TipoClase("Especial");

		// Tipos de Pokemon
		TipoPokemon Bicho = new TipoPokemon("Bicho");
		TipoPokemon Dragon = new TipoPokemon("Dragon");
		TipoPokemon Electrico = new TipoPokemon("Electrico");
		TipoPokemon Hada = new TipoPokemon("Hada");
		TipoPokemon Lucha = new TipoPokemon("Lucha");
		TipoPokemon Fuego = new TipoPokemon("Fuego");
		TipoPokemon Volador = new TipoPokemon("Volador");
		TipoPokemon Fantasma = new TipoPokemon("Fantasma");
		TipoPokemon Planta = new TipoPokemon("Planta");
		TipoPokemon Tierra = new TipoPokemon("Tierra");
		TipoPokemon Hielo = new TipoPokemon("Hielo");
		TipoPokemon Normal = new TipoPokemon("Normal");
		TipoPokemon Veneno = new TipoPokemon("Veneno");
		TipoPokemon Psiquico = new TipoPokemon("Psiquico");
		TipoPokemon Roca = new TipoPokemon("Roca");
		TipoPokemon Acero = new TipoPokemon("Acero");
		TipoPokemon Agua = new TipoPokemon("Agua");
		TipoPokemon None = new TipoPokemon("None");

		// Estados
		Estado SinEstado = new Estado("None");
		Estado Paralizado = new Estado("Paralizado");
		Estado Quemado = new Estado("Quemado");
		Estado Envenenado = new Estado("Envenenado");
		Estado GravementeEnvenenado = new Estado("GravementeEnvenenado");
		Estado Dormido = new Estado("Dormido");
		Estado Congelado = new Estado("Congelado");
		Estado Pokerus = new Estado("Pokerus");
		Estado Debilitado = new Estado("Debilitado");

		Estado Confuso = new Estado("Confuso");
		Estado Enamorado = new Estado("Enamorado");
		Estado Drenado = new Estado("Drenado");
		Estado Maldito = new Estado("Maldito");
		Estado Canto_Mortal = new Estado("Canto Mortal");
		Estado Atrapado = new Estado("Atrapado");

		// Estados inventados
		Estado RobarTurno = new Estado("RobarTurno");

		// Movimientos

		// Nombre, Tipo, Clase, daño, precision, PP, A, D, AS, DS, S, H, Efecto, Probabilidad, Ar, Dr, DSr, Sr, Hr
		
		Movimiento Exterminio = new Movimiento("Exterminio", Normal, Fisico, 500, 1, 10, 0, 0, 0, 0, 0, SinEstado, 0, 0, 0, 0, 0, 0);
		
		Movimiento LeechSeed = new Movimiento("Leech Seed", Planta, Estado, 0, 0.9, 16, 0, 0, 0, 0, 0, Drenado, 1, 0, 0, 0, 0, 0);
		Movimiento SleepPowder = new Movimiento("Sleep Powder", Planta, Estado, 0, 0.75, 24, 0, 0, 0, 0, 0, Dormido, 1, 0, 0, 0, 0, 0);
		Movimiento PosionPowder = new Movimiento("Poison Powder", Veneno, Estado, 0, 0.75, 56, 0, 0, 0, 0, 0, Envenenado, 1, 0, 0, 0, 0, 0);

		Movimiento Flamethrower = new Movimiento("Flamethrower", Fuego, Especial, 90, 1, 24, 0, 0, 0, 0, 0, Quemado,
				0.1, 0, 0, 0, 0, 0);
		Movimiento Inferno = new Movimiento("Inferno", Fuego, Especial, 100, 0.5, 8, 0, 0, 0, 0, 0, Quemado, 1, 0, 0, 0,
				0, 0);
		Movimiento FlareBlitz = new Movimiento("Flare Blitz", Fuego, Fisico, 120, 1, 24, 0, 0, 0, 0, -0.33, Quemado,
				0.1, 0, 0, 0, 0, 0); // perder vida para usar
		Movimiento AirSlash = new Movimiento("Air Slash", Volador, Especial, 75, 0.95, 24, 0, 0, 0, 0, 0, RobarTurno,
				0.3, 0, 0, 0, 0, 0);// 30% su rival no ataque

		// Pokemons
		lista_Pokemons.add(new Pokemon(3, "Venusaur", Planta, Veneno, 187, 134, 135, 152, 152, 132));
		lista_Pokemons.add(new Pokemon(6, "Charizard", Fuego, Volador, 185, 136, 130, 161, 137, 152));
		lista_Pokemons.add(new Pokemon(9, "Blastoise", Agua, None, 186, 135, 152, 137, 157, 130));
		lista_Pokemons.add(new Pokemon(18, "Pidgeot", Normal, Volador, 190, 132, 127, 122, 122, 153));
		lista_Pokemons.add(new Pokemon(25, "Pikachu", Electrico, None, 142, 107, 92, 102, 102, 142));
		lista_Pokemons.add(new Pokemon(149, "Dragonite", Dragon, Volador, 198, 186, 147, 152, 152, 132));
		
		//Movimientos a Pokemons
		ArrayList<Movimiento> movements = new ArrayList<>();
		
		//movimientos para charizard
		movements.add(Flamethrower);
		movements.add(Inferno);
		lista_Pokemons.get(1).setMovimientos(movements);
		
		//Movimientos para venasaur
		movements.clear();
		movements.add(LeechSeed);
		movements.add(SleepPowder);
		lista_Pokemons.get(0).setMovimientos(movements);
		
		//Movimiento el exterminador a todos los pokemon
		movements.clear();
		movements.add(Exterminio);
		lista_Pokemons.get(0).setMovimientos(movements);
		lista_Pokemons.get(1).setMovimientos(movements);
		lista_Pokemons.get(2).setMovimientos(movements);
		lista_Pokemons.get(3).setMovimientos(movements);
		lista_Pokemons.get(4).setMovimientos(movements);
		lista_Pokemons.get(5).setMovimientos(movements);


		
	}
}
