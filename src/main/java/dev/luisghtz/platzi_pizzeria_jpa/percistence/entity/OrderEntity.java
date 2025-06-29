package dev.luisghtz.platzi_pizzeria_jpa.percistence.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pizza_order")
@Setter
@Getter
@NoArgsConstructor
public class OrderEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "id_customer", nullable = false, length = 15)
  private String idCustomer;

  @Column(nullable = false, columnDefinition = "DATETIME")
  private LocalDateTime date;

  @Column(nullable = false, columnDefinition = "DECIMAL(6,2)")
  private Double total;

  @Column(nullable = false, columnDefinition = "CHAR(1)")
  private String method;

  @Column(name = "additional_notes", length = 200)
  private String additionalNotes;

  @OneToOne
  @JoinColumn(name = "id_customer", referencedColumnName = "id", insertable = false, updatable = false)
  private CustomerEntity customer;

  @OneToMany(mappedBy = "order")
  private List<OrderItemEntity> items;
}
