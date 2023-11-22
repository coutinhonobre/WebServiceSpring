package br.edu.ifgoias.sistemaacademico.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfessorDTOTest {

    @Test
    void givenConstructorWithId_whenCreatingObject_thenCorrectlyInitialized() {
        // Given
        Integer id = 1;
        String nome = "Prof. Octavio";
        String titulacao = "Doutor";

        // When
        ProfessorDTO professor = new ProfessorDTO(id, nome, titulacao);

        // Then
        assertEquals(id, professor.getIdProfessor());
        assertEquals(nome, professor.getNome());
        assertEquals(titulacao, professor.getTitulacao());
    }

    @Test
    void givenConstructorWithoutId_whenCreatingObject_thenCorrectlyInitialized() {
        // Given
        String nome = "Prof. Dory";
        String titulacao = "Mestre";

        // When
        ProfessorDTO professor = new ProfessorDTO(nome, titulacao);

        // Then
        assertNull(professor.getIdProfessor());
        assertEquals(nome, professor.getNome());
        assertEquals(titulacao, professor.getTitulacao());
    }

    @Test
    void givenTwoEqualObjects_whenCheckingEquality_thenShouldBeEqual() {
        // Given
        ProfessorDTO professor1 = new ProfessorDTO(2, "Prof. Raphael", "PhD");
        ProfessorDTO professor2 = new ProfessorDTO(2, "Prof. Raphael", "PhD");

        // When
        boolean isEqual = professor1.equals(professor2);

        // Then
        assertTrue(isEqual);
    }

    @Test
    void givenTwoDifferentObjects_whenCheckingEquality_thenShouldNotBeEqual() {
        // Given
        ProfessorDTO professor1 = new ProfessorDTO(3, "Prof. Octavio", "Doutor");
        ProfessorDTO professor2 = new ProfessorDTO(4, "Prof. Dory", "Mestre");

        // When
        boolean isEqual = professor1.equals(professor2);

        // Then
        assertFalse(isEqual);
    }

    @Test
    void givenTwoEqualObjects_whenComparingHashCodes_thenShouldBeEqual() {
        // Given
        ProfessorDTO professor1 = new ProfessorDTO(5, "Prof. Raphael", "PhD");
        ProfessorDTO professor2 = new ProfessorDTO(5, "Prof. Raphael", "PhD");

        // When
        int hash1 = professor1.hashCode();
        int hash2 = professor2.hashCode();

        // Then
        assertEquals(hash1, hash2);
    }

    @Test
    void givenSameObject_whenCheckingEquality_thenShouldBeEqual() {
        // Given
        ProfessorDTO professor = new ProfessorDTO(1, "Prof. Octavio", "Doutor");

        // When
        boolean isEqual = professor.equals(professor);

        // Then
        assertTrue(isEqual);
    }

    @Test
    void givenNull_whenCheckingEquality_thenShouldNotBeEqual() {
        // Given
        ProfessorDTO professor = new ProfessorDTO(2, "Prof. Raphael", "PhD");

        // When
        boolean isEqual = professor.equals(null);

        // Then
        assertFalse(isEqual);
    }

    @Test
    void givenDifferentClassObject_whenCheckingEquality_thenShouldNotBeEqual() {
        // Given
        ProfessorDTO professor = new ProfessorDTO(3, "Prof. Raphael", "Doutor");
        Object otherObject = new Object();

        // When
        boolean isEqual = professor.equals(otherObject);

        // Then
        assertFalse(isEqual);
    }

    @Test
    void givenDifferentNameOrTitulacao_whenCheckingEquality_thenShouldNotBeEqual() {
        // Given
        ProfessorDTO professor1 = new ProfessorDTO(4, "Prof. Raphael", "Mestre");
        ProfessorDTO professor2 = new ProfessorDTO(4, "Prof. Raphael", "Doutor");
        ProfessorDTO professor3 = new ProfessorDTO(4, "Prof. Dory", "Mestre");

        // When
        boolean isEqualName = professor1.equals(professor3);
        boolean isEqualTitulacao = professor1.equals(professor2);

        // Then
        assertFalse(isEqualName);
        assertFalse(isEqualTitulacao);
    }

    @Test
    void givenDefaultConstructor_whenCreatingObject_thenFieldsShouldBeNull() {
        // When
        ProfessorDTO professor = new ProfessorDTO();

        // Then
        assertNull(professor.getIdProfessor());
        assertNull(professor.getNome());
        assertNull(professor.getTitulacao());
    }

}
