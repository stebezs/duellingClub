package duellingClub;

import java.util.Random;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.ThreadedBehaviourFactory;
import jade.core.behaviours.TickerBehaviour;


public class JudgeAgent extends Agent{
	private static final long serialVersionUID = 1L;

	private AID [] wizardList;
	private AID [] duelList;
	private AID judge;

	protected void setup() {
		System.out.println("Creating Judge");

	}
}
