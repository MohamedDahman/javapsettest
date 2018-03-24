package at.refugeecode.pset2.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Moves {

    public List<Move>  getMoves(){
        List<Move> moves = new ArrayList<>();
        moves.add(new Rock());
        moves.add(new Scissors());
        moves.add(new Paper());
        return  moves;
    }

}
