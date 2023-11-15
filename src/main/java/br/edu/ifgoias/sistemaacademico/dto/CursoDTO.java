package br.edu.ifgoias.sistemaacademico.dto;

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
}
