package at.refugeecode.pset4.controller.travelstage;




import at.refugeecode.pset4.model.Luggage;

import java.time.Duration;

public class DropOffStand implements TravelStage {


    @Override
    public Luggage process(Luggage luggage) {

        // TODO add 10 minutes to the processing time

        Duration lastwaitingDuration = luggage.getWaitingDuration();
        Duration duration = lastwaitingDuration.plusMinutes(10);
        luggage.setWaitingDuration(duration);
        return luggage;
    }
}
