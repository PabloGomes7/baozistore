package com.uninter.baozistore.controller;

import com.uninter.baozistore.model.Pedido;
import com.uninter.baozistore.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    @PostMapping
    public Pedido criar(@RequestBody Pedido pedido) {
        return repository.save(pedido);
    }

    @GetMapping
    public List<Pedido> listarTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Pedido> consultarPorId(@PathVariable Long id) {
        return repository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void apagar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}