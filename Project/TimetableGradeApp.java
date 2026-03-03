import java.util.Scanner;

public class TimetableGradeApp {

    private static final int DAYS = 5;
    private static final int SLOTS = 6;
    private static final int MAX_SUBJECTS = 10;
    private static final int MAX_EXAMS = 5;
    private static final double PASS_THRESHOLD = 4.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TimetableManager timetableManager = new TimetableManager(DAYS, SLOTS);
        GradeManager gradeManager = new GradeManager(MAX_SUBJECTS, MAX_EXAMS, PASS_THRESHOLD);

        // Load saved data from JSON files - (AI generated)
        timetableManager.loadTimetable();
        gradeManager.loadGrades();

        int choice;
        do {
            printMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> timetableManager.manageTimetable(scanner);
                case 2 -> gradeManager.manageGrades(scanner);
                case 3 -> showReports(timetableManager, gradeManager);
                case 4 -> System.out.println("Exiting program. Goodbye!");
                default -> System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        } while (choice != 4);

        scanner.close();
    }

    // Outline of printMenu (AI generated)
    private static void printMenu() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║    Timetable & Grade Calculator        ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║  1. Manage Timetable                   ║");
        System.out.println("║  2. Manage Grades                      ║");
        System.out.println("║  3. Show Reports                       ║");
        System.out.println("║  4. Exit                               ║");
        System.out.println("╚════════════════════════════════════════╝");
    }

    // Outline of showReports (AI generated)
    private static void showReports(TimetableManager timetableManager, GradeManager gradeManager) {
        System.out.println();
        System.out.println("╔════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                              STUDENT REPORT                                    ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.println("--- Weekly Timetable ---");
        timetableManager.printTimetable();
        System.out.println();
        System.out.println("--- Grade Report ---");
        gradeManager.printReportWithPassFail();
    }
}
