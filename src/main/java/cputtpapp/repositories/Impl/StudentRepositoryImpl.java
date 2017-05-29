package cputtpapp.repositories.Impl;


import cputtpapp.domain.Student;
import cputtpapp.repositories.StudentRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hashcode on 2017/05/09.
 */
public class StudentRepositoryImpl implements StudentRepository{

    private static StudentRepositoryImpl respository = null;

    private Map<String,Student> studentTable;

    private StudentRepositoryImpl() {
        studentTable = new HashMap<String, Student>();
    }

    public static StudentRepositoryImpl getInstance(){
        if(respository==null)
            respository = new StudentRepositoryImpl();
        return respository;
    }

    public Student create(Student student) {
        studentTable.put(student.getId(),student);
        Student savedStudent = studentTable.get(student.getId());
        return savedStudent;
    }

    public Student read(String id) {
        Student student = studentTable.get(id);
        return student;
    }

    public Student update(Student student) {
        studentTable.put(student.getId(),student);
        Student savedStudent = studentTable.get(student.getId());
        return savedStudent;
    }

    public void delete(String id) {
        studentTable.remove(id);
    }
}
