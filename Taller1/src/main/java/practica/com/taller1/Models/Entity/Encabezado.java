package practica.com.taller1.Models.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "encabezado")
public class Encabezado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "The clientId cannot be null")
    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @NotNull(message = "The subtotal cannot be null")
    @Column(name = "sub_total")
    private Double subTotal;

    @NotNull(message = "The total cannot be null")
    @Column(name = "total")
    private Double total;

    @Column(name = "total_discount")
    private Double totalDiscount;

    @OneToMany(mappedBy = "header", cascade = CascadeType.ALL)
    private List<Detalle> details;

    public Encabezado() {
    }

    public Encabezado(Long id, Long clientId, Date date, Double subTotal, Double total, Double totalDiscount) {
        this.id = id;
        this.clientId = clientId;
        this.date = date;
        this.subTotal = subTotal;
        this.total = total;
        this.totalDiscount = totalDiscount;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(Double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public List<Detalle> getDetails() {
        return details;
    }

    public void setDetails(List<Detalle> details) {
        this.details = details;
    }
}
