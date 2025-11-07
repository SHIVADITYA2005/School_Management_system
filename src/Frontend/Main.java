package Frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {
    public Main(){
        setTitle("School Management System");
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2,3,15,15));

        JButton studentbtn =new JButton("Student");
        JButton teacherbtn =new JButton("Teacher");
        JButton subjectbtn =new JButton("Subjects");    
        JButton classbtn =new JButton("Classroom");
        JButton enrollbtn =new JButton("Enrollment");
        JButton attendbtn =new JButton("Attendance");

        add(studentbtn);
        add(teacherbtn);
        add(subjectbtn);
        add(classbtn);
        add(enrollbtn);
        add(attendbtn);
        
        studentbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Stud().setVisible(true);
            }
        });

        teacherbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Teach().setVisible(true);
            }
        });

        subjectbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Sub().setVisible(true);
            }
        });

        classbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Blass().setVisible(true);
            }
        });

        enrollbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Enroll().setVisible(true);
            }
        });

        attendbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new attend().setVisible(true);
            }
        });
        }
        public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        new Main().setVisible(true);
        });
}

}
//javac -cp "lib/mysql-connector-j-9.5.0.jar;src" -d bin src\Frontend\*.java src\Execution\*.java src\Attributes\*.java src\connection\*.java
//java -cp "lib/mysql-connector-j-9.5.0.jar;bin" Frontend.Main

// test of COA tommo0row MCQ 3,4,5 // ARM to be asked in IE 2 
// test of OS thursday 3,4