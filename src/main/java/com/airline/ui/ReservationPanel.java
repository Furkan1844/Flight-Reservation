package com.airline.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReservationPanel extends JPanel {
    private JTextField nameField, surnameField, seatNumberField;
    private JCheckBox disabledCheckBox, elderlyCheckBox;
    private JTable passengersTable;
    private JComboBox<String> dateComboBox, locationComboBox, flightComboBox;
    private JButton saveButton;

    public ReservationPanel() {
        setLayout(null);

        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setBounds(10, 10, 100, 25);
        add(dateLabel);

        dateComboBox = new JComboBox<>();
        dateComboBox.setBounds(100, 10, 120, 25);
        add(dateComboBox);

        JLabel locationLabel = new JLabel("Location:");
        locationLabel.setBounds(250, 10, 100, 25);
        add(locationLabel);

        locationComboBox = new JComboBox<>();
        locationComboBox.setBounds(350, 10, 120, 25);
        add(locationComboBox);

        JLabel flightLabel = new JLabel("Flights:");
        flightLabel.setBounds(500, 10, 100, 25);
        add(flightLabel);

        flightComboBox = new JComboBox<>();
        flightComboBox.setBounds(600, 10, 120, 25);
        add(flightComboBox);

        JPanel seatPanel = new JPanel();
        seatPanel.setBounds(10, 50, 800, 200);
        add(seatPanel);
        seatPanel.setLayout(new GridLayout(8, 8, 10, 10));

        for (int i = 1; i <= 64 ; i++) {
            JButton seatButton = new JButton("Seat " + i);
            seatPanel.add(seatButton);
        }

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 270, 100, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(100, 270, 120, 25);
        add(nameField);
        nameField.setColumns(10);

        JLabel surnameLabel = new JLabel("Surname:");
        surnameLabel.setBounds(250, 270, 100, 25);
        add(surnameLabel);

        surnameField = new JTextField();
        surnameField.setBounds(350, 270, 120, 25);
        add(surnameField);
        surnameField.setColumns(10);

        JLabel seatNumberLabel = new JLabel("Seat Number:");
        seatNumberLabel.setBounds(500, 270, 100, 25);
        add(seatNumberLabel);

        seatNumberField = new JTextField();
        seatNumberField.setBounds(600, 270, 120, 25);
        add(seatNumberField);
        seatNumberField.setColumns(10);

        disabledCheckBox = new JCheckBox("Disabled");
        disabledCheckBox.setBounds(100, 310, 120, 25);
        add(disabledCheckBox);

        elderlyCheckBox = new JCheckBox("Elderly");
        elderlyCheckBox.setBounds(350, 310, 120, 25);
        add(elderlyCheckBox);

        saveButton = new JButton("Save");
        saveButton.setBounds(600, 310, 120, 25);
        add(saveButton);

        passengersTable = new JTable(new Object[][]{}, new String[]{"Seat Number", "Name", "Surname", "Gender", "Disabled", "Elderly"});
        JScrollPane scrollPane = new JScrollPane(passengersTable);
        scrollPane.setBounds(10, 350, 800, 200);
        add(scrollPane);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String surname = surnameField.getText();
                String seatNumber = seatNumberField.getText();
                boolean disabled = disabledCheckBox.isSelected();
                boolean elderly = elderlyCheckBox.isSelected();
            }
        });
    }
}