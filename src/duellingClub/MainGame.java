package duellingClub;

public class MainGame {

	public static void main(String[] args) {
		// TODO Create Wizard list, Judge and start the game
		System.out.println("Criando novo Jogo! ");
		WizardAgent joseTheWizard = new WizardAgent();
		WizardAgent cileideTheWIzard = new WizardAgent();
		JudgeAgent judge = new JudgeAgent();
		System.out.println("Chamando setup do agente! ");
		
		System.out.println("Criando jogadores");
		joseTheWizard.setup();
		cileideTheWIzard.setup();
		judge.setup();
	}

}
