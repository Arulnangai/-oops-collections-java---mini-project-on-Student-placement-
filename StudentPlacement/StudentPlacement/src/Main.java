import bean.Student;
import exception.StudentExist;
import exception.StudentNotFoundException;
import service.TnPManagement;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws StudentExist, StudentNotFoundException {
        TnPManagement tnp = new TnPManagement();
        try {
            Student s1 = new Student(1001, "A", "EEE", 6.5f, false);
            tnp.addStudent(s1);
            Student s2 = new Student(1002, "B", "ECE", 7.5f, false);
            tnp.addStudent(s2);
            Student s3 = new Student(1003, "C", "EEE", 5.5f, false);
            tnp.addStudent(s3);
            Student s4 = new Student(1004, "D", "CSE", 8.5f, false);
            tnp.addStudent(s4);
            Student s5 = new Student(1005, "E", "ECE", 7.5f, false);
            tnp.addStudent(s5);
            Student s6 = new Student(1006, "F", "EEE", 6.5f, false);
            tnp.addStudent(s6);
            tnp.addStudent(s1);
        } catch (StudentExist s)
        {
            System.out.println("Student already exist in database"+ "\n"+ s);
        }

        ArrayList<Student> std = tnp.getEligibleStudents("EEE", 6.0f);
        System.out.println("Student Eligibility list .....!");
        System.out.println(std);

        ArrayList<Student> std1 = tnp.getStudent(1001);
        System.out.println(std1);

        tnp.updatePlacementStatusAndSort(1004,"Zoho");
        tnp.updatePlacementStatusAndSort(1001,"TCS");

        System.out.println("Total number of student has been placed : "+tnp.getPlacedStudentCount());
    }
}