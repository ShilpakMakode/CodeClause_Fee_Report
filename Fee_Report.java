import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name; 
    private int rollNumber;
    private String dateOfBirth;
    private double courseFee;
    private double paidFee;
    
    public Student(String name, int rollNumber, String dateOfBirth, double courseFee, double paidFee) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.dateOfBirth = dateOfBirth;
        this.courseFee = courseFee;
        this.paidFee = paidFee;
    }
    
    public String getName() {
        return name;
    }
    public int getRollNumber() {
        return rollNumber;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public double getCourseFee() {
        return courseFee;
    }
    public double getPaidFee() {
        return paidFee;
    }
    public double getDueFee() {
        return courseFee - paidFee;
    }
}
public class Fee_Report {
    private static List<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);   
    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\nFee Report System");
            System.out.println("1. Add Student");
            System.out.println("2. View Report");
            System.out.println("3. Exit");
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewReport();
                    break;
                case 3:
                    running = false;
                    System.out.println("Leaving...!!!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }
    private static void addStudent() {
        System.out.print("\nEnter Student Name (in First_Name Last_Name): ");
        String name = scanner.nextLine();
        
        System.out.print("\nEnter roll number (in between 1 to 100): ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();    
        System.out.print("\nEnter date of birth (in DD/MM/YYYY): ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("\nEnter course fee (in \u20B9): ");
        double courseFee = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("\nEnter paid fee (in \u20B9): ");
        double paidFee = scanner.nextDouble();
        scanner.nextLine(); 
        Student student = new Student(name, rollNumber, dateOfBirth, courseFee, paidFee);
        studentList.add(student);
        System.out.println("\nStudent added successfully.");
    }
    private static void viewReport() {
        System.out.println("\nFee Report");   
        if (studentList.isEmpty()) {
            System.out.println("\nNo students found.");
        } else {
            for (Student student : studentList) {
                System.out.println("\nName: " + student.getName());
                System.out.println("Roll Number: " + student.getRollNumber());
                System.out.println("Date of Birth: " + student.getDateOfBirth());
                System.out.println("Course Fee: " + student.getCourseFee());
                System.out.println("Paid Fee: " + student.getPaidFee());
                System.out.println("Due Fee: " + student.getDueFee());
                System.out.println("----------------------");
                // System.out.println("Only above students are Registered with us.\n\n");
            }
        }
    }
}
