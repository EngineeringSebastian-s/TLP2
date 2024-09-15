package practica.com.taller1.Models.DAO.cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;
import practica.com.taller1.Models.Entity.Cliente;

import java.util.List;

@Repository
public class ClienteDaoImp implements IClienteDao {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Cliente> findAll() {
        return em.createQuery("from Cliente").getResultList();
    }

    @Transactional
    @Override
    public void Save(Cliente cliente) {

        if(cliente.getId()!=null && cliente.getId()>0){
            em.merge(cliente);
        }
        else{
            em.persist(cliente);
        }

    }

    @Transactional(readOnly = true)
    @Override
    public Cliente findOne(Long id) {
        return em.find(Cliente.class, id);
    }

    @Transactional
    @Override
    public void Delete(Long id) {
        Cliente cliente=findOne(id);
        em.remove(cliente);
    }


}

