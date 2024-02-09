package com.ayush.demoProject;
import java.util.*;
import java.sql.*;

public class OperationClass {
    Scanner sc = new Scanner(System.in);
    ConnectionClass connectionobj = new ConnectionClass();
    Connection con = null;
    int count = 0;

    public OperationClass() throws ClassNotFoundException, SQLException {
        if (con == null) {
            con = connectionobj.getConnection();
        }
    }

    public void insert_record() throws ClassNotFoundException, SQLException {
        try {
            System.out.println("Enter Student Name: ");
            String Name = sc.next();
            System.out.println("Enter Student UID: ");
            String UID = sc.next();
            System.out.println("Enter Student Course: ");
            String Course = sc.next();
            System.out.println("Enter Student Batch: ");
            int Batch = sc.nextInt();
            String insertQuery = "insert into student815 value(?,?,?,?,?)";
            con = connectionobj.getConnection();
            String searchCount = "select max(ID) from student815";
            PreparedStatement psmt1 = con.prepareStatement(searchCount);
            ResultSet rs = psmt1.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
            count += 1;
            PreparedStatement psmt = con.prepareStatement(insertQuery);
            psmt.setInt(1, count);
            psmt.setString(2, UID);
            psmt.setString(3, Name);
            psmt.setString(4, Course);
            psmt.setInt(5, Batch);
            int status = psmt.executeUpdate();
            if (status > 0) {
                System.out.println("Record inserted successfully: " + status);
            } else {
                System.out.println("record is not inserted !");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete() throws ClassNotFoundException, SQLException {
        try {
            System.out.println("Enter Student UID");
            String studentUID = sc.next();
            String searchString = "select * from student815 where studentUID=?";
            PreparedStatement psmt3 = con.prepareStatement(searchString);
            psmt3.setString(1, studentUID);
            ResultSet rs = psmt3.executeQuery();
            if (rs.next()) {
                System.out.println("Student UID:" + rs.getString(2));
                System.out.println("Student Name:" + rs.getString(3));
                System.out.println("Student Course:" + rs.getString(4));
                System.out.println("Student Batch:" + rs.getInt(5));
                int n;
                System.out.println("press 1 to delete !");
                n = sc.nextInt();
                if (n == 1) {
                    String deleteString = "delete from student815 where studentUID=?";
                    psmt3 = con.prepareStatement(deleteString);
                    psmt3.setString(1, studentUID);
                    int status = psmt3.executeUpdate();
                    if (status > 0) {
                        System.out.println("data is deleted !");
                    } else {
                        System.out.println("data is not deleted !");
                    }
                } else {
                    System.out.println("Deletion cancelled.");
                }
            } else {
                System.out.println("no record found !");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update() throws SQLException, ClassNotFoundException {
        try {
            System.out.println("Enter Student UID");
            String studentUID = sc.next();
            String searchQuery = "select * from student815 where studentUID=?";
            if (con == null) {
                con = connectionobj.getConnection();
            }
            PreparedStatement psmt1 = con.prepareStatement(searchQuery);
            psmt1.setString(1, studentUID);
            ResultSet rs = psmt1.executeQuery();
            if (rs.next()) {
                System.out.println("Student UID:" + rs.getString(2));
                System.out.println("Student Name:" + rs.getString(3));
                System.out.println("Student Course:" + rs.getString(4));
                System.out.println("Student Batch:" + rs.getInt(5));
                System.out.println("Enter updated Course:");
                String updatedstudentCourse = sc.next();
                String updatedQuery = "update student815 set studentCourse=? where studentUID=?";
                PreparedStatement psmt2 = con.prepareStatement(updatedQuery);
                psmt2.setString(1, updatedstudentCourse);
                psmt2.setString(2, studentUID);
                int status = psmt2.executeUpdate();
                if (status > 0) {
                    System.out.println("Record updated");
                } else {
                    System.out.println("Record not updated !");
                }
            } else {
                System.out.println("Record not available !");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
