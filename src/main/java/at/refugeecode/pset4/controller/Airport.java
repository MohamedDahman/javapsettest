package at.refugeecode.pset4.controller;

import at.refugeecode.pset4.controller.travelstage.*;
import at.refugeecode.pset4.model.*;

import at.refugeecode.pset4.view.Host;
import at.refugeecode.pset4.view.SummaryReporter;

import java.util.List;
import java.util.stream.Collectors;

public class Airport {

    public SecurityControl securityControl = new SecurityControl();
    private TravelStage dropOff = new DropOffStand();
    private TravelStage storageArea = new StorageArea();
    private TravelStage transportCart = new TransportCart();
    private TravelStage flight = new Flight();
    private TravelStage luggageClaim = new LuggageClaim();

    private SummaryReporter summaryReporter = new SummaryReporter();

    public List<Luggage> travel(List<Luggage> departureLuggage) {
        // TODO apply airport travel stages per the following order
        // show a welcome message

        //Host.welcome();

        List<Luggage> rejected = departureLuggage.stream()
                .filter(e -> securityControl.isAllowedToTravel(e)==true)
                .collect(Collectors.toList());

        List<Luggage> acceptedLuggage = departureLuggage.stream()
                .filter(e -> securityControl.isAllowedToTravel(e)==false)
                .collect(Collectors.toList());
/*

        for (Luggage l:acceptedLuggage) {
                dropOff.process(l);
                storageArea.process(l);

        }
*/
        acceptedLuggage.forEach(e->dropOff.process(e));

        acceptedLuggage.forEach(e-> dropOff.process(e));
        acceptedLuggage.forEach(e->storageArea.process(e));
        acceptedLuggage.forEach(e->transportCart.process(e));
        acceptedLuggage.forEach(e->flight.process(e));
        acceptedLuggage.forEach(e->transportCart.process(e));
        acceptedLuggage.forEach(e->luggageClaim.process(e));

      //  summaryReporter.reportRejected(rejected);
      //  summaryReporter.reportAccepted(acceptedLuggage);

        //Host.goodBy();
        return acceptedLuggage;
    }


}
