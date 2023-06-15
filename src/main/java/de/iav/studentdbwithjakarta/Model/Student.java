package de.iav.studentdbwithjakarta.Model;

import jakarta.validation.constraints.NotBlank;

public record Student(
        @NotBlank(message = "StudentID can not be blank")
        String studentID,
        String name,
        String course) {
}
