package br.edu.ifgoias.sistemaacademico.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.Objects;

public class EventoDTO {
    private Integer idEvento;
    private String nome;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date data;
    private String local;
    private String descricao;

    public EventoDTO() {

    }

    public EventoDTO(Integer idEvento, String nome, Date data, String local, String descricao) {
        this.idEvento = idEvento;
        this.nome = nome;
        this.data = new Date(data.getTime());
        this.local = local;
        this.descricao = descricao;
    }

    public EventoDTO(String nome, Date data, String local, String descricao) {
        this.nome = nome;
        this.data = new Date(data.getTime());
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
        this.data = new Date(data.getTime());
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
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        EventoDTO eventoDTO = (EventoDTO) obj;
        return idEvento.equals(eventoDTO.idEvento) &&
                nome.equals(eventoDTO.nome) &&
                data.equals(eventoDTO.data) &&
                local.equals(eventoDTO.local) &&
                descricao.equals(eventoDTO.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEvento, nome, data, local, descricao);
    }
}
