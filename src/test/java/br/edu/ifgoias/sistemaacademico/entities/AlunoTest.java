package br.edu.ifgoias.sistemaacademico.entities;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;


class AlunoTest {

    private static final Logger LOGGER = mock(Logger.class);

    @Test
    void givenDefaultConstructor_whenCreatingObject_thenCorrectlyInitialized() {
        // Given
        Aluno aluno = new Aluno();

        // Then
        assertNull(aluno.getIdaluno());
        assertNull(aluno.getNome());
        assertNull(aluno.getSexo());
        assertNull(aluno.getDtNasc());
        assertTrue(aluno.getCursos().isEmpty());
    }

    @Test
    void givenConstructorWithAllParameters_whenCreatingObject_thenCorrectlyInitialized() {
        // Given
        Integer id = 1;
        String nome = "Aluno 1";
        String sexo = "M";
        Date dtNasc = new Date();

        // When
        Aluno aluno = new Aluno(id, nome, sexo, dtNasc);

        // Then
        assertEquals(id, aluno.getIdaluno());
        assertEquals(nome, aluno.getNome());
        assertEquals(sexo, aluno.getSexo());
        assertEquals(dtNasc, aluno.getDtNasc());
    }

    @Test
    void whenSettersUsed_thenFieldsAreCorrectlySet() {
        // Given
        Aluno aluno = new Aluno();
        Integer id = 2;
        String nome = "Aluno 2";
        String sexo = "F";
        Date dtNasc = new Date();

        // When
        aluno.setIdaluno(id);
        aluno.setNome(nome);
        aluno.setSexo(sexo);
        aluno.setDtNasc(dtNasc);

        // Then
        assertEquals(id, aluno.getIdaluno());
        assertEquals(nome, aluno.getNome());
        assertEquals(sexo, aluno.getSexo());
        assertEquals(dtNasc, aluno.getDtNasc());
    }

    @Test
    void whenAddCurso_thenCursoIsAdded() {
        // Given
        Aluno aluno = new Aluno();
        Curso curso = new Curso();
        curso.adicionarAluno(aluno);

        // When
        aluno.adicionarCurso(curso);

        // Then
        assertTrue(aluno.getCursos().contains(curso));
        assertTrue(curso.getAlunos().contains(aluno));
    }

    @Test
    void whenRemoveCurso_thenCursoIsRemoved() {
        // Given
        Aluno aluno = new Aluno();
        Curso curso = new Curso(); 
        aluno.adicionarCurso(curso);

        // When
        aluno.removeCurso(curso);

        // Then
        assertFalse(aluno.getCursos().contains(curso));
        assertFalse(curso.getAlunos().contains(aluno));
    }

    @Test
    void whenEqualsCalledWithSameObject_thenTrue() {
        // Given
        Aluno aluno1 = new Aluno(1, "Aluno 1", "M", new Date());

        // Then
        assertEquals(aluno1, aluno1);
    }

    @Test
    void whenEqualsCalledWithDifferentObject_thenFalse() {
        // Given
        Aluno aluno1 = new Aluno(1, "Aluno 1", "M", new Date());
        Aluno aluno2 = new Aluno(2, "Aluno 2", "F", new Date());

        // Then
        assertNotEquals(aluno1, aluno2);
    }

    @Test
    void whenEqualsCalledWithNullAndNonNullDtNasc_thenFalse(){
      Aluno aluno1 = new Aluno(1, "Aluno 1", "M", null);
      Aluno aluno2 = new Aluno(2, "Aluno 2", "M", new Date());

        assertNotEquals(aluno1, aluno2);
    }

    @Test
    void whenHashCodeCalled_thenCorrectHashCodeReturned() {
        // Given
        Aluno aluno1 = new Aluno(1, "Aluno 1", "M", new Date());
        Aluno aluno2 = new Aluno(1, "Aluno 1", "M", new Date());

        // Then
        assertEquals(aluno1.hashCode(), aluno2.hashCode());
    }

    @Test
    void whenToStringCalled_thenCorrectStringReturned() {
        // Given
        Aluno aluno = new Aluno(1, "Aluno 1", "M", new Date());

        // When
        String alunoString = aluno.toString();

        // Then
        assertTrue(alunoString.contains("Aluno 1"));
        assertTrue(alunoString.contains("1"));
        assertTrue(alunoString.contains("M"));
    }

    @Test
    void givenTwoEqualObjects_whenHashCode_thenSameHashCode() {
        Aluno aluno1 = new Aluno(1, "Nome", "M", new Date());
        Aluno aluno2 = new Aluno(1, "Nome", "M", new Date());
        assertEquals(aluno1.hashCode(), aluno2.hashCode());
    }

    @Test
    void givenTwoDifferentObjects_whenHashCode_thenDifferentHashCode() {
        Aluno aluno1 = new Aluno(1, "Nome", "M", new Date());
        Aluno aluno2 = new Aluno(2, "Outro Nome", "F", new Date());
        assertNotEquals(aluno1.hashCode(), aluno2.hashCode());
    }

    @Test
    void givenNull_whenEquals_thenFalse() {
        Aluno aluno = new Aluno(1, "Nome", "M", new Date());
        assertNotNull(aluno);
    }

    @Test
    void givenDifferentClassObject_whenEquals_thenFalse() {
        Aluno aluno = new Aluno(1, "Nome", "M", new Date());
        Object outroObjeto = new Object();
        assertNotEquals(aluno, outroObjeto);
    }

    @Test
    void givenTwoEqualObjects_whenEquals_thenTrue() {
        Aluno aluno1 = new Aluno(1, "Nome", "M", new Date());
        Aluno aluno2 = new Aluno(1, "Nome", "M", new Date());
        assertEquals(aluno1, aluno2);
    }

    @Test
    void givenTwoDifferentObjects_whenEquals_thenFalse() {
        Aluno aluno1 = new Aluno(1, "Nome", "M", new Date());
        Aluno aluno2 = new Aluno(2, "Outro Nome", "F", new Date());
        assertNotEquals(aluno1, aluno2);
    }

    @Test
    void whenEqualsCalledWithDifferentClassObject_thenFalse() {
        // Given
        Aluno aluno = new Aluno(1, "Aluno 1", "M", new Date());
        Object outroObjeto = new Object();

        // Then
        assertNotEquals(aluno, outroObjeto);
    }

    @Test
    void whenEqualsCalledWithNullObject_thenFalse() {
        // Given
        Aluno aluno = new Aluno(1, "Aluno 1", "M", new Date());

        // Then
        assertNotNull(aluno);
    }

    @Test
    void whenAllAttributesAreNull_thenCorrectHashCode() {
        Aluno aluno = new Aluno();
        int expectedHashCode = 31 * 31 * 31 * 31;
        assertEquals(expectedHashCode, aluno.hashCode());
    }

    @Test
    void whenAllAttributesAreNonNull_thenCorrectHashCode() {
        Date dtNasc = new Date();
        Aluno aluno = new Aluno(1, "Aluno", "M", dtNasc);
        int expectedHashCode = 31 * (31 * (31 * (31 + dtNasc.hashCode()) + Integer.hashCode(1)) + "Aluno".hashCode()) + "M".hashCode();
        assertEquals(expectedHashCode, aluno.hashCode());
    }

    @Test
    void givenTwoObjectsWithDifferentAttributes_whenHashCode_thenDifferentHashCode() {
        Aluno aluno1 = new Aluno(1, "Aluno1", "M", new Date());
        Aluno aluno2 = new Aluno(2, "Aluno2", "F", new Date());
        assertNotEquals(aluno1.hashCode(), aluno2.hashCode());
    }
}
