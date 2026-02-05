public class GradeManagerApp {

       // CUSTOM EXCEPTION (BONUS)

    static class InvalidGradeException extends Exception {
        public InvalidGradeException(String message) {
            super(message);
        }
    }

       // GRADE MANAGER CLASS

    static class GradeManager {

        private int[] grades;
        private int count;

        // Constructor
        public GradeManager(int size) {
            grades = new int[size];
            count = 0;
            log("GradeManager created with size " + size);
        }

        // Simple logging mechanism (BONUS)
        private void log(String message) {
            System.out.println("[LOG] " + message);
        }

        // Adding the grade
        public void addGrade(int grade) throws InvalidGradeException {
            if (grade < 0 || grade > 100) {
                throw new InvalidGradeException("Grade must be between 0 and 100");
            }

            try {
                grades[count] = grade;
                count++;
                log("Grade added: " + grade);
            } catch (ArrayIndexOutOfBoundsException e) {
                log("Failed to add grade: array is full");
                System.out.println("Cannot add more grades. Array is full.");
            }
        }

        // Calculating the average
        public double calculateAverage() {
            if (count == 0) {
                throw new IllegalArgumentException("No grades available to calculate average");
            }

            int sum = 0;
            for (int i = 0; i < count; i++) {
                sum += grades[i];
            }

            double average = (double) sum / count;
            log("Average calculated");
            return average;
        }

        // Finding the highest grade
        public int getHighestGrade() {
            if (count == 0) {
                throw new IllegalArgumentException("No grades available");
            }

            int max = grades[0];
            for (int i = 1; i < count; i++) {
                if (grades[i] > max) {
                    max = grades[i];
                }
            }
            log("Highest grade found");
            return max;
        }

        // Finding the  lowest grade
        public int getLowestGrade() {
            if (count == 0) {
                throw new IllegalArgumentException("No grades available");
            }

            int min = grades[0];
            for (int i = 1; i < count; i++) {
                if (grades[i] < min) {
                    min = grades[i];
                }
            }
            log("Lowest grade found");
            return min;
        }

        // Sorting the  grades
        public void sortGrades() {
            for (int i = 0; i < count - 1; i++) {
                for (int j = 0; j < count - 1 - i; j++) {
                    if (grades[j] > grades[j + 1]) {
                        int temp = grades[j];
                        grades[j] = grades[j + 1];
                        grades[j + 1] = temp;
                    }
                }
            }
            log("Grades sorted");
        }

        // Searching the for a grade
        public boolean searchGrade(int grade) {
            for (int i = 0; i < count; i++) {
                if (grades[i] == grade) {
                    log("Grade found: " + grade);
                    return true;
                }
            }
            log("Grade not found: " + grade);
            return false;
        }

        // Displaying the grades
        public void displayGrades() {
            System.out.print("Grades: ");
            for (int i = 0; i < count; i++) {
                System.out.print(grades[i] + " ");
            }
            System.out.println();
        }
    }


      // MAIN METHOD displaying and calling all methods

    public static void main(String[] args) {

        GradeManager manager = new GradeManager(5);

        try {

            manager.addGrade(85);
            manager.addGrade(90);
            manager.addGrade(70);
            manager.addGrade(95);


            manager.addGrade(120);

        } catch (InvalidGradeException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Grade input process completed.");
        }

        manager.displayGrades();

        // Sorting
        manager.sortGrades();
        manager.displayGrades();

        // Searching
        System.out.println("Searching for grade 90: " + manager.searchGrade(90));
        System.out.println("Searching for grade 50: " + manager.searchGrade(50));

        // Calculations
        try {
            System.out.println("Average grade: " + manager.calculateAverage());
            System.out.println("Highest grade: " + manager.getHighestGrade());
            System.out.println("Lowest grade: " + manager.getLowestGrade());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Program execution finished.");
    }
}
