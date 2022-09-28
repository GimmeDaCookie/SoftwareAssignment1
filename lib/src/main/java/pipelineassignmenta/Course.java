package pipelineassignmenta;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private final String courseID;
    private List<Student> enrolledStudents = new ArrayList<Student>();
    private List<Module> courseModules;

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(DateTime endDate) {
        this.endDate = endDate;
    }

    private DateTime startDate;
    private DateTime endDate;

    public String getCourseID() {
        return courseID;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public List<Module> getCourseModules() {
        return courseModules;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public DateTime getEndDate() {
        return endDate;
    }

    public Course(String courseID, List<Module> courseModules, DateTime startDate, DateTime endDate) {
        this.courseID = courseID;
        this.courseModules = courseModules;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void addStudent(Student student){
        enrolledStudents.add(student);
        for (Module module : courseModules) {
            module.addStudent(student);
        }
    }

    public void removeStudent(Student student){
        enrolledStudents.remove(student);
        for (Module module : courseModules) {
            module.removeStudent(student);
        }
    }
}
