package com.aralbayev.studentapi;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
class StudentControllerTest {
    @Test void missingStudentReturns404() {
        StudentRepository repo = mock(StudentRepository.class);
        when(repo.findById(999L)).thenReturn(Optional.empty());
        ResponseStatusException ex = assertThrows(ResponseStatusException.class, () -> new StudentController(repo).one(999L));
        assertEquals(HttpStatus.NOT_FOUND, ex.getStatusCode());
    }
}
