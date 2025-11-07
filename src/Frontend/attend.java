package Frontend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.List;
import Execution.attendance;
import attributes.Attendance;

public class attend extends JFrame {
    private JTextField subjectIdField, studentIdField, dateField, sessionIdField, statusField;
    private JTable table;
    private attendance dao;

    public attend() {
        dao = new attendance(); 
        setTitle("Attendance Management");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        formPanel.add(new JLabel("Subject ID:")); subjectIdField = new JTextField(); formPanel.add(subjectIdField);
        formPanel.add(new JLabel("Student ID:")); studentIdField = new JTextField(); formPanel.add(studentIdField);
        formPanel.add(new JLabel("Date (YYYY-MM-DD):")); dateField = new JTextField(); formPanel.add(dateField);
        formPanel.add(new JLabel("Session ID:")); sessionIdField = new JTextField(); formPanel.add(sessionIdField);
        formPanel.add(new JLabel("Status (PRESENT/ABSENT):")); statusField = new JTextField(); formPanel.add(statusField);

        JButton addBtn = new JButton("Add");
        JButton deleteBtn = new JButton("Delete");
        JButton refreshBtn = new JButton("Refresh");

        formPanel.add(addBtn);
        formPanel.add(deleteBtn);
        formPanel.add(refreshBtn);

        add(formPanel, BorderLayout.NORTH);

        
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        
        loadAttendance();


        addBtn.addActionListener(e -> {
            try {
                Attendance a = new Attendance();
                a.setsubjectid(Integer.parseInt(subjectIdField.getText()));
                a.setstudent_id(Integer.parseInt(studentIdField.getText()));
                a.setDate(LocalDate.parse(dateField.getText()));
                a.setsessionid(Integer.parseInt(sessionIdField.getText()));
                a.setstatus(Attendance.Status.valueOf(statusField.getText().toUpperCase()));

                dao.addAttendance(a);
                JOptionPane.showMessageDialog(this, "Attendance added successfully!");
                loadAttendance();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error adding attendance: " + ex.getMessage());
            }
        });

    
        deleteBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(studentIdField.getText());
                dao.deleteatt(id);
                JOptionPane.showMessageDialog(this, "Deleted successfully!");
                loadAttendance();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error deleting: " + ex.getMessage());
            }
        });

    
        refreshBtn.addActionListener(e -> loadAttendance());
    }

    
    private void loadAttendance() {
        List<Attendance> list = dao.listall();
        String[] cols = {"Subject ID", "Student ID", "Date", "Session ID", "Status"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        for (Attendance a : list) {
            Object[] row = {
                a.getsubjectid(),
                a.getstudent_id(),
                a.getDate(),
                a.getsessionid(),
                a.getstatus().name()
            };
            model.addRow(row);
        }
        table.setModel(model);
    }
}

