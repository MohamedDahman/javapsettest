package oop.pset2.view;

import org.springframework.stereotype.Component;

@Component
public class Host {
    public void welcome() {
        System.out.println("Welcome to Rock Paper scissors");
    }


    public void goodbye() {
        System.out.println("Goodbye");
    }
}
