package pipelineassignmenta;

import org.joda.time.DateTime;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseTest {
    static Student student1;
    static Student student2;
    static Student student3;

    static Lecturer lecturer1;
    static Lecturer lecturer2;

    static Module programming;
    static Module biology;
    static Course compSci;
    static Course bioAndCompSci;

    @BeforeAll
    static void setup(){
        student1 = new Student("John", new DateTime(1999,8,1,0,0,0));
        student2 = new Student("George", new DateTime(2000,3,1,0,0,0));
        student3 = new Student("Hannah", new DateTime(2001,12,1,0,0,0));

        lecturer1 = new Lecturer("Anthony", new DateTime(1969,4,1,0,0,0));
        lecturer2 = new Lecturer("Joe", new DateTime(1990,9,1,0,0,0));

        programming = new Module("Programming", "P1000", lecturer1);
        biology = new Module("Biology", "BIO2000", lecturer2);

        compSci = new Course("CS101",
                new ArrayList<Module>(List.of(programming)), new DateTime(2022,9,20,0,0,0), new DateTime(2025,5,20,0,0,0));

        bioAndCompSci = new Course("BCS202",
                new ArrayList<Module>(Arrays.asList(programming,biology)), new DateTime(2021,9,20,0,0,0), new DateTime(2024,5,20,0,0,0));

        //Adding courses to students
        student1.addCourse(bioAndCompSci);
        student2.addCourse(compSci);
    }

    @Test
    void testCourseStuff(){
        //After courses are added to students the student lists for modules and module lists for students are automatically updated
        assertEquals(student1.getUsername(), "John-23");
        assertEquals(student2.getID(), "S2");
        assertEquals(student1.getModules(), Arrays.asList(programming,biology));
        assertEquals(lecturer1.getID(), "L1");
        assertEquals(programming.getStudentList(), Arrays.asList(student1,student2));
        assertEquals(compSci.getEnrolledStudents(), List.of(student2));
    }

}
