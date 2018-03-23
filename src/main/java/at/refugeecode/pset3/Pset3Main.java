package at.refugeecode.pset3;


import at.refugeecode.pset3.controller.Judge;
import at.refugeecode.pset3.controller.Players;
import at.refugeecode.pset3.model.Player;
import at.refugeecode.pset3.model.Result;
import at.refugeecode.pset3.view.Host;

import java.util.List;

public class Pset3Main {

    public static void main(String[] args) {

        Host host = new Host();
        host.welcome();
        Players players = new Players();
        List<Player> twoPlayers = players.getTwoPlayers();
        Player player1 = twoPlayers.get(0);
        Player player2 = twoPlayers.get(1);
        Boolean playersWantToPlay = true;
        while (playersWantToPlay) {
            playOneRound(player1, player2);
            Result result = new Result();
            Judge judge = new Judge();
            result = judge.getResult(player1.getMove(), player2.getMove());
            System.out.println(result.getWinner());
            playersWantToPlay = ask(player1, player2);
        }
        host.goodbye();


    }

    private static void playOneRound(Player player1, Player player2) {
        player1.setMove();
        player2.setMove();
    }

    private static Boolean ask(Player player1, Player player2) {
        return player1.wantToPlay() && player2.wantToPlay();
    }
}
