package br.edu.ifgoias.sistemaacademico.utils;

import org.junit.jupiter.api.Test;
import br.edu.ifgoias.sistemaacademico.dto.AlunoDTO;
import br.edu.ifgoias.sistemaacademico.entities.Aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

class AlunoMapperTest {

    private final AlunoMapper mapper = new AlunoMapper();

    @Test
    void givenAlunoDTO_whenConvertDTOParaEntidade_thenCorrect() {
        // Given
    	   String nome = "Aluno 1";
           String sexo = "M";
           Date dtNasc = new Date();

          // When
          AlunoDTO dto = new AlunoDTO(nome,sexo,dtNasc);

        // When
        Aluno entity = mapper.convertDTOParaEntidade(dto);

        // Then
        assertNotNull(entity);
        assertEquals(dto.getIdaluno(), entity.getIdaluno());
        assertEquals(dto.getNome(), entity.getNome());
        assertEquals(dto.getSexo(), entity.getSexo());
        assertEquals(dto.getDtNasc(), entity.getDtNasc());

    }

    @Test
    void givenAlunoEntity_whenConvertEntidadeParaDTO_thenCorrect() {
        // Given
    	 String nome = "Aluno 2";
         String sexo = "M";
         Date dtNasc = new Date();
        Aluno entity = new Aluno(2, nome,sexo,dtNasc);

        // When
        AlunoDTO dto = mapper.convertEntidadeParaDTO(entity);

        // Then
        assertNotNull(dto);
        assertEquals(entity.getIdaluno(), dto.getIdaluno());
        assertEquals(dto.getNome(), entity.getNome());
        assertEquals(dto.getSexo(), entity.getSexo());
        assertEquals(dto.getDtNasc(), entity.getDtNasc());
    }
}
