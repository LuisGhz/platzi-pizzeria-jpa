package dev.luisghtz.platzi_pizzeria_jpa.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

  public List<OrderEntity> getAllAfterDate() {
    LocalDateTime today = LocalDate.now().atTime(0, 0);
    return orderRepository.findAllByDateAfter(today);
  }
}
