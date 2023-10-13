package service;

import bean.Student;
import exception.StudentExist;
import exception.StudentNotFoundException;
import util.TnPManagementInterface;

import java.util.ArrayList;

public class TnPManagement implements TnPManagementInterface {

    private ArrayList<Student> studentArrayList = new ArrayList<>();

    @Override
    public void addStudent(Student s) throws StudentExist {

    for(Student i : studentArrayList)
    {
        if(i.getRegNo() == s.getRegNo())
        {

            throw new StudentExist();
        }
    }
        studentArrayList.add(s);
        System.out.println(s.getRegNo()+" student detail has been updated");
    }

    @Override
    public ArrayList<Student> getEligibleStudents(String branch, float cgpa) {
        ArrayList<Student> students = new ArrayList<>();
        for(Student i : studentArrayList )
            if(i.getBranch().equalsIgnoreCase(branch) && i.getCgpa() >= cgpa && i.isPlacementStatus() == false)
            {
                    students.add(i);
                }

        return students;
    }

    @Override
    public int getPlacedStudentCount() {
        int c = 0;
        for(Student i : studentArrayList)
        {
            if(i.isPlacementStatus() == true)
            {
                c++;
            }
        }
        return c;
    }

    @Override
    public ArrayList<Student> getStudent(int regNo) throws StudentNotFoundException {
        ArrayList<Student> arrayList = new ArrayList<>();
        for(Student i : studentArrayList)
        {
            if(i.getRegNo() == regNo)
            {
               arrayList.add(i);
                System.out.println(i.getRegNo()+ " student details ....!");
               break;
            }
            else
                throw new StudentNotFoundException();
        }
        return arrayList;
    }

    @Override
    public void updatePlacementStatusAndSort(int regNo, String company) throws StudentNotFoundException{
        //ArrayList<Student> studentArray = new ArrayList<>();
        int f =0;
        for (Student i : studentArrayList)
        {
            if (i.getRegNo() == regNo)
            {
            i.setPlacementStatus(true);
            i.setCompany(company);
            System.out.println(i.getRegNo()+ "Student placement status has been updated ");
            f = 1;
            break;
            }
        }

        if(f == 0)
        {
            throw new StudentNotFoundException();
        }
    }
}
