import javax.swing.*;
import java.util.*;

public class Main {


    public static void main(String[] args) {

        int tU; // cummilative total number of units
        int tGU; // cummulative total units and grades
        double cgpa = 0.0;
        int noOfSessions = 0;
        double gpa = calculateCGPA(noOfSessions);

    }

    public static double calculateCGPA(int no) {
        int a;
        int b;
        for (int i = 0; i < no; i++) {

            Object[] cgpaForSession = calcCGPAForSession();
            System.out.println("CGPA FOR ");



        }

    }

    public static Object[] calcCGPAForSession() {

        Object[] x = calculateGPA();
        System.out.println("Gpa for first semester is " + x[0]);
        Object[] y = calculateGPA();
        int tu = (int) x[2] + (int) y[2];
        int tgu = (int) x[1] + (int) y[1];
        double cpga = (double) tgu / tu;
        System.out.println("Gpa for Second semester is " + y[0]);

        return new Object[]{
                cpga,
                tgu, tu
        };

    }

    public static Object[] calculateGPA() {

        int[] x = getUnitsAndGrades();
        System.out.println("ARRAY VALUE IS  " + Arrays.toString(x));
        int totalGradeUnits = x[0];
        int totalUnits = x[1];
        System.out.println("units is " + totalUnits);
        double gpa = (double) totalGradeUnits / totalUnits;
        System.out.println("GPA for the semsster is  " + gpa);
        return new Object[]{gpa, totalGradeUnits, totalUnits,};

    }

    public static int[] getUnitsAndGrades() {

        int noOfCourses = (int) getInput("Enter number of courses for this semester");
        System.out.println("Please Enter each course units for the " + noOfCourses + " courses And respective grades as shown below ");
        System.out.println("3A,2B,4C,");
        Object gradesAndUnits = getInput("Enter grades and units  as shown above");
        String gradesAndUnitsAsString = gradesAndUnits.toString();
        System.out.println("Grades and units in raw form is " + gradesAndUnitsAsString);
        gradesAndUnitsAsString = gradesAndUnitsAsString.trim();
        final int[] gradeUnits = calcGradeUnits(gradesAndUnitsAsString, noOfCourses);
        System.out.println("Grades and units withouth whitspaces is  " + gradesAndUnitsAsString);
        return gradeUnits;


    }

    public static int[] calcGradeUnits(String data, int noOfCourses) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < noOfCourses; i++) {

            final String val = String.valueOf(data.charAt(i));
            if (Objects.equals(val, ",")) {
                int grade = gradeToInt(String.valueOf(data.charAt(i-1)));
                int unit = (int) data.charAt(i-2);
                int gradeUnit = grade * unit;
                a = a+ gradeUnit;
                b = b + unit;
            }
            if(i == noOfCourses-1){
                int grade = gradeToInt(String.valueOf(data.charAt(i)));
                int unit = (int) data.charAt(i-1);
                return new int[]{a,b};
            }

        }
        System.out.println("total units is "+b+" and total grade units is "+a);
        return new int[]{a,b};
    }

    public static int gradeToInt(String letter) {
        switch (letter) {
            case "A":
                return 5;
            case "B":
                return 4;
            case "C":
                return 3;
            case "D":
                return 2;
            case "E":
                return 1;
            case "F":
                return 0;
            default:
                System.out.println("invalid grade; " + letter + " is not a valid grade");
                return -1;

        }
    }

    public static Object getInput(String preText) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(preText);
        return scanner.nextLine();
    }
}





