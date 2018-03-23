package at.refugeecode.pset1.model;

import at.refugeecode.pset1.controller.MovieDatabaseSummarizer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class SummaryTest {

  /*  MovieActorParser movieActorParser = new MovieActorParser();
    List<MovieActors> moviesActor = movieActorParser.getMoviesActor("src/main/java/at/refugeecode/pset1/data/actors.csv");
*/


/*
    MovieParser movieParser = new MovieParser();
    List<Movie> movieList = movieParser.getMovies("src/at/refugeecode/pset1/data/movies.csv");
*/

    MovieDatabaseSummarizer movieDatabaseSummarizer ;

    @Before
    public void SummaryTest() {
        movieDatabaseSummarizer = new MovieDatabaseSummarizer();
    }


    @Test
    public void getMostMovieGenres() {
        Summary summarize = movieDatabaseSummarizer.summarize();
        List<String> mostMovieGenres = summarize.getMostMovieGenres();
        assertEquals(Arrays.asList("Drama 14495","Comedy 8955"),mostMovieGenres);
    }

    @Test
    public void getMaleFemaleRatio() {
        Summary summarize = movieDatabaseSummarizer.summarize();
        String maleFemaleRatio = summarize.getMaleFemaleRatio();
        System.out.println(maleFemaleRatio);
        assertEquals("Man0.6041223230963034 Woaman0.39587767690369663",maleFemaleRatio);
    }

    @Test
    public void getMostHiredActors() {
        Summary summarize = movieDatabaseSummarizer.summarize();
        List<String> mostHiredActors = summarize.getMostHiredActors();


        List<String> theresult= new ArrayList<>();
        theresult.add("Bess Flowers 81");
        theresult.add("Christopher Lee 69");
        theresult.add("Grey Griffin 58");
        theresult.add("Danny Trejo 54");
        theresult.add("Eric Roberts 52");
        assertEquals(theresult,mostHiredActors);
    }


    @Test
    public void getTopMovieRate() {
        Summary summarize = movieDatabaseSummarizer.summarize();
        List<Movie> topMovieRate = summarize.getTopMovieRate();
        List<String> collect = topMovieRate.stream().map(e -> e.getTitle()).collect(Collectors.toList());

        List<String> list = Arrays.asList("Reckless", "Girl in the Cadillac", "The Haunted World of Edward D. Wood, Jr.", "Carmen Miranda: Bananas Is My Business", "Other Voices Other Rooms");
        assertEquals(list,collect);


    }
}