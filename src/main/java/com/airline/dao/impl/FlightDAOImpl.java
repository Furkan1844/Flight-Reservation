package com.airline.dao.impl;

import com.airline.dao.FlightDAO;
import com.airline.model.Flight;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightDAOImpl implements FlightDAO {
    private String jdbcURL = "jdbc:sqlite:airline_reservation.db";

    @Override
    public void saveFlight(Flight flight) {
        String sql = "INSERT INTO flights (date, location, plane_id) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(jdbcURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, flight.getDate());
            pstmt.setString(2, flight.getLocation());
            pstmt.setInt(3, flight.getPlaneId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Flight getFlight(int id) {
        String sql = "SELECT * FROM flights WHERE id = ?";
        Flight flight = null;
        try (Connection conn = DriverManager.getConnection(jdbcURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                flight = new Flight();
                flight.setId(rs.getInt("id"));
                flight.setDate(rs.getString("date"));
                flight.setLocation(rs.getString("location"));
                flight.setPlaneId(rs.getInt("plane_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flight;
    }

    @Override
    public List<Flight> getAllFlights() {
        String sql = "SELECT * FROM flights";
        List<Flight> flights = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(jdbcURL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Flight flight = new Flight();
                flight.setId(rs.getInt("id"));
                flight.setDate(rs.getString("date"));
                flight.setLocation(rs.getString("location"));
                flight.setPlaneId(rs.getInt("plane_id"));
                flights.add(flight);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flights;
    }

    @Override
    public void updateFlight(Flight flight) {
        String sql = "UPDATE flights SET date = ?, location = ?, plane_id = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(jdbcURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, flight.getDate());
            pstmt.setString(2, flight.getLocation());
            pstmt.setInt(3, flight.getPlaneId());
            pstmt.setInt(4, flight.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFlight(int id) {
        String sql = "DELETE FROM flights WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(jdbcURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
