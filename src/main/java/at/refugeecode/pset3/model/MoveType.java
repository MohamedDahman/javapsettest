package at.refugeecode.pset3.model;

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

