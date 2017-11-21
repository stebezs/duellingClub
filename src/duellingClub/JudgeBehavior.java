package duellingClub;

import jade.domain.AMSService;
import jade.domain.FIPAAgentManagement.*;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.domain.AMSService;
import jade.domain.FIPAAgentManagement.AMSAgentDescription;
import jade.domain.FIPAAgentManagement.SearchConstraints;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class JudgeBehavior extends Behaviour {

	private static final long serialVersionUID = 1L;
	private AID [] wizardList = { };
	private MessageTemplate [] messageTempl;
	private int step = 0;

	public JudgeBehavior(AID [] wizards) {
		this.wizardList = wizards.clone();
	}

	public void action() {
		switch (step) {
			case 0:
				// Send info about the wizards
				ACLMessage firstWizard = new ACLMessage(ACLMessage.INFORM);
				ACLMessage secondWizard = new ACLMessage(ACLMessage.INFORM);
	
				firstWizard.addReceiver(wizardList[0]);
				firstWizard.setContent(wizardList[1].toString());
				firstWizard.setConversationId("prep-duel-wizards");
				firstWizard.setReplyWith("cpf " + System.currentTimeMillis());
	
				secondWizard.addReceiver(wizardList[1]);
				secondWizard.setContent(wizardList[0].toString());
				secondWizard.setConversationId("prep-duel-wizards");
				secondWizard.setReplyWith("cpf " + System.currentTimeMillis());
	
				myAgent.send(firstWizard);
				System.out.println("Judge: Info about Wizard1 sent.");
				myAgent.send(secondWizard);
				System.out.println("Judge: Info about Wizard2 sent.");
	
				// Go to the next step in the Behavior
				//step = 1;
				break;
			case 1:
				// Watching duel info about the duel
				break;
		
		}        
	}

	public boolean done() {
		return false;
	}
}