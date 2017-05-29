package cputtpapp.services.Impl;

import cputtpapp.domain.Student;
import cputtpapp.repositories.Impl.StudentRepositoryImpl;
import cputtpapp.repositories.StudentRepository;
import cputtpapp.services.StudentService;

/**
 * Created by hashcode on 2017/05/16.
 */
public class StudentServiceImpl implements StudentService{

    private static StudentServiceImpl service = null;

    StudentRepository repository = StudentRepositoryImpl.getInstance();

    public static StudentServiceImpl getInstance(){
        if(service == null)
            service = new StudentServiceImpl();
        return service;
    }

    public Student create(Student student) {
        return repository.create(student);
    }

    public Student read(String id) {
        return repository.read(id);
    }

    public Student update(Student student) {
        return repository.update(student);
    }

    public void delete(String id) {
        repository.delete(id);

    }
}
