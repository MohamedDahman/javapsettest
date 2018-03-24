package at.refugeecode.pset2.model;

import org.springframework.stereotype.Component;

import  java.util.Collections;
import java.util.List;

@Component
public class ComputerPlayer implements Player {
    private Move movetype;
    @Override
    public Move getMove() {

        return movetype;
    }

    @Override
    public void setMove() {
        Moves moves = new Moves();
        List<Move> movesList = moves.getMoves();
        Collections.shuffle(movesList);
        System.out.println("Computer "+movesList.get(0).getName());
        movetype =movesList.get(0);
    }

    @Override
    public Boolean wantToPlay() {
        return true;
    }
}
