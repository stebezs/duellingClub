package duellingClub;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;


public class JudgeAgent extends Agent {
	private static final long serialVersionUID = 1L;

	private AID [] wizardList;
	private boolean inDuel = false;
	
	protected void setup() {
		System.out.println("Creating Judge");

		// Search for new players
		addBehaviour(new TickerBehaviour(this, 1000) {

			private static final long serialVersionUID = 1L;

			protected void onTick() {
				if(!inDuel) {
					System.out.println("Searching for wizards");

					// Update the list of wizards agents
					DFAgentDescription template = new DFAgentDescription();
					ServiceDescription sd = new ServiceDescription();
					sd.setType("waiting-duel");
					template.addServices(sd);

					// Trying to get to wizards to duel
					try {
						DFAgentDescription[] result = DFService.search(myAgent, template);

						if (result.length >= 2) {
							System.out.println("Found the following wizards:");

							wizardList = new AID [result.length];
							wizardList[0] = result[0].getName();
							wizardList[1] = result[1].getName();

							for(AID item : wizardList) {
								System.out.println(item.getName());
							}
							
							// Starts and monitor the duel
							System.out.println("Starting duel");
							inDuel = true;
							myAgent.addBehaviour(new JudgeBehavior(wizardList));
							
						} else {
							System.out.println("Not found 2 available wizards");
							block();
						}
					}
					catch (FIPAException fe) {
						fe.printStackTrace();
					}	
				} else {
					System.out.println("JUDGE: Already in duel!");
					block();
				}
			}
		} );
	}
}
