package br.edu.ifgoias.sistemaacademico.entities;

import br.edu.ifgoias.sistemaacademico.dto.EventoDTO;
import org.junit.jupiter.api.Test;

import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class EventoTest {

    @Test
    void givenDefaultConstructor_whenCreatingObject_thenCorrectlyInitialized() {
        // Given
        Evento evento = new Evento();

        // Then
        assertNull(evento.getIdEvento());
        assertNull(evento.getNome());
        assertNull(evento.getData());
        assertNull(evento.getLocal());
        assertNull(evento.getDescricao());
    }

    @Test
    void givenConstructorWithAllParameters_whenCreatingObject_thenCorrectlyInitialized() {
        // Given
        Integer idEvento = 1;
        String nome = "Evento 1";
        Date data = new Date();
        String local = "Local 1";
        String descricao = "Descricao 1";

        // When
        Evento evento = new Evento(idEvento, nome, data, local, descricao);

        // Then
        assertEquals(idEvento, evento.getIdEvento());
        assertEquals(nome, evento.getNome());
        assertEquals(data, evento.getData());
        assertEquals(local, evento.getLocal());
        assertEquals(descricao, evento.getDescricao());
    }

    @Test
    void whenSettersUsed_thenFieldsAreCorrectlySet() {
        // Given
        Evento evento = new Evento();
        Integer idEvento = 2;
        String nome = "Evento 2";
        Date data = new Date();
        String local = "Local 2";
        String descricao = "Descricao 2";

        // When
        evento.setIdEvento(idEvento);
        evento.setNome(nome);
        evento.setData(data);
        evento.setLocal(local);
        evento.setDescricao(descricao);

        // Then
        assertEquals(idEvento, evento.getIdEvento());
        assertEquals(nome, evento.getNome());
        assertEquals(data, evento.getData());
        assertEquals(local, evento.getLocal());
        assertEquals(descricao, evento.getDescricao());
    }

    @Test
    void whenEqualsCalledWithSameObject_thenTrue() {
        // Given
        Evento evento1 = new Evento(1, "Evento 1", new Date(), "Local 1", "Descricao 1");

        // Then
        assertEquals(evento1, evento1);
    }

    @Test
    void whenEqualsCalledWithDifferentObject_thenFalse() {
        // Given
        Evento evento1 = new Evento(1, "Evento 1", new Date(), "Local 1", "Descricao 1");
        Evento evento2 = new Evento(2, "Evento 2", new Date(), "Local 2", "Descricao 2");

        // Then
        assertNotEquals(evento1, evento2);
    }

    @Test
    void whenEqualsCalledWithDifferentObjectButSameData_thenTrue() {
        // Given
        Evento evento1 = new Evento(1, "Evento 1", new Date(), "Local 1", "Descricao 1");
        Evento evento2 = new Evento(1, "Evento 1", new Date(), "Local 1", "Descricao 1");

        // Then
        assertEquals(evento1, evento2);
    }

    @Test
    void whenEqualsCalledWithNull_thenFalse() {
        // Given
        Evento evento1 = new Evento(1, "Evento 1", new Date(), "Local 1", "Descricao 1");

        // Then
        assertNotEquals(null, evento1);
    }

    @Test
    void whenEqualsCalledWithDifferentClass_thenFalse() {
        // Given
        Evento evento1 = new Evento(1, "Evento 1", new Date(), "Local 1", "Descricao 1");
        Object otherObject = new Object();

        // Then
        assertNotEquals(evento1, otherObject);
    }

    @Test
    void whenEqualsCalledWithDifferentFieldValues_thenFalse() {
        // Given
        Evento evento1 = new Evento(1, "Evento 1", new Date(), "Local 1", "Descricao 1");
        Evento evento2 = new Evento(1, "Evento 1", new Date(), "Local 1", "Different Description");

        // Then
        assertNotEquals(evento1, evento2);
    }

    @Test
    void whenHashCodeCalled_thenCorrectHashCodeReturned() {
        // Given
        Evento evento1 = new Evento(1, "Evento 1", new Date(), "Local 1", "Descricao 1");
        Evento evento2 = new Evento(1, "Evento 1", new Date(), "Local 1", "Descricao 1");

        // Then
        assertEquals(evento1.hashCode(), evento2.hashCode());
    }

    @Test
    void whenToStringCalled_thenCorrectStringReturned() {
        // Given
        Evento evento = new Evento(1, "Evento 1", new Date(), "Local 1", "Descricao 1");

        // When
        String eventoString = evento.toString();

        // Then
        assertTrue(eventoString.contains("Evento 1"));
        assertTrue(eventoString.contains("1"));
        assertTrue(eventoString.contains("Local 1"));
        assertTrue(eventoString.contains("Descricao 1"));
    }

    @Test
    void whenHashCodeCalled_onSameObjectMultipleTimes_thenSameHashCodeReturned() {
        // Given
        Evento evento = new Evento();

        // When
        int firstCallHashCode = evento.hashCode();
        int secondCallHashCode = evento.hashCode();

        // Then
        assertEquals(firstCallHashCode, secondCallHashCode);
    }

    @Test
    void whenHashCodeCalled_onDifferentObjects_thenDifferentHashCodesReturned() {
        // Given
        Evento evento1 = new Evento(1, "Evento 1", new Date(), "Local 1", "Descricao 1");
        Evento evento2 = new Evento(2, "Evento 2", new Date(), "Local 2", "Descricao 2");

        // When
        int hashCode1 = evento1.hashCode();
        int hashCode2 = evento2.hashCode();

        // Then
        assertNotEquals(hashCode1, hashCode2);
    }

    @Test
    void whenHashCodeCalled_withDifferentData_thenDifferentHashCodes() {
        // Given
        Evento evento1 = new Evento(1, "Evento 1", new Date(), "Local 1", "Descricao 1");
        Evento evento2 = new Evento(2, "Evento 2", new Date(), "Local 2", "Descricao 2");

        // When
        int hashCode1 = evento1.hashCode();
        int hashCode2 = evento2.hashCode();

        // Then
        assertNotEquals(hashCode1, hashCode2);
    }

    @Test
    void whenHashCodeCalled_withSameDataDifferentInstances_thenSameHashCodes() {
        // Given
        Date data = new Date();
        Evento evento1 = new Evento(1, "Evento 1", data, "Local 1", "Descricao 1");
        Evento evento2 = new Evento(1, "Evento 1", data, "Local 1", "Descricao 1");

        // When
        int hashCode1 = evento1.hashCode();
        int hashCode2 = evento2.hashCode();

        // Then
        assertEquals(hashCode1, hashCode2);
    }

    @Test
    void whenEqualsCalledWithDifferentClassObject_thenFalse() {
        Evento evento = new Evento(1, "Evento 1", new Date(), "Local 1", "Descricao 1");
        Object otherObject = new Object();
        assertNotEquals(evento, otherObject);
    }

    @Test
    void whenEqualsCalledWithDifferentNome_thenFalse() {
        Evento evento1 = new Evento(1, "Evento 1", new Date(), "Local 1", "Descricao 1");
        Evento evento2 = new Evento(1, "Evento 2", new Date(), "Local 1", "Descricao 1");
        assertNotEquals(evento1, evento2);
    }

    @Test
    void whenEqualsCalledWithDifferentLocal_thenFalse() {
        Evento evento1 = new Evento(1, "Evento 1", new Date(), "Local 1", "Descricao 1");
        Evento evento2 = new Evento(1, "Evento 1", new Date(), "Local 2", "Descricao 1");
        assertNotEquals(evento1, evento2);
    }

    @Test
    void whenEqualsCalledWithDifferentDescricao_thenFalse() {
        Evento evento1 = new Evento(1, "Evento 1", new Date(), "Local 1", "Descricao 1");
        Evento evento2 = new Evento(1, "Evento 1", new Date(), "Local 1", "Descricao 2");
        assertNotEquals(evento1, evento2);
    }

    @Test
    void givenNullObject_whenCheckingEquality_thenShouldNotBeEqual() {
        // Given
        EventoDTO evento = new EventoDTO(1, "Evento 1", new Date(), "Local 1", "Descrição 1");

        // When-Then
        assertNotNull(evento);
    }

    @Test
    void givenDifferentClassObject_whenCheckingEquality_thenShouldNotBeEqual() {
        // Given
        EventoDTO evento = new EventoDTO(1, "Evento 1", new Date(), "Local 1", "Descrição 1");
        Object otherObject = new Object();

        // When-Then
        assertNotEquals(evento, otherObject);
    }
}
