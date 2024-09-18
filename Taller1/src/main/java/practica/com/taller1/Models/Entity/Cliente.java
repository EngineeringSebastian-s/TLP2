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
    private Long Id;

    @NotEmpty(message = "El nombre no puede estar vacío")
    @Size(min = 4, max = 15, message = "El nombre debe tener entre 4 y 15 caracteres")
    @Column(name = "name")
    private String Name;

    @NotEmpty(message = "El apellido no puede estar vacío")
    @Size(min = 4, max = 30, message = "El apellido debe tener entre 4 y 30 caracteres")
    @Column(name = "lastname")
    private String Lastname;

    @NotEmpty(message = "El email no puede estar vacío")
    @Size(min = 14, max = 60, message = "El email debe tener entre 14 y 60 caracteres")
    @Email(message = "El email debe ser válido")
    @Column(name = "email")
    private String Email;

    @NotEmpty
    @Column(name = "create_at", updatable = false)
    @Temporal(TemporalType.DATE)
    private Date CreateAt;

    @PrePersist
    public void perPersist() {
        CreateAt = new Date();
    }

    public Cliente(Long id, String name, String lastname, String email, Date createAt) {
        Id = id;
        Name = name;
        Lastname = lastname;
        Email = email;
        CreateAt = createAt;
    }

    public Cliente() {
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

    public @NotEmpty(message = "El apellido no puede estar vacío") @Size(min = 4, max = 30, message = "El apellido debe tener entre 4 y 30 caracteres") String getLastname() {
        return Lastname;
    }

    public void setLastname(@NotEmpty(message = "El apellido no puede estar vacío") @Size(min = 4, max = 30, message = "El apellido debe tener entre 4 y 30 caracteres") String lastname) {
        Lastname = lastname;
    }

    public @NotEmpty(message = "El email no puede estar vacío") @Size(min = 14, max = 60, message = "El email debe tener entre 14 y 60 caracteres") @jakarta.validation.constraints.Email(message = "El email debe ser válido") String getEmail() {
        return Email;
    }

    public void setEmail(@NotEmpty(message = "El email no puede estar vacío") @Size(min = 14, max = 60, message = "El email debe tener entre 14 y 60 caracteres") @jakarta.validation.constraints.Email(message = "El email debe ser válido") String email) {
        Email = email;
    }

    public @NotEmpty Date getCreateAt() {
        return CreateAt;
    }

    public void setCreateAt(@NotEmpty Date createAt) {
        CreateAt = createAt;
    }
}
