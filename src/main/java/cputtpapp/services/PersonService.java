package cputtpapp.services;

import cputtpapp.domain.Person;

/**
 * Created by hashcode on 2017/05/16.
 */
public interface PersonService {
    Person create(Person person);
    Person read(String id);
    Person update(Person person);
    void delete (String id);
}
