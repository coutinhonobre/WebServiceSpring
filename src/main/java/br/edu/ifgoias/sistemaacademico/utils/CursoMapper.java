package br.edu.ifgoias.sistemaacademico.utils;

import br.edu.ifgoias.sistemaacademico.dto.CursoDTO;
import br.edu.ifgoias.sistemaacademico.entities.Curso;

public class CursoMapper implements GenericMapper<Curso, CursoDTO> {
    @Override
    public Curso convertDTOParaEntidade(CursoDTO dto) {
        return new Curso(
            dto.getIdCurso(),
            dto.getNomecurso()
        );
    }

    @Override
    public CursoDTO convertEntidadeParaDTO(Curso curso) {
        return new CursoDTO(
            curso.getIdCurso(),
            curso.getNomecurso()
        );
    }
}
