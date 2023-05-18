package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Grammar {
    /**
     * Множество нетерминалов
     */
    public List<String> nonTerminal;

    /**
     * Множество нетерминалов
     */
    public List<String> terminal;


    /**
     * Множество правил (продукций) грамматики
     */
    public List<Rule> rules;

    /**
     * Целевой (начальный) символ грамматики
     */
    public String S = "S";

    public Grammar(List<String> nonterminal, List<String> terminal, List<Rule> rules, String s) {
        this.nonTerminal = nonterminal;
        this.terminal = terminal;
        this.rules = rules;
        S = s;
    }

    public Grammar(List<String> nonterminal, List<String> terminal, List<Rule> rules) {
        this.nonTerminal = nonterminal;
        this.terminal = terminal;
        this.rules = rules;
        S = "S";
    }

    public String getTypeGrammar() {

        // Тип 1: контекстно-зависимые (КЗ) и неукорачивающие грамматики
        boolean isTypeOne = true;

        // Тип 2: контекстно-свободные (КС) грамматики
        boolean isTypeTwo = true;

        // Тип 3: регулярные грамматики
        boolean isTypeThree = true;

        boolean isEachTermPosBigger = true;
        boolean isEachTermPosSmaller = true;

        for (Rule rule : rules) {

            // проверка проинадлежности первому типу грамматики
            isTypeOne &= rule.key.length() <= rule.value.length();

            // проверка на 2й тип
            for (String terminal : this.terminal) {
                isTypeTwo &= !rule.key.contains(terminal);
            }

            if (isEachTermPosBigger || isEachTermPosSmaller) {

                List<Integer> terminalPositions = new ArrayList<>();
                List<Integer> nonTerminalPositions = new ArrayList<>();

                for (String nonTerminal : this.nonTerminal) {
                    int TEMP = rule.value.indexOf(nonTerminal);
                    if (TEMP != -1)
                        nonTerminalPositions.add(TEMP);
                }

                for (String terminal : this.terminal) {
                    int TEMP = rule.value.indexOf(terminal);
                    if (TEMP != -1)
                        terminalPositions.add(TEMP);
                }

                for (int positionTerminal : terminalPositions) {
                    for (int positionNonTerminal : nonTerminalPositions) {
                        isEachTermPosBigger &= positionTerminal > positionNonTerminal;
                        isEachTermPosSmaller &= positionTerminal < positionNonTerminal;
                    }
                }

                if (isEachTermPosBigger == false && isEachTermPosSmaller == false)
                    isTypeThree = false;
            }

        }

        StringBuilder result = new StringBuilder("0");
        if (isTypeOne)
            result.append(" 1");

        if (isTypeTwo)
            result.append(" 2");

        if (isTypeThree)
            result.append(" 3");

        return result.toString();
    }

    public String makeTree(String text) {
        int maxCount = 10000;
        int count = 0;

        List<String> tree = new ArrayList<>();
        tree.add(text);

        while (count < maxCount) {
            for (Rule rule : rules) {
                int position = text.lastIndexOf(rule.value);
                if (position != -1) {
                    text = text.replaceFirst(rule.value, rule.key);

                    StringBuilder separator = new StringBuilder("|");
                    for (int i = 0; i < position; i++) {
                        separator.append(" ");
                    }
                    tree.add(separator.toString());
                    tree.add(text);
                }
            }
            count++;
        }
        Collections.reverse(tree);

        StringBuilder resultTree = new StringBuilder("");
        for (String str : tree) {
            resultTree.append(str + "\n");
//            System.out.println(str);
        }

        return resultTree.toString();
    }
}
