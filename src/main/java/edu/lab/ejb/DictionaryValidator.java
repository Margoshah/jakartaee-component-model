package edu.lab.ejb;
import jakarta.ejb.Stateless;

@Stateless
public class DictionaryValidator {
    public boolean isValid(String word) {
        return word != null && word.length() >= 2;
    }
}