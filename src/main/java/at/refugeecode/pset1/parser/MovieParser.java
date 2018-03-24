package at.refugeecode.pset1.parser;

import at.refugeecode.pset1.model.Movie;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Component
public class MovieParser {


    public  List<Movie> getMovies(String filePath) {
        try {
            Stream<String> lines = Files.lines(Paths.get(filePath));
            return lines.skip(1)
                    .map(line -> line.split(";"))
                    .filter(line -> line.length == 24 )
                    .map(toMovie())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();

        }

    }


    private static List<String> toGeneres(String column) {
        String objects = column.replaceAll("\\[", "").replaceAll("]", "");
        objects = objects.replaceAll("[0-9]", "");
        objects = objects.replaceAll("\\{", "").replaceAll("}", "");
        objects = objects.replaceAll("\\'name\\': ", "");
        objects = objects.replaceAll("\\'id\\': ", "");
        objects = objects.replaceAll("\\'", "");
        objects = objects.replaceAll(" ", "");
        objects = objects.replaceAll(",,", ",");
        String[] generes = objects.split(",");
        return Stream.of(generes)
                .filter(e -> e.length()!=0)
                .collect(Collectors.toList());
    }

    private static Function<String[], Movie> toMovie() {
        return columns -> {
            Movie movie = new Movie();
            movie.setTitle(columns[20]);
            movie.setVote_average(Float.parseFloat(columns[22]));
            movie.setGenres(toGeneres(columns[3]));
            return movie;
        };
    }


}
