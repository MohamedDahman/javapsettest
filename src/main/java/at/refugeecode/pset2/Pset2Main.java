package at.refugeecode.pset2;

import at.refugeecode.pset2.controller.Judge;
import at.refugeecode.pset2.controller.Players;
import at.refugeecode.pset2.model.Player;
import at.refugeecode.pset2.model.Result;
import oop.pset2.view.Host;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Pset2Main {


    public static void playOneRound(Player player1, Player player2) {
            player1.setMove();
            player2.setMove();
     }

    public static Boolean ask(Player player1, Player player2) {
        return player1.wantToPlay() && player2.wantToPlay();
    }
}
