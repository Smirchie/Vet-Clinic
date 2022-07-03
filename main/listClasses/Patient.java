package main.listClasses;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

public class Patient {
    public UUID id = java.util.UUID.randomUUID();

    public String name;

    private Calendar date;

    public String getDate()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date.getTime());
    }
    public Patient(String name, Calendar date)
    {

        this.name = name;
        this.date = date;
    }
}
