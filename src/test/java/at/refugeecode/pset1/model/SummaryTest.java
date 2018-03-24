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

    Summary summary;

    @Test
    public void testMoiveGeneres(){
        Summary summary = new Summary();
        List<String> listGeneres = new ArrayList<>();
        listGeneres.add("Drama 50");
        listGeneres.add("Comedy 40");
        //Summary summary = new Summary();
        summary.setMostMovieGenres(listGeneres);
        assertEquals(Arrays.asList("Drama 50","Comedy 40"),summary.getMostMovieGenres());
    }

    @Test
    public void testMaleFemaileRatio(){
        Summary summary = new Summary();
        summary.setMaleFemaleRatio("Man 0.66 Woman0.34");
        assertEquals("Man 0.66 Woman0.34",summary.getMaleFemaleRatio());
    }

    @Test
    public void testmostHiredActors(){

        Summary summary = new Summary();

        List<String> mostHiredActors = new ArrayList<>();
        mostHiredActors.add("Bess Flowers 81");
        mostHiredActors.add("Christopher Lee 69");
        mostHiredActors.add("Grey Griffin 58");
        mostHiredActors.add("Danny Trejo 54");
        mostHiredActors.add("Eric Roberts 52");
        summary.setMostHiredActors(mostHiredActors);

        List<String> theresult= new ArrayList<>();
        theresult.add("Bess Flowers 81");
        theresult.add("Christopher Lee 69");
        theresult.add("Grey Griffin 58");
        theresult.add("Danny Trejo 54");
        theresult.add("Eric Roberts 52");

        assertEquals(theresult,summary.getMostHiredActors());



        //summary.set
    }


    @Test
    public void TestTopMovieRate() {
        Summary summary = new Summary();

        //summary.setTopMovieRate()
       List<Movie> movieList = new ArrayList<>();

       Movie movie1 = new Movie();
       movie1.setTitle("Reckless");
       movie1.setGenres(Arrays.asList("Comody"));
       movie1.setVote_average((float) 10);

       Movie movie2 = new Movie();
       movie2.setTitle("Girl in the Cadillac");
       movie2.setGenres(Arrays.asList("Comody"));
       movie2.setVote_average((float) 8);
       movieList.add(movie1);
       movieList.add(movie2);
       summary.setTopMovieRate(movieList);

       movieList.add(movie1);
       movieList.add(movie2);

       List<String> list = Arrays.asList("Reckless", "Girl in the Cadillac");
       assertEquals(movieList,summary.getTopMovieRate());
    }
}