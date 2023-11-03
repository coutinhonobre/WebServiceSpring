package br.edu.ifgoias.sistemaacademico.resources;

import br.edu.ifgoias.sistemaacademico.entities.DefaultEntitie;
import br.edu.ifgoias.sistemaacademico.entities.Professor;
import br.edu.ifgoias.sistemaacademico.services.AlunoService;
import br.edu.ifgoias.sistemaacademico.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping(value = "/professores")
public class ProfessorResource {

    @Autowired
    private ProfessorService service;

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
    public ResponseEntity<Professor> insert(@RequestBody Professor p) {
        p = service.insert(p);
        return ResponseEntity.ok().body(p);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Professor> update(@PathVariable Integer id, @RequestBody Professor p) {
        p = service.update(id, p);
        return ResponseEntity.ok().body(p);
    }
}
