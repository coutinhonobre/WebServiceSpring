package br.edu.ifgoias.sistemaacademico.resources;

import br.edu.ifgoias.sistemaacademico.dto.AlunoDTO;
import br.edu.ifgoias.sistemaacademico.entities.Aluno;
import br.edu.ifgoias.sistemaacademico.services.AlunoService;
import br.edu.ifgoias.sistemaacademico.utils.AlunoMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@SpringBootTest
class AlunoResourceTest {

    @Mock
    AlunoService alunoService;

    @Mock
    ResponseEntity responseEntity;

    @InjectMocks
    AlunoResource alunoResource;

    @Test
    void findAll_ShouldReturnAllStudents() {
        // Given
        List<Aluno> expectedAlunos = Arrays.asList(
                new Aluno(1, "Aluno 1", "M", new Date()),
                new Aluno(2, "Aluno 2", "F", new Date())
        );
        given(alunoService.findAll()).willReturn(expectedAlunos);

        // When
        ResponseEntity<List<Aluno>> response = alunoResource.findAll();

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedAlunos, response.getBody());
    }

    @Test
    void findById_ShouldReturnStudentWhenIdExists() {
        // Given
        int validId = 10;
        Aluno expectedAluno = new Aluno(validId, "Aluno", "M", new Date());
        given(alunoService.findById(validId)).willReturn(expectedAluno);

        // When
        ResponseEntity<Aluno> actualResponse = alunoResource.findById(validId);

        // Then
        assertEquals(ResponseEntity.ok(expectedAluno), actualResponse);
    }

    @Test
    void insert_ShouldReturnInsertedStudent() {
        // Given
        AlunoDTO alunoToInsert = new AlunoDTO("New Aluno", "M", new Date());
        Aluno expectedAluno = new Aluno("New Aluno", "M", new Date());
        AlunoDTO expectedAlunoDTO = new AlunoMapper().convertEntidadeParaDTO(expectedAluno);

        given(alunoService.insert(any(Aluno.class))).willReturn(expectedAluno);

        // When
        ResponseEntity<AlunoDTO> actualResponse = alunoResource.insert(alunoToInsert);

        // Then
        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
        assertEquals(expectedAlunoDTO, actualResponse.getBody());
        verify(alunoService, times(1)).insert(any(Aluno.class));
    }

    @Test
    void update_ShouldReturnUpdatedStudentWhenIdExists() {
        // Given
        int existingId = 10;
        AlunoDTO alunoToUpdate = new AlunoDTO(existingId, "Updated Aluno", "M", new Date());
        Aluno updatedAluno = new Aluno(existingId, "Updated Aluno", "M", new Date());
        AlunoDTO updatedAlunoDTO = new AlunoMapper().convertEntidadeParaDTO(updatedAluno);

        given(alunoService.update(eq(existingId), any(Aluno.class))).willReturn(updatedAluno);

        // When
        ResponseEntity<AlunoDTO> actualResponse = alunoResource.update(existingId, alunoToUpdate);

        // Then
        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
        assertEquals(updatedAlunoDTO, actualResponse.getBody());
    }

    @Test
    void delete_ShouldCallServiceToDeleteStudentAndReturnNoContent() {
        // Given
        int validId = 10;
        doNothing().when(alunoService).delete(validId);

        // Then
        assertDoesNotThrow(() -> alunoResource.delete(validId));
        verify(alunoService, times(1)).delete(validId);
    }

}