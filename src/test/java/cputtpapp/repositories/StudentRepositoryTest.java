package cputtpapp.repositories;

import cputtpapp.domain.Student;
import cputtpapp.factories.StudentFactory;
import cputtpapp.repositories.Impl.PersonRepositoryImpl;
import cputtpapp.repositories.Impl.StudentRepositoryImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;


/**
 * Created by hashcode on 2017/05/09.
 */
public class StudentRepositoryTest {
    Map<String,String> values;
    StudentRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {
        repository = StudentRepositoryImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("firstname","John");
        values.put("lastname","Deo");
    }

    @Test
    public void create() throws Exception {
        Student student = StudentFactory.getStudent(values,25);
        repository.create(student);
        assertEquals(25,student.getAge());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Student readstudent = repository.read("1");
        assertEquals(25,readstudent.getAge());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Student student = repository.read("1");
        Student newStudent = new Student.Builder()
                .age(22)
                .firstname(values.get("firstname"))
                .lastname(values.get("lastname"))
                .id(values.get("id"))
                .build();
        repository.update(newStudent);
        Student UpdatePerson = repository.read("1");
        assertEquals(22,UpdatePerson.getAge());
    }

    @Test (dependsOnMethods = "update")
    public void delete() throws Exception {
        repository.delete("1");
        Student student = repository.read("1");
        assertNull(student);
    }

}