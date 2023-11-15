package br.edu.ifgoias.sistemaacademico.resources;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.test.context.ActiveProfiles;

import br.edu.ifgoias.sistemaacademico.dto.CursoDTO;
import br.edu.ifgoias.sistemaacademico.entities.Curso;
import br.edu.ifgoias.sistemaacademico.services.CursoService;
import br.edu.ifgoias.sistemaacademico.utils.CursoMapper;
@ActiveProfiles("test")
@SpringBootTest
public class CursoResourceTest {

	@Mock
	CursoService cursoService;
	
	@Mock
    ResponseEntity responseEntity;
	
	@InjectMocks
	CursoResource cursoResource;
	
	@Test
	void findAll_ShouldReturnAllCourses() {
	    // Given
        List<Curso> expectedCursos = Arrays.asList(
                new Curso(1, "Curso 1" ),
                new Curso(2, "Curso 2")
        );
        given(cursoService.findAll()).willReturn(expectedCursos);

        // When
        ResponseEntity<List<Curso>> response = cursoResource.findAll();

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedCursos, response.getBody());
	}
	
    @Test
    void findById_ShouldReturnCourseWhenIdExists() {
        // Given
        int validId = 10;
        Curso expectedCurso = new Curso(validId, "Curso 1" );
        given(cursoService.findById(validId)).willReturn(expectedCurso);

        // When
        ResponseEntity< Curso> actualResponse = cursoResource.findById(validId);

        // Then
        assertEquals(ResponseEntity.ok(expectedCurso), actualResponse);
    }
    @Test
    void insert_ShouldReturnInsertedCourse() {
        // Given
    	CursoDTO CursoToInsert = new CursoDTO("Curso");
        Curso expectedCurso = new Curso("Curso");
        CursoDTO expectedCursoDTO = new CursoMapper().convertEntidadeParaDTO(expectedCurso);

        given(cursoService.insert(any(Curso.class))).willReturn(expectedCurso);

        // When
        ResponseEntity<CursoDTO> actualResponse = cursoResource.insert(CursoToInsert);
        System.out.println(actualResponse.getBody().getNomecurso());
        // Then
        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
        assertEquals(expectedCursoDTO, actualResponse.getBody());
        verify(cursoService, times(1)).insert(any(Curso.class));
    }

    @Test
    void update_ShouldReturnUpdatedStudentWhenIdExists() {
        // Given
        int existingId = 10;
        CursoDTO CursoToUpdate = new CursoDTO(existingId, "Updated Curso");
        Curso updatedCurso = new Curso(existingId, "Updated Curso");
        CursoDTO updatedCursoDTO = new CursoMapper().convertEntidadeParaDTO(updatedCurso);

        given(cursoService.update(eq(existingId), any(Curso.class))).willReturn(updatedCurso);

        // When
        ResponseEntity<CursoDTO> actualResponse = cursoResource.update(existingId, CursoToUpdate);

        // Then
        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
        assertEquals(updatedCursoDTO, actualResponse.getBody());
    }

    @Test
    void delete_ShouldCallServiceToDeleteStudentAndReturnNoContent() {
        // Given
        int validId = 10;
        doNothing().when(cursoService).delete(validId);

        // Then
        assertDoesNotThrow(() -> cursoResource.delete(validId));
        verify(cursoService, times(1)).delete(validId);
    }
}
