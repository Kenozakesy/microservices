package payService.repositories;


import payService.domain.product.Product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
//@Repository
public class ProductRepo {

    @PersistenceContext
    private EntityManager em;

    public void save(Product product) { //not the best solution but manage able
        em.merge(product);
        //em.persist(product);
    }

    public Product find(long id) {
        return em.find(Product.class, id);
    }

    public List<Product> findAll() {
        return em.createQuery("SELECT l FROM Product l", Product.class)
                .getResultList();
    }

    public void update(Product product) {
        em.merge(product);
    }

    public void detach(Product account) {
        em.detach(account);
    }

    public void delete(long id) {
        Product product = em.find(Product.class, id);
        em.remove(product);
    }
}
