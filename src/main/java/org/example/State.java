package org.example;


import java.util.HashMap;
import java.util.Map;

/**
 * Состояние автомата
 */
public class State {

    // Само состояние
    public Character nameState;

    // Map с переходами состояний
    private Map<Character, State> transitions;

    // Конечное данное состояние или нет
    public boolean isFinal;

    public State(char nameState, boolean isFinal) {
        this.nameState = nameState;
        this.isFinal = isFinal;
        setTransitions(new HashMap<>());
    }

    public Map<Character, State> getTransitions() {
        return transitions;
    }

    public void setTransitions(Map<Character, State> transitions) {
        this.transitions = transitions;
    }

//    @Override
    public String getState() {

        if (transitions.isEmpty()) {
            return nameState + " не имеет путей.";
        }

        StringBuilder builder = new StringBuilder();


        for (var transition : transitions.entrySet()) {
            builder.append(nameState);
            builder.append(" -- ");
            builder.append(transition.getKey());
            builder.append(" --> ");
            builder.append(transition.getValue().nameState);
            builder.append("\n");
        }
        return builder.toString();

    }
}
