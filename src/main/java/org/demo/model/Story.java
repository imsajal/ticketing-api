package org.demo.model;

import org.demo.service.strategy.TransitionStrategy;

import java.util.List;

public class Story extends Ticket{

    public Story(String title, int id, List<Task> tasks, TransitionStrategy transitionStrategy, String description) {
        super(title, id, tasks, transitionStrategy, description);
    }
}
