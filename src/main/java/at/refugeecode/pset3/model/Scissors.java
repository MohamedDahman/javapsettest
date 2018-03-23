package at.refugeecode.pset3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Scissors implements Move {

    private List<Move> defeatList =new ArrayList<>();

    @Override
    public List<Move>  whoCanDefeat() {
        defeatList.add(new Paper());
        defeatList.add(new Lizard());
        return  defeatList;
    }


    @Override
    public String getName() {
        return "scissors";
    }
    }
