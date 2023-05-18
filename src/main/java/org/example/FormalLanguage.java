package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FormalLanguage {

    //Кол-во максимальных повторений, чтобы не циклило
    private final int maxRepetitions = 10000;

    /**
     * @param rules Список правил
     * @return Возвращает строку с правилами
     */
    public String getRules(List<Rule> rules) {
        StringBuilder text = new StringBuilder();
        for (Rule rule : rules) {
            text.append(rule.toString() + "\n");
        }

        return text.toString();
    }


    /**
     * Проверяет зацикливает ли правило во входной строке
     *
     * @param input       Входная строка
     * @param rule        Правило, которое проверяется
     * @param repeatCount Кол-во повторений которое будет повторяться. Не рекомендуется ставить большое число
     * @return True - Правило зацикливает, false - нет
     */
    private boolean checkLoop(String input, Rule rule, int repeatCount) {

        for (int i = 0; i < repeatCount; i++) {

            int isFind = input.indexOf(rule.key);

            if (isFind != -1)
                input = input.replaceFirst(rule.key, rule.value);
            else
                return false;

        }
        return true;
    }

    private void refreshRulesLooped(List<Rule> rules) {
        for (Rule rule : rules) {
            rule.isLooped = false;
        }
    }


    public String translate(String text, List<Rule> rules) {

        int count = 0;
        boolean isEnd = false;

        while (count < maxRepetitions) {

            if (isEnd)
                break;

            count++;
            isEnd = true;

            for (Rule rule : rules) {

                if (!rule.isLooped) {

                    int pos = text.indexOf(rule.key);

                    //Если ключ не найден
                    if (pos != -1) {
                        if (checkLoop(text, rule, 5))
                            rule.isLooped = true;
                        else {
                            text = text.replaceFirst(rule.key, rule.value);
                            isEnd = false;
                            break;
                        }
                    }
                } else
                    rule.isLooped = !rule.isLooped;
            }
        }

        refreshRulesLooped(rules);
        return text;
    }

    /**
     * Левосторонний вывод
     * @param text Начальная строка с которой продолжается левосторонний вывод
     * @param rules Правила по которым осуществляется вывод
     * @return
     */
    public String outputLeft(String text, List<Rule> rules) {
        int count = 0;

        while (count < maxRepetitions) {

            int position = -1;

            // найдем крайний левый нетерминальный символ в цепочке
            for (Rule rule : rules) {
                int findPosition = text.indexOf(rule.key);

                if ((position > findPosition || position == -1) && findPosition != -1) {
                    position = findPosition;
                }
            }

            // если не найдено ниодного подходящего правила - выходим
            if (position == -1) {
                break;
            }

            //Правила только для одного нетерминала например для "S"
            List<Rule> localRules = new ArrayList<>();

            for (Rule rule : rules) {
                if (position == text.indexOf(rule.key)) {
                    localRules.add(rule);
                }
            }

            Random random = new Random();
            int index = random.nextInt(localRules.size());
            Rule rule = localRules.get(index);

            text = text.replaceFirst(rule.key, rule.value);

            count++;

        }
        return text;
    }

}
