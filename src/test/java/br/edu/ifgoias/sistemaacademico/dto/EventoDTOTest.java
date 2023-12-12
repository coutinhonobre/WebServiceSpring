package br.edu.ifgoias.sistemaacademico.dto;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EventoDTOTest {
    @Test
    void givenConstructorWithId_whenCreatingObject_thenCorrectlyInitialized() {
        // Given
        Integer idEvento = 1;
        String nome = "Evento 1";
        Date data = new Date();
        String local = "Local 1";
        String descricao = "Descrição do Evento 1";

        // When
        EventoDTO evento = new EventoDTO(idEvento, nome, data, local, descricao);

        // Then
        assertEquals(idEvento, evento.getIdEvento());
        assertEquals(nome, evento.getNomeEvento());
        assertEquals(data, evento.getDataEvento());
        assertEquals(local, evento.getLocalEvento());
        assertEquals(descricao, evento.getDescricaoEvento());
    }

    @Test
    void givenConstructorWithoutId_whenCreatingObject_thenCorrectlyInitialized() {
        // Given
        String nome = "Evento 1";
        Date data = new Date();
        String local = "Local 1";
        String descricao = "Descrição do Evento 1";

        // When
        EventoDTO evento = new EventoDTO(nome, data, local, descricao);

        // Then
        assertNull(evento.getIdEvento());
        assertEquals(nome, evento.getNomeEvento());
        assertEquals(data, evento.getDataEvento());
        assertEquals(local, evento.getLocalEvento());
        assertEquals(descricao, evento.getDescricaoEvento());
    }

    @Test
    void givenTwoEqualObjects_whenCheckingEquality_thenShouldBeEqual() {
        // Given
        EventoDTO evento1 = new EventoDTO(1, "Evento 1", new Date(), "Local 1", "Descrição 1");
        EventoDTO evento2 = new EventoDTO(1, "Evento 1", new Date(), "Local 1", "Descrição 1");

        // When-Then
        assertEquals(evento1, evento2);
    }

    @Test
    void givenTwoEqualObjects_whenComparingHashCodes_thenShouldBeEqual() {
        // Given
        Integer idEvento = 1;
        String nome = "Evento 1";
        Date data = new Date();
        String local = "Local 1";
        String descricao = "Descrição do Evento 1";

        EventoDTO evento1 = new EventoDTO(idEvento, nome, data, local, descricao);
        EventoDTO evento2 = new EventoDTO(idEvento, nome, data, local, descricao);

        // When
        int hash1 = evento1.hashCode();
        int hash2 = evento2.hashCode();

        // Then
        assertEquals(hash1, hash2);
    }

    @Test
    void givenTwoDifferentObjects_whenComparingHashCodes_thenShouldNotBeEqual() {
        // Given
        EventoDTO evento1 = new EventoDTO(1, "Evento 1", new Date(), "Local 1", "Descrição 1");
        EventoDTO evento2 = new EventoDTO(2, "Evento 2", new Date(), "Local 2", "Descrição 2");

        // When
        int hash1 = evento1.hashCode();
        int hash2 = evento2.hashCode();

        // Then
        assertNotEquals(hash1, hash2);
    }

    @Test
    void givenSameObject_whenCheckingEquality_thenShouldBeEqual() {
        // Given
        EventoDTO evento = new EventoDTO(1, "Evento 1", new Date(), "Local 1", "Descrição 1");

        // When-Then
        assertEquals(evento, evento);
    }

    @Test
    void givenNull_whenCheckingEquality_thenShouldNotBeEqual() {
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

    @Test
    void givenTwoDifferentObjects_whenCheckingEquality_thenShouldNotBeEqual() {
        // Given
        EventoDTO evento1 = new EventoDTO(1, "Evento 1", new Date(), "Local 1", "Descrição 1");
        EventoDTO evento2 = new EventoDTO(2, "Evento 2", new Date(), "Local 2", "Descrição 2");

        // When-Then
        assertNotEquals(evento1, evento2);
    }

    @Test
    void givenDifferentName_whenCheckingEquality_thenShouldNotBeEqual() {
        // Given
        EventoDTO evento1 = new EventoDTO(1, "Evento 1", new Date(), "Local 1", "Descrição 1");
        EventoDTO evento2 = new EventoDTO(1, "Evento 2", new Date(), "Local 1", "Descrição 1");

        // When-Then
        assertNotEquals(evento1, evento2);
    }

    @Test
    void givenDifferentDate_whenCheckingEquality_thenShouldNotBeEqual() {
        // Given
        Date data1 = new Date();
        Date data2 = new Date(data1.getTime() + 100000);
        EventoDTO evento1 = new EventoDTO(1, "Evento 1", data1, "Local 1", "Descrição 1");
        EventoDTO evento2 = new EventoDTO(1, "Evento 1", data2, "Local 1", "Descrição 1");

        // When-Then
        assertNotEquals(evento1, evento2);
    }

    @Test
    void givenDifferentLocal_whenCheckingEquality_thenShouldNotBeEqual() {
        // Given
        EventoDTO evento1 = new EventoDTO(1, "Evento 1", new Date(), "Local 1", "Descrição 1");
        EventoDTO evento2 = new EventoDTO(1, "Evento 1", new Date(), "Local 2", "Descrição 1");

        // When-Then
        assertNotEquals(evento1, evento2);
    }

    @Test
    void givenDifferentDescricao_whenCheckingEquality_thenShouldNotBeEqual() {
        // Given
        EventoDTO evento1 = new EventoDTO(1, "Evento 1", new Date(), "Local 1", "Descrição 1");
        EventoDTO evento2 = new EventoDTO(1, "Evento 1", new Date(), "Local 1", "Descrição 2");

        // When-Then
        assertNotEquals(evento1, evento2);
    }

    @Test
    void givenDefaultConstructor_whenCreatingObject_thenFieldsShouldBeNull() {
        // When
        EventoDTO evento = new EventoDTO();

        // Then
        assertNull(evento.getIdEvento());
        assertNull(evento.getNomeEvento());
        assertNull(evento.getDataEvento());
        assertNull(evento.getLocalEvento());
        assertNull(evento.getDescricaoEvento());
    }

    @Test
    void givenSetIdEvento_whenSettingId_thenShouldBeSet() {
        // Given
        EventoDTO evento = new EventoDTO();

        // When
        evento.setIdEvento(1);

        // Then
        assertEquals(1, evento.getIdEvento());
    }

    @Test
    void givenSetNome_whenSettingNome_thenShouldBeSet() {
        // Given
        EventoDTO evento = new EventoDTO();

        // When
        evento.setNomeEvento("Evento 1");

        // Then
        assertEquals("Evento 1", evento.getNomeEvento());
    }

    @Test
    void givenSetData_whenSettingData_thenShouldBeSet() {
        // Given
        EventoDTO evento = new EventoDTO();
        Date data = new Date();

        // When
        evento.setDataEvento(data);

        // Then
        assertEquals(data, evento.getDataEvento());
    }

    @Test
    void givenSetLocal_whenSettingLocal_thenShouldBeSet() {
        // Given
        EventoDTO evento = new EventoDTO();

        // When
        evento.setLocalEvento("Local 1");

        // Then
        assertEquals("Local 1", evento.getLocalEvento());
    }

    @Test
    void givenSetDescricao_whenSettingDescricao_thenShouldBeSet() {
        // Given
        EventoDTO evento = new EventoDTO();

        // When
        evento.setDescricaoEvento("Descrição 1");

        // Then
        assertEquals("Descrição 1", evento.getDescricaoEvento());
    }
}
