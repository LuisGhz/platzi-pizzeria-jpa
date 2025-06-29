package dev.luisghtz.platzi_pizzeria_jpa.services;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import dev.luisghtz.platzi_pizzeria_jpa.percistence.entity.PizzaEntity;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PizzaService {
  private final JdbcTemplate jdbcTemplate;

  public List<PizzaEntity> getAll() {
    return this.jdbcTemplate.query("SELECT * FROM pizza", new BeanPropertyRowMapper<>(PizzaEntity.class));
  }
}
