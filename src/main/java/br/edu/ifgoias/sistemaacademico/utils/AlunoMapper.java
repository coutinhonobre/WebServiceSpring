package br.edu.ifgoias.sistemaacademico.utils;

import br.edu.ifgoias.sistemaacademico.entities.Aluno;
import br.edu.ifgoias.sistemaacademico.dto.AlunoDTO;

public class AlunoMapper implements GenericMapper<Aluno, AlunoDTO> {

    @Override
    public Aluno convertDTOParaEntidade(AlunoDTO dto) {
        return new Aluno(
                dto.getIdaluno(),
                dto.getNome(),
                dto.getSexo(),
                dto.getDtNasc()
        );
    }

    @Override
    public AlunoDTO convertEntidadeParaDTO(Aluno aluno) {
        return new AlunoDTO(
                aluno.getIdaluno(),
                aluno.getNome(),
                aluno.getSexo(),
                aluno.getDtNasc()
        );
    }

}
