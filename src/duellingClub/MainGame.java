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
			AgentController gameAgents = containerController.createNewAgent("Game Judge", "duellingClub.JudgeAgent", null);
			AgentController jadeGUI = containerController.createNewAgent("rma", "jade.tools.rma.rma", args);
			
			jadeGUI.start();
			gameAgents.start();
		} catch (Exception e) {
			System.out.println("Error found!");
			System.out.println(e.getMessage());
		}

	}

}
