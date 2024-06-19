import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of subjects from the user
        System.out.println("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        // Declare variables to store total marks and marks for each subject
        int totalMarks = 0;
        int[] subjectMarks = new int[numSubjects];

        // Get marks for each subject from the user
        for (int i = 0; i < numSubjects; i++) {
            System.out.println("Enter the marks for subject(out of 100) " + (i + 1) + ": ");
            subjectMarks[i] = scanner.nextInt();

            // Input validation (marks should be between 0 and 100)
            while (subjectMarks[i] < 0 || subjectMarks[i] > 100) {
                System.out.println("Invalid marks entered. Please enter marks between 0 and 100: ");
                subjectMarks[i] = scanner.nextInt();
            }

            totalMarks += subjectMarks[i];
        }

        // Calculate the average percentage
        double averagePercentage = (double) totalMarks / numSubjects;

        // Calculate the grade based on the average percentage
        String grade = calculateGrade(averagePercentage);

        // Display the results
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    public static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A";
        } else if (averagePercentage >= 80) {
            return "B";
        } else if (averagePercentage >= 70) {
            return "C";
        } else if (averagePercentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}
