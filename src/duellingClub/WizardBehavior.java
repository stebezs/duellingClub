package duellingClub;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
   
public class WizardBehavior extends Behaviour{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int i = 1;
   
	public WizardBehavior(Agent agent) {
		super(agent);
	}
   
	public void action() {
	   if (i == 1) { 
		   System.out.println(myAgent.getLocalName( ) + " atacou o oponente " + i + " vez!");
	   } else {
		   System.out.println(myAgent.getLocalName( ) + " atacou o oponente " + " vezes!" );
	   }
	   
	   i=i +1;
    }
    public boolean done() {
    	System.out.println(myAgent.getLocalName( ) + " finalizou o ataque");

        return i > 3;
   }
}