package cputtpapp.factories;

import cputtpapp.domain.Person;

import java.util.Map;

/**
 * Created by hashcode on 2017/05/09.
 */
public class PersonFactory {

    public static Person getPerson(Map<String, String> values, int age){
        Person person = new Person.Builder()
                .age(age)
                .firstname(values.get("firstname"))
                .lastname(values.get("lastname"))
                .id(values.get("id"))
                .build();
        return person;

    }


}
