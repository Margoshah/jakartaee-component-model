package edu.lab.cdi;

public class WordAddedEvent {
    private final String word;

    public WordAddedEvent(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }
}