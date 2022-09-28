package pipelineassignmenta;

import org.joda.time.DateTime;

import java.util.List;

public class Lecturer {
    public String getName() {
        return Name;
    }

    private String Name;

    private int Age;
    private DateTime DOB;
    private static int lastID = 0;
    private final String ID;
    private final String Username;

    private List<Module> moduleList;

    public Lecturer(String Name, DateTime DOB){
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
        return "L"+lastID;
    }

    public String getUsername() {
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

    public void addModule(Module module) {
        moduleList.add(module);
    }

    public void removeModule(Module module) {
        moduleList.remove(module);
    }


}
