package br.edu.ifgoias.sistemaacademico.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CursoDTOTest {

    @Test
    void givenConstructorWithId_whenCreatingObject_thenCorrectlyInitialized() {
        // Given
        Integer id = 1;
        String nome = "Sistemas de informação";

        // When
        CursoDTO curso = new CursoDTO(id, nome);

        // Then
        assertEquals(id, curso.getIdCurso());
        assertEquals(nome, curso.getNomecurso());
    }

    @Test
    void givenConstructorWithoutId_whenCreatingObject_thenCorrectlyInitialized() {
        // Given
        String nome = "Quimica";

        // When
        CursoDTO curso = new CursoDTO(nome);

        // Then
        assertNull(curso.getIdCurso());
        assertEquals(nome, curso.getNomecurso());
    }

    @Test
    void givenTwoEqualObjects_whenCheckingEquality_thenShouldBeEqual() {
        // Given
        CursoDTO curso1 = new CursoDTO(2, "Sistemas");
        CursoDTO curso2 = new CursoDTO(2, "Sistemas");

        // When
        boolean isEqual = curso1.equals(curso2);

        // Then
        assertTrue(isEqual);
    }

    @Test
    void givenTwoDifferentObjects_whenCheckingEquality_thenShouldNotBeEqual() {
        // Given
        CursoDTO curso1 = new CursoDTO(3, "Portugues");
        CursoDTO curso2 = new CursoDTO(4, "Geografia");

        // When
        boolean isEqual = curso1.equals(curso2);

        // Then
        assertFalse(isEqual);
    }

    @Test
    void givenTwoEqualObjects_whenComparingHashCodes_thenShouldBeEqual() {
        // Given
        CursoDTO curso1 = new CursoDTO(5, "Sistemas");
        CursoDTO curso2 = new CursoDTO(5, "Sistemas");

        // When
        int hash1 = curso1.hashCode();
        int hash2 = curso2.hashCode();

        // Then
        assertEquals(hash1, hash2);
    }

    @Test
    void givenSameObject_whenCheckingEquality_thenShouldBeEqual() {
        // Given
        CursoDTO curso = new CursoDTO(1, "Fisica");

        // When
        boolean isEqual = curso.equals(curso);

        // Then
        assertTrue(isEqual);
    }

    @Test
    void givenNull_whenCheckingEquality_thenShouldNotBeEqual() {
        // Given
        CursoDTO curso = new CursoDTO(2, "Engenharia");

        // When
        boolean isEqual = curso.equals(null);

        // Then
        assertFalse(isEqual);
    }

    @Test
    void givenDifferentClassObject_whenCheckingEquality_thenShouldNotBeEqual() {
        // Given
        CursoDTO curso = new CursoDTO(3, "Sistemas");
        Object otherObject = new Object();

        // When
        boolean isEqual = curso.equals(otherObject);

        // Then
        assertFalse(isEqual);
    }

    @Test
    void givenDifferentNameOrTitulacao_whenCheckingEquality_thenShouldNotBeEqual() {
        // Given
        CursoDTO curso1 = new CursoDTO(4, "Sistemas");
        CursoDTO curso3 = new CursoDTO(4, "Quimica");

        // When
        boolean isEqualName = curso1.equals(curso3);

        // Then
        assertFalse(isEqualName);
    }

    @Test
    void givenDefaultConstructor_whenCreatingObject_thenFieldsShouldBeNull() {
        // When
        CursoDTO curso = new CursoDTO();

        // Then
        assertNull(curso.getIdCurso());
        assertNull(curso.getNomecurso());
    }

}
