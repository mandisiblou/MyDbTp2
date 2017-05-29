package cputtpapp.factories;

import cputtpapp.domain.Student;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

/**
 * Created by hashcode on 2017/05/09.
 */
public class StudentFactoryTest {
    Map<String,String> values;

    @BeforeMethod
    public void setUp() throws Exception {
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("firstname","John");
        values.put("lastname","Doe");
    }

    @Test
    public void getStudent() throws Exception {
        Student student = StudentFactory.getStudent(values,25);
        assertEquals("Doe",student.getLastname());
    }

}