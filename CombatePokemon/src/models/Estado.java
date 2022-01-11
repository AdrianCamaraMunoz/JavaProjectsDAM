package models;

public class Estado {
	//Propiedades
	private String nombre;
	
	//Builders
	public Estado(String nombre) {
		this.nombre = nombre;
	}
	
	//Getters and Setters 
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * comprueba el daño o efecto causado por los diferentes estados
	 * @param atacante pokemon que ataca
	 * @param defensor pokemon que recibe el ataque
	 * @param estado estado que causa el atacante al defensor
	 */
	public void getEstado(Pokemon atacante, Pokemon defensor, String estado) {
		switch(estado) {
		case "Drenado":
			defensor.setHP(defensor.getHP() - (defensor.getMaxHP()/8));
			atacante.setHP(atacante.getHP() + (defensor.getMaxHP()/8));
			if(atacante.getHP() > atacante.getMaxHP()) {
				atacante.setHP(atacante.getMaxHP());
			}
			System.out.println(defensor.getNombre() + " tiene drenado, pierde " + (defensor.getMaxHP()/8) + " de vida, que recupera " + atacante.getNombre());
			defensor.setEstado("Drenado");
			break;
		case "Dormido":
			System.out.println(defensor.getNombre() + " está dormido.");
			defensor.setEstado("Dormido");
			break;
		case "Envenenado":
			defensor.setHP(defensor.getHP() - (defensor.getMaxHP()/8));
			System.out.println(defensor.getNombre() + " está envenenado.");
			defensor.setEstado("Envenenado");
		case "Quemado":
			defensor.setHP(defensor.getHP() - (defensor.getMaxHP()/16));
			defensor.setAttack(defensor.getAttack() - (int)(defensor.getAttack() * 0.5));
			defensor.setEstado("Quemado");

		}

	}

}
