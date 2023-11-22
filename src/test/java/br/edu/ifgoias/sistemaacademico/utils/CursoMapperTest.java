package br.edu.ifgoias.sistemaacademico.utils;

import org.junit.jupiter.api.Test;
import br.edu.ifgoias.sistemaacademico.dto.CursoDTO;
import br.edu.ifgoias.sistemaacademico.entities.Curso;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CursoMapperTest {

    private final CursoMapper mapper = new CursoMapper();

    @Test
    void givenCursoDTO_whenConvertDTOParaEntidade_thenCorrect() {
        // Given
        CursoDTO dto = new CursoDTO(1, "Curso 1");

        // When
        Curso entity = mapper.convertDTOParaEntidade(dto);

        // Then
        assertNotNull(entity);
        assertEquals(dto.getIdCurso(), entity.getIdCurso());
        assertEquals(dto.getNomecurso(), entity.getNomecurso());

    }

    @Test
    void givenCursoEntity_whenConvertEntidadeParaDTO_thenCorrect() {
        // Given
        Curso entity = new Curso(2, "Curso 2");

        // When
        CursoDTO dto = mapper.convertEntidadeParaDTO(entity);

        // Then
        assertNotNull(dto);
        assertEquals(entity.getIdCurso(), dto.getIdCurso());
        assertEquals(entity.getNomecurso(), dto.getNomecurso());
    }
}
