package br.edu.ifgoias.sistemaacademico.utils;

import org.junit.jupiter.api.Test;
import br.edu.ifgoias.sistemaacademico.dto.ProfessorDTO;
import br.edu.ifgoias.sistemaacademico.entities.Professor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ProfessorMapperTest {

    private final ProfessorMapper mapper = new ProfessorMapper();

    @Test
    void givenProfessorDTO_whenConvertDTOParaEntidade_thenCorrect() {
        // Given
        ProfessorDTO dto = new ProfessorDTO(1, "Prof. Octavio", "Doutor");

        // When
        Professor entity = mapper.convertDTOParaEntidade(dto);

        // Then
        assertNotNull(entity);
        assertEquals(dto.getIdProfessor(), entity.getIdProfessor());
        assertEquals(dto.getNome(), entity.getNome());
        assertEquals(dto.getTitulacao(), entity.getTitulacao());
    }

    @Test
    void givenProfessorEntity_whenConvertEntidadeParaDTO_thenCorrect() {
        // Given
        Professor entity = new Professor(2, "Prof. Dory", "Mestre");

        // When
        ProfessorDTO dto = mapper.convertEntidadeParaDTO(entity);

        // Then
        assertNotNull(dto);
        assertEquals(entity.getIdProfessor(), dto.getIdProfessor());
        assertEquals(entity.getNome(), dto.getNome());
        assertEquals(entity.getTitulacao(), dto.getTitulacao());
    }
}
