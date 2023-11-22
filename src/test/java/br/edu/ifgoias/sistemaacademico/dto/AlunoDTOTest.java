package br.edu.ifgoias.sistemaacademico.dto;

import org.junit.jupiter.api.Test;

import br.edu.ifgoias.sistemaacademico.entities.Aluno;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

class AlunoDTOTest {

    @Test
    void givenConstructorWithId_whenCreatingObject_thenCorrectlyInitialized() {
        // Given
        Integer id = 1;
        String nome = "Aluno 1";
        String sexo = "M";
        Date dtNasc = new Date();
        // When
        AlunoDTO aluno = new AlunoDTO(id, nome,sexo,dtNasc);

        // Then
        assertEquals(id, aluno.getIdaluno());
        assertEquals(nome, aluno.getNome());
        assertEquals(sexo, aluno.getSexo());
        assertEquals(dtNasc, aluno.getDtNasc());

    }

    @Test
    void givenConstructorWithoutId_whenCreatingObject_thenCorrectlyInitialized() {
        // Given
         String nome = "Aluno 1";
         String sexo = "M";
         Date dtNasc = new Date();

        // When
        AlunoDTO aluno = new AlunoDTO(nome,sexo,dtNasc);

        // Then
        assertNull(aluno.getIdaluno());
        assertEquals(nome, aluno.getNome());
        assertEquals(sexo, aluno.getSexo());
        assertEquals(dtNasc, aluno.getDtNasc());
    }

    @Test
    void givenTwoEqualObjects_whenCheckingEquality_thenShouldBeEqual() {
        // Given
    	Integer id = 1;
        String nome = "Aluno 1";
        String sexo = "M";
        Date dtNasc = new Date();
        
        AlunoDTO aluno1 = new AlunoDTO(id, nome,sexo,dtNasc);
        AlunoDTO aluno2 = new AlunoDTO(id, nome,sexo,dtNasc);

        // When
        boolean isEqual = aluno1.equals(aluno2);

        // Then
        assertTrue(isEqual);
    }

    @Test
    void givenTwoDifferentObjects_whenCheckingEquality_thenShouldNotBeEqual() {
        // Given
    	Integer id = 1;
        String nome = "Aluno 1";
        String sexo = "M";
        Date dtNasc = new Date();
        
    	Integer idSeg = 2;
        String nomeSeg = "Aluno 2";
        String sexoSeg = "F";
        Date dtNascSeg = new Date();
        
        AlunoDTO aluno1 = new AlunoDTO(id, nome,sexo,dtNasc);
        AlunoDTO aluno2 = new AlunoDTO(idSeg, nomeSeg,sexoSeg,dtNascSeg);

        // When
        boolean isEqual = aluno1.equals(aluno2);

        // Then
        assertFalse(isEqual);
    }

    @Test
    void givenTwoEqualObjects_whenComparingHashCodes_thenShouldBeEqual() {
        // Given
    	   // Given
    	Integer id = 1;
        String nome = "Aluno 1";
        String sexo = "M";
        Date dtNasc = new Date();
        
        AlunoDTO aluno1 = new AlunoDTO(id, nome,sexo,dtNasc);
        AlunoDTO aluno2 = new AlunoDTO(id, nome,sexo,dtNasc);

        // When
        int hash1 = aluno1.hashCode();
        int hash2 = aluno2.hashCode();

        // Then
        assertEquals(hash1, hash2);
    }

    @Test
    void givenSameObject_whenCheckingEquality_thenShouldBeEqual() {
        // Given
    	Integer id = 1;
        String nome = "Aluno 1";
        String sexo = "M";
        Date dtNasc = new Date();
        
        AlunoDTO aluno = new AlunoDTO(id, nome,sexo,dtNasc);

        // When
        boolean isEqual = aluno.equals(aluno);

        // Then
        assertTrue(isEqual);
    }

    @Test
    void givenNull_whenCheckingEquality_thenShouldNotBeEqual() {
        // Given
    	Integer id = 1;
        String nome = "Aluno 1";
        String sexo = "M";
        Date dtNasc = new Date();
        
        AlunoDTO aluno = new AlunoDTO(id, nome,sexo,dtNasc);

        // When
        boolean isEqual = aluno.equals(null);

        // Then
        assertFalse(isEqual);
    }

    @Test
    void givenDifferentClassObject_whenCheckingEquality_thenShouldNotBeEqual() {
        // Given
    	Integer id = 1;
        String nome = "Aluno 1";
        String sexo = "M";
        Date dtNasc = new Date();
        
        AlunoDTO aluno = new AlunoDTO(id, nome,sexo,dtNasc);
        Object otherObject = new Object();

        // When
        boolean isEqual = aluno.equals(otherObject);

        // Then
        assertFalse(isEqual);
    }

    @Test
    void givenDifferentNameOrTitulacao_whenCheckingEquality_thenShouldNotBeEqual() {
        // Given
     	Integer id = 1;
        String nome = "Aluno 1";
        String sexo = "M";
        Date dtNasc = new Date();
        
    	Integer idSeg = 2;
        String nomeSeg = "Aluno 2";
        String sexoSeg = "F";
        Date dtNascSeg = new Date();
        
        AlunoDTO aluno1 = new AlunoDTO(id, nome,sexo,dtNasc);
        AlunoDTO aluno2 = new AlunoDTO(idSeg, nomeSeg,sexoSeg,dtNascSeg);

        // When
        boolean isEqualName = aluno1.equals(aluno2);

        // Then
        assertFalse(isEqualName);
    }

    @Test
    void givenDefaultConstructor_whenCreatingObject_thenFieldsShouldBeNull() {
        // When
        AlunoDTO aluno = new AlunoDTO();

        // Then
        assertNull(aluno.getIdaluno());
        assertNull(aluno.getNome());
    }

}
