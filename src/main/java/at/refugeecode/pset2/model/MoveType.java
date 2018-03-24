package at.refugeecode.pset2.model;

import org.springframework.stereotype.Component;

@Component
public enum MoveType {

    ROCK(0), PAPER(1), SCISSORS(2) ;

    private Integer number;

    MoveType(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }
}

