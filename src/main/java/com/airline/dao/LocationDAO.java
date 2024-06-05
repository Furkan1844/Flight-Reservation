package com.airline.dao;

import com.airline.model.Location;

import java.util.List;

public interface LocationDAO {
    void saveLocation(Location location);
    Location getLocation(int id);
    List<Location> getAllLocations();
    void updateLocation(Location location);
    void deleteLocation(int id);
}
