package practica.com.taller1.Models.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

@Entity
@Table(name = "productos")
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "El nombre no puede estar vacío")
    @Size(min = 4, max = 15, message = "El nombre debe tener entre 4 y 15 caracteres")
    @Column(name = "name")
    private String Name;

    @NotEmpty(message = "La descripción no puede estar vacía")
    @Size(min = 10, max = 120, message = "La descripción debe tener entre 10 y 120 caracteres")
    @Column(name = "description")
    private String description;

    @NotNull(message = "El valor unitario no puede ser nulo")
    @Positive(message = "El valor unitario debe ser positivo")
    @Column(name = "unit_value")
    private Long uniValue;

    @NotNull(message = "El stock no puede ser nulo")
    @Positive(message = "El stock debe ser positivo")
    @Column(name = "stock")
    private Long stock;

    public Producto(Long id, String name, String description, Long uniValue, Long stock) {
        this.id = id;
        Name = name;
        this.description = description;
        this.uniValue = uniValue;
        this.stock = stock;
    }

    public Producto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotEmpty(message = "El nombre no puede estar vacío") @Size(min = 4, max = 15, message = "El nombre debe tener entre 4 y 15 caracteres") String getName() {
        return Name;
    }

    public void setName(@NotEmpty(message = "El nombre no puede estar vacío") @Size(min = 4, max = 15, message = "El nombre debe tener entre 4 y 15 caracteres") String name) {
        Name = name;
    }

    public @NotEmpty(message = "La descripción no puede estar vacía") @Size(min = 10, max = 120, message = "La descripción debe tener entre 10 y 120 caracteres") String getDescription() {
        return description;
    }

    public void setDescription(@NotEmpty(message = "La descripción no puede estar vacía") @Size(min = 10, max = 120, message = "La descripción debe tener entre 10 y 120 caracteres") String description) {
        this.description = description;
    }

    public @NotNull(message = "El valor unitario no puede ser nulo") @Positive(message = "El valor unitario debe ser positivo") Long getUniValue() {
        return uniValue;
    }

    public void setUniValue(@NotNull(message = "El valor unitario no puede ser nulo") @Positive(message = "El valor unitario debe ser positivo") Long uniValue) {
        this.uniValue = uniValue;
    }

    public @NotNull(message = "El stock no puede ser nulo") @Positive(message = "El stock debe ser positivo") Long getStock() {
        return stock;
    }

    public void setStock(@NotNull(message = "El stock no puede ser nulo") @Positive(message = "El stock debe ser positivo") Long stock) {
        this.stock = stock;
    }
}
