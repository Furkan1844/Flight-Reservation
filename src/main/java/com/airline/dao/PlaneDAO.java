package com.airline.dao;

import com.airline.model.Plane;
import java.util.List;

public interface PlaneDAO {
    void savePlane(Plane plane);
    Plane getPlane(int id);
    List<Plane> getAllPlanes();
    void updatePlane(Plane plane);
    void deletePlane(int id);
}