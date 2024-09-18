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
    private Long Id;

    @NotEmpty(message = "El nombre no puede estar vacío")
    @Size(min = 4, max = 15, message = "El nombre debe tener entre 4 y 15 caracteres")
    @Column(name = "name")
    private String Name;

    @NotEmpty(message = "La descripción no puede estar vacía")
    @Size(min = 10, max = 120, message = "La descripción debe tener entre 10 y 120 caracteres")
    @Column(name = "description")
    private String Description;

    @NotNull(message = "El valor unitario no puede ser nulo")
    @Positive(message = "El valor unitario debe ser positivo")
    @Column(name = "unit_value")
    private Long UniValue;

    @NotNull(message = "El stock no puede ser nulo")
    @Positive(message = "El stock debe ser positivo")
    @Column(name = "stock")
    private Long Stock;

    public Producto(Long id, String name, String description, Long uniValue, Long stock) {
        Id = id;
        Name = name;
        Description = description;
        UniValue = uniValue;
        Stock = stock;
    }

    public Producto() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public @NotEmpty(message = "El nombre no puede estar vacío") @Size(min = 4, max = 15, message = "El nombre debe tener entre 4 y 15 caracteres") String getName() {
        return Name;
    }

    public void setName(@NotEmpty(message = "El nombre no puede estar vacío") @Size(min = 4, max = 15, message = "El nombre debe tener entre 4 y 15 caracteres") String name) {
        Name = name;
    }

    public @NotEmpty(message = "La descripción no puede estar vacía") @Size(min = 10, max = 120, message = "La descripción debe tener entre 10 y 120 caracteres") String getDescription() {
        return Description;
    }

    public void setDescription(@NotEmpty(message = "La descripción no puede estar vacía") @Size(min = 10, max = 120, message = "La descripción debe tener entre 10 y 120 caracteres") String description) {
        Description = description;
    }

    public @NotNull(message = "El valor unitario no puede ser nulo") @Positive(message = "El valor unitario debe ser positivo") Long getUniValue() {
        return UniValue;
    }

    public void setUniValue(@NotNull(message = "El valor unitario no puede ser nulo") @Positive(message = "El valor unitario debe ser positivo") Long uniValue) {
        UniValue = uniValue;
    }

    public @NotNull(message = "El stock no puede ser nulo") @Positive(message = "El stock debe ser positivo") Long getStock() {
        return Stock;
    }

    public void setStock(@NotNull(message = "El stock no puede ser nulo") @Positive(message = "El stock debe ser positivo") Long stock) {
        Stock = stock;
    }
}
