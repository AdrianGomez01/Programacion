package Tema5.boletin2t52;

public class EsportsTournament {

	public static void main(String[] args) {
		EsportsTournament tournament = new EsportsTournament();
		Gamer[] gamers = new Gamer[3];
		gamers[0] = new SportsGamer();
		gamers[1] = new MOBAGamer();
		gamers[2] = new FPSGamer();
		tournament.startTournament(gamers);
	}

	public void startTournament(Gamer[] players) {
		for (Gamer gamer : players) {
			gamer.playGame();

		}

	}
}
