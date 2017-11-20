package duellingClub;

import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;


public class WizardAgent extends Agent{
	private static final long serialVersionUID = 1L;
	private static final float attackPoints = 10;
	
	private float health = 100;
	private boolean available = true;

	protected void setup() {
		System.out.println("Creating Wizard");
		
		DFAgentDescription dfd = new DFAgentDescription();
		dfd.setName(getAID());
		ServiceDescription sd = new ServiceDescription();
		sd.setType("waiting-duel");
		sd.setName("Wizard");
		dfd.addServices(sd);	
		
		try {
			DFService.register(this, dfd);
		}
		catch (FIPAException fe) {
			fe.printStackTrace();
		}

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
