package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class EventLogTest {
    EventLog el;

    //this thing will say that our method should throw an exception
    @Rule
    public ExpectedException ex = ExpectedException.none();

    @Before
    public void setup() {
        el = new EventLog();
    }

    @After
    public void teardown() {

    }

    @Test
    public void addEventWorksWhenEventsAreValid() {
        Event e1 = new Event("CONNECTED", "Face2Face");
        Event e2 = new Event("CONNECTED", "PhoneCall");
        Event e3 = new Event("CONNECTED", "TextMessaging");
        Event e4 = new Event("CONNECTED", "Unknown");

        el.addEvent(e1);
        el.addEvent(e2);
        el.addEvent(e3);
        el.addEvent(e4);

        assertEquals(4, el.getNumEvents());
    }

    @Test
    public void addEventThrowsExceptionWhenEventNull() {
        // we have a null event
        Event e = null;

        // we expect this method to throw an illegalargumentexception
        ex.expect(IllegalArgumentException.class);

        // add the null event
        el.addEvent(e);

        assertEquals(4, el.getNumEvents());
    }

    @Test
    public void addEventThrowsExceptionIfEventIncomplete() {
        Event e = new Event(null, "Something random");

        ex.expect(IllegalArgumentException.class);
        el.addEvent(e);

        assertEquals(4, el.getNumEvents());
    }

}