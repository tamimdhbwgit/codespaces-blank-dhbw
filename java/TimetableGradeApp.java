import java.util.Scanner;

public class TimetableGradeApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            printMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    manageTimetable(scanner);
                    break;
                case 2:
                    manageGrades(scanner);
                    break;
                case 3:
                    showReports();
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        } while (choice != 4);

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("===== Timetable & Grade Calculator =====");
        System.out.println("1. Manage Timetable");
        System.out.println("2. Manage Grades");
        System.out.println("3. Show Reports");
        System.out.println("4. Exit");
    }

    // We will fill these later
    private static void manageTimetable(Scanner scanner) {
        System.out.println("[Timetable management will be implemented here]");
    }

    private static void manageGrades(Scanner scanner) {
        System.out.println("[Grade management will be implemented here]");
    }

    private static void showReports() {
        System.out.println("[Reports will be implemented here]");
    }
}
