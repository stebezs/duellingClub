package duellingClub;

import jade.core.Agent;


public class WizardAgent extends Agent{
	private static final long serialVersionUID = 1L;
	private static final float attackPoints = 10;
	
	private float health = 100;
	private boolean available = true;

	protected void setup() {
		System.out.println("Creating Wizard");
		addBehaviour(new WizardBehavior(this));               

	}
	
	
	
	
	// GETTERS  and Setters 
	public float getHealth() {
		return health;
	}
	public void setHealth(float health) {
		this.health = health;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public static float getAttackpoints() {
		return attackPoints;
	}
	

}
