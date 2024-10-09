package practica.com.parcial1.Models.DAO.user;

import org.springframework.data.jpa.repository.JpaRepository;
import practica.com.parcial1.Models.Entity.User;

import java.util.List;

public interface IUserDao {
    public List<User> findAllClients();

    public List<User> findAllAdmins();

    public void Save(User user);

    public User findOne(Long id);

    public void Delete(Long id);

    public void Drop();
}
