package main.listClasses;

import main.enums.AppStatus;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

public class App {
    public UUID id = UUID.randomUUID();

    public UUID patientId;
    private Calendar date;

    public AppStatus status;

    public String getDate()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date.getTime());
    }
    public App(UUID patientId, Calendar date,AppStatus status)
    {

        this.patientId = patientId;
        this.date = date;
        this.status = status;
    }
}
