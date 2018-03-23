package at.refugeecode.pset3.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomChoice {

    public Move getOneAtRandom() {
        List<Move> moves = getMoveType();
        Collections.shuffle(moves);
        Move firstMove = moves.get(0);
        return firstMove;
    }

    public List<Move> getMoveType() {
        return Stream.of(
                new Rock(),
                new Scissors(),
                new Paper())
                .collect(Collectors.toList());
    }

}
