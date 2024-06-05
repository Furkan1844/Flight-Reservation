package com.airline.ui;

import javax.swing.*;

public class LocationPanel extends JPanel {
    private JTextField countryField, cityField, airportField;
    private JButton saveButton;
    private JTable locationTable;

    public LocationPanel() {
        setLayout(null);

        JLabel countryLabel = new JLabel("Country:");
        countryLabel.setBounds(10, 10, 120, 25);
        add(countryLabel);

        countryField = new JTextField();
        countryField.setBounds(120, 10, 150, 25);
        add(countryField);

        JLabel cityLabel = new JLabel("City:");
        cityLabel.setBounds(280, 10, 120, 25);
        add(cityLabel);

        cityField = new JTextField();
        cityField.setBounds(390, 10, 150, 25);
        add(cityField);

        JLabel airportLabel = new JLabel("Airport:");
        airportLabel.setBounds(550, 10, 120, 25);
        add(airportLabel);

        airportField = new JTextField();
        airportField.setBounds(660, 10, 150, 25);
        add(airportField);

        saveButton = new JButton("Save");
        saveButton.setBounds(530, 50, 120, 25);
        add(saveButton);

        locationTable = new JTable(new Object[][]{}, new String[]{"Country", "City", "Airport"});
        JScrollPane scrollPane = new JScrollPane(locationTable);
        scrollPane.setBounds(10, 90, 800, 460);
        add(scrollPane);
    }
}
