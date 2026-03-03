import java.util.Scanner;

public class GradeManager {

    private final int MAX_SUBJECTS;
    private final int MAX_EXAMS;
    private final double PASS_THRESHOLD;

    private final String[] subjectNames;
    private final double[][] grades;
    private final int[] examCountPerSubject;
    private int subjectCount = 0;

    public GradeManager(int maxSubjects, int maxExams, double passThreshold) {
        this.MAX_SUBJECTS = maxSubjects;
        this.MAX_EXAMS = maxExams;
        this.PASS_THRESHOLD = passThreshold;
        this.subjectNames = new String[MAX_SUBJECTS];
        this.grades = new double[MAX_SUBJECTS][MAX_EXAMS];
        this.examCountPerSubject = new int[MAX_SUBJECTS];
    }

    /** Load grade data from JSON file (called once at startup). */
    public void loadGrades() {
        int loaded = JsonHelper.loadGrades(subjectNames, grades, examCountPerSubject, MAX_SUBJECTS, MAX_EXAMS);
        if (loaded > 0) {
            subjectCount = loaded;
            System.out.println("Grades loaded from file (" + loaded + " subjects).");
        }
    }

    /** Save current grade data to JSON file. */
    public void saveGrades() {
        JsonHelper.saveGrades(subjectNames, grades, examCountPerSubject, subjectCount);
    }

    public void manageGrades(Scanner scanner) {
        boolean back = false;

        while (!back) {
            System.out.println("=== Grade Management ===");
            System.out.println("1. Add subject");
            System.out.println("2. Add grade to subject");
            System.out.println("3. View grades");
            System.out.println("4. Back to main menu");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addSubject(scanner);
                case 2 -> addGradeToSubject(scanner);
                case 3 -> printGrades();
                case 4 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
            System.out.println();
        }
    }

    private void addSubject(Scanner scanner) {
        // checks the limits defined by the main menu class
        if (subjectCount >= MAX_SUBJECTS) {
            System.out.println("Cannot add more subjects (limit reached).");
            return;
        }

        System.out.print("Enter subject name: ");
        String name = scanner.nextLine();

        // Check for duplicate subject name
        for (int i = 0; i < subjectCount; i++) {
            if (subjectNames[i].equalsIgnoreCase(name)) {
                System.out.println("Subject '" + name + "' already exists.");
                return;
            }
        }

        subjectNames[subjectCount] = name;
        examCountPerSubject[subjectCount] = 0;
        subjectCount++;
        saveGrades();
        System.out.println("Subject added and saved.");
    }

