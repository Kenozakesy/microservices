package payService.repositories;


import payService.domain.payment.Payment;
import payService.domain.product.Product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
//@Repository
public class PaymentRepo {

    @PersistenceContext
    private EntityManager em;

    public void save(Payment payment) { //not the best solution but manage able
        em.merge(payment);
        //em.persist(product);
    }

    public Payment find(long id) {
        return em.find(Payment.class, id);
    }

    public List<Payment> findAll() {
        return em.createQuery("SELECT l FROM Payment l", Payment.class)
                .getResultList();
    }

    public void update(Payment payment) {
        em.merge(payment);
    }

    public void detach(Payment payment) {
        em.detach(payment);
    }

    public void delete(long id) {
        Payment payment = em.find(Payment.class, id);
        em.remove(payment);
    }
}
