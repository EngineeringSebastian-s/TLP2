package practica.com.taller1.Models.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

@Entity
@Table(name="productos")
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @NotEmpty
    @Size(min =4, max = 15)
    @Column(name = "name")
    private String Name;

    @NotEmpty
    @Size(min =10, max = 120)
    @Column(name = "description")
    private String Description;
}
