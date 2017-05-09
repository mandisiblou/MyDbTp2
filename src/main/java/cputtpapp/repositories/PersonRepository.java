package cputtpapp.repositories;

import cputtpapp.domain.Person;

/**
 * Created by hashcode on 2017/05/09.
 */
public interface PersonRepository {
    Person create(Person person);
    Person read(String id);
    Person update(Person person);
    void   delete(String id);
}
