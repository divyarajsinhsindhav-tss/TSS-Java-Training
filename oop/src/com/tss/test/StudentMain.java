package com.tss.test;

import com.tss.model.Student;

import java.util.Scanner;

public class StudentMain {
    public static Scanner scanner = new Scanner(System.in);
    public static int totalStudent = 0;
    public static void main(String[] args) {
        System.out.println("How many students you want to create?: ");
        int numberOfStudents = scanner.nextInt();
        Student[] students = new Student[numberOfStudents];
        int index = 0;
        int studentId;

        while (true) {
            System.out.println("\n\n=== Main Menu ===");
            System.out.println("1. Add new Student \n2. Pay fees \n3. Pending fees \n4. Dispaly a student \n5. Display all student \n6. Update Course \n7. Exit");
            System.out.println("Enter your choice: ");
            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    students[index] = new Student();
                    createStudent(students, index);
                    index++;
                    break;
                case 2:
                    System.out.println("For which student you want to pay a fees?: ");
                    studentId = scanner.nextInt();
                    for (int i = 0; i<students.length; i++) {
                        if (students[i] == null) break;
                        if (students[i].getId() == studentId) {
                            System.out.println("Pending fees: " + students[i].getPenddingFees());
                            while(true) {
                                System.out.println("Enter amount you want to paid: ");
                                double amount = scanner.nextDouble();
                                if (students[i].payFees(amount)) break;
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("For which student you want to see pending fees?: ");
                    studentId = scanner.nextInt();
                    for (int i = 0; i<students.length; i++) {
                        if (students[i].getId() == studentId) {
                            System.out.println("Pending fees: " + students[i].getPenddingFees());
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Which student details you want?: ");
                    studentId = scanner.nextInt();
                    for (int i = 0; i<students.length; i++) {
                        if (studentId == students[i].getId()) {
                            System.out.println(students[i]);
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("--------------- All student data ---------------");
                    System.out.println("Student ID \tName \tCourse \tPaid Fees \tTotal Fees \tPending Fees");
                    System.out.println("-----------------------------------------------------------------------");
                    for (int i = 0; i<students.length; i++){
                        System.out.println(students[i].getId() + "\t" +students[i].getName() + "\t" +students[i].getCourse()+ "\t" +students[i].getFeesPaid()+ "\t" +students[i].getTotalFees() + "\t" + students[i].getPenddingFees());
                    }
                    break;
                case 6:
                    System.out.println("For which student you want to update course?: ");
                    studentId = scanner.nextInt();
                    for (int i = 0; i<students.length; i++) {
                        if (studentId == students[i].getId()) {
                            System.out.println("Enter course name: ");
                            scanner.nextLine();
                            String updatedCourse = scanner.nextLine();
                            students[i].setCourse(updatedCourse);
                            System.out.println("Update total fees for updated course: ");
                            double updatedTotalFees = scanner.nextInt();
                            students[i].setTotalFees(updatedTotalFees);
                        }
                    }
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Enter valid choice.");
            }
        }
    }
    private static void createStudent(Student[] students, int index) {
        while(true) {
            System.out.print("Enter Student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            if (students[index].setId(id)) break;
        }

        System.out.print("\nEnter Student Name: ");
        String name = scanner.nextLine();
        students[index].setName(name);

        System.out.print("\nEnter Student Course: ");
        String course = scanner.nextLine();
        students[index].setCourse(course);

        System.out.print("\nEnter fees currently paid: ");
        double feesPaid = scanner.nextDouble();
        students[index].setFeesPaid(feesPaid);

        System.out.print("\nEnter total fees: ");
        double totalFees = scanner.nextDouble();
        students[index].setTotalFees(totalFees);
        totalStudent++;
    }
}
