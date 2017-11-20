package duellingClub;

import jade.core.Runtime;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;

public class MainGame {

	public static void main(String[] args) {
		// JADE initialization
		try {
			Runtime jadeRuntime = Runtime.instance();
			Profile profile = new ProfileImpl(null, 1200, null);
			ContainerController containerController = jadeRuntime.createMainContainer(profile);
			
			// Game agents instantiation
			AgentController judgeAgent = containerController.createNewAgent("Game Judge", "duellingClub.JudgeAgent", null);
			AgentController wizard1 = containerController.createNewAgent("Wizard 1", "duellingClub.WizardAgent", null);
			AgentController wizard2 = containerController.createNewAgent("Wizard 2", "duellingClub.WizardAgent", null);
			AgentController jadeGUI = containerController.createNewAgent("rma", "jade.tools.rma.rma", args);
			
			jadeGUI.start();
			judgeAgent.start();
			wizard1.start();
			wizard2.start();
		} catch (Exception e) {
			System.out.println("Error found!");
			System.out.println(e.getMessage());
		}

	}

}
