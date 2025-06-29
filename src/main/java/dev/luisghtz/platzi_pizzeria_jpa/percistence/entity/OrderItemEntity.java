package dev.luisghtz.platzi_pizzeria_jpa.percistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_item")
@IdClass(OrderItemId.class)
@Setter
@Getter
@NoArgsConstructor
public class OrderItemEntity {
  @Id
  @Column(name = "id_order", nullable = false)
  private Integer idOrder;

  @Id
  @Column(name = "id_item", nullable = false)
  private Integer idItem;

  @Column(nullable = false, columnDefinition = "DECIMAL(2,1)")
  private Double quantity;

  @Column(nullable = false, columnDefinition = "DECIMAL(5,2)")
  private Double price;
}
