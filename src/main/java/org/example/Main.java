package org.example;

import java.util.*;


public class Main {
    public static void main(String[] args) {

        /*
            Задание 2.а
         */
        System.out.println("Выполнил Сорокин Александр.\nПервая лабораторная работа.\nЗадание 2.\nПодпункт a)\n");

        List<Rule> rules = new ArrayList<>();
        rules.add(new Rule("S", "aaCFD"));
        rules.add(new Rule("AD", "D"));
        rules.add(new Rule("F", "AFB"));
        rules.add(new Rule("F", "AB"));
        rules.add(new Rule("Cb", "bC"));
        rules.add(new Rule("AB", "bBA"));
        rules.add(new Rule("CB", "C"));
        rules.add(new Rule("Ab", "bA"));
        rules.add(new Rule("bCD", "\u03B5"));

        FormalLanguage language = new FormalLanguage();

        System.out.println("Правила:");
        System.out.println(language.getRules(rules));
        System.out.println("Цепочка: " + language.translate("S", rules));
        System.out.println("Язык: L = { a^n | n > 0 }");

        /*
            Задание 2.б
        */
        System.out.println("\nПодпункт б)\n");

        rules.clear();

        rules.addAll(
                List.of(new Rule[]{new Rule("S", "A\u00A7"),   // \u27C2 - значок перпендикуляра
                        new Rule("S", "B\u00A7"),
                        new Rule("A", "a"),
                        new Rule("A", "Ba"),
                        new Rule("b", "b"),
                        new Rule("b", "Bb"),
                        new Rule("b", "Ab")})
        );

        System.out.println("Правила:");
        System.out.println(language.getRules(rules));
        System.out.println("Цепочка: " + language.translate("S", rules));
        System.out.println("Язык: L = { (a\u00A7)^n | n>0 }");

        /*
            Задание 3.а
         */
        System.out.println();
        System.out.println("Задание 3.");
        System.out.println("Подпункт a)");
        System.out.println("Язык: L = { a^n b^m c^k | n, m, k > 0}");
        System.out.println("Грамматика: G: ({a, b, c}, {A, B, C}, P, S)");

        rules.clear();
        rules.addAll(
                List.of(
                        new Rule[]{
                                new Rule("S", "aaB"),
                                new Rule("B", "bCCCC"),
                                new Rule("B", "b"),
                                new Rule("C", "Cc"),
                                new Rule("C", "c"),
                        })
        );
        System.out.println("Правила:");
        System.out.println(language.getRules(rules));
        System.out.println("Цепочка: " + language.translate("S", rules));

        /*
            Задание 3.б
        */
        System.out.println("Подпункт б)");
        System.out.println("Язык: L = {0^n(10)^m | n, m ≥ 0}");
        System.out.println("Грамматика: G: ({0, 10}, {A, B}, P, S)");
        rules.clear();
        rules.addAll(
                List.of(
                        new Rule[]{
                                new Rule("S", "0AB"),
                                new Rule("A", "000"),
                                new Rule("B", "1010"),
                        })
        );
        System.out.println("\nПравила:");
        System.out.println(language.getRules(rules));
        System.out.println("Цепочка: " + language.translate("S", rules));

        /*
            Задание 3.в
        */
        System.out.println("Подпункт в)");
        System.out.println("Язык: L = {a1 a2 … an an … a2a1 | ai E {0, 1}}");
        System.out.println("Грамматика: G: ({0, 1}, {A, B}, P, S)");
        rules.clear();
        rules.addAll(
                List.of(
                        new Rule[]{
                                new Rule("S", "AB"),
                                new Rule("A", "1001010"),
                                new Rule("B", "0101001"),
                        })
        );
        System.out.println("\nПравила:");
        System.out.println(language.getRules(rules));
        System.out.println("Цепочка: " + language.translate("S", rules) + "\n");

        /*
            Задание 4.a
        */
        System.out.println();
        System.out.println("Задание 4.");
        System.out.println("Подпункт a)");
        rules.clear();
        rules.addAll(
                List.of(
                        new Rule[]{
                                new Rule("S", "0A1"),
                                new Rule("S", "01"),
                                new Rule("0A", "00A1"),
                                new Rule("A", "01"),
                        })
        );
        System.out.println("\nПравила:");
        System.out.println(language.getRules(rules));

        Grammar grammar = new Grammar(
                List.of("S", "A"),
                List.of("0", "1"),
                rules
        );

        System.out.println("Грамматика: G: ({0, 1}, {S, A}, P, S)");
        System.out.println("Относится к типам по Хомскому:\n" + grammar.getTypeGrammar());

         /*
            Задание 4.б
        */
        System.out.println("Подпункт б)");
        rules.clear();
        rules.addAll(
                List.of(
                        new Rule[]{
                                new Rule("S", "Ab"),
                                new Rule("A", "Aa"),
                                new Rule("A", "ba"),
                        })
        );
        System.out.println("\nПравила:");
        System.out.println(language.getRules(rules));

        grammar = new Grammar(
                List.of("S", "A"),
                List.of("a", "b"),
                rules
        );
        System.out.println("Грамматика: G: ({a, b}, {S, A}, P, S)");
        System.out.println("Относится к типам по Хомскому:\n" + grammar.getTypeGrammar() + "\n");

        /*
            Задание 5
        */
        System.out.println("Задание 5");
        rules.clear();
        //Первая Грамматика
        rules.addAll(
                List.of(
                        new Rule[]{
                                new Rule("S", "aSL"),
                                new Rule("S", "aL"),
                                new Rule("L", "Kc"),
                                new Rule("cK", "Kc"),
                                new Rule("K", "b"),
                        })
        );
        System.out.println("\nПравила:");
        System.out.println(language.getRules(rules));

        System.out.println("Цепочка: " + language.translate("S", rules));
        System.out.println("Язык: L = {a^n b^m c^k | a, b, k > 0}");

        // Вторая грамматика
        rules.clear();
        rules.addAll(
                List.of(
                        new Rule[]{
                                new Rule("S", "aSBc"),
                                new Rule("S", "abc"),
                                new Rule("cB", "Bc"),
                                new Rule("bB", "bb"),
                        })
        );
        System.out.println("\nПравила:");
        System.out.println(language.getRules(rules));

        System.out.println("Цепочка: " + language.translate("S", rules));
        System.out.println("Язык: L = {a^n b^m c^k | a, b, k > 0}");

        System.out.println("Грамматики эквиваленты т.к. они определяют один и тот же язык.\n");

        /*
            Задание 6
         */
        System.out.println("Задание 6.");

        // Заданная грамматика
        rules.clear();
        rules.addAll(
                List.of(
                        new Rule[]{
                                new Rule("S", "AB"),
                                new Rule("S", "ABS"),
                                new Rule("A", "a"),
                                new Rule("B", "b"),
                                new Rule("AB", "BA"),
                                new Rule("BA", "AB"),

                        })
        );
        System.out.println("\nПравила:");
        System.out.println(language.getRules(rules));

        System.out.println("Цепочка: " + language.translate("S", rules));

        // Эквивалентная грамматика
        rules.clear();
        rules.addAll(
                List.of(
                        new Rule[]{
                                new Rule("S", "ab"),
                        })
        );
        System.out.println("\nПравила:");
        System.out.println(language.getRules(rules));

        System.out.println("Цепочка: " + language.translate("S", rules));

        /*
            Задание 7
         */
        System.out.println("Задание 7.");
        // Заданная грамматика
        rules.clear();
        rules.addAll(
                List.of(
                        new Rule[]{
                                new Rule("S", "A.A"),
                                new Rule("A", "B"),
                                new Rule("A", "BA"),
                                new Rule("B", "0"),
                                new Rule("B", "1"),
                        })
        );
        System.out.println("\nПравила:");
        System.out.println(language.getRules(rules));

        System.out.println("Цепочка: " + language.translate("S", rules));

        // Эквивалентная грамматика
        rules.clear();
        rules.addAll(
                List.of(
                        new Rule[]{
                                new Rule("S", "A.0"),
                                new Rule("A", "0"),
                                new Rule("A", "1"),
                        })
        );
        System.out.println("\nПравила:");
        System.out.println(language.getRules(rules));

        System.out.println("Цепочка: " + language.translate("S", rules) + "\n");

        /*
            Задание 9.a
         */
        System.out.println("Задание 9.a");
        rules.clear();
        rules.addAll(
                List.of(
                        new Rule[]{
                                new Rule("S", "aSbS"),
                                new Rule("S", "bSaS"),
                                new Rule("S", "\u03B5"),
                        })
        );
        grammar = new Grammar(
                List.of("S"),
                List.of("a", "b", "\u03B5"),
                rules
        );
        System.out.println("Дерево вывода1:\n" + grammar.makeTree("a\u03B5ba\u03B5b\u03B5"));
        System.out.println("Дерево вывода2:\n" + grammar.makeTree("ab\u03B5a\u03B5b\u03B5"));


        /*
            Задание 11
         */
        System.out.println("Задание 11");

        System.out.println("Подпункт а)");
        System.out.println("Грамматика описывает язык 0^n 1^n 'Символ перепендикуляра' \u27C2");
        rules.clear();
        rules.addAll(
                List.of(
                        new Rule[]{
                                new Rule("S", "0S"),
                                new Rule("S", "0B"),
                                new Rule("B", "1B"),
                                new Rule("B", "1C"),
                                new Rule("C", "1C"),
                                new Rule("C", "\u27C2"),
                        })
        );

        System.out.println("Вывод по заданной грамматике:");
        System.out.println(language.outputLeft("S", rules));

        rules.clear();
        rules.addAll(
                List.of(
                        new Rule[]{
                                new Rule("S", "A\u27C2"),
                                new Rule("A", "A1"),
                                new Rule("A", "CB1"),
                                new Rule("B", "B1"),
                                new Rule("B", "C1"),
                                new Rule("B", "CB1"),
                                new Rule("C", "0"),
                        })
        );
//        System.out.println("\nПо эквивалентной:\n" + language.getRules(rules) + "\n");
        System.out.println(language.outputLeft("S", rules));


        System.out.println("Подпункт б)");
        System.out.println("Грамматика описывает язык {a^n b^n} 'Символ перепендикуляра' \u27C2");
        rules.clear();
        rules.addAll(
                List.of(
                        new Rule[]{
                                new Rule("S", "aA"),
                                new Rule("S", "aB"),
                                new Rule("S", "bA"),
                                new Rule("A", "bS"),
                                new Rule("B", "aS"),
                                new Rule("B", "bB"),
                                new Rule("B", "\u27C2"),

                        })
        );
        System.out.println(language.outputLeft("S", rules));

        rules.clear();
        rules.addAll(
                List.of(
                        new Rule[]{
                                new Rule("S", "A\u27C2"),
                                new Rule("A", "Ba"),
                                new Rule("A", "Bb"),
                                new Rule("A", "Ab"),
                                new Rule("A", "ABa"),
                                new Rule("A", "ABb"),
                                new Rule("B", "a"),
                                new Rule("B", "b"),

                        })
        );
        System.out.println(language.outputLeft("S", rules));

        /*
            Задание 12
         */
        System.out.println("Задание 12");
        System.out.println("Объединением языков L1 и L2 является язык L = { 01 0|1^n | n > 0 } \nпостроенный по заданной грамматике:");
        rules.clear();
        rules.addAll(
                List.of(
                        new Rule[]{
                                new Rule("S", "A1"),
                                new Rule("S", "A0"),
                                new Rule("A", "C1"),
                                new Rule("A", "A1"),
                                new Rule("C", "0"),
                        })
        );
        System.out.println(language.getRules(rules));

        System.out.println("ДС:");

        System.out.println("H -- 0 --> С");
        System.out.println("           |   + -- 1 -- +");
        System.out.println("           1  /          |");
        System.out.println("           ↓ /           |");
        System.out.println("+ -- 0 --- A <---------- +");
        System.out.println("|          ↑");
        System.out.println("|          1");
        System.out.println("|          |");
        System.out.println("+ -------> S");


        // Состояния для автомата
        State H1 = new State('H', false);
        State S1 = new State('S', true);
        State C1 = new State('C', false);
        State A1 = new State('A', true);

        // Переходы состояний

        H1.getTransitions().put('0', C1);
        C1.getTransitions().put('1', A1);
        A1.getTransitions().put('0', S1);
        A1.getTransitions().put('1', A1);
        S1.getTransitions().put('1', A1);

        List<State> states = new ArrayList<>();
        states.add(H1);
        states.add(C1);
        states.add(A1);
        states.add(S1);

        Automaton automaton1 = new Automaton();
        automaton1.Run(H1, states, "010");
        automaton1.Run(H1, states, "0101111");
        automaton1.Run(H1, states, "00");


        /*-----------------------------------------------------------------------------------------------------*/

        /*
            Лабораторная №2
        */

        /*
            Задание 1
        */
        System.out.println("\n\nЛабораторная №2");
        System.out.println("Задание 1.");
        // Создаем состояния
        State H = new State('H', false);
        State N2 = new State('N', false);
        State P = new State('P', false);
        State S2 = new State('S', true);

        states.clear();
        states.add(H);
        states.add(N2);
        states.add(P);
        states.add(S2);

        // Добавляем переходы из состояния в состояние
        H.getTransitions().put('0', N2);
        H.getTransitions().put('1', N2);

        N2.getTransitions().put('0', N2);
        N2.getTransitions().put('1', N2);
        N2.getTransitions().put('.', P);

        P.getTransitions().put('0', S2);
        P.getTransitions().put('1', S2);

        S2.getTransitions().put('0', S2);
        S2.getTransitions().put('1', S2);

        Automaton automaton = new Automaton();


        automaton.Run(H, states, "11.010");
        automaton.Run(H, states, "0.1");
        automaton.Run(H, states, "01.");
        automaton.Run(H, states, "100");

         /*
            Задание 2
        */
        System.out.println("Задание 2.");
        System.out.println("Подпункт а)");

        State A2 = new State('A', false);
        State B2 = new State('B', false);
//        State ER = new State('E', true);

        S2.getTransitions().clear();
        H.getTransitions().clear();

        H.getTransitions().put('0', A2);
        H.getTransitions().put('1', A2);

        A2.getTransitions().put('0', A2);
        A2.getTransitions().put('1', A2);
        A2.getTransitions().put('+', B2);
        A2.getTransitions().put('-', B2);
        A2.getTransitions().put('\u27C2', S2);

        B2.getTransitions().put('0', A2);
        B2.getTransitions().put('1', A2);

        states.clear();

        states.add(H);
        states.add(A2);
        states.add(B2);
        states.add(S2);
//        states.add(ER);

        System.out.println("Цепочка:" + automaton.getChain(H, states, "1011\u27C2"));
        System.out.println("Цепочка:" + automaton.getChain(H, states, "10+011\u27C2"));
        System.out.println("Цепочка:" + automaton.getChain(H, states, "0-101+1\u27C2"));


        System.out.println("Подпункт б)");

        rules.clear();
        rules.addAll(
                List.of(
                        new Rule[]{
                                new Rule("S", "A\u27C2"),
                                new Rule("A", "A1"),
                                new Rule("A", "A0"),
                                new Rule("A", "B+"),
                                new Rule("A", "B-"),
                                new Rule("A", "1"),
                                new Rule("A", "0"),
                                new Rule("B", "A1"),
                                new Rule("B", "A0"),


                        })
        );
        System.out.println("Восстановленная грамматика");
        System.out.println(language.getRules(rules));

        System.out.println("Подпункт в)");
        System.out.println("Грамматика описывает язык L = {a1 a2 … c1 … am … cn … an …  | ai E {0, 1}, ci E {+, -}} 'Символ перепендикуляра' \\u27C2\"");


         /*
            Задание 4
        */
        System.out.println("Задание 4.");

        H.getTransitions().clear();
        H.getTransitions().put('a', S2);
        H.getTransitions().put('b', S2);
//        H.transitions.put('a', A);

        S2.isFinal = true;
        S2.getTransitions().clear();
        S2.getTransitions().put('a', A2);
        S2.getTransitions().put('b', S2);

        A2.getTransitions().clear();
        A2.isFinal = true;
        A2.getTransitions().put('a', A2);
        A2.getTransitions().put('b', S2);

        System.out.println("Грамматика описывает язык L = { a^n|b^m  | n, m >= 0 }");
        System.out.println("ДС:");
        System.out.println("           +--b--+");
        System.out.println("           |     |");
        System.out.println("           ↓     |");
        System.out.println("H --a,b--> S ----+");
        System.out.println("           |");
        System.out.println("+ ---a---- +");
        System.out.println("|          ↑");
        System.out.println("|          |");
        System.out.println("↓          |");
        System.out.println("A ---b---- +");

        states.clear();
        states.add(H);
        states.add(S2);
        states.add(A2);

        automaton.Run(H, states, "abbaabab");

        states.clear();

        /*-----------------------------------------------------------------------------------------------------*/

        /*
            Лабораторная №4
        */

        List<NewState> stateList = new ArrayList<>();

        System.out.println("\n\nЛабораторная №4");


        NewState S = new NewState('S', false);
        NewState A = new NewState('A', false);
        NewState B = new NewState('B', false);
        NewState C = new NewState('C', false);
        NewState D = new NewState('D', false);
        NewState E = new NewState('E', false);
        NewState F = new NewState('F', false);
        NewState G = new NewState('G', false);
        NewState N = new NewState('N', false);

        stateList.add(S);
        stateList.add(A);
        stateList.add(B);
        stateList.add(C);
        stateList.add(D);
        stateList.add(E);
        stateList.add(F);
        stateList.add(G);
        stateList.add(N);


        S.getTransitions().clear();
        S.getTransitions().add(new Transition('d', D));
        S.getTransitions().add(new Transition('d', F));

        A.getTransitions().add(new Transition('0', S));
        A.getTransitions().add(new Transition('1', C));

        B.getTransitions().add(new Transition('a', S));
        B.getTransitions().add(new Transition('b', C));

        C.getTransitions().add(new Transition('1', S));
        C.getTransitions().add(new Transition('d', E));

        D.getTransitions().add(new Transition('1', E));
        D.getTransitions().add(new Transition('a', E));
        D.getTransitions().add(new Transition('a', G));

        E.getTransitions().add(new Transition('0', C));

        F.getTransitions().add(new Transition('1', E));
        F.getTransitions().add(new Transition('a', E));
        F.getTransitions().add(new Transition('a', N));

        G.getTransitions().add(new Transition('c', E));
        G.getTransitions().add(new Transition('b', N));

        N.getTransitions().add(new Transition('c', E));
        N.getTransitions().add(new Transition('b', G));

        System.out.println("Начальные состояния:");
        // Вывод состояний на экран
        for (var state : stateList) {
            System.out.println(state.getState());
        }
        System.out.println("Кол-во состояний:" + stateList.size());

        NewState startState = S;
        List<Integer> indexDeletedStates = new ArrayList<>();


        System.out.println("Этап 1: Удаление недостижимых состояний");

        // Пройдем по всем состояниям и посмотрим на достижимость каждое из них
        for (int i = 0; i < stateList.size(); i++) {

            // Текущее состояние
            NewState currentState = stateList.get(i);

            // Достижимо текущее состояние или нет
            boolean isReachable = false;

            for (int j = 0; j < stateList.size(); j++) {
                if (i == j)
                    continue;

                // Проходим по всем переходам из текущего состояния
                for (var transition : stateList.get(j).getTransitions()) {

                    if (transition.state.nameState.equals(currentState.nameState) || currentState == startState) {
                        isReachable = true;
                        break;
                    }

                }

                if (isReachable)
                    break;

            }

            if (!isReachable) {
                indexDeletedStates.add(i);
            }
        }
        Collections.reverse(indexDeletedStates);
        // Удаляем состояния
        for (int i : indexDeletedStates) {
            stateList.remove(i);
        }

        // Вывод состояний на экран
        for (var state : stateList) {
            System.out.println(state.getState());
        }
        System.out.println("Кол-во состояний:" + stateList.size());

        System.out.println("Этап 2: Удаление эквивалетных состояний");

        for (int i = 0; i < stateList.size(); i++) {
            NewState currentState = stateList.get(i);

//            var currentTransitions = currentState.getTransitions();

            int stateIndex = 0;

            Character equalWith = null;

            for (stateIndex = 0; stateIndex < stateList.size(); stateIndex++) {
                if (i == stateIndex)
                    continue;

                int equalCount = 0;

                for (var transition : stateList.get(stateIndex).getTransitions()) {

                    for (var currentTransition : currentState.getTransitions()) {

                        if (currentTransition.transitionSymbol == transition.transitionSymbol && currentTransition.state.nameState == transition.state.nameState) {
                            equalCount++;
                            break;
                        }

                        if (currentTransition.transitionSymbol == transition.transitionSymbol && (currentState.nameState == transition.state.nameState && stateList.get(stateIndex).nameState == currentTransition.state.nameState))
                        {
                            equalCount++;
                            break;
                        }
                    }
                }

                if (equalCount == currentState.getTransitions().size() &&
                        equalCount == stateList.get(stateIndex).getTransitions().size()) {

                    equalWith = stateList.get(stateIndex).nameState;
                    break;
                }
            }

            if (equalWith != null) {
                for (var state : stateList) {
                    for (var transition : state.getTransitions()) {
                        if (transition.state.equals(equalWith)) {
                            transition.state = currentState;
                        }
                    }
                }

                for (var state: stateList) {
                    for (var transition: state.getTransitions()) {
                        if (transition.state.nameState == equalWith)
                            transition.state.nameState = currentState.nameState;
                    }
                }

                stateList.remove(stateIndex);
                i = 0;
            }
        }
        // Вывод состояний на экран
        for (var state : stateList) {
            System.out.println(state.getState());
        }
        System.out.println("Кол-во состояний:" + stateList.size());


    }
}