package cputtpapp.repositories.Impl;

import cputtpapp.domain.Person;
import cputtpapp.repositories.PersonRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hashcode on 2017/05/09.
 */
public class PersonRepositoryImpl implements PersonRepository{
    Map<String,Person> personTable;

    public PersonRepositoryImpl() {
        personTable = new HashMap<String, Person>();
    }

    public Person create(Person person) {
        personTable.put(person.getId(),person);
        Person savedPerson = personTable.get(person.getId());
        return savedPerson;
    }

    public Person read(String id) {
        Person person = personTable.get(id);
        System.out.println(" The Person Object is "+person);
        return person;
    }

    public Person update(Person person) {
        personTable.put(person.getId(),person);
        Person savedPerson = personTable.get(person.getId());
        return savedPerson;
    }

    public void delete(String id) {
        personTable.remove(id);

    }
}
