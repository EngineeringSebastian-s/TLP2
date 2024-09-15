package practica.com.taller1.Models.Enty;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @NotEmpty
    @Size(min =4, max = 15)
    @Column(name = "name")
    private String Name;

    @NotEmpty
    @Size(min =4, max = 30)
    @Column(name = "lastname")
    private String Lastname;

    @NotEmpty
    @Size(min =14, max = 60)
    @Column(name = "email")
    private String Email;

    @NotEmpty
    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date CreateAt;

    @PrePersist
    public void perPersist(){
        CreateAt = new Date();
    }

    public Cliente(Long id, String name, String lastname, String email, Date createAt) {
        Id = id;
        Name = name;
        Lastname = lastname;
        Email = email;
        CreateAt = createAt;
    }

    public Cliente(){

    }

    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getLastname() {
        return Lastname;
    }
    public void setLastname(String lastname) {
        Lastname = lastname;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public Date getCreateAt() {
        return CreateAt;
    }
    public void setCreateAt(Date createAt) {
        CreateAt = createAt;
    }


}
