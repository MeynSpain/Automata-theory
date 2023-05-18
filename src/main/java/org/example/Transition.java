package org.example;

public class Transition {

    public Character transitionSymbol;

    public NewState state;

    public Transition(Character transitionSymbol, NewState state) {
        this.transitionSymbol = transitionSymbol;
        this.state = state;
    }
}
