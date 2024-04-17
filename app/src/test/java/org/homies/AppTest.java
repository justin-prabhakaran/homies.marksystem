package org.homies;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
// import org.homies.;
import org.junit.jupiter.api.Test;

public class AppTest {
    // @Test
    // void testPrintAllStudents() {
    // Student st = new Student();
    // st.setName("asdasd");
    // st.setMarks(new Mark(10, 0, 0, 0, 0, 0));

    // App.list.clear();
    // App.list.add(st);
    // App.list.add(st);
    // App.list.add(st);

    // App.printAllStudents();   
    // }

    // @Test
    // void testPrintStudent() {

    // Student st = new Student();
    // st.setName("asfdfds");
    // st.setMarks(new Mark(10, 0, 0, 0, 0, 0));
    // // Add test data
    // App.list.clear();
    // App.list.add(st);
    // App.list.add(st);
    // App.list.add(st);

    // App.printStudent("asfdfds");
    // }

    @Test
    void testCreateStudent() {

        Student student = App.createStudent();

        assertNotNull(student);
        assertEquals("justin", student.getName());
    }
}
