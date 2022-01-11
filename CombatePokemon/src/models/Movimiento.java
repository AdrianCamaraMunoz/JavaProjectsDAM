package models;

public class Movimiento {
	//Propiedades
	private String nombre;
	private TipoPokemon tipo;
	private TipoClase clase;
	private double precision;
	private int maxPP;
	private int actualPP;
	private int damage;
	private double modAttack;
	private double modDef;
	private double modSpDef;
	private double modSpeed;
	private double modHP;
	private Estado aplicaEstado;
	private double probabilidadEstado;
	private double modAttackRival;
	private double modDefRival;
	private double modSpDefRival;
	private double modSpeedRival;
	private double modHPRival;
	
	//Builder
	public Movimiento(String nombre, TipoPokemon tipo, TipoClase clase, int damage, double precision, int maxPP, double modAttack,
			double modDef, double modSpDef, double modSpeed, double modHP, Estado aplicaEstado, double probabilidadEstado, double modAttackRival,
			double modDefRival, double modSpDefRival, double modSpeedRival, double modHPRival) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.clase = clase;
		
		this.damage = damage;
		this.precision = precision;
		this.maxPP = maxPP;
		
		this.modAttack = modAttack;
		this.modDef = modDef;
		this.modSpDef = modSpDef;
		this.modSpeed = modSpeed;
		this.modHP = modHP;
		
		this.aplicaEstado = aplicaEstado;
		this.probabilidadEstado = probabilidadEstado;
		
		this.modAttackRival = modAttackRival;
		this.modDefRival = modDefRival;
		this.modSpDefRival = modSpDefRival;
		this.modSpeedRival = modSpeedRival;
		this.modHPRival = modHPRival;
		
		this.actualPP = maxPP;
	}

	//Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoPokemon getTipo() {
		return tipo;
	}

	public void setTipo(TipoPokemon tipo) {
		this.tipo = tipo;
	}

	public TipoClase getClase() {
		return clase;
	}

	public void setClase(TipoClase clase) {
		this.clase = clase;
	}

	public double getPrecision() {
		return precision;
	}

	public void setPrecision(double precision) {
		this.precision = precision;
	}

	public int getMaxPP() {
		return maxPP;
	}

	public void setMaxPP(int maxPP) {
		this.maxPP = maxPP;
	}

	public int getActualPP() {
		return actualPP;
	}

	public void setActualPP(int actualPP) {
		this.actualPP = actualPP;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public double getModAttack() {
		return modAttack;
	}

	public void setModAttack(double modAttack) {
		this.modAttack = modAttack;
	}

	public double getModDef() {
		return modDef;
	}

	public void setModDef(double modDef) {
		this.modDef = modDef;
	}

	public double getModSpDef() {
		return modSpDef;
	}

	public void setModSpDef(double modSpDef) {
		this.modSpDef = modSpDef;
	}

	public double getModSpeed() {
		return modSpeed;
	}

	public void setModSpeed(double modSpeed) {
		this.modSpeed = modSpeed;
	}

	public double getModHP() {
		return modHP;
	}

	public void setModHP(double modHP) {
		this.modHP = modHP;
	}

	public Estado getAplicaEstado() {
		return aplicaEstado;
	}

	public void setAplicaEstado(Estado aplicaEstado) {
		this.aplicaEstado = aplicaEstado;
	}

	public double getProbabilidadEstado() {
		return probabilidadEstado;
	}

	public void setProbabilidadEstado(double probabilidadEstado) {
		this.probabilidadEstado = probabilidadEstado;
	}

	public double getModAttackRival() {
		return modAttackRival;
	}

	public void setModAttackRival(double modAttackRival) {
		this.modAttackRival = modAttackRival;
	}

	public double getModDefRival() {
		return modDefRival;
	}

	public void setModDefRival(double modDefRival) {
		this.modDefRival = modDefRival;
	}

	public double getModSpDefRival() {
		return modSpDefRival;
	}

	public void setModSpDefRival(double modSpDefRival) {
		this.modSpDefRival = modSpDefRival;
	}

	public double getModSpeedRival() {
		return modSpeedRival;
	}

	public void setModSpeedRival(double modSpeedRival) {
		this.modSpeedRival = modSpeedRival;
	}

	public double getModHPRival() {
		return modHPRival;
	}

	public void setModHPRival(double modHPRival) {
		this.modHPRival = modHPRival;
	}
	
	
	
	
	
	
	
	
}
