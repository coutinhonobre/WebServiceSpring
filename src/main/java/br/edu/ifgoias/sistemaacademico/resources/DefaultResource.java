package br.edu.ifgoias.sistemaacademico.resources;

import br.edu.ifgoias.sistemaacademico.entities.DefaultEntitie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200/")
public interface DefaultResource {
    @GetMapping
    public ResponseEntity<List> findAll();
}
