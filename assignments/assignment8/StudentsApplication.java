package com.info;

import com.sun.javafx.logging.JFRInputEvent;
import com.sun.tools.javac.comp.Flow;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class StudentsApplication extends JFrame {

    public JTable studentsTable;
    public Students students;
    public StudentsTableModel model;
    public AddView addView;
    public StudentsApplication(Students students) {
        this.students = students;
        model = new StudentsTableModel(this.students);
        studentsTable = new JTable(model);
        JScrollPane jsp = new JScrollPane(studentsTable);
        jsp.setSize(400, 400);
        Container con = getContentPane();
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btn = new JButton("Add");
        btn.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                addView = new AddView();

            }
        });
        panel.add(btn);
        panel.add(jsp);
        con.add(panel);

        setSize(500, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        Students s = new Students();
        s.addStudent(new Student(100, "Divya", "Sharma", true));
        s.addStudent(new Student(101, "Mihir", "Salunke", false));
        new StudentsApplication(s);

    }


    // Add Student View
    class AddView extends JFrame {

        JTextField id;
        JTextField firstName;
        JTextField lastName;
        JRadioButton male;
        JRadioButton female;

        public AddView() {
            super("Add Student");
            //设置在屏幕的位置
            setLocation(100,50);
            setSize(400,200);
            setVisible(true);

            Container container = getContentPane();
            container.setLayout(new GridLayout(4, 1));
            Font font = new Font("TimesRoman", Font.PLAIN, 14);

            // ID panle
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel idL = new JLabel("ID         ");
            idL.setFont(font);
            id = new JTextField(5);
            id.setFont(font);
            panel.add(idL);
            panel.add(id);
            container.add(panel);

            // name panel
            panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel firstL = new JLabel("FirstName");
            firstL.setFont(font);
            firstName = new JTextField(5);
            firstName.setFont(font);

            JLabel lastL = new JLabel("LastName ");
            lastL.setFont(font);
            lastName = new JTextField(5);
            lastName.setFont(font);
            panel.add(firstL);
            panel.add(firstName);
            panel.add(lastL);
            panel.add(lastName);
            container.add(panel);

            // gender panel
            panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel genderL = new JLabel("Gender   ");
            genderL.setFont(font);

            JLabel maleL = new JLabel("Male");
            maleL.setFont(font);
            JLabel femaleL = new JLabel("Female");
            femaleL.setFont(font);
            male = new JRadioButton();
            female = new JRadioButton();
            ButtonGroup group = new ButtonGroup();
            group.add(male);
            group.add(female);
            panel.add(genderL);
            panel.add(maleL);
            panel.add(male);
            panel.add(femaleL);
            panel.add(female);
            container.add(panel);

            // add button panel
            panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JButton add = new JButton("Add");
            add.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (check()) {
                        AlertView alertView = new AlertView("Success");
                        StudentsApplication.this.students.addStudent(new Student(Integer.parseInt(AddView.this.id.getText()), AddView.this.firstName.getText(), AddView.this.lastName.getText(),male.isSelected()));
                        StudentsApplication.this.studentsTable.updateUI();
                        dispose();
                    } else {
                        AlertView alertView = new AlertView("Fail");
                    }


                }
            });
            add.setFont(font);
            panel.add(add);
            container.add(panel);
        }

        public boolean check() {
            Pattern p = Pattern.compile("[a-zA-Z]+");   // the pattern to search for
            Matcher m = p.matcher(id.getText());
            if (id.getText().equals("") || m.find() || firstName.getText().equals("") || lastName.getText().equals("") || (!male.isSelected() && !female.isSelected()))
                return false;
            return true;
        }
    }


    // Alert Information View
    class AlertView extends JFrame {
        private String msg;

        public AlertView(String message) {
            super(message);
            setLocation(200,100);
            setSize(500,100);
            setVisible(true);

            if (message.equals("Success")) {
                msg = "Add student successfully!";
            } else {
                msg = "Add failed, please check if the information is complete. (ID should only contain digits)";
            }
            Container container = getContentPane();
            container.setLayout(new GridLayout(2, 1));
            Font font = new Font("TimesRoman", Font.PLAIN, 14);

            // ID panle
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JLabel msgL = new JLabel(msg);
            msgL.setFont(font);
            panel.add(msgL);
            container.add(panel);

            panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JButton ok = new JButton("OK");
            ok.setFont(font);
            ok.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
            panel.add(ok);
            container.add(panel);
        }

    }

}



class Students {
    private Collection<Student> students = new ArrayList<Student>();

    public Collection<Student> getStudents() {
        return students;

    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public int getNumberOfStudents() {
        return getStudents().size();
    }

}

class Student {
    int roll;
    String first;
    String last;
    boolean gender = false;

    public Student(int roll, String first, String last, boolean gender) {
        this.roll = roll;
        this.first = first;
        this.last = last;
        this.gender = gender;
    }
}

class StudentsTableModel implements TableModel {

    private Students students;

    public StudentsTableModel(Students students) {
//        super(students.getNumberOfStudents(), 4);
        this.students = students;
    }

    @Override
    public int getRowCount() {
        return students.getNumberOfStudents();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "ROLL";
        }
        if (columnIndex == 1) {
            return "First";
        }
        if (columnIndex == 2)
            return "Last";
        if (columnIndex == 3)
            return "Gender";
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
//        if (columnIndex == 3) {
//            return Boolean.class;
//        }
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Collection<Student> s = students.getStudents();
        int row = -1;
        for (Student student : s) {
            row++;
            if (row == rowIndex) {
                if (columnIndex == 0) {
                    return student.roll + "";
                }
                if (columnIndex == 1) {
                    return student.first;
                }
                if (columnIndex == 2) {
                    return student.last;
                }
                if (columnIndex == 3) {
                    return student.gender? "MALE": "FEMALE";
                }
            }
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
//        Student student = (Student) aValue;

    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        // TODO Auto-generated method stub

    }

}