package mainapp;

import enums.Sexo;
import enums.Tipo;
import models.Pokemon;
import models.Usuario;
import ui.LoginView;
import utils.Almacen;

public class MainApp {
	public static void main(String[] args) {
		
		//Pokemons de prueba
		Almacen.Pokemons.add(new Pokemon(007, Tipo.Agua, "Squirtle", Sexo.Hembra, 0.5, 9.0, "Tortuguita", "Torrente", "https://assets.pokemon.com/assets/cms2/img/pokedex/full/007.png"));
		Almacen.Pokemons.add(new Pokemon(001, Tipo.Planta, "Bulbasaur", Sexo.Macho, 0.7, 6.9, "Semilla", "Espesura", "https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png"));
		Almacen.Pokemons.add(new Pokemon(004, Tipo.Fuego, "Charmander", Sexo.Unico, 0.6, 8.5, "Lagartija", "Mar Llamas", "https://assets.pokemon.com/assets/cms2/img/pokedex/full/004.png"));
		
		//usuario de prueba
		Almacen.Users.add(new Usuario("usuario", "usuario"));
		
		new LoginView();
	}
}
