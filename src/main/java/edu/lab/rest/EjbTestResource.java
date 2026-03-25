package edu.lab.rest;

import edu.lab.ejb.DictionaryValidator;
import edu.lab.ejb.impl.StatefulServiceBean;
import edu.lab.ejb.impl.SingletonServiceBean;
import edu.lab.cdi.Russian;
import edu.lab.cdi.WordAddedEvent;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.enterprise.event.Event;
import java.time.LocalDateTime;
import java.util.List;

@Path("/dict")
@Produces(MediaType.APPLICATION_JSON)
@jakarta.enterprise.context.RequestScoped
public class EjbTestResource {

    @Inject DictionaryValidator validator;
    @Inject StatefulServiceBean userDict;
    @Inject @Russian SingletonServiceBean globalDict;
    @Inject LocalDateTime serverTime;
    @Inject Event<WordAddedEvent> eventLauncher;

    @GET @Path("/add")
    public String add(@QueryParam("word") String word) {
        if (validator.isValid(word)) {
            userDict.addWord(word);
            eventLauncher.fire(new WordAddedEvent(word));
            return "Добавлено! Время: " + (serverTime == null ? "ОШИБКА: ВРЕМЯ NULL" : serverTime);
        }
        return "Ошибка: слово невалидно";
    }

    @GET @Path("/list")
    public List<String> list() { return userDict.getMyWords(); }

    @GET @Path("/global")
    public List<String> global() { return globalDict.getAllWords(); }
}