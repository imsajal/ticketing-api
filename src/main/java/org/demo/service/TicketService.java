package org.demo.service;

import org.demo.enums.TicketStatus;
import org.demo.model.Task;
import org.demo.model.Ticket;
import org.demo.service.strategy.TransitionStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicketService {

    Map<Integer, Ticket> tickets;


    public TicketService() {
        this.tickets = new HashMap<>();
    }

    private String title;
    private int id;
    private List<Task> tasks;
    private TransitionStrategy transitionStrategy;
    private String description;

    public void createTicket(String title, int id, List<Task> tasks,
                             TransitionStrategy transitionStrategy, String description, String ticketType){

        Ticket ticket = TicketFactory.getTicket(title, id, tasks, transitionStrategy, description, ticketType);
        tickets.put(id, ticket);

    }

    public void changeTicketStatus(Integer ticketId, TicketStatus current, TicketStatus newStatus){
         Ticket ticket = tickets.get(ticketId);
         boolean isValidTransition = ticket.getTransitionStrategy().transitionTo(current, newStatus);
         if(isValidTransition){
             ticket.setStatus(newStatus);
         }
         else{
             System.out.println("Invalid transition flow");
         }
    }

    public void addTaskToTicket(Integer ticketId, String title, int id, String description){

        Task task = new Task(TicketStatus.OPEN, title, id, description);
        Ticket ticket = tickets.get(ticketId);
        ticket.getTasks().add(task);

    }

    public void changeTaskStatus(int ticketId, int taskId, TicketStatus current, TicketStatus newStatus){
        Ticket ticket = tickets.get(ticketId);
        // can be converted to map of task with id
        Task task = ticket.getTasks().get(taskId-1);
        boolean isValidTransition = ticket.getTransitionStrategy().transitionTo(current, newStatus);
        if(isValidTransition){
            task.setStatus(newStatus);
        }
        else {
            System.out.println("Invalid task transition flow");
        }
    }

   public void deleteTaskFromTicket(int ticketId, int taskId){
       Ticket ticket = tickets.get(ticketId);
       Task task = ticket.getTasks().get(taskId -1);
       if(task != null){
           ticket.getTasks().remove(task);
       }
   }

    public Ticket getTicketByID(Integer ticketId) {
        return tickets.get(ticketId);
    }
}
