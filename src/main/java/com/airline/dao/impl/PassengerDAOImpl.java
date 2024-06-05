package com.airline.dao.impl;

import com.airline.dao.PassengerDAO;
import com.airline.model.Passenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PassengerDAOImpl implements PassengerDAO {
    private String jdbcURL = "jdbc:sqlite:airline_reservation.db";

    @Override
    public void savePassenger(Passenger passenger) {
        String sql = "INSERT INTO passengers (name, surname, seat_number, gender, elderly, disabled, flight_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(jdbcURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, passenger.getName());
            pstmt.setString(2, passenger.getSurname());
            pstmt.setString(3, passenger.getSeatNumber());
            pstmt.setString(4, passenger.getGender());
            pstmt.setBoolean(5, passenger.isElderly());
            pstmt.setBoolean(6, passenger.isDisabled());
            pstmt.setInt(7, passenger.getFlightId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Passenger getPassenger(int id) {
        String sql = "SELECT * FROM passengers WHERE id = ?";
        Passenger passenger = null;
        try (Connection conn = DriverManager.getConnection(jdbcURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                passenger = new Passenger();
                passenger.setId(rs.getInt("id"));
                passenger.setName(rs.getString("name"));
                passenger.setSurname(rs.getString("surname"));
                passenger.setSeatNumber(rs.getString("seat_number"));
                passenger.setGender(rs.getString("gender"));
                passenger.setElderly(rs.getBoolean("elderly"));
                passenger.setDisabled(rs.getBoolean("disabled"));
                passenger.setFlightId(rs.getInt("flight_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return passenger;
    }

    @Override
    public List<Passenger> getAllPassengers() {
        String sql = "SELECT * FROM passengers";
        List<Passenger> passengers = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(jdbcURL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Passenger passenger = new Passenger();
                passenger.setId(rs.getInt("id"));
                passenger.setName(rs.getString("name"));
                passenger.setSurname(rs.getString("surname"));
                passenger.setSeatNumber(rs.getString("seat_number"));
                passenger.setGender(rs.getString("gender"));
                passenger.setElderly(rs.getBoolean("elderly"));
                passenger.setDisabled(rs.getBoolean("disabled"));
                passenger.setFlightId(rs.getInt("flight_id"));
                passengers.add(passenger);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return passengers;
    }

    @Override
    public void updatePassenger(Passenger passenger) {
        String sql = "UPDATE passengers SET name = ?, surname = ?, seat_number = ?, gender = ?, elderly = ?, disabled = ?, flight_id = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(jdbcURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, passenger.getName());
            pstmt.setString(2, passenger.getSurname());
            pstmt.setString(3, passenger.getSeatNumber());
            pstmt.setString(4, passenger.getGender());
            pstmt.setBoolean(5, passenger.isElderly());
            pstmt.setBoolean(6, passenger.isDisabled());
            pstmt.setInt(7, passenger.getFlightId());
            pstmt.setInt(8, passenger.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePassenger(int id) {
        String sql = "DELETE FROM passengers WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(jdbcURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
