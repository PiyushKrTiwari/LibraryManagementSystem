package org.example.dao;

import org.example.config.DBConnection;
import org.example.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentDAO {

    public void addStudent(Student student) {

        String sql = "INSERT INTO students(name, email) VALUES (?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());

            ps.executeUpdate();

            System.out.println("Student added successfully!");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    public void viewStudents() {

        String sql = "SELECT * FROM students";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            var rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("Student ID: " + rs.getInt("student_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Email: " + rs.getString("email"));

                System.out.println("----------------------");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}