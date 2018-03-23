package at.refugeecode.pset4.controller;

import at.refugeecode.pset4.model.Luggage;
import at.refugeecode.pset4.parse.LuggageParser;
import at.refugeecode.pset4.util.TimeUtils;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import javax.sound.midi.Soundbank;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class AirportTest {
    Airport airport = new Airport();
    LuggageParser luggageParser = new LuggageParser();
    List<Luggage> departureLuggage = luggageParser.asList("src/main/java/at/refugeecode/pset4/data/luggage.csv");
    List<Luggage> arrivalLuggage = airport.travel(departureLuggage);


    @Test
    void travelCount() {
        assertEquals(18,arrivalLuggage.size());
    }

    @Test
    void travelNames(){
        String collect = arrivalLuggage.stream().map(e -> e.getOwner()).collect(Collectors.joining(", "));
        String passengerName ="Hosam, Ismael, Mohamed Dahman, Mohammad Almosleh, Ghiath, Mohammad Sawas, Nisreen, Nourallah, Sarah, Thaer, Wael, Yazan, Diaa, Ali, Hadi, Farah, Fozat, Sadra";
        assertEquals(passengerName,collect);
    }
    @Test
    void testDuration(){
        Optional<Duration> reduce = arrivalLuggage.stream().map(e -> e.getWaitingDuration()).reduce((e1, e2) -> e1.plus(e2));
        long minutes =0;
        if (reduce.isPresent()){
            minutes = reduce.get().toMinutes();
        }
        assertEquals(8629,minutes);
    }

    @Test
    void testTravel(){
        Luggage luggage = new Luggage();
        luggage.setOwner("SomeOne");
        luggage.setDestination("Moscow");
        luggage.setType("Back");
        luggage.setDropOffTime(TimeUtils.todayAt("14:15"));
        luggage.setDepartureTime(TimeUtils.todayAt("18:00"));
        luggage.setFlightDuration(TimeUtils.durationOfHours("5"));
        luggage.setWaitingDuration(Duration.ofSeconds(0));


        List<Luggage> luggageList = new ArrayList<>();
        luggageList.add(luggage) ;

        Airport airport1 = new Airport();
        List<Luggage> travel = airport1.travel(luggageList);

        assertEquals(1,travel.size());

    }

    @Test
    void testRejected(){
        Luggage luggage = new Luggage();
        luggage.setOwner("SomeOne");
        luggage.setDestination("anyWhere");
        luggage.setType("Back");
        luggage.setDropOffTime(TimeUtils.todayAt("18:01"));
        luggage.setDepartureTime(TimeUtils.todayAt("18:00"));
        luggage.setFlightDuration(TimeUtils.durationOfHours("5"));
        luggage.setWaitingDuration(Duration.ofSeconds(0));


        List<Luggage> luggageList = new ArrayList<>();
        luggageList.add(luggage) ;


        Luggage luggage1 = new Luggage();
        luggage1.setOwner("SomeOne");
        luggage1.setDestination("anyWhere");
        luggage1.setType("Back");
        luggage1.setDropOffTime(TimeUtils.todayAt("15:01"));
        luggage1.setDepartureTime(TimeUtils.todayAt("18:00"));
        luggage1.setFlightDuration(TimeUtils.durationOfHours("5"));
        luggage1.setWaitingDuration(Duration.ofSeconds(0));
        luggageList.add(luggage1);

        Airport airport1 = new Airport();
        List<Luggage> travel = airport1.travel(luggageList);
        System.out.println(travel.size());
        assertEquals(1,travel.size());
    }

}