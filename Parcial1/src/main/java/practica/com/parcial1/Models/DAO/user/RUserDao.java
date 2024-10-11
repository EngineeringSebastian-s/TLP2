package practica.com.parcial1.Models.DAO.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import practica.com.parcial1.Models.Entity.User;

import java.util.List;

@Repository
public class RUserDao implements IUserDao {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<User> findAllClients() {
        return em.createQuery("from User where role='Cliente'").getResultList();
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<User> findAllAdmins() {
        return em.createQuery("from User where role='Administrador'").getResultList();
    }

    @Transactional
    @Override
    public void Save(User user) {
        try {
            if (user.getId() != null && user.getId() > 0) {
                User existingUser = em.find(User.class, user.getId());
                if (existingUser != null) {
                    // Mantener las compras existentes
                    user.setPurchases(existingUser.getPurchases());
                }
                em.merge(user);
            } else {
                // Persistir un nuevo usuario
                em.persist(user);
            }
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public User findOne(Long id) {
        return em.find(User.class, id);
    }

    @Transactional
    @Override
    public void Delete(Long id) {
        User user = findOne(id);
        if (user != null) {
            em.remove(user);
        }
    }

    @Transactional
    @Override
    public void Drop() {
        List<User> clients = findAllClients();
        for(User user : clients) {
            em.remove(user);
        }
    }

}

