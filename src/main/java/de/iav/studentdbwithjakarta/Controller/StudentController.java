package de.iav.studentdbwithjakarta.Controller;

import de.iav.studentdbwithjakarta.Model.Student;
import de.iav.studentdbwithjakarta.Service.StudentService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path(("/students"))
public class StudentController {
    private final StudentService studentService;
    @Inject

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student getStudentByID(@PathParam("id") String id){
        return studentService.getStudentbyID(id);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Student updateStudent(@PathParam("id") String id, @Valid Student updatedStudent) {
        return studentService.updateStudent(id, updatedStudent);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteStudent(@PathParam("id") String id) {
        studentService.deleteStudent(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Student addStudent(@Valid Student student){
        return studentService.addStudent(student);
    }
}
