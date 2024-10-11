package practica.com.parcial1.Models.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "detalles")
public class Detail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "purchase_id", nullable = false)
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @NotNull(message = "La cantidad no puede ser nula.")
    @Positive(message = "La cantidad debe ser un número positivo.")
    @Min(value = 1, message = "La cantidad debe ser al menos 1.")
    @Column(name = "amount")
    private Integer amount;

    @NotNull(message = "El precio no puede ser nulo.")
    @Positive(message = "El precio debe ser un número positivo.")
    @Column(name = "price")
    private Long price;

    @NotNull(message = "El descuento no puede ser nulo.")
    @Positive(message = "El descuento debe ser un número positivo.")
    @Column(name = "discount")
    private Long discount;
}
