package at.refugeecode.pset3.model;

import java.util.ArrayList;
import java.util.List;


public class Rock implements Move {

    private List<Move> defeatList =new ArrayList<>();

    @Override
    public List<Move>  whoCanDefeat() {
        defeatList.add(new Scissors());
        defeatList.add(new Lizard());
        return  defeatList;
    }

    @Override
    public String getName() {
        return "rock";
    }

/*
    @Override
    public Boolean canDefeat(Move Oppositemove) {
        whoCanDefeat();
        Optional<Move> first = defeatList.stream()
                .filter(e -> e.getName().equalsIgnoreCase(Oppositemove.getName()))
                .findFirst();
        if (first.isPresent()) {
            return true;
        }
        return false;
    }*/
}
