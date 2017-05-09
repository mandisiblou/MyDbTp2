package cputtpapp.factories;

import cputtpapp.domain.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by hashcode on 2017/05/09.
 */
public class PersonFactoryTest {
    Map<String,String> values;

    @Before
    public void setUp() throws Exception {
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("firstname","John");
        values.put("lastname","Deo");
    }

    @Test
    public void getPerson() throws Exception {
        Person person = PersonFactory.getPerson(values,25);
        assertEquals("Doe",person.getLastname());
    }

}