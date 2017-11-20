package duellingClub;

import jade.core.AID;
import jade.core.Agent;


public class JudgeAgent extends Agent{
	private static final long serialVersionUID = 1L;
	
	private AID [] wizardList;
	private AID [] duelList;
	
	protected void setup() {
		System.out.println("Creating Judge");
		addBehaviour(new WizardBehavior(this));               
	}

}
