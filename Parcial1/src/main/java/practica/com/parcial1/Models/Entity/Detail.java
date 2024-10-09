package practica.com.parcial1.Models.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "detalles")
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "purchase_id", nullable = false)
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name = "inventory_id", nullable = false)
    private Inventory product;

    @NotNull
    @Column(name = "amount")
    private Integer amount;

    @NotNull
    @Column(name = "price")
    private Long price;

    @NotNull
    @Column(name = "discount")
    private Long discount;
}
