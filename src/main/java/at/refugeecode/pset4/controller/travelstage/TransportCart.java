package at.refugeecode.pset4.controller.travelstage;



import at.refugeecode.pset4.model.Luggage;

import java.time.Duration;

public class TransportCart implements TravelStage {

    @Override
    public Luggage process(Luggage luggage) {
        // TODO add 25 minutes to the processing time

        Duration lastwaitingDuration = luggage.getWaitingDuration();
        Duration duration = lastwaitingDuration.plusMinutes(25);
        luggage.setWaitingDuration(duration);
        return luggage;
    }
}
