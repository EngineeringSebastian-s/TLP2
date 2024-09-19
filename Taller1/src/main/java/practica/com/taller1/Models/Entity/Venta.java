package practica.com.taller1.Models.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


import java.io.Serializable;
import java.util.Date;

@Entity
public class Venta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    @NotNull(message = "El cliente no puede ser nulo")
    private Cliente client;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    @NotNull(message = "El producto no puede ser nulo")
    private Producto product;

    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    @Max(value = 1000, message = "La cantidad no puede ser mayor a 1000")
    private int amount;

    @Column(name = "create_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @PrePersist
    public void prePersist() {
        createAt = new Date();
    }

    public Venta(Long id, Cliente client, Producto product, int amount, Date createAt) {
        this.id = id;
        this.client = client;
        this.product = product;
        this.amount = amount;
        this.createAt = createAt;
    }

    public Venta() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "El cliente no puede ser nulo") Cliente getClient() {
        return client;
    }

    public void setClient(@NotNull(message = "El cliente no puede ser nulo") Cliente client) {
        this.client = client;
    }

    public @NotNull(message = "El producto no puede ser nulo") Producto getProduct() {
        return product;
    }

    public void setProduct(@NotNull(message = "El producto no puede ser nulo") Producto product) {
        this.product = product;
    }

    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    @Max(value = 1000, message = "La cantidad no puede ser mayor a 1000")
    public int getAmount() {
        return amount;
    }

    public void setAmount(@Min(value = 1, message = "La cantidad debe ser al menos 1") @Max(value = 1000, message = "La cantidad no puede ser mayor a 1000") int amount) {
        this.amount = amount;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
