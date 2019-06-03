package payService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import payService.domain.payment.Payment;
import payService.domain.payment.PaymentDTO;
import payService.domain.product.Product;
import payService.domain.product.ProductDTO;
import payService.repositories.PaymentRepo;
import payService.repositories.ProductRepo;

import java.util.List;

@RestController
@Transactional
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    PaymentRepo paymentRepo;

    public PaymentController()
    {

    }

    @GetMapping("/ping")
    public String item()
    {
        return "welkom bij payments";
    }

    @GetMapping("/{id}")
    @ResponseBody()
    public Payment getAccount(@PathVariable("id") long id)
    {
        return paymentRepo.find(id);
    }

    @GetMapping()
    @ResponseBody()
    public List<Payment> getAccounts()
    {
        return paymentRepo.findAll();
    }

    @PutMapping()
    @ResponseBody()
    public ResponseEntity<String> update(@RequestBody PaymentDTO dto) {
        Payment payment = new Payment(dto);
        paymentRepo.update(payment);
        return ResponseEntity.ok().build();
    }

    //user pays for a new product system sends message to warehouse-service
    @PostMapping()
    @ResponseBody()
    public ResponseEntity<String> save(@RequestBody PaymentDTO dto) { //does not work (detached entity)

        Payment payment = new Payment(dto);
        paymentRepo.save(payment);

        //reduce the amount of stock + order if necesary
        restTemplate.postForObject("http://warehouse-service/product/stock", payment, Payment.class);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ResponseBody()
    public ResponseEntity<String> delete(@PathVariable("id") long id) {
        paymentRepo.delete(id);
        return ResponseEntity.ok().build();
    }
}
