package dev.luisghtz.platzi_pizzeria_jpa.percistence.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import dev.luisghtz.platzi_pizzeria_jpa.percistence.entity.OrderEntity;

public interface OrderRepository extends ListCrudRepository<OrderEntity, Integer> {
  List<OrderEntity> findAllByDateAfter(LocalDateTime date);

  List<OrderEntity> findAllByMethodIn(List<String> methods);

  @Query(value = "SELECT * FROM pizza_order WHERE id_customer = :idCustomer", nativeQuery = true)
  List<OrderEntity> findCustomerOrders(@Param("idCustomer") String idCustomer);
}
