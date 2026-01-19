package com.tss.test;

import com.tss.model.Student;

import java.util.Scanner;

public class StudentTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Student ID");
        int id = scanner.nextInt();
        System.out.println("Enter Student Name");
        String name = scanner.next();
        System.out.println("Enter Student Course");
        String course = scanner.next();
        System.out.println("Enter fees currently paid: ");
        double feesPaid = scanner.nextDouble();
        System.out.println("Enter total fees: ");
        double totalFees = scanner.nextDouble();
        Student student1 = new Student(id, name, course, feesPaid, totalFees);

        while(true) {
            System.out.println("======================================");
            System.out.println("1. Display Student Profile");
            System.out.println("2. Pay Fees");
            System.out.println("3. View Pending Fees");
            System.out.println("4. Update Course");
            System.out.println("0. exit");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(student1.toString());
                    break;
                case 2:
                    System.out.println("Enter amount you want to paid: ");
                    double amount = scanner.nextDouble();
                    student1.payFees(amount);
                    break;
                case 3:
                    System.out.println("Pending fees: " + student1.getPenddingFees());
                    break;
                case 4:
                    System.out.println("Enter course name: ");
                    String updatedCourse = scanner.next();
                    student1.setCourse(updatedCourse);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Enter valid choice");
            }
        }
    }
}
