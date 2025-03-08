package org.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Sprint {

    private List<Ticket> stories;
    private String name;

    public Sprint(String name) {

       stories = new ArrayList<>();
        this.name = name;
    }

    public List<Ticket> getStories() {
        return stories;
    }

    public void setStories(List<Ticket> stories) {
        this.stories = stories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
