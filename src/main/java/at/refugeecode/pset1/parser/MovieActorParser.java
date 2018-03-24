package at.refugeecode.pset1.parser;

import at.refugeecode.pset1.model.Actors;
import at.refugeecode.pset1.model.MovieActors;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Component
public class MovieActorParser {



    public  List<MovieActors> getMoviesActor(String filePath) {
        try {
            Stream<String> lines = Files.lines(Paths.get(filePath));
            return lines.skip(1)
                    .map(line -> line.split(";"))
                    .filter(line -> line.length == 3 )
                    .filter(e -> e[0].toString().length()>2)
                    .map(toMovieList())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();

        }

    }

    private static Function<String[], MovieActors> toMovieList() {
        return columns -> {
            MovieActors movieActors = new MovieActors();
            movieActors.setId(Integer.parseInt(columns[2]));
            movieActors.setActorList(toActorList(columns[0]));
            return movieActors;
        };
    }


    private static Map<String , Integer> toActor(String column) {
        String objects = column.replaceAll("\\[", "").replaceAll("]", "");
        String[] actors = objects.split(",");
        List<String> maleAndFemal = Stream.of(actors)
                .filter(E -> E.contains("gender") || E.contains("\'name\'"))
                //.peek(e-> System.out.println(e))
                .collect(Collectors.toList());

        List<String> names = maleAndFemal;
        List<String > gender = maleAndFemal;
        String nameString = names.stream()
                .filter(e-> e.contains("'name':"))
                .collect(Collectors.joining(","))
                .replaceAll("'name':","")
                .replaceAll("\"","")
                .replaceAll("'","").trim();

        String genderString= gender.stream()
                .filter(e->e.contains("'gender'"))
                .collect(Collectors.joining(","))
                .replaceAll("'gender':","").trim();

        names = Stream.of(nameString.split(",")).collect(Collectors.toList());
        gender  =Stream.of(genderString.split(",")).collect(Collectors.toList());
        //Map<String, String>  actorsMap = null;
        List<String> finalNames = names;
        List<String> finalGender = gender;
        Map<String, Integer> map = IntStream.range(0, names.size())
                .collect(
                        HashMap::new,
                        (m,i)-> m.put(finalNames.get(i),  Integer.parseInt(finalGender.get(i))),
                        Map::putAll);
        return  map;

    }


    private static List<Actors> toActorList(String column) {
        String objects = column.replaceAll("\\[", "").replaceAll("]", "");
        String[] actors = objects.split(",");
        List<String> maleAndFemal = Stream.of(actors)
                .filter(E -> E.contains("gender") || E.contains("\'name\'"))
                //.peek(e-> System.out.println(e))
                .collect(Collectors.toList());

        List<String> names = maleAndFemal;
        List<String > gender = maleAndFemal;
        String nameString = names.stream()
                .filter(e-> e.contains("'name':"))
                .collect(Collectors.joining(","))
                .replaceAll("'name': ","")
                .replaceAll("\"","")
                .replaceAll("'","").trim();

        String genderString= gender.stream()
                .filter(e->e.contains("'gender'"))
                .collect(Collectors.joining(","))
                .replaceAll(" 'gender': ","").trim();


        names = Stream.of(nameString.split(",")).collect(Collectors.toList());
        gender  =Stream.of(genderString.split(",")).collect(Collectors.toList());
        Map<String, String>  actorsMap = null;
        List<String> finalNames = names;
        List<String> finalGender = gender;

        Map<String, Integer> map =IntStream.range(0, names.size())
                .collect(
                        HashMap::new,
                        (m,i)-> m.put(finalNames.get(i),  Integer.parseInt(finalGender.get(i))),
                        Map::putAll);
        List<Actors> collectActors = map.entrySet()
                .stream()
                .map(e -> new Actors(e.getKey().replaceAll("\"","").trim(), e.getValue()))
                .collect(Collectors.toList());

        return  collectActors;
    }

}
