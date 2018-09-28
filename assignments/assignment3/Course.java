package Assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Course {
    private int MAX_NUMBER = 10;

    private String name;
    private int numberOfStudent;
    private Student[] students;

    /**
     * current number of student in the array
     */
    public Course(String name) {
        this.name = name;
        numberOfStudent = 0;
        students = new Student[MAX_NUMBER];
    }

    public Student[] getStudents() {
        Student[] cur = new Student[numberOfStudent];
        for (int i = 0; i < numberOfStudent; i++) {
            cur[i] = students[i];
        }
        return cur;
    }

    public boolean isFull() { return numberOfStudent == MAX_NUMBER; }

    public boolean registerStudent(Student student) {
        if (isFull()) return false;
        students[numberOfStudent++] = student;
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfStudent() {
        return numberOfStudent;
    }

//    public void setNumberOfStudent(int numberOfStudent) {
//        if (numberOfStudent > MAX_NUMBER) return;
//        this.numberOfStudent = numberOfStudent;
//    }
}
