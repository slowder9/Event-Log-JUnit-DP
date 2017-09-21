package com.company;

import java.util.List;
import java.util.ArrayList;

public class EventLog {

    private List<Event> eventList;//"eventList" is a variable***...goes in constructor below

    public EventLog () {
        this.eventList = new ArrayList<>();
    }

    public boolean addEvent(Event event) {//Event is the type and event is the variable
        // Throw an IllegalArgumentException if the event parameter is null or if either
        // if the two variables of event are null.
        if (event == null || event.getName() == null || event.getAction() == null) {
            throw new IllegalArgumentException("Event is not fully formed");
        }

        String action = event.getAction();

//        event.getAction().equals("Face2Face")//this is same as line above
        if (!(action.equals("Face2Face") ||
                action.equals("PhoneCall") ||
                action.equals("TextMessaging") ||
                action.equals("Unknown"))) {
            throw new IllegalArgumentException("Event Action is invalid");
        }

        // If both parameters are set then
        // print the event to the console and
        System.out.println(event);

        // add it to the list.
        eventList.add(event);
//
        return true;
    }
//
    public int getNumEvents () {
        return eventList.size();
    }
}
