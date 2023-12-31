package de.iav.studentdbwithjakarta.Repository;

import de.iav.studentdbwithjakarta.Model.Student;
import de.iav.studentdbwithjakarta.Exception.StudentNotFoundException;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class StudentRepository {

    private final Map<String, Student> studentMap = new LinkedHashMap<>();

    public List<Student> getAllStudents(){
        return List.copyOf(studentMap.values());
    }

    public StudentRepository() {
    }



    public Student addStudent(Student student){
        studentMap.put(student.studentID(),student);
        return getStudentbyID(student.studentID());
    }

    public Student getStudentbyID(String id){
        return studentMap.get(id);
    }

    public void deleteStudent(String id){
        studentMap.remove(id);
    }

    public Student updateStudent(String id, Student student){
        if(!studentMap.containsKey(id)){
            throw new StudentNotFoundException(id);
        }
        studentMap.remove(id);
        studentMap.put(id, student);
        return getStudentbyID(id);
    }


}
