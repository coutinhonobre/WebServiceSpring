package br.edu.ifgoias.sistemaacademico.entities;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CursoTest {

    @Test
    void testConstructorDefault() {
        // Given
        Curso curso = new Curso();

        // Then
        assertNull(curso.getIdCurso());
        assertNull(curso.getNomecurso());
        assertTrue(curso.getAlunos().isEmpty());
    }

    @Test
    void testConstructorWithParameters() {
        // Given
        Integer idCurso = 1;
        String nomecurso = "Curso 1";

        // When
        Curso curso = new Curso(idCurso, nomecurso);

        // Then
        assertEquals(idCurso, curso.getIdCurso());
        assertEquals(nomecurso, curso.getNomecurso());
        assertTrue(curso.getAlunos().isEmpty());
    }

    @Test
    void testSettersAndGetters() {
        // Given
        Curso curso = new Curso();
        curso.setIdCurso(2);
        curso.setNomecurso("Curso 2");

        // Then
        assertEquals(2, curso.getIdCurso());
        assertEquals("Curso 2", curso.getNomecurso());
    }

    @Test
    void testRemoveAluno_RemovesAlunoFromCursoAndCursoFromAluno() {
        // Given
        Curso curso = new Curso(1, "Curso Teste");
        Aluno aluno = new Aluno("Igor", "M", new Date());
        curso.adicionarAluno(aluno);

        // When
        curso.removeAluno(aluno);

        // Then
        assertFalse(curso.getAlunos().contains(aluno));
        assertFalse(aluno.getCursos().contains(curso));
    }

    @Test
    void testHashCode_WithSameData_GeneratesSameHashCode() {
        // Given
        Integer idCurso = 1;
        String nomeCurso = "Curso Teste";
        Curso curso1 = new Curso(idCurso, nomeCurso);
        Curso curso2 = new Curso(idCurso, nomeCurso);

        // When
        int hashCode1 = curso1.hashCode();
        int hashCode2 = curso2.hashCode();

        // Then
        assertEquals(hashCode1, hashCode2, "Cursos com os mesmos dados devem ter o mesmo hashCode");
    }

    @Test
    void testHashCode_WithDifferentData_GeneratesDifferentHashCode() {
        // Given
        Curso curso1 = new Curso(1, "Curso Teste 1");
        Curso curso2 = new Curso(2, "Curso Teste 2");

        // When
        int hashCode1 = curso1.hashCode();
        int hashCode2 = curso2.hashCode();

        // Then
        assertNotEquals(hashCode1, hashCode2, "Cursos com dados diferentes devem ter hashCodes diferentes");
    }

    @Test
    void testHashCode_WithNullIdCurso_GeneratesConsistentHashCode() {
        // Given
        Curso curso = new Curso(null, "Curso Teste");

        // When
        int hashCode1 = curso.hashCode();
        int hashCode2 = curso.hashCode();

        // Then
        assertEquals(hashCode1, hashCode2, "HashCode deve ser consistente mesmo com idCurso null");
    }

    @Test
    void testHashCode_WithNullNomecurso_GeneratesConsistentHashCode() {
        // Given
        Curso curso = new Curso(1, null);

        // When
        int hashCode1 = curso.hashCode();
        int hashCode2 = curso.hashCode();

        // Then
        assertEquals(hashCode1, hashCode2, "HashCode deve ser consistente mesmo com nomecurso null");
    }

    @Test
    void testHashCode_WithBothNullFields_GeneratesConsistentHashCode() {
        // Given
        Curso curso = new Curso(null, null);

        // When
        int hashCode1 = curso.hashCode();
        int hashCode2 = curso.hashCode();

        // Then
        assertEquals(hashCode1, hashCode2, "HashCode deve ser consistente mesmo com ambos os campos null");
    }

    @Test
    void testEquals_SameObject_ReturnsTrue() {
        // Given
        Curso curso = new Curso(1, "Curso Teste");

        // Then
        assertEquals(curso, curso, "Um objeto deve ser igual a si mesmo.");
    }

    @Test
    void testEquals_DifferentClass_ReturnsFalse() {
        // Given
        Curso curso = new Curso(1, "Curso Teste");
        Object obj = new Object();

        // Then
        assertNotEquals(curso, obj, "Objetos de classes diferentes não devem ser iguais.");
    }

    @Test
    void testEquals_DifferentIdCurso_ReturnsFalse() {
        // Given
        Curso curso1 = new Curso(1, "Curso Teste");
        Curso curso2 = new Curso(2, "Curso Teste");

        // Then
        assertNotEquals(curso1, curso2, "Objetos com idCurso diferentes não devem ser iguais.");
    }

    @Test
    void testEquals_DifferentNomecurso_ReturnsFalse() {
        // Given
        Curso curso1 = new Curso(1, "Curso Teste 1");
        Curso curso2 = new Curso(1, "Curso Teste 2");

        // Then
        assertNotEquals(curso1, curso2, "Objetos com nomecurso diferentes não devem ser iguais.");
    }

    @Test
    void testEquals_NullIdCursoInOneObject_ReturnsFalse() {
        // Given
        Curso curso1 = new Curso(null, "Curso Teste");
        Curso curso2 = new Curso(1, "Curso Teste");

        // Then
        assertNotEquals(curso1, curso2, "Objetos com um idCurso null e outro não, não devem ser iguais.");
    }

    @Test
    void testEquals_NullNomecursoInOneObject_ReturnsFalse() {
        // Given
        Curso curso1 = new Curso(1, null);
        Curso curso2 = new Curso(1, "Curso Teste");

        // Then
        assertNotEquals(curso1, curso2, "Objetos com um nomecurso null e outro não, não devem ser iguais.");
    }

    @Test
    void testEquals_BothNullFields_ReturnsTrue() {
        // Given
        Curso curso1 = new Curso(null, null);
        Curso curso2 = new Curso(null, null);

        // Then
        assertEquals(curso1, curso2, "Dois objetos com campos null devem ser iguais.");
    }

    @Test
    void testEquals_SameFields_ReturnsTrue() {
        // Given
        Curso curso1 = new Curso(1, "Curso Teste");
        Curso curso2 = new Curso(1, "Curso Teste");

        // Then
        assertEquals(curso1, curso2, "Dois objetos com os mesmos campos devem ser iguais.");
    }

    @Test
    void testToString_ReturnsCorrectFormat() {
        // Given
        Integer id = 1;
        String nome = "Aluno 1";
        String sexo = "M";
        Date dtNasc = new Date();
        Curso curso = new Curso(1, "Curso Teste");
        Aluno aluno = new Aluno(id, nome, sexo, dtNasc);
        curso.adicionarAluno(aluno);

        String expected = "Curso [idcurso=1, nomecurso=Curso Teste, alunos=[" + aluno.toString() + "]]";

        // When
        String actual = curso.toString();

        // Then
        assertEquals(expected, actual, "O método toString deve retornar a string no formato esperado.");
    }

    @Test
    void testEquals_NullObject_ReturnsFalse() {
        // Given
        Curso curso = new Curso(1, "Curso Teste");

        // When
        boolean isEqual = curso.equals(null);

        // Then
        assertFalse(isEqual, "Comparação de um objeto Curso com null deve retornar false.");
    }

    @Test
    void testSetAlunos_SetsNewListOfAlunos() {
        // Given
        Curso curso = new Curso();
        Aluno aluno1 = new Aluno(1, "Aluno 1", "F", new Date());
        Aluno aluno2 = new Aluno(2, "Aluno 2", "M", new Date());
        List<Aluno> novaLista = Arrays.asList(aluno1, aluno2);

        // When
        curso.setAlunos(novaLista);

        // Then
        assertEquals(novaLista, curso.getAlunos(), "setAlunos deve definir a nova lista de alunos.");
    }

    @Test
    void testSetAlunos_DoesNotReflectChangesInOriginalList() {
        // Given
        Curso curso = new Curso();
        Aluno aluno1 = new Aluno(1, "Aluno 1", "F", new Date());
        Aluno aluno2 = new Aluno(2, "Aluno 2", "M", new Date());
        List<Aluno> originalList = Arrays.asList(aluno1, aluno2);
        curso.setAlunos(originalList);

        // When
        Aluno aluno3 = new Aluno(3, "Aluno 3", "F", new Date());

        // Then
        assertFalse(curso.getAlunos().contains(aluno3), "Alterações na lista original não devem afetar a lista de alunos do curso.");
    }
}
