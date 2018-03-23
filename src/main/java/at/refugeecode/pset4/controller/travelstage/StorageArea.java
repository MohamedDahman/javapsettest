package at.refugeecode.pset4.controller.travelstage;



import at.refugeecode.pset4.model.Luggage;

import java.time.Duration;


public class StorageArea implements TravelStage {

    @Override
    public Luggage process(Luggage luggage) {
        // TODO add as much duration to the processing time as the departure time minus 30 minutes
        // if 30 minutes is not possible, the luggage won't be stored at all, which means that
        // no waiting time will be added at all

        Duration between = Duration.between(luggage.getDropOffTime(), luggage.getDepartureTime()).abs();
        /*if (between.toMinutes() > 30) {*/
        luggage.setWaitingDuration(between.minusMinutes(30));

        return luggage;
    }
}
