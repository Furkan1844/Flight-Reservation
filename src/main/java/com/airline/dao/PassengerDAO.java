package com.airline.dao;

import com.airline.model.Passenger;

import java.util.List;

public interface PassengerDAO {
    void savePassenger(Passenger passenger);
    Passenger getPassenger(int id);
    List<Passenger> getAllPassengers();
    void updatePassenger(Passenger passenger);
    void deletePassenger(int id);
}
