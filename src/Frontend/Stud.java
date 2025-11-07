package Frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import Execution.Students;       
import attributes.students;     

public class Stud extends JFrame {
    private JTextField idField, fnameField, lnameField, dobField, emailField, phoneField, addressField, admissionField, statusField;
    private Students dao;

    public Stud() {
        dao = new Students(); // DAO connection

        setTitle("Student Management");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(11, 2, 5, 5));

        
        add(new JLabel("Student ID:")); idField = new JTextField(); add(idField);
        add(new JLabel("First Name:")); fnameField = new JTextField(); add(fnameField);
        add(new JLabel("Last Name:")); lnameField = new JTextField(); add(lnameField);
        add(new JLabel("Date of Birth (YYYY-MM-DD):")); dobField = new JTextField(); add(dobField);
        add(new JLabel("Email:")); emailField = new JTextField(); add(emailField);
        add(new JLabel("Phone:")); phoneField = new JTextField(); add(phoneField);
        add(new JLabel("Address:")); addressField = new JTextField(); add(addressField);
        add(new JLabel("Admission Date (YYYY-MM-DD):")); admissionField = new JTextField(); add(admissionField);
        add(new JLabel("Status (ACTIVE/INACTIVE):")); statusField = new JTextField(); add(statusField);

        
        JButton addBtn = new JButton("Add");
        JButton searchBtn = new JButton("Search");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");

        add(addBtn);
        add(searchBtn);
        add(updateBtn);
        add(deleteBtn);

        
        addBtn.addActionListener(e -> {
            try {
                students s = new students(
                    Integer.parseInt(idField.getText()),
                    fnameField.getText(),
                    lnameField.getText(),
                    LocalDate.parse(dobField.getText()),
                    emailField.getText(),
                    phoneField.getText(),
                    addressField.getText(),
                    LocalDate.parse(admissionField.getText()),
                    students.Status.valueOf(statusField.getText().toUpperCase())
                );
                dao.addstudent(s);
                JOptionPane.showMessageDialog(this, "Student added successfully!");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error adding student: " + ex.getMessage());
            }
        });

        
        searchBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                students s = dao.getstudentId(id);
                if (s != null) {
                    fnameField.setText(s.getfirst_name());
                    lnameField.setText(s.getlast_name());
                    dobField.setText(s.getdate_of_birth().toString());
                    emailField.setText(s.getemail());
                    phoneField.setText(s.getphone());
                    addressField.setText(s.getaddress());
                    admissionField.setText(s.getadmission_Date().toString());
                    statusField.setText(s.getstatus().name());
                } else {
                    JOptionPane.showMessageDialog(this, "Student not found!");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error searching student: " + ex.getMessage());
            }
        });

        
        updateBtn.addActionListener(e -> {
            try {
                students s = new students(
                    Integer.parseInt(idField.getText()),
                    fnameField.getText(),
                    lnameField.getText(),
                    LocalDate.parse(dobField.getText()),
                    emailField.getText(),
                    phoneField.getText(),
                    addressField.getText(),
                    LocalDate.parse(admissionField.getText()),
                    students.Status.valueOf(statusField.getText().toUpperCase())
                );
                dao.updatestudent(s);
                JOptionPane.showMessageDialog(this, "Student updated successfully!");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error updating student: " + ex.getMessage());
            }
        });

        
        deleteBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                dao.deletestudent(id);
                JOptionPane.showMessageDialog(this, "Student deleted successfully!");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error deleting student: " + ex.getMessage());
            }
        });
    }
}

