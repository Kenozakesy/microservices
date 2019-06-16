package orderService.repositories;

import orderService.domain.order.Deliver;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
//@Repository
public class DeliverRepo {

    @PersistenceContext
    private EntityManager em;

    public void save(Deliver deliver) {
        //em.merge(product);
        em.persist(deliver);
    }

    public Deliver find(long id) {
        return em.find(Deliver.class, id);
    }

    public List<Deliver> findAll() {
        return em.createQuery("SELECT l FROM Order l", Deliver.class)
                .getResultList();
    }

    public void update(Deliver deliver) {
        em.merge(deliver);
    }

    public void detach(Deliver deliver) {
        em.detach(deliver);
    }

    public void delete(long id) {
        Deliver product = em.find(Deliver.class, id);
        em.remove(product);
    }
}
