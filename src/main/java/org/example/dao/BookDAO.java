package org.example.dao;

import org.example.config.DBConnection;
import org.example.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BookDAO {

    // ADD BOOK
    public void addBook(Book book) {

        String sql = "INSERT INTO books(title, author, quantity) VALUES (?, ?, ?)";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getQuantity());

            ps.executeUpdate();

            System.out.println("Book added successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // VIEW BOOKS
    public void viewBooks() {

        String sql = "SELECT * FROM books";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            var rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("Book ID: " + rs.getInt("book_id"));
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Author: " + rs.getString("author"));
                System.out.println("Quantity: " + rs.getInt("quantity"));

                System.out.println("------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // SEARCH BOOK
    public void searchBook(String title) {

        String sql = "SELECT * FROM books WHERE title LIKE ?";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, "%" + title + "%");

            var rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("Book ID: " + rs.getInt("book_id"));
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Author: " + rs.getString("author"));
                System.out.println("Quantity: " + rs.getInt("quantity"));

                System.out.println("----------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


