package dev.luisghtz.platzi_pizzeria_jpa.percistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import dev.luisghtz.platzi_pizzeria_jpa.percistence.entity.PizzaEntity;

public interface PizzaRepository extends CrudRepository<PizzaEntity, Integer> {
  List<PizzaEntity> findAllByAvailableTrueOrderByPrice();

  List<PizzaEntity> findAllByAvailableTrueAndNameIgnoreCase(String name);

  Optional<PizzaEntity> findFirstByAvailableTrueAndNameIgnoreCase(String name);

  List<PizzaEntity> findAllByAvailableTrueAndDescriptionContainingIgnoreCase(String description);

  List<PizzaEntity> findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(String description);

  long countByVeganTrue();
}
