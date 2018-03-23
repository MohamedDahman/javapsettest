package at.refugeecode.pset3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Paper implements Move {

    private List<Move> defeatList =new ArrayList<>();


    @Override
    public List<Move> whoCanDefeat() {
        defeatList.add(new Rock());
        defeatList.add(new Spock());
        return  defeatList;
    }

    @Override
    public String getName() {
        return "paper";
    }

}
