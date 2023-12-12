package br.edu.ifgoias.sistemaacademico.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.Objects;

public class EventoDTO {
    private Integer idEvento;
    private String nomeEvento;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataEvento;
    private String localEvento;
    private String descricaoEvento;

    public EventoDTO() {

    }

    public EventoDTO(Integer idEvento, String nomeEvento, Date dataEvento, String localEvento, String descricaoEvento) {
        this.idEvento = idEvento;
        this.nomeEvento = nomeEvento;
        this.dataEvento = new Date(dataEvento.getTime());
        this.localEvento = localEvento;
        this.descricaoEvento = descricaoEvento;
    }

    public EventoDTO(String nomeEvento, Date dataEvento, String localEvento, String descricaoEvento) {
        this.nomeEvento = nomeEvento;
        this.dataEvento = new Date(dataEvento.getTime());
        this.localEvento = localEvento;
        this.descricaoEvento = descricaoEvento;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public Date getDataEvento() {
        if (dataEvento == null) {
            return null;
        }
        return new Date(dataEvento.getTime());
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = new Date(dataEvento.getTime());
    }

    public String getLocalEvento() {
        return localEvento;
    }

    public void setLocalEvento(String localEvento) {
        this.localEvento = localEvento;
    }

    public String getDescricaoEvento() {
        return descricaoEvento;
    }

    public void setDescricaoEvento(String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        EventoDTO eventoDTO = (EventoDTO) obj;
        return idEvento.equals(eventoDTO.idEvento) &&
                nomeEvento.equals(eventoDTO.nomeEvento) &&
                dataEvento.equals(eventoDTO.dataEvento) &&
                localEvento.equals(eventoDTO.localEvento) &&
                descricaoEvento.equals(eventoDTO.descricaoEvento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEvento, nomeEvento, dataEvento, localEvento, descricaoEvento);
    }
}
