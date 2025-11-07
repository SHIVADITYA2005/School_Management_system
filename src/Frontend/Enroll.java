package Frontend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import Execution.Enrollment;
import attributes.enrollment;

public class Enroll extends JFrame {
    private JTextField studentIdField, subjectIdField;
    private JTable table;
    private Enrollment dao;

    public Enroll() {
        dao = new Enrollment(); 

        setTitle("Enrollment Management");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());


        JPanel formPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        formPanel.add(new JLabel("Student ID:"));
        studentIdField = new JTextField();
        formPanel.add(studentIdField);

        formPanel.add(new JLabel("Subject ID:"));
        subjectIdField = new JTextField();
        formPanel.add(subjectIdField);

        
        JButton addBtn = new JButton("Add");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");
        JButton refreshBtn = new JButton("Refresh");

        JPanel btnPanel = new JPanel();
        btnPanel.add(addBtn);
        btnPanel.add(updateBtn);
        btnPanel.add(deleteBtn);
        btnPanel.add(refreshBtn);

        add(formPanel, BorderLayout.NORTH);
        add(btnPanel, BorderLayout.SOUTH);

        
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        
        loadEnrollments();

        
        addBtn.addActionListener(e -> {
            try {
                enrollment en = new enrollment();
                en.setstudent_id(Integer.parseInt(studentIdField.getText()));
                en.setsubjectid(Integer.parseInt(subjectIdField.getText()));

                dao.addenroll(en);
                JOptionPane.showMessageDialog(this, "Enrollment added successfully!");
                loadEnrollments();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error adding enrollment: " + ex.getMessage());
            }
        });

        
        updateBtn.addActionListener(e -> {
            try {
                enrollment en = new enrollment();
                en.setstudent_id(Integer.parseInt(studentIdField.getText()));
                en.setsubjectid(Integer.parseInt(subjectIdField.getText()));

                dao.updateenrolle(en);
                JOptionPane.showMessageDialog(this, "Enrollment updated successfully!");
                loadEnrollments();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error updating enrollment: " + ex.getMessage());
            }
        });

        
        deleteBtn.addActionListener(e -> {
            try {
                int studentId = Integer.parseInt(studentIdField.getText());
                int subjectId = Integer.parseInt(subjectIdField.getText());
                dao.deletestud(studentId, subjectId);
                JOptionPane.showMessageDialog(this, "Enrollment deleted successfully!");
                loadEnrollments();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error deleting enrollment: " + ex.getMessage());
            }
        });

        
        refreshBtn.addActionListener(e -> loadEnrollments());
    }

    
    private void loadEnrollments() {
        List<enrollment> list = dao.geteveryone();
        String[] cols = {"Student ID", "Subject ID"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);

        for (enrollment e : list) {
            Object[] row = { e.getstudent_id(), e.getsubjectid() };
            model.addRow(row);
        }
        table.setModel(model);
    }
}

