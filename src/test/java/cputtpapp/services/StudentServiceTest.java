package cputtpapp.services;

import cputtpapp.domain.Student;
import cputtpapp.factories.StudentFactory;
import cputtpapp.services.Impl.StudentServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by hashcode on 2017/05/16.
 */
public class StudentServiceTest {
    StudentService service;
    Map<String,String> values;

    @BeforeMethod
    public void setUp() throws Exception {
        service = new StudentServiceImpl();
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("firstname","John");
        values.put("lastname","Deo");
    }

    @Test
    public void testCreate() throws Exception {
        Student student = StudentFactory.getStudent(values,25);
        service.create(student);
        assertEquals(25,student.getAge());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Student readstudent = service.read("1");
        assertEquals(25,readstudent.getAge());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Student student = service.read("1");
        Student newStudent = new Student.Builder()
                .age(22)
                .firstname(values.get("firstname"))
                .lastname(values.get("lastname"))
                .id(values.get("id"))
                .build();
        service.update(newStudent);
        Student UpdateStudent = service.read("1");
        assertEquals(22,UpdateStudent.getAge());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        service.delete("1");
        Student student = service.read("1");
        assertNull(student);
    }

}