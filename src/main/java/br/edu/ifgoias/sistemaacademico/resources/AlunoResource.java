package br.edu.ifgoias.sistemaacademico.resources;

import java.util.List;

import br.edu.ifgoias.sistemaacademico.dto.AlunoDTO;
import br.edu.ifgoias.sistemaacademico.utils.AlunoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
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

import br.edu.ifgoias.sistemaacademico.entities.Aluno;
import br.edu.ifgoias.sistemaacademico.services.AlunoService;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping(value = "/alunos")
public class AlunoResource {

	private final AlunoService service;

	@Autowired
	public AlunoResource(AlunoService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Aluno>> findAll() {
		List<Aluno> listaAluno = service.findAll();
		return ResponseEntity.ok().body(listaAluno);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Aluno> findById(@PathVariable Integer id) {
		Aluno aluno = service.findById(id);
		return ResponseEntity.ok().body(aluno);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<AlunoDTO> insert(@RequestBody AlunoDTO dto) {
		Aluno aluno = new AlunoMapper().convertDTOParaEntidade(dto);
		aluno = service.insert(aluno);
		AlunoDTO response = new AlunoMapper().convertEntidadeParaDTO(aluno);
		return ResponseEntity.ok().body(response);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}

	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<AlunoDTO> update(@PathVariable Integer id, @RequestBody AlunoDTO dto) {
		AlunoMapper alunoMapper = new AlunoMapper();

		Aluno aluno = alunoMapper.convertDTOParaEntidade(dto);
		aluno.setIdaluno(id);
		aluno = service.update(id, aluno);

		AlunoDTO response = alunoMapper.convertEntidadeParaDTO(aluno);
		return ResponseEntity.ok().body(response);
	}
}
