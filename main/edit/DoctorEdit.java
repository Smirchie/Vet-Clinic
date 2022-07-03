package main.edit;

import main.data.Memory;
import main.listClasses.Doctor;

import java.util.Scanner;

public class DoctorEdit {

    public static void CreateDoctor()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ФИО: ");
        String name = scanner.nextLine();

        Memory.doctors.add(new Doctor(name));
        System.out.println("Врач был добавлен");
    }

}
