package at.refugeecode.pset2.model;

import org.springframework.stereotype.Component;

@Component
public class Rock implements Move{

    @Override
    public String getName() {
        return "rock";
    }


}
