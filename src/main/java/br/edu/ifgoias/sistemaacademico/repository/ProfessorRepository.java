package br.edu.ifgoias.sistemaacademico.repository;

import br.edu.ifgoias.sistemaacademico.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}
