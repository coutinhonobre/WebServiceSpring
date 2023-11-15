package br.edu.ifgoias.sistemaacademico.resources;

import java.util.List;

import br.edu.ifgoias.sistemaacademico.dto.CursoDTO;
import br.edu.ifgoias.sistemaacademico.utils.CursoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifgoias.sistemaacademico.entities.Curso;
import br.edu.ifgoias.sistemaacademico.services.CursoService;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping ( value = "/cursos")
public class CursoResource {

	private final CursoService service;

	@Autowired
	public CursoResource(CursoService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<Curso>> findAll(){
		List<Curso>  listaCurso = service.findAll();
		return ResponseEntity.ok().body(listaCurso);
	}
	
	@GetMapping ( value = "/{id}")
	public ResponseEntity<Curso> findById(@PathVariable Integer id){
		Curso curso = service.findById(id);
		return ResponseEntity.ok().body(curso);
	}
	
	@PostMapping
	@ResponseStatus (HttpStatus.CREATED)
	public ResponseEntity<CursoDTO> insert(@RequestBody CursoDTO dto) {
		Curso curso = new CursoMapper().convertDTOParaEntidade(dto);
		curso = service.insert(curso);
		CursoDTO response = new CursoMapper().convertEntidadeParaDTO(curso);
		return ResponseEntity.ok().body(response);
	}
	
	@DeleteMapping (value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete (@PathVariable Integer id){
		service.delete(id);
	}
	
	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)		
	public ResponseEntity<CursoDTO> update (@PathVariable Integer id, @RequestBody CursoDTO dto){
		CursoMapper cursoMapper = new CursoMapper();
		Curso curso = cursoMapper.convertDTOParaEntidade(dto);
		curso.setIdCurso(id);
		curso = service.update(id, curso);
		CursoDTO response = cursoMapper.convertEntidadeParaDTO(curso);
		return ResponseEntity.ok().body(response);
	}
}
