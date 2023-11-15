package br.edu.ifgoias.sistemaacademico.dto;

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
}
