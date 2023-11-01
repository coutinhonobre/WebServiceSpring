package br.edu.ifgoias.sistemaacademico.resources;

import br.edu.ifgoias.sistemaacademico.entities.DefaultEntitie;
import br.edu.ifgoias.sistemaacademico.entities.Professor;
import br.edu.ifgoias.sistemaacademico.services.AlunoService;
import br.edu.ifgoias.sistemaacademico.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = "/professores")
public class ProfessorResource implements DefaultResource {

    @Autowired
    private ProfessorService service;

    @Override
    public ResponseEntity<List> findAll() {
        List<Professor> listaProfessores = service.findAll();
        return ResponseEntity.ok().body(listaProfessores);
    }
}
