package org.demo.model;

import org.demo.enums.TicketStatus;
import org.demo.service.strategy.TransitionStrategy;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
    private String title;
    private int id;
    private List<Task> tasks;
    private TransitionStrategy transitionStrategy;
    private String description;
    private TicketStatus status;


    public Ticket(String title, int id, List<Task> tasks, TransitionStrategy transitionStrategy, String description) {
        this.title = title;
        this.id = id;
        this.tasks = tasks;
        this.transitionStrategy = transitionStrategy;
        this.description = description;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public TransitionStrategy getTransitionStrategy() {
        return transitionStrategy;
    }

    public void setTransitionStrategy(TransitionStrategy transitionStrategy) {
        this.transitionStrategy = transitionStrategy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
