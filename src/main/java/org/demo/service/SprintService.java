package org.demo.service;

import org.demo.model.Sprint;
import org.demo.model.Story;
import org.demo.model.Ticket;

public class SprintService {

    Sprint currentSprint;
    TicketService ticketService;

    public SprintService(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public void createSprint(String name){
        currentSprint = new Sprint(name);
    }

    public Sprint getCurrentSprint(){
        return currentSprint;
    }

    public void addStoryToSprint(Integer ticketId){

        Ticket ticket = ticketService.getTicketByID(ticketId);

        if(ticket instanceof Story)
        currentSprint.getStories().add(ticket);
        else System.out.println("Ticket is not a story");

    }

    public void removeStoryFromSprint(Integer ticketId){
        Ticket ticket = ticketService.getTicketByID(ticketId);
        currentSprint.getStories().remove(ticket);
    }
}
