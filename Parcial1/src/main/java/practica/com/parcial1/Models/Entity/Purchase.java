package practica.com.parcial1.Models.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "compras")
public class Purchase implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull(message = "Debes seleccionar un usuario")
    private User user;

    @Column(name = "create_at", updatable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @PrePersist
    public void perPersist() {
        date = new Date();
    }

    @NotNull
    @Column(name = "subtotal")
    private Long subTotal;

    @NotNull
    @Column(name = "total")
    private Long total;

    @NotNull
    @Column(name = "discount_total")
    private Long discountTotal;

    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Detail> details = new ArrayList<>();
}
