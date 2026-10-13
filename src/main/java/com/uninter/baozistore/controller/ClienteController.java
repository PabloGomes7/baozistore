package com.uninter.baozistore.controller;

import com.uninter.baozistore.model.Cliente;
import com.uninter.baozistore.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    public Cliente criar(@RequestBody Cliente cliente) {
        return repository.save(cliente);
    }

    @GetMapping
    public List<Cliente> listarTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> consultarPorId(@PathVariable Long id) {
        return repository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void apagar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}