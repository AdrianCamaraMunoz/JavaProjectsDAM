package models;

import java.util.ArrayList;
import java.util.Scanner;

public class Pokemon {

	// Propiedades
	protected int numero;
	protected String nombre;
	protected TipoPokemon tipo1;
	protected TipoPokemon tipo2;
	protected String estado;
	protected int attack;
	protected int defense;
	protected int specialAttack;
	protected int specialDefense;
	protected int speed;
	protected ArrayList<Movimiento> movimientos;
	protected int maxHP;
	protected int HP;
	protected int level;

	// Builder
	public Pokemon(int numero, String nombre, TipoPokemon tipo1, TipoPokemon tipo2, int attack, int defense,
			int specialAttack, int specialDefense, int speed, int maxHP) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.tipo1 = tipo1;
		this.tipo2 = tipo2;

		this.maxHP = maxHP;
		this.HP = maxHP;
		this.attack = attack;
		this.defense = defense;
		this.specialAttack = specialAttack;
		this.specialDefense = specialDefense;
		this.speed = speed;
		this.level = 50;
	}

	// Getters y Setters
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoPokemon getTipo1() {
		return tipo1;
	}

	public void setTipo1(TipoPokemon tipo1) {
		this.tipo1 = tipo1;
	}

	public TipoPokemon getTipo2() {
		return tipo2;
	}

	public void setTipo2(TipoPokemon tipo2) {
		this.tipo2 = tipo2;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getSpecialAttack() {
		return specialAttack;
	}

	public void setSpecialAttack(int specialAttack) {
		this.specialAttack = specialAttack;
	}

	public int getSpecialDefense() {
		return specialDefense;
	}

	public void setSpecialDefense(int specialDefense) {
		this.specialDefense = specialDefense;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public ArrayList<Movimiento> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(ArrayList<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}
	
	public int getHP() {
		return HP;
	}

	public void setHP(int HP) {
		this.HP = HP;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	// Methods
	
	/**
	 * Elije un movimiento para poder usarlo
	 * @return movimiento seleccionado
	 * @throws Exception si el movimiento elegido no existe
	 */
	public Movimiento elegirMovimiento() throws Exception {
		Scanner sc = new Scanner(System.in);
		mostrarMovimiento();
		int num = -1;

		do {
			System.out.println();
			System.out.println("Introduce el numero de la persona que deseas elegir: ");
			num = Integer.parseInt(sc.nextLine());

			if (num > movimientos.size() - 1) {
				throw new Exception("El movimiento indicado no existe.");
			} else {
				System.out.println("El movimiento ha sido seleccionado correctamente.");
			}

		} while (num > movimientos.size() - 1);

		sc.close();

		return movimientos.get(num);

	}

	/**
	 * mostrar la lista de movimientos del pokemon
	 */
	public void mostrarMovimiento() {
		int contador = 1;

		for (Movimiento m : movimientos) {
			System.out.println(contador + "- " + m.getNombre() + "(" + m.getActualPP() + "/" + m.getMaxPP() + ")");
			contador++;
		}

	}

}
