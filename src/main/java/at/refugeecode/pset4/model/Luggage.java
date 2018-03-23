package at.refugeecode.pset4.model;


import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Luggage {

    private String owner;

    private String destination;

    private String type;

    private LocalDateTime dropOffTime;

    private LocalDateTime departureTime;

    private Duration flightDuration;

    private Duration waitingDuration;

    private LocalDateTime arrivalTime;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getDropOffTime() {
        return dropOffTime;
    }

    public void setDropOffTime(LocalDateTime dropOffTime) {
        this.dropOffTime = dropOffTime;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public Duration getFlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(Duration flightDuration) {
        this.flightDuration = flightDuration;
    }

    public Duration getWaitingDuration() {
        return waitingDuration;
    }

    public void setWaitingDuration(Duration waitingDuration) {
        this.waitingDuration = waitingDuration;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return "Luggage{" +
                "owner='" + owner + '\'' +
                ", destination='" + destination + '\'' +
                ", type='" + type + '\'' +
                ", dropOffTime=" + dropOffTime +
                ", departureTime=" + departureTime +
                ", flightDuration=" + flightDuration +
                ", waitingDuration=" + waitingDuration +
                ", arrivalTime=" + arrivalTime +
                '}';
    }
    public String rejectformat() {
        long latemiunte = Duration.between(dropOffTime, departureTime).abs().toMinutes();
        return  "Baggage of "+ owner +" arrived to the drop off "+latemiunte+"  minutes late.";
    }
    public String arraivedFormat() {

        Duration x;
        x= waitingDuration;
        Duration duration = x.minusHours(waitingDuration.toHours());

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        String format = timeFormatter.format(arrivalTime);
        String tmp = waitingDuration.toHours()+" hours "+duration.toMinutes()+" minutes";

        return type+" of "+owner+" arrived to "+destination+" at "+format+" "+getLocltime()+" and waited a total of "+tmp;
    }



    public String getLocltime(){

        ZoneId vienna = ZoneId.of("Europe/Vienna");
        String destination = getDestination();
        ZoneId destinationId = ZoneId.of("Europe/"+destination);
        LocalDateTime now = getArrivalTime();

        ZonedDateTime viennaTime = now.atZone(vienna);

        ZonedDateTime arrivelocationTime = viennaTime.withZoneSameInstant(destinationId);

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        String format = timeFormatter.format(arrivelocationTime);

        String result="(local time "+format+")";
        return result;

    }



}
