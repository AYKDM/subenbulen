package com.mycompany.quanlysinhvien;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    public static List<student> selectAll() {
        List<student> studentList = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysinhvien", "root", "");
            String sql = "SELECT * FROM sinhvien";
            stmt = (Statement) con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                student sv = new student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("gender"),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getInt("phone")
                );
                studentList.add(sv);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return studentList;
    }

    public static void insert(student sv) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysinhvien", "root", "");
            String sql = "INSERT INTO sinhvien(name, age, gender , address , email , phone ) values (?,?,?,?,?,?)";
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1,sv.getName());
            stmt.setInt(2,sv.getAge());
            stmt.setString(3,sv.getGender());
            stmt.setString(4,sv.getAddress());
            stmt.setString(5,sv.getEmail());
            stmt.setInt(6,sv.getPhone());
            stmt.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                con.close();
                stmt.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void update(student sv) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysinhvien", "root", "");
            String sql = "UPDATE sinhvien SET name = ?, age = ?, gender = ? , address = ? , email = ? , phone = ?  where id = ?";
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1,sv.getName());
            stmt.setInt(2,sv.getAge());
            stmt.setString(3,sv.getGender());
            stmt.setString(4,sv.getAddress());
            stmt.setString(5,sv.getEmail());
            stmt.setInt(6,sv.getPhone());
            stmt.setInt(7,sv.getId());
            stmt.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                con.close();
                stmt.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void detete(int id) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysinhvien", "root", "");
            String sql = "DELETE FROM sinhvien WHERE id = ?";
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setInt(1,id);
            stmt.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                con.close();
                stmt.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static List<student> findbyname(String name) {
        List<student> studentList = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysinhvien", "root", "");
            String sql = "SELECT * FROM sinhvien WHERE name like '%"+name+"%'";
            stmt = (Statement) con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                student sv = new student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("gender"),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getInt("phone")
                );
                studentList.add(sv);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return studentList;
    }
}