
import java.util.Scanner;
void main() {
        Scanner scanner = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Find Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Major: ");
                    String major = scanner.nextLine();

                    service.addStudent(new Student(id, name, age, major));
                    break;

                case 2:
                    System.out.print("Enter student ID: ");
                    service.removeStudent(scanner.nextInt());
                    break;

                case 3:
                    System.out.print("Enter student ID: ");
                    Student student = service.findStudent(scanner.nextInt());
                    System.out.println(student != null ? student : "Student not found");
                    break;

                case 4:
                    service.displayStudents();
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
