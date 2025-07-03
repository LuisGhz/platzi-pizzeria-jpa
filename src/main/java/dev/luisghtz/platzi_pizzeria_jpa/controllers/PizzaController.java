package dev.luisghtz.platzi_pizzeria_jpa.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.luisghtz.platzi_pizzeria_jpa.percistence.entity.PizzaEntity;
import dev.luisghtz.platzi_pizzeria_jpa.services.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/pizzas")
@RequiredArgsConstructor
public class PizzaController {
  private final PizzaService pizzaService;

  @GetMapping
  public ResponseEntity<List<PizzaEntity>> getAll() {
    return ResponseEntity.ok(pizzaService.getAll());
  }

  @GetMapping("available")
  public ResponseEntity<List<PizzaEntity>> getAavailable() {
    return ResponseEntity.ok(pizzaService.getAvailable());
  }

  @GetMapping("byname")
  public ResponseEntity<List<PizzaEntity>> getMethodName(@RequestParam String name) {
    return ResponseEntity.ok(pizzaService.getByName(name));
  }

  @GetMapping("{id}")
  public ResponseEntity<PizzaEntity> getById(@PathVariable int id) {
    return ResponseEntity.ok(pizzaService.getById(id));
  }

  @PostMapping
  public ResponseEntity<PizzaEntity> save(@RequestBody PizzaEntity entity) {
    if (entity.getId() == null || !pizzaService.exist(entity.getId())) {
      return new ResponseEntity<>(pizzaService.save(entity), HttpStatus.CREATED);
    }

    return ResponseEntity.badRequest().build();
  }

  @PutMapping
  public ResponseEntity<PizzaEntity> update(@RequestBody PizzaEntity entity) {
    if (entity.getId() != null || pizzaService.exist(entity.getId())) {
      return new ResponseEntity<>(pizzaService.save(entity), HttpStatus.CREATED);
    }

    return ResponseEntity.badRequest().build();
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Void> delete(@PathVariable int id) {
    if (pizzaService.exist(id))
      pizzaService.delete(id);

    return ResponseEntity.noContent().build();
  }

}