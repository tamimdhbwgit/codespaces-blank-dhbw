import java.util.Scanner;

public class TimetableManager {

    private final int DAYS;
    private final int SLOTS;
    private final String[][] timetable;
    private static final String[] DAY_NAMES = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" };

    public TimetableManager(int days, int slots) {
        this.DAYS = days;
        this.SLOTS = slots;
        this.timetable = new String[DAYS][SLOTS];
    }

    // Load timetable data from JSON file (called once at startup) - (AI generated)
    public void loadTimetable() {
        String[][] loaded = JsonHelper.loadTimetable(DAYS, SLOTS);
        if (loaded != null) {
            for (int d = 0; d < DAYS; d++) {
                for (int s = 0; s < SLOTS; s++) {
                    timetable[d][s] = loaded[d][s];
                }
            }
            System.out.println("Timetable loaded from file.");
        }
    }

    // Save current timetable data to JSON file - (AI generated)
    public void saveTimetable() {
        JsonHelper.saveTimetable(timetable, DAYS, SLOTS);
    }

    public void manageTimetable(Scanner scanner) {
        boolean back = false;

        while (!back) {
            System.out.println("=== Timetable Management ===");
            System.out.println("1. View timetable");
            System.out.println("2. Set a subject in a slot");
            System.out.println("3. Clear a slot");
            System.out.println("4. Back to main menu");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // quick note: this is needed immediately after scanner.nextInt()- because of
                                // input buffer problems. (w3 resources)

            switch (choice) {
                case 1 -> printTimetable();
                case 2 -> setTimetableSlot(scanner);
                case 3 -> clearTimetableSlot(scanner);
                case 4 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
            System.out.println();
        }
    }

    // Outline of printTimetable - (AI generated)
    public void printTimetable() {
        System.out.println("+------------+----------+----------+----------+----------+----------+----------+");
        System.out.printf("| %-10s ", "Day"); // Spacing for the day column (GeeksforGeeks)
        for (int s = 1; s <= SLOTS; s++) {
            System.out.printf("| %-8s ", "Slot " + s); // Spacing for the slot column (GeeksforGeeks)
        }
        System.out.println("|");
        System.out.println("+------------+----------+----------+----------+----------+----------+----------+");

        for (int d = 0; d < DAYS; d++) {
            String dayName = (d < DAY_NAMES.length) ? DAY_NAMES[d] : "Day " + d; // powerful and efficient way to check
                                                                                 // if the day is within the range of
                                                                                 // the array (W3schoools)
            System.out.printf("| %-10s ", dayName); // Spacing for the day column (GeeksforGeeks)
            for (int s = 0; s < SLOTS; s++) {
                String value = timetable[d][s];
                if (value == null || value.isEmpty()) { // value : subject name
                    System.out.printf("| %-8s ", "  ---"); // Spacing for the empty slot (GeeksforGeeks)
                } else {
                    String display = value.length() > 8 ? value.substring(0, 8) : value; // Boichemistry would become
                                                                                         // "Biochemi"
                    System.out.printf("| %-8s ", display);
                }
            }
            System.out.println("|");
        }
        System.out.println("+------------+----------+----------+----------+----------+----------+----------+");
    }

    private void setTimetableSlot(Scanner scanner) {
        int[] selection = selectDayAndSlot(scanner);
        if (selection == null)
            return;

        System.out.print("Enter subject name: ");
        String subject = scanner.nextLine();
        timetable[selection[0]][selection[1]] = subject;
        saveTimetable();
        System.out.println("Slot updated and saved.");
    }

    private void clearTimetableSlot(Scanner scanner) {
        int[] selection = selectDayAndSlot(scanner);
        if (selection == null)
            return;

        timetable[selection[0]][selection[1]] = null;
        saveTimetable();
        System.out.println("Slot cleared and saved.");
    }

    /*
     * Lists available days, reads day and slot input from the scanner,
     * and validates the selection.
     * Returns int[] {day, slot} on success, or null if the input is invalid.
     */
    private int[] selectDayAndSlot(Scanner scanner) {
        System.out.println("Select day:");
        for (int i = 0; i < DAYS; i++) {
            String dayName = (i < DAY_NAMES.length) ? DAY_NAMES[i] : "Day " + i;
            System.out.println("  " + i + ": " + dayName);
        }
        System.out.print("Enter day (0 to " + (DAYS - 1) + "): ");
        int day = scanner.nextInt();
        System.out.print("Enter slot (1 to " + SLOTS + "): ");
        int slot = scanner.nextInt() - 1;
        scanner.nextLine();

        if (day < 0 || day >= DAYS || slot < 0 || slot >= SLOTS) {
            System.out.println("Invalid day or slot index.");
            return null;
        }
        return new int[] { day, slot };
    }

    /*
     * Returns the timetable array--> not used in the program, but for future
     * encapsulation it might needed.
     */
    // public String[][] getTimetable() {
    // return timetable;
    // }
}
