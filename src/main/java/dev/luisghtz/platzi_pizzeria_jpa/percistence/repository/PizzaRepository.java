package dev.luisghtz.platzi_pizzeria_jpa.percistence.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import dev.luisghtz.platzi_pizzeria_jpa.percistence.entity.PizzaEntity;

public interface PizzaRepository extends CrudRepository<PizzaEntity, Integer> {
  List<PizzaEntity> findAllByAvailableTrueOrderByPrice();

  List<PizzaEntity> findAllByAvailableTrueAndNameIgnoreCase(String name);
}
