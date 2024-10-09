package practica.com.parcial1.Models.DAO.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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

        if (user.getId() != null && user.getId() > 0) {
            em.merge(user);
        } else {
            em.persist(user);
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
        em.remove(user);
    }

    @Transactional
    @Override
    public void Drop() {
        em.createQuery("delete from Detail ").executeUpdate();
        em.createQuery("delete from Purchase").executeUpdate();
        em.createQuery("delete from User ").executeUpdate();
    }

}

