import java.util.ArrayList;
import java.util.Scanner;

class Patient {
    String name;
    int age;
    String disease;

    Patient(String name, int age, String disease) {
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Disease: " + disease);
        System.out.println("---------------------");
    }
}

public class HospitalManagementSystem {

    static ArrayList<Patient> patients = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addPatient() {
        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Disease: ");
        String disease = sc.nextLine();

        patients.add(new Patient(name, age, disease));
        System.out.println("Patient added successfully!");
    }

    public static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patient records found.");
        } else {
            System.out.println("\nPatient Records:");
            for (Patient p : patients) {
                p.display();
            }
        }
    }

    public static void searchPatient() {
        System.out.print("Enter Patient Name: ");
        String searchName = sc.nextLine();

        boolean found = false;

        for (Patient p : patients) {
            if (p.name.equalsIgnoreCase(searchName)) {
                p.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Patient not found.");
        }
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== Hospital Management System =====");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addPatient();
                    break;

                case 2:
                    viewPatients();
                    break;

                case 3:
                    searchPatient();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}