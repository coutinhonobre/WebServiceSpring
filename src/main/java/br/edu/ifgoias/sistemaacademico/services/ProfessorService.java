package br.edu.ifgoias.sistemaacademico.services;

import br.edu.ifgoias.sistemaacademico.entities.Professor;
import br.edu.ifgoias.sistemaacademico.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository repository;

    public List<Professor> findAll() {
        return repository.findAll();
    }
}
