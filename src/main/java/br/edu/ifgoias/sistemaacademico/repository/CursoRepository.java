package br.edu.ifgoias.sistemaacademico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifgoias.sistemaacademico.entities.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>
{

}
