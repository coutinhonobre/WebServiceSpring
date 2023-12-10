package br.edu.ifgoias.sistemaacademico.dto;

import java.util.Objects;

public class ProfessorDTO {
    private Integer idProfessor;
    private String nome;
    private String titulacao;

    public ProfessorDTO() {

    }

    public ProfessorDTO(Integer idProfessor, String nome, String titulacao) {
    	this.idProfessor = idProfessor;
    	this.nome = nome;
    	this.titulacao = titulacao;
    }

    public ProfessorDTO(String nome, String titulacao) {
    	this.nome = nome;
    	this.titulacao = titulacao;
    }

    public Integer getIdProfessor() {
    	return idProfessor;
    }

    public String getNome() {
    	return nome;
    }

    public String getTitulacao() {
    	return titulacao;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ProfessorDTO professorDTO = (ProfessorDTO) o;
        return Objects.equals(idProfessor, professorDTO.idProfessor) &&
                Objects.equals(nome, professorDTO.nome) &&
                Objects.equals(titulacao, professorDTO.titulacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProfessor, nome, titulacao);
    }
}
