package org.example;

import org.example.dao.BookDAO;
import org.example.dao.StudentDAO;
import org.example.dao.IssueDAO;
import org.example.model.Book;
import org.example.model.Student;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BookDAO bookDAO = new BookDAO();
        StudentDAO studentDAO = new StudentDAO();
        IssueDAO issueDAO = new IssueDAO();

        while (true) {

            System.out.println("\n====================================");
            System.out.println("       LIBRARY MANAGEMENT SYSTEM");
            System.out.println("====================================");

            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Add Student");
            System.out.println("5. View Students");
            System.out.println("6. Issue Book");
            System.out.println("7. Return Book");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter author: ");
                    String author = sc.nextLine();

                    System.out.print("Enter quantity: ");
                    int quantity = sc.nextInt();

                    Book book = new Book(title, author, quantity);

                    bookDAO.addBook(book);

                    break;


                case 2:

                    bookDAO.viewBooks();

                    break;


                case 3:

                    System.out.print("Enter book title to search: ");
                    String searchTitle = sc.nextLine();

                    bookDAO.searchBook(searchTitle);

                    break;


                case 4:

                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter student email: ");
                    String email = sc.nextLine();

                    Student student = new Student(name, email);

                    studentDAO.addStudent(student);

                    break;


                case 5:

                    studentDAO.viewStudents();

                    break;


                case 6:

                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();

                    System.out.print("Enter Student ID: ");
                    int studentId = sc.nextInt();

                    issueDAO.issueBook(bookId, studentId);

                    break;


                case 7:

                    System.out.print("Enter Issue ID: ");
                    int issueId = sc.nextInt();

                    issueDAO.returnBook(issueId);

                    break;


                case 8:

                    System.out.println("Thank you for using Library Management System!");

                    sc.close();

                    return;


                default:

                    System.out.println("Invalid choice!");

            }
        }
    }
}