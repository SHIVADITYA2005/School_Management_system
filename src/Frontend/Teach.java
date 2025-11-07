package Frontend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;
import Execution.Teachers;
import attributes.teachers;

public class Teach extends JFrame {
    private JTextField idField, firstNameField, lastNameField, emailField, phoneField, subjectField, salaryField, joinDateField;
    private JComboBox<String> genderBox, statusBox;
    private JTable table;
    private Teachers dao;

    public Teach() {
        dao = new Teachers();

        setTitle("Teacher Management");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        
        JPanel formPanel = new JPanel(new GridLayout(10, 2, 8, 8));
        formPanel.setBorder(BorderFactory.createTitledBorder("Teacher Details"));

        formPanel.add(new JLabel("Teacher ID:"));
        idField = new JTextField();
        formPanel.add(idField);

        formPanel.add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        formPanel.add(firstNameField);

        formPanel.add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        formPanel.add(lastNameField);

        formPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        formPanel.add(emailField);

        formPanel.add(new JLabel("Phone:"));
        phoneField = new JTextField();
        formPanel.add(phoneField);

        formPanel.add(new JLabel("Subject:"));
        subjectField = new JTextField();
        formPanel.add(subjectField);

        formPanel.add(new JLabel("Join Date (YYYY-MM-DD):"));
        joinDateField = new JTextField();
        formPanel.add(joinDateField);

        formPanel.add(new JLabel("Salary:"));
        salaryField = new JTextField();
        formPanel.add(salaryField);

        formPanel.add(new JLabel("Gender:"));
        genderBox = new JComboBox<>(new String[]{"MALE", "FEMALE", "OTHER"});
        formPanel.add(genderBox);

        formPanel.add(new JLabel("Status:"));
        statusBox = new JComboBox<>(new String[]{"ACTIVE", "INACTIVE"});
        formPanel.add(statusBox);

        
        JPanel buttonPanel = new JPanel();
        JButton addBtn = new JButton("Add");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");
        JButton refreshBtn = new JButton("Refresh");

        buttonPanel.add(addBtn);
        buttonPanel.add(updateBtn);
        buttonPanel.add(deleteBtn);
        buttonPanel.add(refreshBtn);

        
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);

        add(formPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        
        loadTeachers();

    
        addBtn.addActionListener(e -> {
            try {
                teachers t = new teachers();
                t.setfirstname(firstNameField.getText());
                t.setlastname(lastNameField.getText());
                t.setemail(emailField.getText());
                t.setphone(phoneField.getText());
                t.setsubject(subjectField.getText());
                t.setjndt(LocalDate.parse(joinDateField.getText()));
                t.setsalary(Float.parseFloat(salaryField.getText()));
                t.setgender(teachers.Gender.valueOf((String) genderBox.getSelectedItem()));
                t.setstatus(teachers.Status.valueOf((String) statusBox.getSelectedItem()));

                dao.addteacher(t);
                JOptionPane.showMessageDialog(this, "Teacher added successfully!");
                loadTeachers();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error adding teacher: " + ex.getMessage());
                ex.printStackTrace();
            }
        });

        updateBtn.addActionListener(e -> {
            try {
                teachers t = new teachers();
                t.setteacherid(Integer.parseInt(idField.getText()));
                t.setfirstname(firstNameField.getText());
                t.setlastname(lastNameField.getText());
                t.setemail(emailField.getText());
                t.setphone(phoneField.getText());
                t.setsubject(subjectField.getText());
                t.setjndt(LocalDate.parse(joinDateField.getText()));
                t.setsalary(Float.parseFloat(salaryField.getText()));
                t.setgender(teachers.Gender.valueOf((String) genderBox.getSelectedItem()));
                t.setstatus(teachers.Status.valueOf((String) statusBox.getSelectedItem()));

                dao.updateteacher(t);
                JOptionPane.showMessageDialog(this, "Teacher updated successfully!");
                loadTeachers();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error updating teacher: " + ex.getMessage());
                ex.printStackTrace();
            }
        });

        deleteBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                dao.deleteteacher(id);
                JOptionPane.showMessageDialog(this, "Teacher deleted successfully!");
                loadTeachers();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error deleting teacher: " + ex.getMessage());
                ex.printStackTrace();
            }
        });

        refreshBtn.addActionListener(e -> loadTeachers());

        
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
                int row = table.getSelectedRow();
                idField.setText(table.getValueAt(row, 0).toString());
                firstNameField.setText(table.getValueAt(row, 1).toString());
                lastNameField.setText(table.getValueAt(row, 2).toString());
                emailField.setText(table.getValueAt(row, 3).toString());
                phoneField.setText(table.getValueAt(row, 4).toString());
                subjectField.setText(table.getValueAt(row, 5).toString());
                joinDateField.setText(table.getValueAt(row, 6).toString());
                salaryField.setText(table.getValueAt(row, 7).toString());
                genderBox.setSelectedItem(table.getValueAt(row, 8).toString());
                statusBox.setSelectedItem(table.getValueAt(row, 9).toString());
            }
        });
    }

    
    private void loadTeachers() {
        List<teachers> list = dao.geteveryone();
        String[] cols = {"Teacher ID", "First Name", "Last Name", "Email", "Phone", "Subject", "Join Date", "Salary", "Gender", "Status"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);

        for (teachers t : list) {
            Object[] row = {
                t.getteacherid(),
                t.getfirstname(),
                t.getlastname(),
                t.getemail(),
                t.getphone(),
                t.getsubject(),
                t.getjndt(),
                t.getsalary(),
                t.getgender(),
                t.getstatus()
            };
            model.addRow(row);
        }

        table.setModel(model);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Teach().setVisible(true));
    }
}
// javac -cp "lib/mysql-connector-j-9.5.0.jar;src" -d bin src\Frontend\*.java src\Execution\*.java src\Attributes\*.java src\connection\*.java
