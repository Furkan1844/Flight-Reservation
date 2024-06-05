package com.airline.dao;

import com.airline.model.Flight;
import java.util.List;

public interface FlightDAO {
    void saveFlight(Flight flight);
    Flight getFlight(int id);
    List<Flight> getAllFlights();
    void updateFlight(Flight flight);
    void deleteFlight(int id);
}
