package at.refugeecode.pset1.view;


import at.refugeecode.pset1.model.Summary;
import org.springframework.stereotype.Component;

@Component
public class SummaryDisplayer {

    public void display(Summary summary) {


        System.out.println("The 5 most rated films (top to bottom)");
        summary.getTopMovieRate()
                .forEach(e -> System.out.println(e.getTitle()));



        System.out.println("----------------------------------------");

        System.out.println("The 5 most hired actors (top to bottom)");

        summary.getMostHiredActors()
                .forEach(e ->System.out.println(e));

        System.out.println("----------------------------------------");

        System.out.println("The 2 most appearing movie genres (top to bottom)");
        summary.getMostMovieGenres()
                .forEach(e-> System.out.println(e));

        System.out.println("----------------------------------------");
        System.out.println("The % of male-female ratio (biggest % smallest)");
        System.out.println(summary.getMaleFemaleRatio());


    }
}
