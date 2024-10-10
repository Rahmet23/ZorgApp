class ZorgApp {
    public static void main(String[] args) {
        User user = new User(1, "Jack Sparrow");
        System.out.format("Current user: [%d] %s\n", user.getUserID(), user.getUserName());

        System.out.println();

        Patient[] patients = Patient.createPatients();

        // Call administration menu
        Administration administration = new Administration(user, patients);
        administration.viewpatient();
        administration.menu();
        // Call beeldmedicijnen() after the menu is finished
        administration.beeldmedicijnen();
    }
}