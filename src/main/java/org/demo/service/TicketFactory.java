package org.demo.service;

import org.demo.model.*;
import org.demo.service.strategy.TransitionStrategy;

import java.util.List;

public class TicketFactory {

    public static Ticket getTicket(String title, int id, List<Task> tasks, TransitionStrategy transitionStrategy, String description, String ticketType){
        Ticket ticket = null;
        switch(ticketType){
            case "story":
                ticket = new Story(title, id, tasks, transitionStrategy, description);
                break;
            case "epic":
                ticket =  new Epic(title, id, tasks, transitionStrategy, description);
                break;
            case "oncall":
                ticket = new OnCall(title, id, tasks, transitionStrategy, description);
                break;
        }
        return ticket;
    }
}
