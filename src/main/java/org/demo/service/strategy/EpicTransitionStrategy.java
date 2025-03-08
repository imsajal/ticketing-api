package org.demo.service.strategy;

import org.demo.enums.TicketStatus;

import java.util.HashMap;
import java.util.Map;

public class EpicTransitionStrategy implements  TransitionStrategy{

    Map<TicketStatus, TicketStatus> statusTransitions;

    public EpicTransitionStrategy() {
        statusTransitions = new HashMap<>();
        initializeTransitions();
    }

    private void initializeTransitions() {
        statusTransitions.put(TicketStatus.OPEN, TicketStatus.INPROGRESS);
        statusTransitions.put(TicketStatus.INPROGRESS, TicketStatus.COMPLETED);
    }

    @Override
    public boolean transitionTo(TicketStatus current, TicketStatus newStatus) {
        boolean validTransition = false;
        if(statusTransitions.containsKey(current) && statusTransitions.get(current).equals(newStatus))
        {
            validTransition = true;
        }
        return validTransition;

    }
}
