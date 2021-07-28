package br.edu.ifgoias.sistemaacademico.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Aluno implements Serializable{

	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer idaluno;
	
	private String nome;
	private String sexo;
	private Date dt_nasc;
	
	@ManyToMany(mappedBy = "alunos")
	private List<Curso> cursos = new ArrayList<>();
	
	public Aluno() {

	}

	public Aluno(Integer idaluno, String nome, String sexo, Date dt_nasc) {
		this.idaluno = idaluno;
		this.nome = nome;
		this.sexo = sexo;
		this.dt_nasc = dt_nasc;
	}
	
	
	public void adicionarCurso(Curso c) {
		this.cursos.add(c);
		c.getAlunos().add(this);
	}
	
	public void removeCurso(Curso c) {
		this.cursos.remove(c);
		c.getAlunos().remove(this);
	}
	
	public Integer getIdaluno() {
		return idaluno;
	}

	public void setIdaluno(Integer idaluno) {
		this.idaluno = idaluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDt_nasc() {
		return dt_nasc;
	}

	public void setDt_nasc(Date dt_nasc) {
		this.dt_nasc = dt_nasc;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dt_nasc == null) ? 0 : dt_nasc.hashCode());
		result = prime * result + ((idaluno == null) ? 0 : idaluno.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
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
		Aluno other = (Aluno) obj;
		if (dt_nasc == null) {
			if (other.dt_nasc != null)
				return false;
		} else if (!dt_nasc.equals(other.dt_nasc))
			return false;
		if (idaluno == null) {
			if (other.idaluno != null)
				return false;
		} else if (!idaluno.equals(other.idaluno))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aluno [idaluno=" + idaluno + ", nome=" + nome + ", sexo=" + sexo + ", dt_nasc=" + dt_nasc + ", cursos="
				+ cursos + "]";
	}
	
}
