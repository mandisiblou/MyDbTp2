package cputtpapp.factories;

import cputtpapp.domain.Student;

import java.util.Map;

/**
 * Created by hashcode on 2017/05/09.
 */
public class StudentFactory {

    public static Student getStudent(Map<String, String> values, int age){
        Student student = new Student.Builder()
                .age(age)
                .firstname(values.get("firstname"))
                .lastname(values.get("lastname"))
                .id(values.get("id"))
                .build();
        return student;

    }


}
