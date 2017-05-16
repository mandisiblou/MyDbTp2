package cputtpapp.services.Impl;

import cputtpapp.domain.Person;
import cputtpapp.repositories.Impl.PersonRepositoryImpl;
import cputtpapp.repositories.PersonRepository;
import cputtpapp.services.PersonService;

/**
 * Created by hashcode on 2017/05/16.
 */
public class PersonServiceImpl implements PersonService{

    PersonRepository repository = PersonRepositoryImpl.getInstance();
    public Person create(Person person) {
        return repository.create(person);
    }

    public Person read(String id) {
        return repository.read(id);
    }

    public Person update(Person person) {
        return repository.update(person);
    }

    public void delete(String id) {
        repository.delete(id);

    }
}
