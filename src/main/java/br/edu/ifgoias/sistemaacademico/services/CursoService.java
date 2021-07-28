package br.edu.ifgoias.sistemaacademico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.edu.ifgoias.sistemaacademico.entities.Curso;
import br.edu.ifgoias.sistemaacademico.repository.CursoRepository;

@Service
public class CursoService {

	@Autowired
	private CursoRepository repository;
	
	public List<Curso> findAll(){
		return repository.findAll();
	}
	
	public Curso findById(Integer id) {
		return repository.findById(id).orElseThrow( () -> new ResponseStatusException( HttpStatus.NOT_FOUND)  );
	}
	
	public Curso insert(Curso c) {
		return repository.save(c);
	}
	
	public void delete (Integer id) {
			repository.findById(id).map(
				curso -> {
							repository.delete(curso);
							return Void.TYPE;
						 }).orElseThrow( () -> new ResponseStatusException( HttpStatus.NOT_FOUND)  );		
	}
	
	public Curso update (Integer id, Curso obj) {
		return repository.findById(id).map(
					curso -> { 
								curso.setNomecurso(  obj.getNomecurso() ); 
							    return repository.save(curso);
							 }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND) );
	}
	
}