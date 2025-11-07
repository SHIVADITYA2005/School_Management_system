package Frontend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import Execution.Classroom;
import attributes.Class;

public class Blass extends JFrame {
    private JTextField sectionField, floorField, typeField, classNumField;
    private JTable table;
    private Classroom dao;

    public Blass() {
        dao = new Classroom();  
        setTitle("Classroom Management");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        formPanel.add(new JLabel("Section:"));
        sectionField = new JTextField();
        formPanel.add(sectionField);

        formPanel.add(new JLabel("Floor:"));
        floorField = new JTextField();
        formPanel.add(floorField);

        formPanel.add(new JLabel("Type (e.g., LAB / THEORY):"));
        typeField = new JTextField();
        formPanel.add(typeField);

        formPanel.add(new JLabel("Class Number:"));
        classNumField = new JTextField();
        formPanel.add(classNumField);

        
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

        
        loadClasses();

    
        addBtn.addActionListener(e -> {
            try {
                Class c = new Class();
                c.setsection(sectionField.getText());
                c.setfloor(floorField.getText());
                c.settype(Class.Type.valueOf(typeField.getText().toUpperCase()));
                c.setclassnum(Integer.parseInt(classNumField.getText()));

                dao.addclass(c);
                JOptionPane.showMessageDialog(this, "Class added successfully!");
                loadClasses();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error adding class: " + ex.getMessage());
            }
        });

        
        deleteBtn.addActionListener(e -> {
            try {
                int classNum = Integer.parseInt(classNumField.getText());
                dao.deleteclass(classNum);
                JOptionPane.showMessageDialog(this, "Class deleted successfully!");
                loadClasses();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error deleting class: " + ex.getMessage());
            }
        });

        
        refreshBtn.addActionListener(e -> loadClasses());
    }
    
    private void loadClasses() {
        List<Class> list = dao.geteveryone();
        String[] cols = {"Class Number", "Section", "Floor", "Type"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        for (Class c : list) {
            Object[] row = {
                c.getclassnum(),
                c.getsection(),
                c.getfloor(),
                c.gettype().name()
            };
            model.addRow(row);
        }
        table.setModel(model);
    }
}

