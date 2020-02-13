package ca.ubc.cpsc210.helpdesk.test;


import ca.ubc.cpsc210.helpdesk.model.Incident;
import ca.ubc.cpsc210.helpdesk.model.IncidentQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IncidentQueueTest {
    private IncidentQueue q;
    private Incident i1;
    private Incident i2;

    @BeforeEach
    void runBefore() {
        q = new IncidentQueue();
        i1 = new Incident(1, "Broken Bone");
        i2 = new Incident(5, "Broken Ankle");
    }

    @Test
    void testConstructor() {
        assertFalse(q.isFull());
        assertTrue(q.isEmpty());
        assertEquals(0,q.length());
    }

    @Test
    void testAddIncident() {
        q.addIncident(i1);
        q.addIncident(i2);
        assertEquals(2,q.length());
        assertFalse(q.isFull());
        assertFalse(q.isEmpty());
    }

    @Test
    void testGetNextIncident() {
        q.addIncident(i1);
        q.addIncident(i2);
        q.getNextIncident();
        assertEquals(1,q.length());
    }

    @Test
    void testGetPositionOfCase() {
        q.addIncident(i1);
        q.addIncident(i2);
        assertEquals(2,q.getPositionInQueueOfCaseNumber(5));
        assertEquals(1,q.getPositionInQueueOfCaseNumber(1));
        assertEquals(-1,q.getPositionInQueueOfCaseNumber(7));
    }
}