import java.time.LocalDate;
import java.time.Period;

class Patient {

    int       id;
    String    surname;
    String    firstname;

    double       length;
    int          weight;
    LocalDate dateOfBirth;
    String[] medicijnen;

    /**
     * Constructor
     */
    Patient(int id, String surname, String firstName, double length, int weight, LocalDate dateOfBirth) { // Added length and weight parameters
        this.id = id;
        this.surname = surname;
        this.firstname = firstName;
        this.length = length;
        this.weight = weight;
        this.dateOfBirth = dateOfBirth;
        this.medicijnen = new String[5];
    }

    double BMIrekenen() {
        double LengteinM = length;
        return weight / (LengteinM * LengteinM);
    }

    public static Patient[] createPatients() {
        Patient[] patients = new Patient[5];
        patients[0] = new Patient(1, "James", "Vanzilk", 1.80, 75, LocalDate.of(1990, 10, 24));
        patients[1] = new Patient(2, "Hanz", "Verkaufen", 1.75, 80, LocalDate.of(1975, 5, 10));
        patients[2] = new Patient(3, "Kaylie", "Hoorn", 1.60, 60, LocalDate.of(1998, 12, 8));
        patients[3] = new Patient(4, "Serge", "Veraufen", 1.85, 90, LocalDate.of(2001, 4, 15));
        patients[4] = new Patient(5, "Merco", "Pesto", 1.70, 70, LocalDate.of(1928, 5, 12));
        return patients;
    }

    /**
     * Display patient data.
     */
    void viewData() {
        System.out.format("===== Patient id:%d ==============================\n", id);
        System.out.format("%-17s %s\n", "Firstname:", surname);
        System.out.format("%-17s %s\n", "Surname:", firstname);
        System.out.format("%-17s %s\n", "Lenght", length+"Meter");
        System.out.format("%-17s %s\n", "Weight:", weight+"Kg");
        System.out.format("%-17s %.2f   \n", "your BMI calculated with Weight / (Length*Length):", BMIrekenen());
        System.out.format("%-17s %s\n", "Date of birth:", dateOfBirth);
        Period age = Period.between(dateOfBirth, LocalDate.now());
        System.out.format("%-17s %s\n", "Age:", age.getYears());
        System.out.println("Medicine: ");
        for (String medicijn : medicijnen) {
            if (medicijn != null) {
                System.out.println("- " + medicijn);
            }
        }
    }

    /**
     * Shorthand for a Patient's full name
     */
    String fullName() {
        return String.format("%s %s [%s]", firstname, surname, dateOfBirth.toString());
    }
}
