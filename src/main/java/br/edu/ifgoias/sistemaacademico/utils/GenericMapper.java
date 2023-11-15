package br.edu.ifgoias.sistemaacademico.utils;

public interface GenericMapper<E, D> {
    E convertDTOParaEntidade(D dto);
    D convertEntidadeParaDTO(E entity);
}
