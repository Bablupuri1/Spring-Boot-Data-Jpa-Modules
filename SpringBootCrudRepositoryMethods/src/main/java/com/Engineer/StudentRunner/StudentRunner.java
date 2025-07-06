package com.Engineer.StudentRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.Engineer.Controllers.StudentController;
import com.Engineer.Model.Student;

@Component
public class StudentRunner implements CommandLineRunner {

    @Autowired
    StudentController StudCont;

    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int ch;

        do {
            System.out.println("\n========= STUDENT MENU =========");
            System.out.println("1. Insert One Student");
            System.out.println("2. Insert Multiple Students");
            System.out.println("3. Get Student by ID");
            System.out.println("4. Check if Student Exists");
            System.out.println("5. Display All Students");
            System.out.println("6. Display Students by IDs");
            System.out.println("7. Total Student Count");
            System.out.println("8. Delete Student by ID");
            System.out.println("9. Delete Student by Object");
            System.out.println("10. Delete Students by ID List");
            System.out.println("11. Delete Students by Object List");
            System.out.println("12. Delete All Students");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (ch) {
                case 1: {
                    Student s = new Student();
                    System.out.print("Enter name: ");
                    s.setName(sc.nextLine());
                    System.out.print("Enter course: ");
                    s.setCourse(sc.nextLine());
                    Student saved = StudCont.insertOneStudent(s);
                    System.out.println("Inserted: " + saved);
                    break;
                }

                case 2: {
                    List<Student> list = new ArrayList<>();
                    System.out.print("Enter number of students to insert: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < n; i++) {
                        Student s = new Student();
                        System.out.print("Enter name: ");
                        s.setName(sc.nextLine());
                        System.out.print("Enter course: ");
                        s.setCourse(sc.nextLine());
                        list.add(s);
                    }
                    StudCont.insertMultipleStudents(list).forEach(System.out::println);
                    break;
                }

                case 3: {
                    System.out.print("Enter student ID: ");
                    int id = sc.nextInt();
                    Optional<Student> s = StudCont.fetchStudentById(id);
                    System.out.println(s.isPresent() ? s.get() : "Not Found");
                    break;
                }

                case 4: {
                    System.out.print("Enter student ID: ");
                    int id = sc.nextInt();
                    System.out.println(StudCont.isStudentExist(id) ? "Exists" : "Does not exist");
                    break;
                }

                case 5: {
                    StudCont.fetchAllStudents().forEach(System.out::println);
                    break;
                }

                case 6: {
                    List<Integer> ids = new ArrayList<>();
                    System.out.print("Enter number of IDs: ");
                    int count = sc.nextInt();
                    for (int i = 0; i < count; i++) {
                        System.out.print("Enter ID: ");
                        ids.add(sc.nextInt());
                    }
                    StudCont.fetchStudentsByIds(ids).forEach(System.out::println);
                    break;
                }

                case 7: {
                    System.out.println("Total Students: " + StudCont.totalStudentCount());
                    break;
                }

                case 8: {
                    System.out.print("Enter student ID to delete: ");
                    int id = sc.nextInt();
                    StudCont.deleteStudentById(id);
                    System.out.println("Deleted");
                    break;
                }

                case 9: {
                    Student s = new Student();
                    System.out.print("Enter name: ");
                    s.setName(sc.nextLine());
                    System.out.print("Enter course: ");
                    s.setCourse(sc.nextLine());
                    StudCont.deleteStudentObject(s);
                    System.out.println("Deleted based on object (Make sure record matches)");
                    break;
                }

                case 10: {
                    List<Integer> ids = new ArrayList<>();
                    System.out.print("Enter number of IDs to delete: ");
                    int count = sc.nextInt();
                    for (int i = 0; i < count; i++) {
                        System.out.print("Enter ID: ");
                        ids.add(sc.nextInt());
                    }
                    StudCont.deleteStudentsByIds(ids);
                    System.out.println("Deleted All By IDs");
                    break;
                }

                case 11: {
                    List<Student> list = new ArrayList<>();
                    System.out.print("Enter number of students to delete: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < n; i++) {
                        Student s = new Student();
                        System.out.print("Enter name: ");
                        s.setName(sc.nextLine());
                        System.out.print("Enter course: ");
                        s.setCourse(sc.nextLine());
                        list.add(s);
                    }
                    StudCont.deleteStudentsList(list);
                    System.out.println("Deleted given list of students");
                    break;
                }

                case 12: {
                    StudCont.deleteAllStudents();
                    System.out.println("All Students Deleted");
                    break;
                }

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again!");
            }

        } while (ch != 0);

        sc.close();
    }
}
