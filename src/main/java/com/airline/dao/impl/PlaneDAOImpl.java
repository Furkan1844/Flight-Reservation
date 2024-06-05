package com.airline.dao.impl;


import com.airline.dao.PlaneDAO;
import com.airline.model.Plane;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaneDAOImpl implements PlaneDAO {
    private String jdbcURL = "jdbc:sqlite:flight_reservation.db";

    @Override
    public void savePlane(Plane plane) {
        String sql = "INSERT INTO planes (model, brand, serial_number, seat_capacity) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(jdbcURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, plane.getModel());
            pstmt.setString(2, plane.getBrand());
            pstmt.setString(3, plane.getSerialNumber());
            pstmt.setInt(4, plane.getSeatCapacity());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Plane getPlane(int id) {
        String sql = "SELECT * FROM planes WHERE id = ?";
        Plane plane = null;
        try (Connection conn = DriverManager.getConnection(jdbcURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                plane = new Plane();
                plane.setId(rs.getInt("id"));
                plane.setModel(rs.getString("model"));
                plane.setBrand(rs.getString("brand"));
                plane.setSerialNumber(rs.getString("serial_number"));
                plane.setSeatCapacity(rs.getInt("seat_capacity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return plane;
    }

    @Override
    public List<Plane> getAllPlanes() {
        String sql = "SELECT * FROM planes";
        List<Plane> planes = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(jdbcURL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Plane plane = new Plane();
                plane.setId(rs.getInt("id"));
                plane.setModel(rs.getString("model"));
                plane.setBrand(rs.getString("brand"));
                plane.setSerialNumber(rs.getString("serial_number"));
                plane.setSeatCapacity(rs.getInt("seat_capacity"));
                planes.add(plane);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return planes;
    }

    @Override
    public void updatePlane(Plane plane) {
        String sql = "UPDATE planes SET model = ?, brand = ?, serial_number = ?, seat_capacity = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(jdbcURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, plane.getModel());
            pstmt.setString(2, plane.getBrand());
            pstmt.setString(3, plane.getSerialNumber());
            pstmt.setInt(4, plane.getSeatCapacity());
            pstmt.setInt(5, plane.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePlane(int id) {
        String sql = "DELETE FROM planes WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(jdbcURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}