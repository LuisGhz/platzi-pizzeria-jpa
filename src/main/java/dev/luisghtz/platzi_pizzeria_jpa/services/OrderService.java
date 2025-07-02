package dev.luisghtz.platzi_pizzeria_jpa.services;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.luisghtz.platzi_pizzeria_jpa.percistence.entity.OrderEntity;
import dev.luisghtz.platzi_pizzeria_jpa.percistence.repository.OrderRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
  private final OrderRepository orderRepository;

  public List<OrderEntity> getAll() {
    return orderRepository.findAll();
  }
}
