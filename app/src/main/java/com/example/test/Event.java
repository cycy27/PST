package com.example.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Event
{
    public static ArrayList<Event> eventsList = new ArrayList<>();



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
    private String result;
    private LocalDate date;
    private LocalTime time;
    private String text;



    public Event( String result, LocalDate date, LocalTime time)
    {
        this.result = result;
        this.date = date;
        this.time = time;

    }

    public String getName()
    {
        return result;
    }

    public void setName(String name)
    {
        this.result = name;
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