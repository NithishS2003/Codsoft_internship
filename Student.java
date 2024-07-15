import java.util.Scanner;

class Student {
    private double[] marks;
    private int numSubjects;

    public Student(int numSubjects) {
        this.numSubjects = numSubjects;
        this.marks = new double[numSubjects];
    }

    public void enterMarks() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextDouble();
        }
    }

    public double calculateTotalMarks() {
        double total = 0;
        for (double mark : marks) {
            total += mark;
        }
        return total;
    }

    public double calculateAveragePercentage() {
        double total = calculateTotalMarks();
        return total / numSubjects;
    }

    public char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public void displayResults() {
        double totalMarks = calculateTotalMarks();
        double averagePercentage = calculateAveragePercentage();
        char grade = calculateGrade(averagePercentage);

        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        Student student = new Student(numSubjects);
        student.enterMarks();
        student.displayResults();
    }
}
