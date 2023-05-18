package org.example;

public class Rule {
    public String key;

    public String value;

    public boolean isLooped;

    public Rule(String key, String value, boolean isLooped) {
        this.key = key;
        this.value = value;
        this.isLooped = isLooped;
    }

    public Rule(String key, String value) {
        this.key = key;
        this.value = value;
        this.isLooped = false;
    }

    @Override
    public String toString() {
        return "\"" + key + "\" --> \"" + value + "\"";
    }
}
