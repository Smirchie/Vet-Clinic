package main.listClasses;

import java.util.UUID;

public class Doctor {
    private UUID id = UUID.randomUUID();

    private String name;

    public Doctor(String name)
    {
        this.name = name;
    }
}
