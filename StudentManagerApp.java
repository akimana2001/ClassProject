import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StudentManagerApp {

    // CUSTOM EXCEPTION (BONUS)
    static class InvalidStudentException extends Exception {
        public InvalidStudentException(String message) {
            super(message);
        }
    }

    // STUDENT MANAGER CLASS
    static class StudentManager {

        private Map<Integer, String> hashStudents;
        private Map<Integer, String> treeStudents;

        // Constructor
        public StudentManager() {
            hashStudents = new HashMap<>();
            treeStudents = new TreeMap<>();
            log("StudentManager created.");
        }

        // Simple logging (BONUS)
        private void log(String message) {
            System.out.println("[LOG] " + message);
        }

        // Adding a student
        public void addStudent(Map<Integer, String> students, Integer studentId, String name) throws InvalidStudentException {
            if (studentId == null || studentId <= 0) {
                throw new InvalidStudentException("Error: Student ID must be positive!");
            }
            if (name == null || name.trim().isEmpty()) {
                throw new InvalidStudentException("Error: Student name cannot be null or empty!");
            }
            try {
                students.put(studentId, name);
                log("Student added: ID = " + studentId + ", Name = " + name);
            } catch (NullPointerException e) {
                System.out.println("Error: Null key or value cannot be added!");
            }
        }

        // Sorting the students by ID (TreeMap does this automatically)
        public void sortStudents() {
            treeStudents.putAll(hashStudents);
            log("Students sorted by ID (TreeMap).");
        }

        // Search for a student by ID
        public void searchStudent(Map<Integer, String> students, Integer studentId) {
            try {
                if (students.containsKey(studentId)) {
                    System.out.println("Student found: ID = " + studentId + ", Name = " + students.get(studentId));
                } else {
                    System.out.println("Student not found with ID: " + studentId);
                }
            } catch (NullPointerException e) {
                System.out.println("Error: Cannot search for null key!");
            }
        }

        // Remove a student by ID
        public void removeStudent(Map<Integer, String> students, Integer studentId) {
            try {
                if (students.containsKey(studentId)) {
                    String removed = students.remove(studentId);
                    System.out.println("Student removed: ID = " + studentId + ", Name = " + removed);
                } else {
                    System.out.println("Student not found with ID: " + studentId);
                }
            } catch (NullPointerException e) {
                System.out.println("Error: Cannot remove null key!");
            }
        }

        // Find student with highest ID
        public void findStudentWithHighestId(Map<Integer, String> students) {
            if (students.isEmpty()) {
                System.out.println("No students available.");
                return;
            }
            Integer maxId = null;
            for (Integer id : students.keySet()) {
                if (maxId == null || id > maxId) {
                    maxId = id;
                }
            }
            System.out.println("Student with highest ID: ID = " + maxId + ", Name = " + students.get(maxId));
        }

        // Find student with lowest ID
        public void findStudentWithLowestId(Map<Integer, String> students) {
            if (students.isEmpty()) {
                System.out.println("No students available.");
                return;
            }
            Integer minId = null;
            for (Integer id : students.keySet()) {
                if (minId == null || id < minId) {
                    minId = id;
                }
            }
            System.out.println("Student with lowest ID: ID = " + minId + ", Name = " + students.get(minId));
        }

        // Display students
        public void displayStudents(Map<Integer, String> students) {
            System.out.println("Students:");
            for (Map.Entry<Integer, String> entry : students.entrySet()) {
                System.out.println("ID = " + entry.getKey() + ", Name = " + entry.getValue());
            }
        }

        // Getters for HashMap and TreeMap
        public Map<Integer, String> getHashStudents() {
            return hashStudents;
        }

        public Map<Integer, String> getTreeStudents() {
            return treeStudents;
        }
    }

    // MAIN METHOD
    public static void main(String[] args) {
        StudentManager sm = new StudentManager();

        // ADD STUDENTS
        try {
            sm.addStudent(sm.getHashStudents(), 1, "Alice");
            sm.addStudent(sm.getHashStudents(), 2, "Bob");
            sm.addStudent(sm.getHashStudents(), 3, "Charlie");

            // Invalid inputs
            sm.addStudent(sm.getHashStudents(), -1, "InvalidID");
        } catch (InvalidStudentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Student input process completed.\n");
        }

        // Display students in HashMap
        sm.displayStudents(sm.getHashStudents());
        System.out.println();

        // Sort students into TreeMap
        sm.sortStudents();
        sm.displayStudents(sm.getTreeStudents());
        System.out.println();

        // Search students
        sm.searchStudent(sm.getHashStudents(), 2); // valid
        sm.searchStudent(sm.getHashStudents(), 5); // invalid
        System.out.println();

        // Remove students
        sm.removeStudent(sm.getHashStudents(), 1); // valid
        sm.removeStudent(sm.getHashStudents(), 10); // invalid
        System.out.println();

        // Find highest and lowest ID
        sm.findStudentWithHighestId(sm.getHashStudents());
        sm.findStudentWithLowestId(sm.getHashStudents());
        System.out.println();

        System.out.println("Program execution finished.");
    }
}

