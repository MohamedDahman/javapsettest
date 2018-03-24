package at.refugeecode.pset1.model;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class MovieActors {
    Integer id;
    List<Actors> actorList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Actors> getActorList() {
        return actorList;
    }

    public void setActorList(List<Actors> actorList) {
        this.actorList = actorList;
    }

    public MovieActors() {
    }

    public MovieActors(Integer id, List<Actors> actorList) {
        this.id = id;
        this.actorList = actorList;
    }
}
