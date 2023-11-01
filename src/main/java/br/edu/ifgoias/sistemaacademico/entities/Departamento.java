package br.edu.ifgoias.sistemaacademico.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDepartamento;
    private String nome;


    @ManyToMany
    @JoinTable( name="departamento_curso",
            joinColumns = @JoinColumn(name="idCurso"),
            inverseJoinColumns = @JoinColumn(name="idDepartamento")
    )
    private List<Curso> cursos = new ArrayList<>();

    @ManyToMany
    @JoinTable( name="departamento_professor",
            joinColumns = @JoinColumn(name="idProfessor"),
            inverseJoinColumns = @JoinColumn(name="idDepartamento")
    )
    private List<Professor> professores = new ArrayList<>();

}
