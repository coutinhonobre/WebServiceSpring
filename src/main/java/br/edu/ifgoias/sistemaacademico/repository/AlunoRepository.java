package br.edu.ifgoias.sistemaacademico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifgoias.sistemaacademico.entities.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer>
{
	
}
