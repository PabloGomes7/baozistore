package com.uninter.baozistore.controller;

import com.uninter.baozistore.model.Produto;
import com.uninter.baozistore.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return repository.save(produto);
    }

    @GetMapping
    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Produto> consultarPorId(@PathVariable Long id) {
        return repository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void apagar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}