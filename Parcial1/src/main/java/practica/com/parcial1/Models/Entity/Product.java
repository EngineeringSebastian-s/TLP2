package practica.com.parcial1.Models.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "productos")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "El nombre no puede estar vacío")
    @Size(min = 4, max = 15, message = "El nombre debe tener entre 4 y 15 caracteres")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "La descripción no puede estar vacía")
    @Size(min = 10, max = 120, message = "La descripción debe tener entre 10 y 120 caracteres")
    @Column(name = "description")
    private String description;

    @NotNull(message = "El valor unitario no puede ser nulo")
    @Positive(message = "El valor unitario debe ser positivo")
    @Column(name = "unit_value")
    private Long unitValue;

    @NotNull(message = "El stock no puede ser nulo")
    @Positive(message = "El stock debe ser positivo")
    @Column(name = "stock")
    private Long stock;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Detail> details;
}
