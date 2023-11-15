package br.edu.ifgoias.sistemaacademico.utils;

import br.edu.ifgoias.sistemaacademico.dto.ProfessorDTO;
import br.edu.ifgoias.sistemaacademico.entities.Professor;

public class ProfessorMapper implements GenericMapper<Professor, ProfessorDTO>{

    @Override
    public Professor convertDTOParaEntidade(ProfessorDTO dto) {
        return new Professor(
            dto.getIdProfessor(),
            dto.getNome(),
            dto.getTitulacao()
        );
    }

    @Override
    public ProfessorDTO convertEntidadeParaDTO(Professor entity) {
        return new ProfessorDTO(
            entity.getIdProfessor(),
            entity.getNome(),
            entity.getTitulacao()
        );
    }
}
