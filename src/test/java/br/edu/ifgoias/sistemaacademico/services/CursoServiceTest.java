package br.edu.ifgoias.sistemaacademico.services;

import br.edu.ifgoias.sistemaacademico.entities.Curso;
import br.edu.ifgoias.sistemaacademico.repository.CursoRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class CursoServiceTest {

    @Mock
    private CursoRepository repository;

    @InjectMocks
    private CursoService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void whenFindAll_thenReturnsList() {
        // Given
        List<Curso> expectedCursos = Arrays.asList(new Curso("Gastronomia"), new Curso("Engenharia"));
        when(repository.findAll()).thenReturn(expectedCursos);

        // When
        List<Curso> actualCursos = service.findAll();

        // Then
        assertEquals(expectedCursos, actualCursos);
    }

    @Test
    void whenFindById_thenReturnsCurso() {
        // Given
        Curso expectedCurso = new Curso("Sistemas");
        Integer id = 1;
        when(repository.findById(id)).thenReturn(of(expectedCurso));

        // When
        Curso actualCurso = service.findById(id);

        // Then
        assertEquals(expectedCurso, actualCurso);
    }

    @Test
    void whenFindById_NotFound_thenThrowsException() {
        // Given
        Integer id = 1;
        when(repository.findById(id)).thenReturn(Optional.empty());

        // When
        assertThrows(ResponseStatusException.class, () -> service.findById(id));
    }

    @Test
    void whenInsert_thenReturnsCurso() {
        // Given
        Curso newCurso = new Curso("Design");
        when(repository.save(newCurso)).thenReturn(newCurso);

        // When
        Curso savedCurso = service.insert(newCurso);

        // Then
        assertEquals(newCurso, savedCurso);
    }

    @Test
    void whenUpdate_ExistingId_thenReturnsUpdatedCurso() {
        // Given
        Integer id = 1;
        Curso existingCurso = new Curso("Quimica");
        existingCurso.setIdCurso(id);
        Curso updatedInfo = new Curso("Sistemas");
        updatedInfo.setNomecurso("Updated Name");
        

        when(repository.findById(id)).thenReturn(of(existingCurso));
        when(repository.save(existingCurso)).thenReturn(existingCurso);

        // When
        Curso updatedCurso = service.update(id, updatedInfo);

        // Then
        assertEquals(updatedInfo.getNomecurso(), updatedCurso.getNomecurso());
    }

    @Test
    void whenUpdate_NonExistingId_thenThrowsException() {
        // Given
        Integer id = 1;
        Curso updatedInfo = new Curso("Exercito");
        when(repository.findById(id)).thenReturn(Optional.empty());

        // When
        assertThrows(ResponseStatusException.class, () -> service.update(id, updatedInfo));
    }

    @Test
    void whenDelete_ExistingId_thenPerformsDeletion() {
        // Given
        Integer id = 1;
        Curso existingCurso = new Curso("Comandos");
        existingCurso.setIdCurso(id);
        when(repository.findById(id)).thenReturn(of(existingCurso));
        doNothing().when(repository).delete(existingCurso);

        // When
        service.delete(id);

        // Then
        verify(repository, times(1)).delete(existingCurso);
    }

    @Test
    void whenDelete_NonExistingId_thenThrowsException() {
        // Given
        Integer id = 1;
        when(repository.findById(id)).thenReturn(Optional.empty());

        // When
        assertThrows(ResponseStatusException.class, () -> service.delete(id));
    }
}
