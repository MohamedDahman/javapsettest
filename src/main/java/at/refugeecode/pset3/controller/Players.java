package at.refugeecode.pset3.controller;

import at.refugeecode.pset3.model.ComputerPlayer;
import at.refugeecode.pset3.model.HumanPlayer;
import at.refugeecode.pset3.model.Player;

import java.util.ArrayList;
import java.util.List;

public class Players {
    public List<Player> getTwoPlayers(){
        List<Player> players=new ArrayList<>();
        players.add(new HumanPlayer());
        players.add(new ComputerPlayer());
        return  players;
    }
}
