package dev.luisghtz.platzi_pizzeria_jpa.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.luisghtz.platzi_pizzeria_jpa.percistence.entity.PizzaEntity;
import dev.luisghtz.platzi_pizzeria_jpa.services.PizzaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/pizzas")
@RequiredArgsConstructor
public class PizzaController {
  private final PizzaService pizzaService;

  @GetMapping
  public ResponseEntity<List<PizzaEntity>> getAll() {
    return ResponseEntity.ok(pizzaService.getAll());
  }

  @GetMapping("{id}")
  public ResponseEntity<PizzaEntity> getById(@PathVariable int id) {
    return ResponseEntity.ok(pizzaService.getById(id));
  }

}