package practica.com.parcial1.Models.DAO.user;

import practica.com.parcial1.Models.Entity.User;

import java.util.List;

public interface IUserDao {
    List<User> findAllClients();

    List<User> findAnotherClients(Long id);

    List<User> findAllAdmins();

    void Save(User user);

    User findOne(Long id);

    void Delete(Long id);

    void Drop();
}
