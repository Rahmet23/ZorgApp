//import java.time.LocalDate;
import java.util.Scanner;

/**
 * class Administration represents the core of the application by showing
 * the main menu, from where all other functionality is accessible, either
 * directly or via sub-menus.
 * An Administration instance needs a User as input, which is passed via the
 * constructor to the data member 'currentUser'.
 * The patient data is available via the data member currentPatient.
 */
class Administration {
    static final int STOP = 0;
    static final int NEXT = 1;
    static final int VIEW = 2;

    Patient[] patients;            // Alle patienten van patient.java
    User currentUser;               // de use in User.java of te wel ik dus.
    int currentPatientIndex;  //huidig patient
    /**
     * Constructor
     */
    Administration(User user, Patient[] patients) {
        currentUser = user;
        this.patients = patients;
        currentPatientIndex = 0;

    }
    public void viewpatient() {
        //if patients list niet gelijk is aan null dus aan leegte en && betekent dat dat hij twee booleans bij elkaar zet en al true uitgeeft.
        if (patients != null && patients.length >= 1) {
            System.out.println("List of patients available: ");
            for (Patient patient : patients) {
                String patientnaam = patient.fullName();
                System.out.println(patientnaam);
            }
        }
    }
    void menu() {
        var scanner = new Scanner(System.in);

        boolean nextCycle = true;
        while (nextCycle) {
            System.out.format("%s\n", "=".repeat(80));
            System.out.format("Current patient: %s\n", patients[currentPatientIndex].fullName());



                /*
                 Print menu on screen
                */
                System.out.format("%d:  STOP\n", STOP);
                System.out.format("%d: Next patient\n", NEXT);
                System.out.format("%d:  View patient data\n", VIEW);

                System.out.print("enter #choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case STOP:
                        nextCycle = false;
                        break;
                    case NEXT:
                        moveNext();
                        break;
                    case VIEW:
                        patients[currentPatientIndex].viewData();
                        nextCycle = false;
                        break;

                    default:
                        System.out.println("Please enter a *valid* digit");
                        break;
                }
            }
        }
    public void moveNext() {
        if (currentPatientIndex < patients.length - 1) {
            currentPatientIndex++;
            System.out.println("Next patient is: " + patients[currentPatientIndex].fullName());
        } else {
            System.out.println("No more patients available.");
        }
    }
    String[] medicijnen = {"Methylfenidaat", "Temazepam", "Alprazolam", "Tramadol", "Diazepam"};

    public void beeldmedicijnen() {
        System.out.println("================================================================================");
        System.out.println("Available medicine that you can add: ");
        for (String medicijn : medicijnen) {
            System.out.println(medicijn);
        }
    }
}