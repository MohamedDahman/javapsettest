package at.refugeecode.pset3.model;

import java.util.ArrayList;
import java.util.List;


public class Lizard implements Move{
    private List<Move> defeatList =new ArrayList<>();

    @Override
    public List<Move> whoCanDefeat() {
        defeatList.add(new Paper());
        defeatList.add(new Spock()) ;
        return  defeatList;
    }

    @Override
    public String getName() {
        return "Lizard";
    }
}
