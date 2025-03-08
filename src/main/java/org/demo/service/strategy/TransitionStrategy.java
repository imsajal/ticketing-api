package org.demo.service.strategy;


import org.demo.enums.TicketStatus;
import org.demo.model.Ticket;

public interface TransitionStrategy {

    boolean transitionTo(TicketStatus current, TicketStatus newStatus);
}
