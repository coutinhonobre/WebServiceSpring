package br.edu.ifgoias.sistemaacademico.dto;

import java.util.Objects;

public class CursoDTO {
    private Integer idCurso;
    private String nomecurso;

    public CursoDTO() {

    }

    public CursoDTO(Integer idCurso, String nomecurso) {
    	this.idCurso = idCurso;
    	this.nomecurso = nomecurso;
    }

    public CursoDTO(String nomecurso) {
    	this.nomecurso = nomecurso;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public String getNomecurso() {
        return nomecurso;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CursoDTO alunoDTO = (CursoDTO) o;
        return Objects.equals(nomecurso, alunoDTO.nomecurso) &&
                Objects.equals(idCurso, alunoDTO.idCurso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCurso, nomecurso);
    }
}
