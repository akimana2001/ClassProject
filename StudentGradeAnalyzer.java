public class StudentGradeAnalyzer {

    // Calculating the average score of the student
    public static double calculateAverage(double a, double b, double c) {

        return (a + b + c) / 3;
    }

    // Determining the letter grade
    public static String determineGrade(double avg) {

        if (avg >= 90) {
            return "A";
        } else if (avg >= 80) {
            return "B";
        } else if (avg >= 70) {
            return "C";
        } else if (avg >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    // Validating the scores (0–100)
    public static boolean isValid(double a, double b, double c) {
        return a >= 0 && a <= 100 &&
                b >= 0 && b <= 100 &&
                c >= 0 && c <= 100;
    }

    public static void main(String[] args) {

        // The Scores for the multiple students
        double[][] scores = {
                {85, 78, 92},
                {45, 50, 55},
                {100, 90, 95}
        };

        for (int i = 0; i < scores.length; i++) {

            double a = scores[i][0];
            double b = scores[i][1];
            double c = scores[i][2];

            System.out.println("Student " + (i + 1));

            if (!isValid(a, b, c)) {
                System.out.println("Invalid scores");
            } else {
                double avg = calculateAverage(a, b, c);
                String grade = determineGrade(avg);

                System.out.println("Average Score: " + avg);
                System.out.println("Final Grade: " + grade);

                if (avg >= 60) {
                    System.out.println("Status: Pass");
                } else {
                    System.out.println("Status: Fail");
                }
            }

            System.out.println();
        }
    }
}
