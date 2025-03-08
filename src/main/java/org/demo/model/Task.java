package org.demo.model;

import org.demo.enums.TicketStatus;
import org.demo.service.strategy.TransitionStrategy;

public class Task {
    private TicketStatus status;
    private String title;
    private int id;
    private String description;

    public Task(TicketStatus status, String title, int id, String description) {
        this.status = status;
        this.title = title;
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
