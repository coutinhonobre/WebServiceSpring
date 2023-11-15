package br.edu.ifgoias.sistemaacademico.resources;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import br.edu.ifgoias.sistemaacademico.dto.ProfessorDTO;
import br.edu.ifgoias.sistemaacademico.entities.Professor;
import br.edu.ifgoias.sistemaacademico.services.ProfessorService;
import br.edu.ifgoias.sistemaacademico.utils.ProfessorMapper;

@ActiveProfiles("test")
@SpringBootTest
class ProfessorResourceTest {

    @Mock
    ProfessorService professorService;

    @Mock
    ResponseEntity responseEntity;

    @InjectMocks
    ProfessorResource professorResource;

    @Test
    void findAll_ShouldReturnAllStudents() {
        // Given
        List<Professor> expectedProfessors = Arrays.asList(
                new Professor(1, "Professor 1", "MESTE"),
                new Professor(2, "Professor 2","ESTE")
        );
        given(professorService.findAll()).willReturn(expectedProfessors);

        // When
        ResponseEntity<List<Professor>> response = professorResource.findAll();

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedProfessors, response.getBody());
    }

    @Test
    void findById_ShouldReturnStudentWhenIdExists() {
        // Given
        int validId = 10;
        Professor expectedProfessor = new Professor(validId, "Professor", "MESTRE" );
        given(professorService.findById(validId)).willReturn(expectedProfessor);

        // When
        ResponseEntity<Professor> actualResponse = professorResource.findById(validId);

        // Then
        assertEquals(ResponseEntity.ok(expectedProfessor), actualResponse);
    }

    @Test
    void insert_ShouldReturnInsertedStudent() {
        // Given
        ProfessorDTO ProfessorToInsert = new ProfessorDTO(1,"New Professor", "M");
        Professor expectedProfessor = new Professor(1,"New Professor", "M");
        ProfessorDTO expectedProfessorDTO = new ProfessorMapper().convertEntidadeParaDTO(expectedProfessor);

        given(professorService.insert(any(Professor.class))).willReturn(expectedProfessor);

        // When
        ResponseEntity<ProfessorDTO> actualResponse = professorResource.insert(ProfessorToInsert);

        // Then
        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
        assertEquals(expectedProfessorDTO, actualResponse.getBody());
        verify(professorService, times(1)).insert(any(Professor.class));
    }

    @Test
    void update_ShouldReturnUpdatedStudentWhenIdExists() {
        // Given
        int existingId = 10;
        ProfessorDTO ProfessorToUpdate = new ProfessorDTO(existingId, "Updated Professor", "M");
        Professor updatedProfessor = new Professor(existingId, "Updated Professor", "M");
        ProfessorDTO updatedProfessorDTO = new ProfessorMapper().convertEntidadeParaDTO(updatedProfessor);

        given(professorService.update(eq(existingId), any(Professor.class))).willReturn(updatedProfessor);

        // When
        ResponseEntity<ProfessorDTO> actualResponse = professorResource.update(existingId, ProfessorToUpdate);

        // Then
        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
        assertEquals(updatedProfessorDTO, actualResponse.getBody());
    }

    @Test
    void delete_ShouldCallServiceToDeleteStudentAndReturnNoContent() {
        // Given
        int validId = 10;
        doNothing().when(professorService).delete(validId);

        // Then
        assertDoesNotThrow(() -> professorResource.delete(validId));
        verify(professorService, times(1)).delete(validId);
    }

}
