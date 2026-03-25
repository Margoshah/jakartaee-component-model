package edu.lab.cdi;
import jakarta.enterprise.inject.Produces;
import java.time.LocalDateTime;

public class RandomProducer {
    @Produces
    public LocalDateTime produceTime() {
        return LocalDateTime.now();
    }
}