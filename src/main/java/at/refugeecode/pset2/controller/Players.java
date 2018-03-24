package at.refugeecode.pset2.controller;

import at.refugeecode.pset2.model.ComputerPlayer;
import at.refugeecode.pset2.model.HumanPlayer;
import at.refugeecode.pset2.model.Player;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Players {
    public List<Player> getTwoPlayers(){
        List<Player> players=new ArrayList<>();
        players.add(new HumanPlayer());
        players.add(new ComputerPlayer());
        return  players;
    }
}
