package org.example;

import java.util.ArrayList;
import java.util.List;

public class NewState {

    // Само состояние
    public Character nameState;

    // Map с переходами состояний
    private List<Transition> transitions;

    // Конечное данное состояние или нет
    public boolean isFinal;


    public NewState(char nameState, boolean isFinal) {
        this.nameState = nameState;
        this.isFinal = isFinal;
        transitions = new ArrayList<>();
    }

    public List<Transition> getTransitions() {
        return transitions;
    }

    public void setTransitions(List<Transition> transitions) {
        this.transitions = transitions;
    }

    //    @Override
    public String getState() {

        if (transitions.isEmpty()) {
            return nameState + " не имеет путей.";
        }

        StringBuilder builder = new StringBuilder();


        for (var transition : transitions) {
            builder.append(nameState);
            builder.append(" -- ");
            builder.append(transition.transitionSymbol);
            builder.append(" --> ");
            builder.append(transition.state.nameState);
            builder.append("\n");
        }
        return builder.toString();

    }
}
