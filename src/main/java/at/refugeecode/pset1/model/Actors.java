package at.refugeecode.pset1.model;

public class Actors {
    private String name;
    private int gender;

    @Override
    public String toString() {
        return "Actors{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }

    public Actors() {
    }

    public Actors(String name, int gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
