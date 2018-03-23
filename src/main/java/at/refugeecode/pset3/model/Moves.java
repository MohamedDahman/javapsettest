package at.refugeecode.pset3.model;

import java.util.ArrayList;
import java.util.List;

public class Moves {

    public List<Move>  getMoves(){
        List<Move> moves = new ArrayList<>();
        moves.add(new Rock());
        moves.add(new Scissors());
        moves.add(new Paper());
        moves.add(new Lizard());
        moves.add(new Spock()) ;
        return  moves;
    }

}
