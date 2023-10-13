package util;

import bean.Student;
import exception.StudentExist;
import exception.StudentNotFoundException;

import java.util.ArrayList;

public interface TnPManagementInterface {
    public void addStudent(Student s)throws StudentExist;
    public ArrayList<Student> getEligibleStudents(String branch, float cgpa);
    public int getPlacedStudentCount();
    public ArrayList<Student> getStudent(int regNo) throws StudentNotFoundException;
    public void updatePlacementStatusAndSort(int regNo, String company) throws StudentNotFoundException;

}
