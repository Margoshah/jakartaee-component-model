package edu.lab.cdi;
public class NormalizationService {
    public String normalize(String word) {
        return (word == null) ? "" : word.trim().toLowerCase();
    }
}