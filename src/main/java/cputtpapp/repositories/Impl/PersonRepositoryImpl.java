package cputtpapp.repositories.Impl;

import cputtpapp.domain.Person;
import cputtpapp.repositories.PersonRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hashcode on 2017/05/09.
 */
public class PersonRepositoryImpl implements PersonRepository{

    private static PersonRepositoryImpl respository = null;

    private Map<String,Person> personTable;

    private PersonRepositoryImpl() {
        personTable = new HashMap<String, Person>();
    }

    public static PersonRepositoryImpl getInstance(){
        if(respository==null)
            respository = new PersonRepositoryImpl();
        return respository;
    }

    public Person create(Person person) {
        personTable.put(person.getId(),person);
        Person savedPerson = personTable.get(person.getId());
        return savedPerson;
    }

    public Person read(String id) {
        Person person = personTable.get(id);
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
