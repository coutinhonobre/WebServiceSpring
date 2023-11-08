package br.edu.ifgoias.sistemaacademico.services;

import br.edu.ifgoias.sistemaacademico.entities.Professor;
import br.edu.ifgoias.sistemaacademico.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository repository;

    public List<Professor> findAll() {
        return repository.findAll();
    }

    public Professor findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Professor insert(Professor p) {
        return repository.save(p);
    }

    public void delete(Integer id) {
        repository.findById(id).ifPresentOrElse(
                repository::delete,
                () -> { throw new ResponseStatusException(HttpStatus.NOT_FOUND); }
        );
    }

    public Professor update(Integer id, Professor professor) {
        return repository.findById(id).map(p -> {
            p.setNome(professor.getNome());
            p.setTitulacao(professor.getTitulacao());
            return repository.save(p);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
