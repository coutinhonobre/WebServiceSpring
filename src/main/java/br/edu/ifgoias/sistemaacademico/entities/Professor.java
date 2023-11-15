package br.edu.ifgoias.sistemaacademico.entities;

import javax.persistence.*;
import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class Professor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProfessor;
    private String nome;
    private String titulacao;

    public Professor(Integer idProfessor, String nome, String titulacao) {
    	this.idProfessor = idProfessor;
    	this.nome = nome;
    	this.titulacao = titulacao;
    }

    public Professor() {

    }

    public Integer getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Integer idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }
}