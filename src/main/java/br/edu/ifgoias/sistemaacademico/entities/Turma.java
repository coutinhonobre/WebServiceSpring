package br.edu.ifgoias.sistemaacademico.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;

@Entity
public class Turma implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idturma;
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "iddisciplina")
    private Disciplina disciplina;

    @ManyToMany
    @JoinTable( name="aluno_turma",
            joinColumns = @JoinColumn(name="idturma"),
            inverseJoinColumns = @JoinColumn(name="idaluno")
    )
    private List<Aluno> alunos = new ArrayList<>();

}
