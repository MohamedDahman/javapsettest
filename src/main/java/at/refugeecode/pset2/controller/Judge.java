package at.refugeecode.pset2.controller;

import at.refugeecode.pset2.model.Move;
import at.refugeecode.pset2.model.Result;
import org.springframework.stereotype.Component;

@Component
public class Judge {

    public Result getResult(Move move1, Move move2){
        Result result = new Result();
        result.setMove1(move1);
        result.setMove2(move2);
        result.setWinner(getWinner(move1, move2));
        return result;
    }
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

    }


}
