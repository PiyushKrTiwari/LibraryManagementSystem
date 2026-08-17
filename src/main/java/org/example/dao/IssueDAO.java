package org.example.dao;

import org.example.config.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class IssueDAO {

    public void issueBook(int bookId, int studentId) {

        try {

            Connection con = DBConnection.getConnection();

            // 1. Add issue record
            String issueSql =
                    "INSERT INTO issued_books(book_id, student_id, issue_date) " +
                            "VALUES (?, ?, CURDATE())";

            PreparedStatement issuePs =
                    con.prepareStatement(issueSql);

            issuePs.setInt(1, bookId);
            issuePs.setInt(2, studentId);

            issuePs.executeUpdate();


            // 2. Reduce book quantity
            String updateSql =
                    "UPDATE books SET quantity = quantity - 1 " +
                            "WHERE book_id = ? AND quantity > 0";

            PreparedStatement updatePs =
                    con.prepareStatement(updateSql);

            updatePs.setInt(1, bookId);

            updatePs.executeUpdate();

            System.out.println("Book issued successfully!");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    public void returnBook(int issueId) {

        try {

            Connection con = DBConnection.getConnection();

            // 1. Find the book ID
            String findSql =
                    "SELECT book_id FROM issued_books " +
                            "WHERE issue_id = ? AND return_date IS NULL";

            PreparedStatement findPs =
                    con.prepareStatement(findSql);

            findPs.setInt(1, issueId);

            var rs = findPs.executeQuery();

            if (rs.next()) {

                int bookId = rs.getInt("book_id");

                // 2. Set return date
                String returnSql =
                        "UPDATE issued_books " +
                                "SET return_date = CURDATE() " +
                                "WHERE issue_id = ?";

                PreparedStatement returnPs =
                        con.prepareStatement(returnSql);

                returnPs.setInt(1, issueId);

                returnPs.executeUpdate();


                // 3. Increase book quantity
                String updateSql =
                        "UPDATE books SET quantity = quantity + 1 " +
                                "WHERE book_id = ?";

                PreparedStatement updatePs =
                        con.prepareStatement(updateSql);

                updatePs.setInt(1, bookId);

                updatePs.executeUpdate();

                System.out.println("Book returned successfully!");

            } else {

                System.out.println("Invalid Issue ID or book already returned!");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}