package main.edit;
import main.data.Memory;
import main.listClasses.Patient;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.UUID;

public class PatientEdit {

    public static void CreatePatient() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите год регистрации: ");
        int year = scanner.nextInt();
        System.out.print("Введите месяц регистрации: ");
        int month = scanner.nextInt();
        System.out.print("Введите день регистрации: ");
        int day = scanner.nextInt();
        Calendar date = new GregorianCalendar(year, month, day);

        Patient newPatient = new Patient(name,date);
        Memory.patients.add(newPatient);
        System.out.println("Пациент был добавлен \n"+newPatient.id);
    }


    public static void ShowAllPatients() {
        if (Memory.patients.isEmpty()) {
            System.out.println("Пусто");
            return;
        }

        Memory.patients.forEach(p -> {
            System.out.printf("ID: %s\nФИО: %s\nДата регистрации: %s", p.id, p.name, p.getDate());
            System.out.println("\n");
        });
    }


    public static void DeletePatient() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ID пациента: ");
        UUID patientId = UUID.fromString(scanner.nextLine());
        Memory.patients.removeIf(p -> p.id.equals(patientId));

        System.out.println("Пациент был удален");
    }


    public static void EditPatientName() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ID пациента: ");
        UUID patientId = UUID.fromString(scanner.nextLine());
        Patient patient = Memory.patients.stream().filter(p -> p.id.equals(patientId)).findFirst().get();


        System.out.print("Введите новое ФИО: ");
        String name = scanner.nextLine();

        patient.name = name;
    }

}
