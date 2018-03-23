package at.refugeecode.pset3.controller;


import at.refugeecode.pset3.model.Move;
import at.refugeecode.pset3.model.Result;

import java.util.List;
import java.util.Optional;


public class Judge {

    public Result getResult(Move move1, Move move2){
        Result result = new Result();
        result.setMove1(move1);
        result.setMove2(move2);

        result.setWinner(getWinner(move1, move2));
        return result;
    }

    private String getWinner(Move move1,Move move2)
    {
           if (move1.getName().equalsIgnoreCase(move2.getName()))
               return  "tie";
           List<Move> moveList= move1.whoCanDefeat();
           Optional<Move> first = moveList.stream()
                   .filter(e -> e.getName().equalsIgnoreCase(move2.getName()))
                        .findFirst();
           if (first.isPresent()) {
               return "Player1 Win";
           }
           return "Player2 Win";
       }
/*
    private String getWinner(Move move1, Move move2)
    {
        if (move1.getName().equalsIgnoreCase(move2.getName())) {
             return "tie";
        }
        if (move1.getName().equalsIgnoreCase("rock")) {
            if (move2.getName().equalsIgnoreCase("scissors"))
                return "Player1 Win";
            else
                return  "Player2 Win";
        }
        if (move1.getName().equalsIgnoreCase("paper")) {
            if (move2.getName().equalsIgnoreCase("rock"))
                return  "Player1 Win";
            else
                return "Player2 Win";
        }
        if (move1.getName().equalsIgnoreCase("scissors")) {
            if (move2.getName().equalsIgnoreCase("paper"))
                return "Player1 Win";
            else
                return  "Player2 Win";
        }
        return "";

    }*/


}
