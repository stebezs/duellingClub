package duellingClub;

import java.util.Random;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.ThreadedBehaviourFactory;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;


public class JudgeAgent extends Agent{
	private static final long serialVersionUID = 1L;

	private AID [] wizardList;
	private AID [] duelList;
	private AID judge;
	private int judgeStep = 0;

	protected void setup() {
		System.out.println("Creating Judge");
		
		// Search for new players
		addBehaviour(new TickerBehaviour(this, 5000) {

			private static final long serialVersionUID = 1L;

			protected void onTick() {
				System.out.println("Searching for wizards");
				
				// Update the list of wizards agents
				DFAgentDescription template = new DFAgentDescription();
				ServiceDescription sd = new ServiceDescription();
				sd.setType("waiting-duel");
				template.addServices(sd);
				
				try {
					DFAgentDescription[] result = DFService.search(myAgent, template); 
					
					if (result.length >= 2) {
						System.out.println("Found the following wizards:");
						wizardList = new AID[result.length];
						
						wizardList[0] = result[0].getName();
						wizardList[1] = result[1].getName();
						
						for(AID item : wizardList) {
							System.out.println(item.getName());
						}
					} else {
						System.out.println("Not found 2 available wizards");
						// DO NOTHING
						// NEEDS TWO WIZARDS
					}
				}
				catch (FIPAException fe) {
					fe.printStackTrace();
				}

				// Perform the request
				//myAgent.addBehaviour(new RequestPerformer());
			}
		} );

	}
}
