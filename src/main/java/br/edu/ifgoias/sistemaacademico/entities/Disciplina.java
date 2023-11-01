package br.edu.ifgoias.sistemaacademico.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Disciplina implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDisciplina;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "idprofessor")
    private Professor professor;

    @ManyToMany
    @JoinTable( name="disciplina_curso",
            joinColumns = @JoinColumn(name="idCurso"),
            inverseJoinColumns = @JoinColumn(name="idDisciplina")
    )
    private List<Curso> cursos = new ArrayList<>();

    @OneToMany(mappedBy = "disciplina")
    private List<Turma> turmas = new ArrayList<>();
}
