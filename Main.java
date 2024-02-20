import javax.swing.*;
import java.util.*;

public class Main {


    public static void main(String[] args) {

        int tU; // cummilative total number of units
        int tGU; // cummulative total units and grades
        double cgpa = 0.0;
        int noOfSessions =  Integer.parseInt(getInput("Enter number of sessions"));
//        int noOfSessions_ =  Integer.parseInt(noOfSessions);
        double gpa = calculateCGPA(noOfSessions);
        System.out.println("CGPA IS FOR ALL SESSIONS IS  " + gpa);

    }

    public static double calculateCGPA(int no) {
        int a = 0;  // cumulative grade units
        int b = 0;      // cumulative units
        for (int i = 0; i < no; i++) {
            String session;
            String index = String.valueOf(i);
            session = switch ( Integer.parseInt(String.valueOf(index.charAt(index.length() - 1)))) {
                case 0 -> i + 1+ "st";
                case 1 -> i + "nd";
                case 2 -> i + "rd";
                default -> i + "th";
            };
            Object[] x = calcCGPAForSession();
            a = a + (int) x[1];
            b = b + (int) x[2];
            System.out.println("CGPA FOR THE " + session + " session is " + x[0]);
            System.out.println();


        }

        return (double) a / b;

    }

    public static Object[] calcCGPAForSession() {

        Object[] x = calculateGPA();
        System.out.println("Gpa for first semester is " + x[0]);
        Object[] y = calculateGPA();
        int tu = (int) x[2] + (int) y[2];
        int tgu = (int) x[1] + (int) y[1];
        double cpga = (double) tgu / tu;
        System.out.println("Gpa for Second semester is " + y[0]);

        return new Object[]{cpga, tgu, tu,};

    }

    public static Object[] calculateGPA() {

        int[] x = getUnitsAndGrades();
        int totalGradeUnits = x[0];
        int totalUnits = x[1];
        System.out.println("units is " + totalUnits);
        double gpa = (double) totalGradeUnits / totalUnits;
        return new Object[]{gpa, totalGradeUnits, totalUnits,};

    }

    public static int[] getUnitsAndGrades() {

        int noOfCourses =  Integer.parseInt(getInput("Enter number of courses for this semester"));
        System.out.println("Please Enter each course units for the " + noOfCourses + " courses And respective grades as shown below ");
        System.out.println("3A,2B,4C,");
        String gradesAndUnits = getInput("Enter grades and units  as shown above");
        System.out.println("Grades and units in raw form is " + gradesAndUnits);
        gradesAndUnits = gradesAndUnits.trim();
        final int[] gradeUnits = calcGradeUnits(gradesAndUnits, noOfCourses);
        System.out.println("Grades and units withouth whitspaces is  " + gradesAndUnits);
        return gradeUnits;


    }

    public static int[] calcGradeUnits(String data, int noOfCourses) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < data.length(); i++) {

            final String val = String.valueOf(data.charAt(i));

            ;
            if (Objects.equals(val, ",")) {

                int grade = gradeToInt(String.valueOf(data.charAt(i - 1)));
                System.out.println("Grade is " + grade);
                int unit =  Integer.parseInt(String.valueOf(data.charAt(i - 2)));
                System.out.println("unit is " + unit);
                int gradeUnit = grade * unit;
                a = a + gradeUnit;
                System.out.println("grade unit is "+ gradeUnit);
                b = b + unit;
            }
            if (i == data.length() - 1) {
                int grade = gradeToInt(String.valueOf(data.charAt(i)));
                int unit =  Integer.parseInt(String.valueOf(data.charAt(i - 1)));
                int gradeUnit = grade * unit;
                a = a + gradeUnit;
                b = b + unit;
                return new int[]{a, b};
            }

        }
        System.out.println("total units is " + b + " and total grade units is " + a);
        return new int[]{a, b};
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

    public static String getInput(String preText) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(preText);
        return scanner.nextLine();
    }
}