    private void addGradeToSubject(Scanner scanner) {
        if (subjectCount == 0) {
            System.out.println("No subjects yet. Add a subject first.");
            return;
        }

        System.out.println("Select subject:");
        for (int i = 0; i < subjectCount; i++) {
            System.out.println("  " + i + ": " + subjectNames[i]);
        }
        System.out.print("Subject index: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // buffer cleanup...

        if (index < 0 || index >= subjectCount) {
            System.out.println("Invalid subject index.");
            return;
        }

        int examCount = examCountPerSubject[index];
        if (examCount >= MAX_EXAMS) {
            System.out.println("Cannot add more exams for this subject (limit reached).");
            return;
        }

        System.out.print("Enter grade (1.0 - 5.0): ");
        double grade = scanner.nextDouble();
        scanner.nextLine(); // buffer cleanup...

        if (grade < 1.0 || grade > 5.0) {
            System.out.println("Invalid grade value. Must be between 1.0 and 5.0.");
            return;
        }

        grades[index][examCount] = grade;
        examCountPerSubject[index] = examCount + 1;
        saveGrades();
        System.out.println("Grade added and saved.");
    }

    public void printGrades() {
        if (!hasSubjects())
            return; // check for subjects...

        System.out.println("+------------------+-----------------------------+---------+----------------+");
        System.out.printf("| %-16s | %-27s | %-7s | %-14s |%n", "Subject", "Grades", "Average", "Label");
        System.out.println("+------------------+-----------------------------+---------+----------------+");

        for (int i = 0; i < subjectCount; i++) {
            double[] avgOut = new double[1];
            String[] row = buildSubjectRow(i, avgOut);

            System.out.printf("| %-16s | %-27s | %7s | %-14s |%n",
                    row[0], row[1], row[2], row[3]);
        }
        System.out.println("+------------------+-----------------------------+---------+----------------+");
    }

    public void printReportWithPassFail() {
        if (!hasSubjects())
            return; // checks for subjects..

        System.out.println("+------------------+-----------------------------+---------+----------------+--------+");
        System.out.printf("| %-16s | %-27s | %-7s | %-14s | %-6s |%n", "Subject", "Grades", "Average", "Label",
                "Status");
        System.out.println("+------------------+-----------------------------+---------+----------------+--------+");

        double overallSum = 0;
        int gradedSubjectCount = 0;

        for (int i = 0; i < subjectCount; i++) {
            double[] avgOut = new double[1];
            String[] row = buildSubjectRow(i, avgOut);

            String status;
            if (examCountPerSubject[i] == 0) {
                status = "  --";
            } else {
                status = (avgOut[0] <= PASS_THRESHOLD) ? " PASS" : " FAIL";
                overallSum += avgOut[0];
                gradedSubjectCount++;
            }

            System.out.printf("| %-16s | %-27s | %7s | %-14s | %-6s |%n",
                    row[0], row[1], row[2], row[3], status);
        }
        System.out.println("+------------------+-----------------------------+---------+----------------+--------+");

        // Overall CGPA calculation
        if (gradedSubjectCount > 0) {
            double overallCgpa = overallSum / gradedSubjectCount;
            String overallLabel = getGradeLabel(overallCgpa);
            String overallStatus = (overallCgpa <= PASS_THRESHOLD) ? "PASS" : "FAIL";
            System.out.printf("  Overall CGPA: %.2f (%s) - %s%n", overallCgpa, overallLabel, overallStatus);
        } else {
            System.out.println("Overall CGPA: N/A (no graded subjects)");
        }

        System.out.println("(Pass threshold: <= " + PASS_THRESHOLD + ")");
    }

    /*
     * Returns the German grade label for a given grade average.
     * 1.0-1.5: Very Good | 1.6-2.5: Good | 2.6-3.5: Satisfactory
     * 3.6-4.0: Sufficient | 4.1-5.0: Fail
     */
    private String getGradeLabel(double average) {
        if (average <= 1.5)
            return "Very Good";
        if (average <= 2.5)
            return "Good";
        if (average <= 3.5)
            return "Satisfactory";
        if (average <= 4.0)
            return "Sufficient";
        return "Fail";
    }

    /**
     * Builds a formatted row of data for a single subject.
     * Returns a String[] with: [shorterSubjectName, shorterGradeStr, avgStr,
     * label].
     * The computed average is stored in array avgOut[0] (set to 0.0 when there are
     * no
     * exams).
     */
    private String[] buildSubjectRow(int subjectIndex, double[] avgOut) {
        int exams = examCountPerSubject[subjectIndex];

        StringBuilder gradeStr = new StringBuilder();
        double sum = 0;
        for (int j = 0; j < exams; j++) {
            if (j > 0)
                gradeStr.append(", ");
            gradeStr.append(String.format("%.1f", grades[subjectIndex][j]));
            sum += grades[subjectIndex][j];
        }

        String avgStr;
        String label;
        if (exams == 0) {
            gradeStr.append("no grades yet");
            avgStr = "  N/A";
            label = "--";
            avgOut[0] = 0.0;
        } else {
            double avg = sum / exams;
            avgStr = String.format("%6.1f", avg);
            label = getGradeLabel(avg);
            avgOut[0] = avg;
        }

        String gStr = gradeStr.toString();
        if (gStr.length() > 27) {
            gStr = gStr.substring(0, 24) + "...";
        }

        String subjectDisplay = subjectNames[subjectIndex].length() > 16
                ? subjectNames[subjectIndex].substring(0, 13) + "..."
                : subjectNames[subjectIndex];

        return new String[] { subjectDisplay, gStr, avgStr, label };
    }

    /*
     * helper method for printGrades() and printReportwithPassFail()
     * checks if there are any subjects to show
     */
    private boolean hasSubjects() {
        if (subjectCount == 0) {
            System.out.println("No subjects to show.");
            return false;
        }
        return true;
    }
}
/*
 * deletion of grades and subjects are missing here.... (did not manage to add
 * these features due to time shortage)
 */