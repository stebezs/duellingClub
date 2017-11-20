package duellingClub;

import jade.domain.AMSService;
import jade.domain.FIPAAgentManagement.*;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.domain.AMSService;
import jade.domain.FIPAAgentManagement.AMSAgentDescription;
import jade.domain.FIPAAgentManagement.SearchConstraints;
   
public class JudgeBehavior extends Behaviour{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    AMSAgentDescription[] agents = null;
	int i = 1;
   
	public JudgeBehavior(Agent agent) {
		super(agent);
	}
   
	public void action() {

		System.out.println(myAgent.getLocalName() + " escolheu quem começa.");

    }
    public boolean done() {
    	System.out.println(myAgent.getLocalName() + " finalizou o duelo.");

        return true;
   }
}