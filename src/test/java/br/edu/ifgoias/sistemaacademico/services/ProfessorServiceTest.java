package br.edu.ifgoias.sistemaacademico.services;

import br.edu.ifgoias.sistemaacademico.entities.Professor;
import br.edu.ifgoias.sistemaacademico.repository.ProfessorRepository;
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

class ProfessorServiceTest {

    @Mock
    private ProfessorRepository repository;

    @InjectMocks
    private ProfessorService service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenFindAll_thenReturnsList() {
        // Given
        List<Professor> expectedProfessors = Arrays.asList(new Professor(), new Professor());
        when(repository.findAll()).thenReturn(expectedProfessors);

        // When
        List<Professor> actualProfessors = service.findAll();

        // Then
        assertEquals(expectedProfessors, actualProfessors);
    }

    @Test
    public void whenFindById_thenReturnsProfessor() {
        // Given
        Professor expectedProfessor = new Professor();
        Integer id = 1;
        when(repository.findById(id)).thenReturn(of(expectedProfessor));

        // When
        Professor actualProfessor = service.findById(id);

        // Then
        assertEquals(expectedProfessor, actualProfessor);
    }

    @Test
    public void whenFindById_NotFound_thenThrowsException() {
        // Given
        Integer id = 1;
        when(repository.findById(id)).thenReturn(Optional.empty());

        // When
        assertThrows(ResponseStatusException.class, () -> service.findById(id));
    }

    @Test
    public void whenInsert_thenReturnsProfessor() {
        // Given
        Professor newProfessor = new Professor();
        when(repository.save(newProfessor)).thenReturn(newProfessor);

        // When
        Professor savedProfessor = service.insert(newProfessor);

        // Then
        assertEquals(newProfessor, savedProfessor);
    }

    @Test
    public void whenUpdate_ExistingId_thenReturnsUpdatedProfessor() {
        // Given
        Integer id = 1;
        Professor existingProfessor = new Professor();
        existingProfessor.setIdProfessor(id);
        Professor updatedInfo = new Professor();
        updatedInfo.setNome("Updated Name");
        updatedInfo.setTitulacao("Updated Titulacao");

        when(repository.findById(id)).thenReturn(of(existingProfessor));
        when(repository.save(existingProfessor)).thenReturn(existingProfessor);

        // When
        Professor updatedProfessor = service.update(id, updatedInfo);

        // Then
        assertEquals(updatedInfo.getNome(), updatedProfessor.getNome());
        assertEquals(updatedInfo.getTitulacao(), updatedProfessor.getTitulacao());
    }

    @Test
    public void whenUpdate_NonExistingId_thenThrowsException() {
        // Given
        Integer id = 1;
        Professor updatedInfo = new Professor();
        when(repository.findById(id)).thenReturn(Optional.empty());

        // When
        assertThrows(ResponseStatusException.class, () -> service.update(id, updatedInfo));
    }

    @Test
    public void whenDelete_ExistingId_thenPerformsDeletion() {
        // Given
        Integer id = 1;
        Professor existingProfessor = new Professor();
        existingProfessor.setIdProfessor(id);
        when(repository.findById(id)).thenReturn(of(existingProfessor));
        doNothing().when(repository).delete(existingProfessor);

        // When
        service.delete(id);

        // Then
        verify(repository, times(1)).delete(existingProfessor);
    }

    @Test
    public void whenDelete_NonExistingId_thenThrowsException() {
        // Given
        Integer id = 1;
        when(repository.findById(id)).thenReturn(Optional.empty());

        // When
        assertThrows(ResponseStatusException.class, () -> service.delete(id));
    }
}
