package Service;

import Model.Student;
import Repository.StudentRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService() {
    }

    @Inject

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents(){
        return studentRepository.getAllStudents();
        }

    public Student getStudentbyID(String id){
        return studentRepository.getStudentbyID(id);
    }

    public Student addStudent(Student student){
        return studentRepository.addStudent(student);
    }

    public void deleteSTudent(Student student){
        studentRepository.deleteStudent(student);
    }

    public Student updateStudent(String id, Student student){
        return studentRepository.updateStudent(id,student);
    }
}