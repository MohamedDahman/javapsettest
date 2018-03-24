package at.refugeecode.pset2.model;

import org.springframework.stereotype.Component;

@Component
public class Paper implements Move{
    @Override
    public String getName() {
        return "paper";
    }

}
