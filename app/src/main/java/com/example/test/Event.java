package com.example.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Event
{
    public static ArrayList<Event> eventsList = new ArrayList<>();

    public Event(String eventSympt1, String eventSympt2, String eventSympt3, String eventSympt4, String eventSympt5, String eventSympt6, LocalDate selectedDate, LocalTime time) {
    }

    public static ArrayList<Event> eventsForDate(LocalDate date)
    {
        ArrayList<Event> events = new ArrayList<>();

        for(Event event : eventsList)
        {
            if(event.getDate().equals(date))
                events.add(event);
        }

        return events;
    }


    private String sympt1;
    private String sympt2;
    private String sympt3;
    private String sympt4;
    private String sympt5;
    private String sympt6;
    private String name;
    private LocalDate date;
    private LocalTime time;



    public Event(String eventSympt1, String eventSympt2, String eventSympt3, String eventSympt4, String sympt1, String sympt2, LocalDate date)
    {
        this.sympt1 = sympt1;
        this.sympt1 = sympt2;
        this.date = date;
        this.time = time;

    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }
    public LocalTime getTime()
    {
        return time;
    }

    public void setTime(LocalTime time)
    {
        this.time = time;
    }


}