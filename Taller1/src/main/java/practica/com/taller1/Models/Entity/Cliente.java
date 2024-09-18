package practica.com.taller1.Models.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "El nombre no puede estar vacío")
    @Size(min = 4, max = 15, message = "El nombre debe tener entre 4 y 15 caracteres")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "El apellido no puede estar vacío")
    @Size(min = 4, max = 30, message = "El apellido debe tener entre 4 y 30 caracteres")
    @Column(name = "lastname")
    private String lastname;

    @NotEmpty(message = "El email no puede estar vacío")
    @Size(min = 14, max = 60, message = "El email debe tener entre 14 y 60 caracteres")
    @Email(message = "El email debe ser válido")
    @Column(name = "email")
    private String email;

    @Column(name = "create_at", updatable = false)
    @Temporal(TemporalType.DATE)
    private Date createAt;

    @PrePersist
    public void perPersist() {
        createAt = new Date();
    }

    public Cliente(Long id, String name, String lastname, String email, Date createAt) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.createAt = createAt;
    }

    public Cliente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotEmpty(message = "El nombre no puede estar vacío") @Size(min = 4, max = 15, message = "El nombre debe tener entre 4 y 15 caracteres") String getName() {
        return name;
    }

    public void setName(@NotEmpty(message = "El nombre no puede estar vacío") @Size(min = 4, max = 15, message = "El nombre debe tener entre 4 y 15 caracteres") String name) {
        this.name = name;
    }

    public @NotEmpty(message = "El apellido no puede estar vacío") @Size(min = 4, max = 30, message = "El apellido debe tener entre 4 y 30 caracteres") String getLastname() {
        return lastname;
    }

    public void setLastname(@NotEmpty(message = "El apellido no puede estar vacío") @Size(min = 4, max = 30, message = "El apellido debe tener entre 4 y 30 caracteres") String lastname) {
        this.lastname = lastname;
    }

    public @NotEmpty(message = "El email no puede estar vacío") @Size(min = 14, max = 60, message = "El email debe tener entre 14 y 60 caracteres") @jakarta.validation.constraints.Email(message = "El email debe ser válido") String getEmail() {
        return email;
    }

    public void setEmail(@NotEmpty(message = "El email no puede estar vacío") @Size(min = 14, max = 60, message = "El email debe tener entre 14 y 60 caracteres") @jakarta.validation.constraints.Email(message = "El email debe ser válido") String email) {
        this.email = email;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(@NotEmpty Date createat) {
        this.createAt = createat;
    }
}
