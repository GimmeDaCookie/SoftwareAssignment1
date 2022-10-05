package pipelineassignmenta;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class Student {
    public String getName() {
        return Name;
    }

    private String Name;

    private int Age;
    private DateTime DOB;
    private static int lastID = 0;
    private String ID;
    private final String Username;
    private List<Course> Courses = new ArrayList<Course>();
    private List<Module> moduleList = new ArrayList<Module>();

    public Student(String Name, DateTime DOB){
        this.Name = Name;
        this.DOB = DOB;
        this.Age = DOB.year().getDifference(null);
        this.Username = Name+""+Age;
        this.ID = setID();
    }

    public String getID(){
        return this.ID;
    }

    public static String setID(){
        lastID++;
        return "S"+lastID;
    }

    public String getUsername(){
        return Username;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public DateTime getDOB() {
        return DOB;
    }

    public void setDOB(DateTime DOB) {
        this.DOB = DOB;
    }

    public void addCourse(Course course){
        Courses.add(course);
        course.addStudent(this);
        moduleList = course.getCourseModules();
    }

    public void removeCourse(Course course){
        Courses.remove(course);
        course.removeStudent(this);
        moduleList = new ArrayList<Module>();
    }

    public List<Course> getCourses(){
        return Courses;
    }

    public List<Module> getModules(){
        return moduleList;
    }
}
