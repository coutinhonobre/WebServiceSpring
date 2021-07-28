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
	private Integer idcurso;
	
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

	public Curso(Integer idcurso, String nomecurso) {
		this.idcurso = idcurso;
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
		
	public Integer getIdcurso() {
		return idcurso;
	}

	public void setIdcurso(Integer idcurso) {
		this.idcurso = idcurso;
	}

	public String getNomecurso() {
		return nomecurso;
	}

	public void setNomecurso(String nomecurso) {
		this.nomecurso = nomecurso;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idcurso == null) ? 0 : idcurso.hashCode());
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
		if (idcurso == null) {
			if (other.idcurso != null)
				return false;
		} else if (!idcurso.equals(other.idcurso))
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
		return "Curso [idcurso=" + idcurso + ", nomecurso=" + nomecurso + ", alunos=" + alunos + "]";
	}
		
}
