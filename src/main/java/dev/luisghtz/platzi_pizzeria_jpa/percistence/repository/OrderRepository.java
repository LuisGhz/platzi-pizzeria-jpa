package dev.luisghtz.platzi_pizzeria_jpa.percistence.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import dev.luisghtz.platzi_pizzeria_jpa.percistence.entity.OrderEntity;

public interface OrderRepository extends ListCrudRepository<OrderEntity, Integer> {
  List<OrderEntity> findAllByDateAfter(LocalDateTime date);
}
