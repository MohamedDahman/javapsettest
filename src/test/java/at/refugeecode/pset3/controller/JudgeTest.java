package at.refugeecode.pset3.controller;

import at.refugeecode.pset3.controller.Judge;
import at.refugeecode.pset3.model.Move;
import at.refugeecode.pset3.model.Paper;
import at.refugeecode.pset3.model.Result;
import at.refugeecode.pset3.model.Scissors;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JudgeTest {

    @Test
    void getResult() {
        Move move1 = new Paper();
        Move move2 = new Scissors();

        Judge judge = new Judge();
        Result result = judge.getResult(move1, move2);
        System.out.println(result.getWinner());
        assertEquals(result.getWinner(),"Player1 Win");
    }
}