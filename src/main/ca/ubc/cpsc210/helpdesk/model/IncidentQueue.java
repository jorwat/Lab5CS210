package ca.ubc.cpsc210.helpdesk.model;

import java.util.LinkedList;

// Represents a queue of incidents to be handled by helpdesk
// with maximum size MAX_SIZE
public class IncidentQueue {
    public static final int MAX_SIZE = 10;

    private LinkedList<Incident> queue;

    // EFFECTS: creates an empty incident queue
    public IncidentQueue() {
        queue = new LinkedList<>();
    }

    // REQUIRES: queue cannot be full
    // MODIFIES: this
    // EFFECTS: if the queue is not full, adds an incident to the end of the queue and returns true.
    //          if queue is full, return false
    public boolean addIncident(Incident incident) {
        boolean state;
        if (isFull()) {
            state = false;
        } else {
            queue.addLast(incident);
            state = true;
        }
        return state;
    }

    // REQUIRES: queue cannot be empty
    // MODIFIES: this
    // EFFECTS: removes the incident from the front of the queue and returns it
    public Incident getNextIncident() {
        Incident i;
        i = queue.getFirst();
        queue.removeFirst();
        return i;
    }

    // EFFECTS: takes a case number and returns the position in the queue of the incident with that number
    //          if there is no incident with that case number, the method returns -1
    public int getPositionInQueueOfCaseNumber(int num) {
        int pos = 0;

        for (Incident i : queue) {
            if (num == i.getCaseNum()) {
                pos = queue.indexOf(i) + 1;
            } else if (pos == 0) {
                pos = -1;
            }
        }
        return pos;
    }

    // EFFECTS: returns length of the queue
    public int length() {
        return queue.size();
    }

    // EFFECTS: returns true is queue is empty, false otherwise
    public boolean isEmpty() {
        boolean state = false;
        if (queue.size() == 0) {
            state = true;
        }
        return state;
    }

    // EFFECTS: returns true if queue is full, false otherwise
    public boolean isFull() {
        boolean state = false;
        if (queue.size() == MAX_SIZE) {
            state = true;
        }
        return state;
    }
}
