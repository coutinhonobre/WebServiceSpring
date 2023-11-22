package br.edu.ifgoias.sistemaacademico.services;

import br.edu.ifgoias.sistemaacademico.entities.Aluno;
import br.edu.ifgoias.sistemaacademico.repository.AlunoRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class AlunoServiceTest {

    @Mock
    private AlunoRepository repository;

    @InjectMocks
    private AlunoService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void whenFindAll_thenReturnsList() {
        // Given
        List<Aluno> expectedAlunos = Arrays.asList(new Aluno(), new Aluno());
        when(repository.findAll()).thenReturn(expectedAlunos);

        // When
        List<Aluno> actualAlunos = service.findAll();

        // Then
        assertEquals(expectedAlunos, actualAlunos);
    }

    @Test
    void whenFindById_thenReturnsAluno() {
        // Given
     	Integer id = 1;
        String nome = "Aluno 1";
        String sexo = "M";
        Date dtNasc = new Date();
        Aluno expectedAluno = new Aluno(id,nome,sexo,dtNasc);
        when(repository.findById(id)).thenReturn(of(expectedAluno));

        // When
        Aluno actualAluno = service.findById(id);

        // Then
        assertEquals(expectedAluno, actualAluno);
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
    void whenInsert_thenReturnsAluno() {
        // Given
        Aluno newAluno = new Aluno();
        when(repository.save(newAluno)).thenReturn(newAluno);

        // When
        Aluno savedAluno = service.insert(newAluno);

        // Then
        assertEquals(newAluno, savedAluno);
    }

    @Test
    void whenUpdate_ExistingId_thenReturnsUpdatedAluno() {
        // Given
        Integer id = 1;
        Aluno existingAluno = new Aluno();
        existingAluno.setIdaluno(id);
        Aluno updatedInfo = new Aluno();
        String nome = "Aluno 1";
        Date dtNasc = new Date();
        updatedInfo.setNome(nome);
        updatedInfo.setIdaluno(id);
        updatedInfo.setDtNasc(dtNasc);
        updatedInfo.setSexo("M");
        
        when(repository.findById(id)).thenReturn(of(existingAluno));
        when(repository.save(existingAluno)).thenReturn(existingAluno);

        // When
        Aluno updatedAluno = service.update(id, updatedInfo);

        System.out.println(updatedAluno.toString());
        // Then
        assertEquals(nome, updatedAluno.getNome());
        assertEquals("M", updatedAluno.getSexo());
        assertEquals(dtNasc, updatedAluno.getDtNasc());
    }

    @Test
    void whenUpdate_NonExistingId_thenThrowsException() {
        // Given
        Integer id = 1;
        Aluno updatedInfo = new Aluno();
        when(repository.findById(id)).thenReturn(Optional.empty());

        // When
        assertThrows(ResponseStatusException.class, () -> service.update(id, updatedInfo));
    }

    @Test
    void whenDelete_ExistingId_thenPerformsDeletion() {
        // Given
        Integer id = 1;
        Aluno existingAluno = new Aluno();
        existingAluno.setIdaluno(id);
        when(repository.findById(id)).thenReturn(of(existingAluno));
        doNothing().when(repository).delete(existingAluno);

        // When
        service.delete(id);

        // Then
        verify(repository, times(1)).delete(existingAluno);
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
