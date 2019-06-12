package warehouseService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import warehouseService.domain.payment.Payment;
import warehouseService.domain.product.Product;
import warehouseService.domain.product.ProductDTO;
import warehouseService.repositories.ProductRepo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.validation.Valid;
import java.util.List;


@RestController
@Transactional
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    ProductRepo productRepo;

    public ProductController()
    {

    }

    @GetMapping("/ping")
    public String item()
    {
        return "welkom bij products";
    }

    @GetMapping("/{productId}")
    @ResponseBody()
    public Product getAccount(@PathVariable("productId") long id)
    {
        return productRepo.find(id);
    }

    @GetMapping()
    @ResponseBody()
    public List<Product> getAccounts()
    {
        return productRepo.findAll();
    }

    @PutMapping()
    @ResponseBody()
    public ResponseEntity<String> update(@RequestBody ProductDTO dto) {
        Product product = new Product(dto);
        productRepo.update(product);
        return ResponseEntity.ok().build();
    }

    @PostMapping()
    @ResponseBody()
    public ResponseEntity<String> save(@RequestBody ProductDTO dto) { //does not work (detached entity)
        Product product = new Product(dto);
        productRepo.save(product);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/stock")
    @ResponseBody()
    public void reduceStock(@RequestBody Payment payment) { //does not work (detached entity)
        Product product = productRepo.find(payment.getProductId());
        product.setAmount(product.getAmount() - payment.getAmount());

        double procent = (double) product.getAmount() / product.getMaxAmount() * 100;
        productRepo.update(product);

        if(procent <= 20) {
            //order new product
        }
    }

    @DeleteMapping("/{id}")
    @ResponseBody()
    public ResponseEntity<String> delete(@PathVariable("id") long id) {
        productRepo.delete(id);
        return ResponseEntity.ok().build();
    }
}
