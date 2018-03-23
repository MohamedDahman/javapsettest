package at.refugeecode.pset3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Spock implements Move{
    private List<Move> defeatList =new ArrayList<>();

    @Override
    public List<Move> whoCanDefeat() {
        defeatList.add(new Scissors());
        defeatList.add(new Rock()) ;
        return defeatList;

    }


    @Override
    public String getName() {
        return "Spock";
    }
}
