package cputtpapp.repositories;


import cputtpapp.domain.Student;

/**
 * Created by hashcode on 2017/05/09.
 */
public interface StudentRepository {
    Student create(Student student);

    Student read(String id);

    Student update(Student student);

    void delete(String id);
}
