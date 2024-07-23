import java.util.Scanner;
import java.util.HashMap;

class Student {
    public String name;
    public int rollno;
    public int age;
    public int marks;

    public Student(String name, int rollno, int age, int marks) {
        this.name = name;
        this.rollno = rollno;
        this.age = age;
        this.marks = marks;
    }
        public void ViewStudent() { 
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollno);
        System.out.println("Age: " + age);
        System.out.println("Marks: " + marks);
    }
}
public class StudentDatabase {
        public static void main(String[] args) {
        try{
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Student> database = new HashMap<>();
            while (true) {
            System.out.println(" 1.Add Student");
            System.out.println(" 2.View Student");
            System.out.println(" 3.Search Student");
            System.out.println(" 4.Calculate Avg Marks");
            System.out.println(" 5.Exit");
            System.out.print("Enter your Choice :");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter your name:");
                    String name = sc.nextLine();
                    System.out.print("Enter your roll number :");
                    int rollno = sc.nextInt();
                    System.out.print("Enter your age :");
                    int age = sc.nextInt();
                    System.out.print("Enter your marks :");
                    int marks = sc.nextInt();
                    Student std = new Student(name, rollno, age, marks);
                    database.put(rollno, std);
                    System.out.println("Student Added Successfully");
                    break;
                case 2:
                    System.out.println("List of Students:");
                    for (Student i : database.values()) {
                        i.ViewStudent();
                    }
                    break;
                case 3:
                    System.out.println("Enter your rollno.");
                    int roll = sc.nextInt();
                    Student data = database.get(roll);
                    if (data != null) {
                        data.ViewStudent();
                    } else {
                        System.out.println("Student not found");
                    }
                    System.out.println("*****************");
                    break;
                case 4:
                    int totalStudents = database.size();
                    int totalMarks = 0;
                    for (Student j : database.values()) {
                        totalMarks = totalMarks + j.marks;
                    }
                        double average = (double) totalMarks / totalStudents;
                        System.out.println("Average Marks:" + average);
                    
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invaild Choice :");
                    break;
            }
        }
}
    catch(Exception e){
        System.out.println(e.getMessage());
    }
}
}