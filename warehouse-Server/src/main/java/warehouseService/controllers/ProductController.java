package warehouseService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
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
        return ResponseEntity.ok()
                .header("Custom-Header", "foo")
                .body("Custom header set");
    }

    @PostMapping()
    @ResponseBody()
    public ResponseEntity<String> save(@RequestBody ProductDTO dto) { //does not work (detached entity)
        Product product = new Product(dto);
        productRepo.save(product);
        return ResponseEntity.ok()
                .header("Custom-Header", "foo")
                .body("Custom header set");
    }

    @DeleteMapping("/{id}")
    @ResponseBody()
    public ResponseEntity<String> delete(@PathVariable("id") long id) {
        productRepo.delete(id);
        return ResponseEntity.ok()
                .header("Custom-Header", "foo")
                .body("Custom header set");
    }
}
