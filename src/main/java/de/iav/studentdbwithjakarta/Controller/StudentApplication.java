package de.iav.studentdbwithjakarta.Controller;

import de.iav.studentdbwithjakarta.Exception.ConstraintViolationExceptionMapper;
import de.iav.studentdbwithjakarta.Exception.StudentNotFoundExceptionMapper;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class StudentApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();

        classes.add(StudentController.class);
        classes.add(StudentNotFoundExceptionMapper.class);
        classes.add(ConstraintViolationExceptionMapper.class);

        return classes;
    }
}
