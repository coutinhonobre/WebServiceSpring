package br.edu.ifgoias.sistemaacademico.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Objects;

public class AlunoDTO {
    private Integer idaluno;
    private String nome;
    private String sexo;
    @JsonFormat(pattern="dd/MM/yyyy")
    @JsonProperty("dt_nasc")
    private Date dtNasc;

    public AlunoDTO() {

    }

    public AlunoDTO(Integer idaluno, String nome, String sexo, Date dtNasc) {
        this.idaluno = idaluno;
        this.nome = nome;
        this.sexo = sexo;
        this.dtNasc = new Date(dtNasc.getTime());
    }

    public AlunoDTO(String nome, String sexo, Date dtNasc) {
        this.nome = nome;
        this.sexo = sexo;
        this.dtNasc = new Date(dtNasc.getTime());
    }

    public Integer getIdaluno() {
        return idaluno;
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    public Date getDtNasc() {
        return new Date(dtNasc.getTime());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlunoDTO alunoDTO = (AlunoDTO) o;
        return Objects.equals(idaluno, alunoDTO.idaluno) &&
                Objects.equals(nome, alunoDTO.nome) &&
                Objects.equals(sexo, alunoDTO.sexo) &&
                Objects.equals(dtNasc, alunoDTO.dtNasc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idaluno, nome, sexo, dtNasc);
    }

}
