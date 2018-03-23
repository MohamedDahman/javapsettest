package at.refugeecode.pset4.controller.travelstage;



import at.refugeecode.pset4.model.Luggage;

import java.time.Duration;

public class LuggageClaim implements TravelStage {

    @Override
    public Luggage process(Luggage luggage) {
        // TODO add 15 minutes to the processing time
        Duration lastwaitingDuration = luggage.getWaitingDuration();
        Duration duration = lastwaitingDuration.plusMinutes(15);
        luggage.setWaitingDuration(duration);
        return luggage;

    }
}
