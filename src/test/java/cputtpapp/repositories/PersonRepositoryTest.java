package cputtpapp.repositories;

import cputtpapp.domain.Person;
import cputtpapp.factories.PersonFactory;
import cputtpapp.repositories.Impl.PersonRepositoryImpl;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;


/**
 * Created by hashcode on 2017/05/09.
 */
public class PersonRepositoryTest {
    Map<String,String> values;
    PersonRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {
        repository = PersonRepositoryImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("firstname","John");
        values.put("lastname","Deo");
    }

    @Test
    public void create() throws Exception {
        Person person = PersonFactory.getPerson(values,25);
        repository.create(person);
        assertEquals(25,person.getAge());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Person readperson = repository.read("1");
        assertEquals(25,readperson.getAge());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Person person = repository.read("1");
        Person newPerson = new Person.Builder()
                .age(22)
                .firstname(values.get("firstname"))
                .lastname(values.get("lastname"))
                .id(values.get("id"))
                .build();
        repository.update(newPerson);
        Person UpdatePerson = repository.read("1");
        assertEquals(22,UpdatePerson.getAge());
    }

    @Test (dependsOnMethods = "update")
    public void delete() throws Exception {
        repository.delete("1");
        Person person = repository.read("1");
        assertNull(person);
    }

}