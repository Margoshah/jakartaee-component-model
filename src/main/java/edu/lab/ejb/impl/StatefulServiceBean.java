package edu.lab.ejb.impl;

import jakarta.ejb.Stateful;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable; 
import java.util.ArrayList;
import java.util.List;

@Stateful
@SessionScoped
public class StatefulServiceBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<String> myWords = new ArrayList<>();

    public void addWord(String word) {
        myWords.add(word);
    }

    public List<String> getMyWords() {
        return myWords;
    }
}