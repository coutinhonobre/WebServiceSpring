package br.edu.ifgoias.sistemaacademico.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEvento;

    private String nome;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date data;
    private String local;
    private String descricao;

    public Evento() {

    }

    public Evento(Integer idEvento, String nome, Date data, String local, String descricao) {
        this.idEvento = idEvento;
        this.nome = nome;
        this.data = (data != null) ? new Date(data.getTime()) : null;
        this.local = local;
        this.descricao = descricao;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        if (data == null) {
            return null;
        }
        return new Date(data.getTime());
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
        result = prime * result + ((idEvento == null) ? 0 : idEvento.hashCode());
        result = prime * result + ((local == null) ? 0 : local.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Evento evento = (Evento) obj;
        return idEvento.equals(evento.idEvento) &&
                nome.equals(evento.nome) &&
                data.equals(evento.data) &&
                local.equals(evento.local) &&
                descricao.equals(evento.descricao);
    }

    @Override
    public String toString() {
        return "Evento{" +
                "idEvento=" + idEvento +
                ", nome='" + nome + '\'' +
                ", data=" + data +
                ", local='" + local + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
