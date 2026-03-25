package edu.lab.ejb.impl;
import edu.lab.cdi.Russian;
import edu.lab.cdi.WordAddedEvent;
import jakarta.ejb.Singleton;
import jakarta.ejb.Lock;
import jakarta.ejb.LockType;
import jakarta.enterprise.event.Observes;
import java.util.ArrayList;
import java.util.List;

@Singleton
@Russian
public class SingletonServiceBean {
    private List<String> globalWords = new ArrayList<>();

    public void onWordAdded(@Observes WordAddedEvent event) {
        globalWords.add(event.getWord());
    }

    @Lock(LockType.READ)
    public List<String> getAllWords() {
        return globalWords;
    }
}