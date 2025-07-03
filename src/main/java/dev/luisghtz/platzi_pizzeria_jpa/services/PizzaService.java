package dev.luisghtz.platzi_pizzeria_jpa.services;

import java.util.List;

// import org.springframework.jdbc.core.BeanPropertyRowMapper;
// import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import dev.luisghtz.platzi_pizzeria_jpa.percistence.entity.PizzaEntity;
import dev.luisghtz.platzi_pizzeria_jpa.percistence.repository.PizzaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PizzaService {
  // private final JdbcTemplate jdbcTemplate;
  private final PizzaRepository pizzaRepository;

  public List<PizzaEntity> getAll() {
    return (List<PizzaEntity>) pizzaRepository.findAll();
    // return this.jdbcTemplate.query("SELECT * FROM pizza", new
    // BeanPropertyRowMapper<>(PizzaEntity.class));
  }

  public List<PizzaEntity> getAvailable() {
    return pizzaRepository.findAllByAvailableTrueOrderByPrice();
  }

  public List<PizzaEntity> getByName(String name) {
    return pizzaRepository.findAllByAvailableTrueAndNameIgnoreCase(name);
  }

  public List<PizzaEntity> getWith(String ingredient) {
    return pizzaRepository.findAllByAvailableTrueAndDescriptionContainingIgnoreCase(ingredient);
  }

  public List<PizzaEntity> getWithout(String ingredient) {
    return pizzaRepository.findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(ingredient);
  }

  public PizzaEntity getById(int id) {
    return pizzaRepository.findById(id).orElse(null);
  }

  public PizzaEntity save(PizzaEntity pizza) {
    return pizzaRepository.save(pizza);
  }

  public void delete(int id) {
    pizzaRepository.deleteById(id);
  }

  public Boolean exist(int id) {
    return pizzaRepository.existsById(id);
  }
}
