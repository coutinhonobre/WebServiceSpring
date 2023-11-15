package br.edu.ifgoias.sistemaacademico.resources;

import br.edu.ifgoias.sistemaacademico.dto.ProfessorDTO;
import br.edu.ifgoias.sistemaacademico.entities.Professor;
import br.edu.ifgoias.sistemaacademico.services.ProfessorService;
import br.edu.ifgoias.sistemaacademico.utils.ProfessorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping(value = "/professores")
public class ProfessorResource {

    private final ProfessorService service;

    @Autowired
    public ProfessorResource(ProfessorService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Professor>> findAll() {
        List<Professor> listaProfessores = service.findAll();
        return ResponseEntity.ok().body(listaProfessores);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Professor> findById(@PathVariable Integer id) {
        Professor professor = service.findById(id);
        return ResponseEntity.ok().body(professor);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProfessorDTO> insert(@RequestBody ProfessorDTO dto) {
        Professor professor = new ProfessorMapper().convertDTOParaEntidade(dto);
        professor = service.insert(professor);
        ProfessorDTO response = new ProfessorMapper().convertEntidadeParaDTO(professor);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProfessorDTO> update(@PathVariable Integer id, @RequestBody ProfessorDTO dto) {
        ProfessorMapper professorMapper = new ProfessorMapper();
        Professor professor = professorMapper.convertDTOParaEntidade(dto);
        professor = service.update(id, professor);
        ProfessorDTO response = professorMapper.convertEntidadeParaDTO(professor);
        return ResponseEntity.ok().body(response);
    }
}
