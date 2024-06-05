package com.airline.dao.impl;

import com.airline.dao.LocationDAO;
import com.airline.model.Location;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LocationDAOImpl implements LocationDAO {
    private String jdbcURL = "jdbc:sqlite:flight_reservation.db";

    @Override
    public void saveLocation(Location location) {
        String sql = "INSERT INTO locations (country, city, airport) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(jdbcURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, location.getCountry());
            pstmt.setString(2, location.getCity());
            pstmt.setString(3, location.getAirport());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Location getLocation(int id) {
        String sql = "SELECT * FROM locations WHERE id = ?";
        Location location = null;
        try (Connection conn = DriverManager.getConnection(jdbcURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                location = new Location();
                location.setId(rs.getInt("id"));
                location.setCountry(rs.getString("country"));
                location.setCity(rs.getString("city"));
                location.setAirport(rs.getString("airport"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return location;
    }

    @Override
    public List<Location> getAllLocations() {
        String sql = "SELECT * FROM locations";
        List<Location> locations = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(jdbcURL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Location location = new Location();
                location.setId(rs.getInt("id"));
                location.setCountry(rs.getString("country"));
                location.setCity(rs.getString("city"));
                location.setAirport(rs.getString("airport"));
                locations.add(location);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return locations;
    }

    @Override
    public void updateLocation(Location location) {
        String sql = "UPDATE locations SET country = ?, city = ?, airport = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(jdbcURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, location.getCountry());
            pstmt.setString(2, location.getCity());
            pstmt.setString(3, location.getAirport());
            pstmt.setInt(4, location.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteLocation(int id) {
        String sql = "DELETE FROM locations WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(jdbcURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
