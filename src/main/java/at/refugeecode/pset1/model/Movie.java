package at.refugeecode.pset1.model;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class Movie {

    private String title;
    private List<String> genres;
    private Float vote_average;

    public Movie()
    {

    }


    public Movie(String title , List<String> genres , Float vote_average)
    {
        this.title = title;
        this.vote_average = vote_average;
        this.genres = genres;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public Float getVote_average() {
        return vote_average;
    }

    public void setVote_average(Float vote_average) {
        this.vote_average = vote_average;
    }
}
