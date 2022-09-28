package pipelineassignmenta;

import java.util.ArrayList;
import java.util.List;

public class Module {
    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleID() {
        return moduleID;
    }

    public void setModuleID(String moduleID) {
        this.moduleID = moduleID;
    }

    public Lecturer getCourseLecturer() {
        return courseLecturer;
    }

    public void setCourseLecturer(Lecturer courseLecturer) {
        this.courseLecturer = courseLecturer;
    }

    private String moduleName;
    private String moduleID;
    private List<Student> studentList = new ArrayList<Student>();
    private Lecturer courseLecturer;

    public Module(String moduleName, String moduleID, Lecturer lecturer) {
        this.moduleName = moduleName;
        this.moduleID = moduleID;
        this.courseLecturer = lecturer;
    }

    public void addStudent(Student student){
        studentList.add(student);
    }

    public void removeStudent(Student student){
        studentList.remove(student);
    }

    public List<Student> getStudentList(){
        return this.studentList;
    }
}
