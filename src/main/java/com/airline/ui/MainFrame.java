package com.airline.ui;

import javax.swing.*;

public class MainFrame extends JFrame {
    private JTabbedPane tabbedPane;
    private ReservationPanel reservationPanel;
    private PlanePanel planePanel;
    private LocationPanel locationPanel;

    public MainFrame() {
        setTitle("Flight Reservation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(820, 650);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();

        reservationPanel = new ReservationPanel();
        tabbedPane.addTab("Reservation", reservationPanel);

        planePanel = new PlanePanel();
        tabbedPane.addTab("Plane", planePanel);

        locationPanel = new LocationPanel();
        tabbedPane.addTab("Location", locationPanel);

        add(tabbedPane);
    }
}