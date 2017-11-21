package duellingClub;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;


public class WizardAgent extends Agent{
	private static final long serialVersionUID = 1L;
	
	private static final float attackPoints = 10;
	private static final float defensePoints = 2;
	private float health = 100;
	private boolean available = true;
	
	private AID dueler = null;
	private AID gameJudge = null;

	protected void setup() {
		System.out.println("Creating Wizard");
		
		// On start, register on yellow pages an intention of duel
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
		
		// Wait for a dueler
		addBehaviour(new CyclicBehaviour() {
			private static final long serialVersionUID = 1L;

			@Override
			public void action() {
				ACLMessage duelerInfo = receive();
				if(duelerInfo != null) {
					System.out.println(getAID() + ": Info received: " + duelerInfo.getContent());
					gameJudge = duelerInfo.getSender();
					//dueler = dfd.getName(duelerInfo.getContent());
				} else {
					System.out.println(getAID() + ": Still waiting dueler...");
				}
				
				
			}
		});

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
