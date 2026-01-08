import java.util.ArrayList;
public class StudentService {

        private ArrayList<Student> students;

        public StudentService() {
            students = FileManager.loadStudents();
        }

    public void addStudent(Student student) {

        if (isIdExists(student.getId())) {
            System.out.println("Error: Student with ID " + student.getId() + " already exists!");
            return;
        }

        students.add(student);
        FileManager.saveStudents(students);
        System.out.println("Student added successfully!");
    }


    public void removeStudent(int id) {
            boolean removed = students.removeIf(s -> s.getId() == id);
            FileManager.saveStudents(students);

            if (removed) {
                System.out.println("Student removed successfully!");
            } else {
                System.out.println("Student not found!");
            }
        }

        public Student findStudent(int id) {
            for (Student s : students) {
                if (s.getId() == id) {
                    return s;
                }
            }
            return null;
        }

        public void displayStudents() {
            if (students.isEmpty()) {
                System.out.println("No students found.");
                return;
            }
            students.forEach(System.out::println);
        }
    private boolean isIdExists(int id) {
        return students.stream().anyMatch(s -> s.getId() == id);
    }

}


