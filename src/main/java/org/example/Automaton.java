package org.example;

import java.util.List;
import java.util.Stack;

public class Automaton {


    /**
     * Метод реализующий работу автомата и возвращающий принята цепочка автоматом или нет
     *
     * @param initialState Начальное состояние с которого начинает работу автомат
     * @param states       Список всех состояний
     * @param text         Цепочка анализируемая автоматом
     * @return true - Принята, false - не принята
     */
    public boolean Run(State initialState, List<State> states, String text) {

        //Текущее состояние автомата
        State currentState = initialState;
        for (int i = 0; i < text.length(); i++) {

            // Проверяем, есть ли переход по символу из текущего состояния
            if (currentState.getTransitions().containsKey(text.charAt(i))) {
                System.out.print(currentState.nameState + " ");
                currentState = currentState.getTransitions().get(text.charAt(i));
            } else {
                System.out.println();
                System.out.println("Состояние " + currentState.nameState + " -> Ошибка: нет перехода по символу №" + i + " = " + text.charAt(i));
                System.out.println("Цепочка " + text + " не принята автоматом");
                return false;
            }
        }
        System.out.print(currentState.nameState + " : ");

        if (currentState.isFinal) {
            System.out.println("Цепочка " + text + " принята автоматом");
            return true;
        } else {
            System.out.println("Цепочка " + text + " не принята автоматом");
            return false;
        }

    }

    public String getChain(State initialState, List<State> states, String text) {
        Stack<String> stack = new Stack<>();
//        stack.add(text);
        //Текущее состояние автомата
        State currentState = initialState;
        for (int i = 0; i < text.length(); i++) {

            // Проверяем, есть ли переход по символу из текущего состояния
            if (currentState.getTransitions().containsKey(text.charAt(i))) {
                System.out.print(currentState.nameState + " ");
                currentState = currentState.getTransitions().get(text.charAt(i));
                stack.add(text.substring(i));
                stack.add(" --> ");
            } else {
                System.out.println();
                System.out.println("Состояние " + currentState.nameState + " -> Ошибка: нет перехода по символу №" + i + " = " + text.charAt(i));
                return "Ошибка";
            }
        }
        System.out.print(currentState.nameState + " : ");
        stack.add(String.valueOf(currentState.nameState));

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }

        if (currentState.isFinal) {
            System.out.println("Цепочка " + text + " принята автоматом");
            return stringBuilder.toString();
        } else {
            System.out.println("Цепочка " + text + " не принята автоматом");
            return stringBuilder.toString();
        }
    }


}
