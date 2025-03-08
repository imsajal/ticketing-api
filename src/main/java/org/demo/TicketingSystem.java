package org.demo;

import org.demo.enums.TicketStatus;
import org.demo.model.Sprint;
import org.demo.model.Ticket;
import org.demo.service.SprintService;
import org.demo.service.TicketFactory;
import org.demo.service.TicketService;
import org.demo.service.strategy.EpicTransitionStrategy;
import org.demo.service.strategy.OnCallTransitionStrategy;
import org.demo.service.strategy.StoryTransitionStrategy;

import java.util.ArrayList;

public class TicketingSystem {
    SprintService sprintService;
    TicketService ticketService;
    TicketFactory ticketFactory;

    public TicketingSystem() {
        this.ticketService = new TicketService();
        this.sprintService = new SprintService(ticketService);
        this.ticketFactory = new TicketFactory();
    }

    public void demo() {

//        User creates a Story ticket with the title "Implement login feature".
//                User creates an Epic ticket with the title "User authentication".
//                User creates an On-call ticket with the title "Fix production bug".

        ticketService.createTicket("Implement login feature",
                1, new ArrayList<>(), new StoryTransitionStrategy(),
                "xyz", "story");


        ticketService.createTicket("Authentication",
                2, new ArrayList<>(), new EpicTransitionStrategy(),
                "xyz", "epic");

        ticketService.createTicket("bug",
                3, new ArrayList<>(), new OnCallTransitionStrategy(),
                "xyz", "oncall");

        // invalid
        ticketService.changeTicketStatus(1, TicketStatus.OPEN, TicketStatus.COMPLETED);
        ticketService.changeTicketStatus(1, TicketStatus.OPEN, TicketStatus.INPROGRESS);

        sprintService.createSprint("sprint");

        sprintService.addStoryToSprint(1);
        sprintService.removeStoryFromSprint(1);

        ticketService.addTaskToTicket(2, "Inform party", 1 , "shipping container");
        // invalid transition flow for task
        ticketService.changeTaskStatus(2,1,TicketStatus.OPEN, TicketStatus.COMPLETED);
        ticketService.changeTaskStatus(2,1,TicketStatus.OPEN, TicketStatus.INPROGRESS);
        ticketService.deleteTaskFromTicket(2, 1);
    }
}
