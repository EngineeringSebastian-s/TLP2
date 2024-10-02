package practica.com.taller1.Models.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "detalle")
public class Detalle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "The headerId cannot be null")
    @Column(name = "header_id")
    private Long headerId;

    @NotNull(message = "The productId cannot be null")
    @Column(name = "product_id")
    private Long productId;

    @NotNull(message = "The quantity cannot be null")
    @Column(name = "quantity")
    private Integer quantity;

    @NotNull(message = "The value cannot be null")
    @Column(name = "cost")
    private Double value;

    @Column(name = "discount")
    private Double discount;

    @ManyToOne
    @JoinColumn(name = "header_id", insertable = false, updatable = false)
    private Encabezado header;

    public Detalle() {
    }

    public Detalle(Long id, Long headerId, Long productId, Integer quantity, Double value, Double discount) {
        this.id = id;
        this.headerId = headerId;
        this.productId = productId;
        this.quantity = quantity;
        this.value = value;
        this.discount = discount;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHeaderId() {
        return headerId;
    }

    public void setHeaderId(Long headerId) {
        this.headerId = headerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Encabezado getHeader() {
        return header;
    }

    public void setHeader(Encabezado header) {
        this.header = header;
    }
}
