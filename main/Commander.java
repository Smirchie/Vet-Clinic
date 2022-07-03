package main;

import java.util.Scanner;

import main.listClasses.Patient;
import main.utils.Login;
import main.edit.PatientEdit;
import main.edit.DoctorEdit;
import main.edit.AppEdit;

import javax.print.Doc;


public class Commander {
    public static void Start() {
        Scanner scanner = new Scanner(System.in);
        if (Login.auth()) while (true) {
            System.out.print("""
                    0 - Выход
                    1 - Новый пациент
                    2 - Новый врач
                    3 - Новый прием
                    4 - Удалить пациента
                    5 - Показать пациентов
                    6 - Изменить ФИО пациента
                    7 - Показать приемы
                    8 - Изменить статус приема
                    """);
            switch (scanner.nextInt()) {
                case 0 -> System.exit(0);
                case 1 -> PatientEdit.CreatePatient();
                case 2 -> DoctorEdit.CreateDoctor();
                case 3 -> AppEdit.CreateApp();
                case 4 -> PatientEdit.DeletePatient();
                case 5 -> PatientEdit.ShowAllPatients();
                case 6 -> PatientEdit.EditPatientName();
                case 7 -> AppEdit.ShowAllPatientApps();
                case 8 -> AppEdit.ChangeAppStatus();
            }
        }
        else {
            System.out.println("Некорректный ввод");
        }
    }
}
