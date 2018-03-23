package at.refugeecode.pset2.controller;

import at.refugeecode.pset2.model.Result;
import at.refugeecode.pset2.model.Move;
import at.refugeecode.pset2.model.Paper;
import at.refugeecode.pset2.model.Scissors;
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
        assertEquals(result.getWinner(),"Player2 Win");
    }
    @Test
    void testTie(){
        Move move1 = new Paper();
        Move move2 = new Paper();

        Judge judge = new Judge();
        Result result = judge.getResult(move1, move2);
        System.out.println(result.getWinner());
        assertEquals(result.getWinner(),"tie");

    }

}