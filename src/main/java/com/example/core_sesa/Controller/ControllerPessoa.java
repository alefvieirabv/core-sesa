package com.example.core_sesa.Controller;

import com.example.core_sesa.Entity.Contato;
import com.example.core_sesa.Entity.Pessoa;
import com.example.core_sesa.Repository.RepositoryPessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/pessoas")
public class ControllerPessoa {

    @Autowired
    private RepositoryPessoa repositorio;

    @GetMapping
    public ResponseEntity<List<Pessoa>> listar() {
        try {
            List<Pessoa> tutorials = new ArrayList<>();
            repositorio.findAll().forEach(tutorials::add);
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Pessoa> salvar(@RequestBody Pessoa pessoa) {
        try {
            pessoa.setCpf(pessoa.getCpf().replaceAll("[^0-9]", ""));
            return new ResponseEntity<>(repositorio.save(pessoa), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity <?> delete(@PathVariable long id) {
        return repositorio.findById(id)
                .map(record -> {
                    repositorio.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") long id,
                                 @RequestBody Pessoa pessoa) {
        return repositorio.findById(id)
                .map(p -> {
                    p.setNome(pessoa.getNome());
                    p.setSobrenome(pessoa.getSobrenome());
                    p.setCpf(pessoa.getCpf());
                    p.setContatos(pessoa.getContatos());
                    return ResponseEntity.ok().body(repositorio.save(p));
                }).orElse(ResponseEntity.notFound().build());
    }
}
