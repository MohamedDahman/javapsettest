package at.refugeecode.pset2;

import at.refugeecode.pset2.controller.Judge;
import at.refugeecode.pset2.controller.Players;
import at.refugeecode.pset2.model.Player;
import at.refugeecode.pset2.model.Result;
import oop.pset2.view.Host;

import java.util.List;

public class Pset2Main {

    public static void main(String[] args) {


        // create player 1  Human
        // create Player 2  computer

        // ASK Player 1 to get us Move
        // ASK Player 2 to get us Move

        // decide who is winer
        //return to step number 3 to paly again



        Host host = new Host();
        host.welcome();
        Players players = new Players();
        List<Player> twoPlayers = players.getTwoPlayers();
        Player player1 = twoPlayers.get(0);
        Player player2 = twoPlayers.get(1);
        Boolean playersWantToPlay = true;
        while (playersWantToPlay) {
            playOneRound(player1, player2);


            Judge judge = new Judge();
            Result result = new Result();
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
