package br.edu.ifgoias.sistemaacademico.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.*;
import java.util.logging.Level;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Aluno implements Serializable{

	private static final long serialVersionUID = 1L;

  private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(Aluno.class.getName());
 
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer idaluno;
	
	private String nome;
	private String sexo;
	@JsonFormat(pattern="dd/MM/yyyy")
	@JsonProperty("dt_nasc")
	private Date dtNasc;
	
	@ManyToMany(mappedBy = "alunos")
	private List<Curso> cursos = new ArrayList<>();
	
	public Aluno() {

	}

	public Aluno(Integer idaluno, String nome, String sexo, Date dtNasc) {
		this.idaluno = idaluno;
		this.nome = nome;
		this.sexo = sexo;
		this.dtNasc = (dtNasc != null) ? new Date(dtNasc.getTime()): null;
	}

	public Aluno(String nome, String sexo, Date dtNasc) {
		this.nome = nome;
		this.sexo = sexo;
		this.dtNasc = new Date(dtNasc.getTime());
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

	public Date getDtNasc() {
		if (this.dtNasc == null) {
			return null;
		}
		return new Date(this.dtNasc.getTime());
	}

	public void setDtNasc(Date dtNasc) {
		this.dtNasc = new Date(dtNasc.getTime());
	}

	public List<Curso> getCursos() {
		return new ArrayList<>(cursos);
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = new ArrayList<>(cursos);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result + ((dtNasc == null) ? 0 : dtNasc.hashCode());
		result = prime * result + ((idaluno == null) ? 0 : idaluno.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());

		return result;
	}

  @Override
  public boolean equals(Object obj) {
      if (this == obj)
          return true;

      if (obj == null || getClass() != obj.getClass())
          return false;

      Aluno other = (Aluno) obj;
      return compareFields(other, Arrays.asList("idaluno", "nome", "sexo", "dtNasc"));
  }

	@Override
	public String toString() {
		return "Aluno [idaluno=" + idaluno + ", nome=" + nome + ", sexo=" + sexo + ", dt_nasc=" + dtNasc + ", cursos="
				+ cursos + "]";
	}

	private Map<String, Object> extractFieldValues(Object object, List<String> fields) {
		Map<String, Object> fieldValues = new HashMap<>();
		for (String fieldName : fields) {
			try {
				fieldValues.put(fieldName, object.getClass().getDeclaredField(fieldName).get(object));
			} catch (Exception e) {
				logError("Error accessing field", fieldName, e);
				return Collections.emptyMap();
			}
		}
		return fieldValues;
	}


	private boolean areBothFieldsNull(Object fieldValue1, Object fieldValue2) {
		return fieldValue1 == null && fieldValue2 == null;
	}

	private boolean compareFieldValue(Map<String, Object> thisFields, Map<String, Object> otherFields, String fieldName) {
		Object thisFieldValue = thisFields.get(fieldName);
		Object otherFieldValue = otherFields.get(fieldName);

		if (areBothFieldsNull(thisFieldValue, otherFieldValue)) {
			return true;
		}
		return thisFieldValue != null && thisFieldValue.equals(otherFieldValue);
	}

	private void logError(String message, String fieldName, Exception e) {
		String logMessage = String.format("%s -> %s", message, fieldName);
		LOGGER.log(Level.SEVERE, logMessage, e);
	}

	private boolean areAnyFieldsNull(Map<String, Object> fields1, Map<String, Object> fields2) {
		return fields1 == null || fields2 == null;
	}

	private boolean compareFields(Aluno other, List<String> fieldsToCompare) {
		Map<String, Object> thisFields = extractFieldValues(this, fieldsToCompare);
		Map<String, Object> otherFields = extractFieldValues(other, fieldsToCompare);

		if (areAnyFieldsNull(thisFields, otherFields)) {
			return false;
		}

		for (String fieldName : fieldsToCompare) {
			if (!compareFieldValue(thisFields, otherFields, fieldName)) {
				return false;
			}
		}
		return true;
	}
}
