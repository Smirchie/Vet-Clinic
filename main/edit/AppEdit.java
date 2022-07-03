package main.edit;

import main.data.Memory;
import main.enums.AppStatus;
import main.listClasses.App;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.UUID;

public class AppEdit {
    public static void CreateApp() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ID пациента: ");
        UUID patientId = UUID.fromString(scanner.nextLine());
        System.out.print("Введите год регистрации: ");
        int year = scanner.nextInt();
        System.out.print("Введите месяц регистрации: ");
        int month = scanner.nextInt();
        System.out.print("Введите день регистрации: ");
        int day = scanner.nextInt();
        Calendar registrationDate = new GregorianCalendar(year, month, day);

        App newApp = new App(patientId, registrationDate, AppStatus.NEW);

        Memory.apps.add(newApp);
        System.out.println("Прием был добавлен \n"+newApp.id);
    }
    public static void ShowAllPatientApps() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ID пациента: ");
        UUID patientId = UUID.fromString(scanner.nextLine());

        if (Memory.apps.stream().noneMatch(a -> a.patientId.equals(patientId))) {
            System.out.println("У пациента нет приемов");
            return;
        }

        System.out.println("Список приемов: ");
        Memory.apps.forEach(a -> {
            if (a.patientId.equals(patientId))
                System.out.println(a.id + " " + a.getDate() + " " + a.status.toString());
        });

    }
    public static void ChangeAppStatus() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ID приема: ");
        UUID appId = UUID.fromString(scanner.nextLine());

        System.out.print("""
                Enter new status:
                0 - Новый
                1 - В процессе
                2 - Отменен
                3 - Ожидает оплаты
                4 - Завершен
                """);

        int statusCode = scanner.nextInt();
        AppStatus newStatus = null;

        switch (statusCode) {
            case 0 -> newStatus = AppStatus.NEW;
            case 1 -> newStatus = AppStatus.IN_PROCESS;
            case 2 -> newStatus = AppStatus.CANCELLED;
            case 3 -> newStatus = AppStatus.AWAITING_PAYMENT;
            case 4 -> newStatus = AppStatus.COMPLETED;
        }

        Memory.apps.stream().filter(a -> a.id.equals(appId)).findFirst().get().status.equals(newStatus);

    }

}
