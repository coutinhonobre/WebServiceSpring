package br.edu.ifgoias.sistemaacademico.utils;

import br.edu.ifgoias.sistemaacademico.entities.Aluno;
import br.edu.ifgoias.sistemaacademico.dto.AlunoDTO;

public class AlunoMapper {

    private AlunoMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static Aluno convertDTOParaEntidade(AlunoDTO dto) {
        return new Aluno(
                dto.getIdaluno(),
                dto.getNome(),
                dto.getSexo(),
                dto.getDtNasc()
        );
    }

    public static AlunoDTO convertEntidadeParaDTO(Aluno aluno) {
        return new AlunoDTO(
                aluno.getIdaluno(),
                aluno.getNome(),
                aluno.getSexo(),
                aluno.getDtNasc()
        );
    }
}
