package Frontend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import Execution.Subjects;
import attributes.subjects;

public class Sub extends JFrame {
    private JTextField subjectIdField, subjectNameField, teacherIdField;
    private JTable table;
    private Subjects dao;

    public Sub() {
        dao = new Subjects();  

        setTitle("Subjects Management");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 8, 8));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        formPanel.add(new JLabel("Subject ID:"));
        subjectIdField = new JTextField();
        formPanel.add(subjectIdField);

        formPanel.add(new JLabel("Subject Name:"));
        subjectNameField = new JTextField();
        formPanel.add(subjectNameField);

        formPanel.add(new JLabel("Teacher ID:"));
        teacherIdField = new JTextField();
        formPanel.add(teacherIdField);
        
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

        
        loadSubjects();

        
        addBtn.addActionListener(e -> {
            try {
                subjects s = new subjects();
                s.setsubjectid(Integer.parseInt(subjectIdField.getText()));
                s.setsubjectname(subjectNameField.getText());
                s.setteacherid(Integer.parseInt(teacherIdField.getText()));

                dao.addsubject(s);
                JOptionPane.showMessageDialog(this, "Subject added successfully!");
                loadSubjects();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error adding subject: " + ex.getMessage());
            }
        });

        
        updateBtn.addActionListener(e -> {
            try {
                subjects s = new subjects();
                s.setsubjectid(Integer.parseInt(subjectIdField.getText()));
                s.setsubjectname(subjectNameField.getText());
                s.setteacherid(Integer.parseInt(teacherIdField.getText()));

                dao.updatesubject(s);
                JOptionPane.showMessageDialog(this, "Subject updated successfully!");
                loadSubjects();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error updating subject: " + ex.getMessage());
            }
        });

        
        deleteBtn.addActionListener(e -> {
            try {
                int subjectId = Integer.parseInt(subjectIdField.getText());
                dao.deletesubject(subjectId);
                JOptionPane.showMessageDialog(this, "Subject deleted successfully!");
                loadSubjects();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error deleting subject: " + ex.getMessage());
            }
        });

        
        refreshBtn.addActionListener(e -> loadSubjects());
    }

    private void loadSubjects() {
        List<subjects> list = dao.geteveryone();
        String[] cols = {"Subject ID", "Subject Name", "Teacher ID"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);

        for (subjects s : list) {
            Object[] row = {
                s.getsubjectid(),
                s.getsubjectname(),
                s.getteacherid()
            };
            model.addRow(row);
        }

        table.setModel(model);
    }
}
