package com.airline.ui;

import javax.swing.*;

public class PlanePanel extends JPanel {
    private JTextField modelField, brandField, serialNumberField, capacityField;
    private JButton saveButton;
    private JTable planeTable;

    public PlanePanel() {
        setLayout(null);

        JLabel modelLabel = new JLabel("Plane Model:");
        modelLabel.setBounds(10, 10, 120, 25);
        add(modelLabel);

        modelField = new JTextField();
        modelField.setBounds(120, 10, 150, 25);
        add(modelField);

        JLabel brandLabel = new JLabel("Plane Brand:");
        brandLabel.setBounds(280, 10, 120, 25);
        add(brandLabel);

        brandField = new JTextField();
        brandField.setBounds(390, 10, 150, 25);
        add(brandField);

        JLabel serialNumberLabel = new JLabel("Serial Number:");
        serialNumberLabel.setBounds(550, 10, 120, 25);
        add(serialNumberLabel);

        serialNumberField = new JTextField();
        serialNumberField.setBounds(660, 10, 150, 25);
        add(serialNumberField);

        JLabel capacityLabel = new JLabel("Capacity:");
        capacityLabel.setBounds(10, 50, 120, 25);
        add(capacityLabel);

        capacityField = new JTextField();
        capacityField.setBounds(120, 50, 150, 25);
        add(capacityField);

        saveButton = new JButton("Save");
        saveButton.setBounds(660, 50, 120, 25);
        add(saveButton);

        planeTable = new JTable(new Object[][]{}, new String[]{"Model", "Brand", "Serial No", "Capacity"});
        JScrollPane scrollPane = new JScrollPane(planeTable);
        scrollPane.setBounds(10, 90, 800, 460);
        add(scrollPane);
    }
}
