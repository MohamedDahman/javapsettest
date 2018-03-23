package at.refugeecode.pset1.controller;


import at.refugeecode.pset1.model.Movie;
import at.refugeecode.pset1.model.MovieActors;
import at.refugeecode.pset1.model.Summary;
import at.refugeecode.pset1.parser.MovieActorParser;
import at.refugeecode.pset1.parser.MovieParser;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



public class MovieDatabaseSummarizer {

    public Summary summarize() {

        MovieActorParser movieActorParser = new MovieActorParser();
        MovieParser movieParser = new MovieParser();
        List<MovieActors> moviesActor = movieActorParser.getMoviesActor("src\\main\\java\\at\\refugeecode\\pset1\\data\\actors.csv");

        List<Movie> movieList = movieParser.getMovies("src\\main\\java\\at\\refugeecode\\pset1\\data\\movies.csv");

        Summary summary = new Summary();
        summary.setTopMovieRate(getTopMovieRate(movieList));
        summary.setMostMovieGenres(getGenersTopNumber(movieList,2));

        summary.setMostHiredActors(mostHiredActors(moviesActor,5));
        summary.setMaleFemaleRatio(getpercent(moviesActor));
        return summary;

    }




    public static List<Movie> getTopMovieRate(List<Movie> originalList)
    {
        return originalList.stream()
                .sorted((e1,e2)-> e2.getVote_average().compareTo(e1.getVote_average()))
                .limit(5)
                .collect(Collectors.toList());
    }

    public static List<String> getGenersTopNumber(List<Movie> originalList, int top){

        Map<String, Long> appearances = originalList.stream()
                .filter(e -> e.getGenres().size() != 0)
                .map(vote -> vote.getGenres())
                .flatMap(e -> e.stream())
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        List<String> topGeners = appearances.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .map(e -> e.getKey() + " " + e.getValue() )
                .limit(top)
                .collect(Collectors.toList());
        return topGeners;
    }



    public static List<String> mostHiredActors(List<MovieActors> originalList, int top){

        Map<String, Long> appearances = originalList.stream()
                .filter(e -> e.getActorList().size() != 0)
                .map(hirelist -> hirelist.getActorList())
                .flatMap(e -> e.stream())
                .map(e -> e.getName())
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        List<String> topGeners = appearances.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .map(e -> e.getKey() + " " + e.getValue() )
                .limit(top)
                .collect(Collectors.toList());
        return topGeners;
    }



    public static Integer countHireByGender(List<MovieActors> originalList, Integer Gender){
        Map<String, Long> appearances = originalList.stream()
                .filter(e -> e.getActorList().size() != 0)
                .map(hirelist -> hirelist.getActorList())
                .flatMap(e -> e.stream())
                .filter(e -> e.getGender()== Gender)
                .map(e -> e.getName())
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        Integer topGeners = Math.toIntExact(appearances.entrySet().stream().count());

        return topGeners;
    }


   public static String getpercent(List<MovieActors> originalList) {
       double men = countHireByGender(originalList, 2);
       double women = countHireByGender(originalList, 1);
       double total = men + women;

       double menPercent = men / total;
       double womenPercent = women / total;
       String result = "Man"+ menPercent+" Woamn"+womenPercent;
       return  result;

   }


}
