package warehouseService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import warehouseService.domain.Transfer.IsCheck;
import warehouseService.domain.order.Deliver;
import warehouseService.domain.order.DeliverDTO;
import warehouseService.domain.payment.Payment;
import warehouseService.domain.product.Product;
import warehouseService.domain.product.ProductDTO;
import warehouseService.repositories.ProductRepo;
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

    @PutMapping("/updateStock")
    @ResponseBody()
    public ResponseEntity<String> update(@RequestBody Deliver deliver) {
        Product product = productRepo.find(deliver.getProductId());
        product.setAmount(product.getAmount() + deliver.getAmount());
        productRepo.update(product);
        return ResponseEntity.ok().build();
    }

    @PostMapping()
    @ResponseBody()
    public ResponseEntity<String> save(@RequestBody ProductDTO dto) {
        Product product = new Product(dto);
        productRepo.save(product);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/stock")
    @ResponseBody
    public IsCheck reduceStock(@RequestBody Payment payment) {

        Product product = productRepo.find(payment.getProductId());
        double totalpay = product.getPrice() * payment.getAmount();

        //calculate payment here
        if(payment.getPayment() >= totalpay) {

            //reduce stock here
            if(product.getAmount() - payment.getAmount() >= 0) {
                product.setAmount(product.getAmount() - payment.getAmount());
                productRepo.update(product);
            } else {
                return new IsCheck(false, "not enough products available", payment.getPayment());
            }
            //order more stock if neccesary
            double procent = (double) product.getAmount() / product.getMaxAmount() * 100;
            if(procent <= 20) {
                //order new product
                DeliverDTO order = new DeliverDTO(payment.getProductId(), product.getMaxAmount() - product.getAmount());
                restTemplate.postForObject("http://deliver-service/deliver", order, DeliverDTO.class);
            }
            double refund = payment.getPayment() - totalpay;
            return new IsCheck(true, "payment succeeded", refund);
        } else {
            return new IsCheck(false, "not enough money", payment.getPayment());
        }
    }

    @DeleteMapping("/{id}")
    @ResponseBody()
    public ResponseEntity<String> delete(@PathVariable("id") long id) {
        productRepo.delete(id);
        return ResponseEntity.ok().build();
    }
}
