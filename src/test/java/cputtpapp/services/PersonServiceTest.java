package cputtpapp.services;

import cputtpapp.domain.Person;
import cputtpapp.factories.PersonFactory;
import cputtpapp.repositories.Impl.PersonRepositoryImpl;
import cputtpapp.services.Impl.PersonServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created by hashcode on 2017/05/16.
 */
public class PersonServiceTest {
    PersonService service;
    Map<String,String> values;

    @BeforeMethod
    public void setUp() throws Exception {
        service = new PersonServiceImpl();
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("firstname","John");
        values.put("lastname","Deo");
    }

    @Test
    public void testCreate() throws Exception {
        Person person = PersonFactory.getPerson(values,25);
        service.create(person);
        assertEquals(25,person.getAge());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Person readperson = service.read("1");
        assertEquals(25,readperson.getAge());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Person person = service.read("1");
        Person newPerson = new Person.Builder()
                .age(22)
                .firstname(values.get("firstname"))
                .lastname(values.get("lastname"))
                .id(values.get("id"))
                .build();
        service.update(newPerson);
        Person UpdatePerson = service.read("1");
        assertEquals(22,UpdatePerson.getAge());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        service.delete("1");
        Person person = service.read("1");
        assertNull(person);
    }

}