package br.edu.ifgoias.sistemaacademico.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

@Entity
public class Curso  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer idCurso;
	
	@Column (name = "nomecurso", nullable = false)
	private String nomecurso;
	
	@ManyToMany 
	@JoinTable( name="aluno_curso",
				joinColumns = @JoinColumn(name="idcurso"),
				inverseJoinColumns = @JoinColumn(name="idaluno")
				)
	private List<Aluno> alunos = new ArrayList<>();
	
	public Curso() {
		
	}

	public Curso(Integer idCurso, String nomecurso) {
		this.idCurso = idCurso;
		this.nomecurso = nomecurso;
	}

	
	public void adicionarAluno(Aluno a) {
		this.alunos.add(a);
		a.getCursos().add(this);
	}
	
	public void removeAluno(Aluno a) {
		this.alunos.remove(a);
		a.getCursos().remove(this);
	}
		
	public Integer getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Integer idcurso) {
		this.idCurso = idcurso;
	}

	public String getNomecurso() {
		return nomecurso;
	}

	public void setNomecurso(String nomecurso) {
		this.nomecurso = nomecurso;
	}

	public List<Aluno> getAlunos() {
		return new ArrayList<>(alunos);
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = new ArrayList<>(alunos);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCurso == null) ? 0 : idCurso.hashCode());
		result = prime * result + ((nomecurso == null) ? 0 : nomecurso.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		if (idCurso == null) {
			if (other.idCurso != null)
				return false;
		} else if (!idCurso.equals(other.idCurso))
			return false;
		if (nomecurso == null) {
			if (other.nomecurso != null)
				return false;
		} else if (!nomecurso.equals(other.nomecurso))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Curso [idcurso=" + idCurso + ", nomecurso=" + nomecurso + ", alunos=" + alunos + "]";
	}
		
}
