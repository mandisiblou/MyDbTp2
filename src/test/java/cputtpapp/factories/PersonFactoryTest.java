package cputtpapp.factories;

import cputtpapp.domain.Person;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


import static org.testng.Assert.assertEquals;

/**
 * Created by hashcode on 2017/05/09.
 */
public class PersonFactoryTest {
    Map<String,String> values;

    @BeforeMethod
    public void setUp() throws Exception {
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("firstname","John");
        values.put("lastname","Doe");
    }

    @Test
    public void getPerson() throws Exception {
        Person person = PersonFactory.getPerson(values,25);
        assertEquals("Doe",person.getLastname());
    }

}