package at.refugeecode.pset3.model;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractMoves {

    public Map whoDefeatWho(){
        Map<Move, Move> DefeatDetails = new HashMap();
        DefeatDetails.put(new Rock(), new Scissors());
        DefeatDetails.put(new Rock(), new Lizard());

        DefeatDetails.put(new Paper(), new Rock());
        DefeatDetails.put(new Paper(), new Spock());

        DefeatDetails.put(new Scissors(), new Paper());
        DefeatDetails.put(new Scissors(), new Lizard());

        DefeatDetails.put(new Lizard(), new Paper());
        DefeatDetails.put(new Lizard(), new Spock());

        DefeatDetails.put(new Spock(), new Scissors());
        DefeatDetails.put(new Spock(), new Rock());

        return DefeatDetails;

    }

}
