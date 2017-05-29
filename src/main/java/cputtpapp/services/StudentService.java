package cputtpapp.services;


import cputtpapp.domain.Student;

/**
 * Created by hashcode on 2017/05/16.
 */
public interface StudentService {
    Student create(Student student);
    Student read(String id);
    Student update(Student student);
    void delete(String id);
}
