/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Question1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


/**
 *
 * @author musankosi
 */
public class SectionA {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //Create an instance of StudentApp and start the application
        StudentApp studentApp = new StudentApp();
        studentApp.run();
    }

    Student searchStudent(String s124) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
//Student class that handles the main logic of the student management application
class StudentApp {
    //List to store student objects
    private final ArrayList<Student> students = new ArrayList<>();
    //Scanner to capture user input
    private final Scanner scanner = new Scanner(System.in);

    //Method used to run the application, disaplying the menu & handling user choices.
    public void run() {
        while (true) {
            displayMenu();// Show the menu to the user
            String choice = scanner.nextLine();//Captures users choice
            switch (choice) {
                case "1" -> captureStudent();
                case "2" -> searchStudent();
                case "3" -> deleteStudent();
                case "4" -> printStudentReport();
                case "5" -> {
                    System.out.println("Exiting Application...");
                    return;
                }
                default -> System.out.println("Invalid option! Please try again.");
            }
        }
    }

    //Method to display the main menu options to the user
    private void displayMenu() {
        System.out.println("STUDENT MANAGEMENT APPLICATION");
        System.out.println("**************");
        System.out.println("Enter (1) to launch menu or any other key to exit.");
        System.out.println();
        System.out.println("Please select one of the following menu items:");
        System.out.println(" (1) Capture a new student");
        System.out.println(" (2) Search for a student.");
        System.out.println(" (3) Delete a student");
        System.out.println(" (4) Print student report.");
        System.out.println(" (5) Exit Application.");
    }

    //Method to capture and store anew student's information
    private void captureStudent() {
        System.out.println("CAPTURE A NEW STUDENT");
        System.out.println("************");

        //Prompt for student details and validate inputs
        int studentId = promptForInt("Enter the student id: ");
        System.out.print("Enter the student name: ");
        String name = scanner.nextLine();
        int age = promptForValidAge("Enter the student age: ");
        System.out.print("Enter the student email: ");
        String email = scanner.nextLine();
        System.out.print("Enter the student course: ");
        String course = scanner.nextLine();

        //Adds new studnets to the list
        students.add(new Student(studentId, name, age, email, course));
        System.out.println("Student details have been successfully saved.");
        promptToContinue();//Ask user to cintinue or exit 
    }

    //Method to prompt the user for an integer input with validation
    private int promptForInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }

    private int promptForValidAge(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int age = Integer.parseInt(scanner.nextLine());
                if (age >= 16) {
                    return age;//Returns age if its 16 or older
                } else {
                    System.out.println("You have entered an incorrect student age!!! Please re-enter the student age.");
                }
            } catch (NumberFormatException e) {
                System.out.println("You have entered an incorrect student age!!! Please re-enter the student age.");
            }
        }
    }

    //Method to search for a student byt their student ID
    void searchStudent() {
        int studentId = promptForInt("Enter the student id to search: ");
        
        // Goes through the list of the students
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                student.printStudentDetails();
                promptToContinue();//Ask the user if they want to continue or exit
                return;
            }
        }
        System.out.println("---------------------------------------------------------------");
        System.out.println("Student with Student Id: " + studentId + " was not found!");
        System.out.println("---------------------------------------------------------------");
        promptToContinue();
    }

    //Method to delete a student by their student ID
    private void deleteStudent() {
        int studentId = promptForInt("Enter the student id to delete: ");
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getStudentId() == studentId) {
                System.out.print("Are you sure you want to delete student " + studentId + " from the system? Yes (y) to delete: ");
                String confirmation = scanner.nextLine();
                if (confirmation.equalsIgnoreCase("y")) {
                    iterator.remove();
                    System.out.println("--------------------------------------------------------");
                    System.out.println("Student with Student Id: " + studentId + " WAS deleted!");
                    System.out.println("--------------------------------------------------------");
                } else {
                    System.out.println("Deletion cancelled.");
                }
                promptToContinue();
                return;
            }
        }
        System.out.println("---------------------------------------------------------------");
        System.out.println("Student with Student Id: " + studentId + " was not found!");
        System.out.println("---------------------------------------------------------------");
        promptToContinue();
    }

    //Method to print report of all the students
    private void printStudentReport() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            int count = 1;
            for (Student student : students) {
                System.out.println("STUDENT " + count++);
                System.out.println("--------------------------------------------");
                student.printStudentDetails();
                System.out.println("----------------------------------------------");
            }
        }
        promptToContinue();
    }

    private void promptToContinue() {
        System.out.println("Enter (1) to launch menu or any other key to exit");
        String input = scanner.nextLine();
        if (!input.equals("1")) {
            System.exit(0);
        }
    }
}

//Student classthat represents the students with attributes (ID, name, age ,email and course)
class Student {
    //Attributes of the student class
    private final int studentId;
    private final String name;
    private final int age;
    private final String email;
    private final String course;

    //Constructor to initialize a Student object with provided values
    public Student(int studentId, String name, int age, String email, String course) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }
//Retrive the student ID
    public int getStudentId() {
        return studentId;
    }
    
//method to print the students details
    public void printStudentDetails() {
        System.out.println("STUDENT ID: " + studentId);
        System.out.println("STUDENT NAME: " + name);
        System.out.println("STUDENT AGE: " + age);
        System.out.println("STUDENT EMAIL: " + email);
        System.out.println("STUDENT COURSE: " + course);
    }

    Object getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
    
    

