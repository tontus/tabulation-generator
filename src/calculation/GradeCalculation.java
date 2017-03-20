package calculation;

/**
 * Created by Kazi Mainul Islam on 3/18/2017.
 */
public class GradeCalculation {

    public static String calculate(int attendance, int tt, int partA, int partB){
        int totalMarks = attendance + tt + partA + partB;
        if (totalMarks >= 80) {
            return "4.0";
        }
        if (totalMarks >= 75) {
            return "3.75";
        }
        if (totalMarks >= 70) {
            return "3.5";
        }
        if (totalMarks >= 65) {
            return "3.25";
        }
        if (totalMarks >= 60) {
            return "3.0";
        }
        if (totalMarks >= 55) {
            return "2.75";
        }
        if (totalMarks >= 50) {
            return "2.5";
        }
        if (totalMarks >= 45) {
            return "2.25";
        }
        if (totalMarks >= 40) {
            return "2.0";
        }
        return "0.0";
    }

    public static String calculate(int totalMarks){
        if (totalMarks >= 80) {
            return "4.0";
        }
        if (totalMarks >= 75) {
            return "3.75";
        }
        if (totalMarks >= 70) {
            return "3.5";
        }
        if (totalMarks >= 65) {
            return "3.25";
        }
        if (totalMarks >= 60) {
            return "3.0";
        }
        if (totalMarks >= 55) {
            return "2.75";
        }
        if (totalMarks >= 50) {
            return "2.5";
        }
        if (totalMarks >= 45) {
            return "2.25";
        }
        if (totalMarks >= 40) {
            return "2.0";
        }
        return "0.0";
    }
}
