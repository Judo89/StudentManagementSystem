import java.io.*;
import java.util.ArrayList;

public class FileManager {
        private static final String FILE_NAME = "students.txt";

        public static void saveStudents(ArrayList<Student> students) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
                for (Student s : students) {
                    writer.write(
                            s.getId() + "," +
                                    s.getName() + "," +
                                    s.getAge() + "," +
                                    s.getMajor()
                    );
                    writer.newLine();
                }
            } catch (IOException e) {
                System.out.println("Error saving students to file.");
            }
        }

        public static ArrayList<Student> loadStudents() {
            ArrayList<Student> students = new ArrayList<>();

            File file = new File(FILE_NAME);
            if (!file.exists()) return students;

            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");

                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    int age = Integer.parseInt(data[2]);
                    String major = data[3];

                    if (students.stream().noneMatch(s -> s.getId() == id)) {
                        students.add(new Student(id, name, age, major));
                    }
                }

            } catch (IOException e) {
                System.out.println("Error loading students from file.");
            }
            return students;
        }
    }


