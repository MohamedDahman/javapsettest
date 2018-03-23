package at.refugeecode.pset3.model;

import java.util.Optional;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private Scanner scanner = new Scanner(System.in);
    private Move movetype;

    @Override
    public void setMove()
    {
        Moves moves = new Moves();
        Optional<Move> first = Optional.empty();
        do {
            System.out.println("Please Enter one Of them ROCK, PAPER, SCISSORS ,Spock ,Lizard");
            String choice = scanner.nextLine();
            first = moves.getMoves().stream()
                    .filter(e -> e.getName().equalsIgnoreCase(choice))
                    .findFirst();
        } while (!first.isPresent());
        movetype = first.get();
    }

    @Override
    public Move getMove() {
        return  movetype;
    }


    @Override
    public Boolean wantToPlay() {
        System.out.println("Do you want to Play again? y/n");
        String choice = scanner.nextLine();
        return choice.equalsIgnoreCase("y");
    }

}
