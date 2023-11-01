package br.edu.ifgoias.sistemaacademico.entities;


import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Avaliacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAvaliacao;
    private String tipo;
    private Double nota;

    @ManyToOne
    @JoinColumn(name = "idaluno")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "iddisciplina")
    private Disciplina disciplina;

}
