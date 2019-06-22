package orderService.controllers;

import orderService.domain.order.Deliver;
import orderService.domain.order.DeliverDTO;
import orderService.repositories.DeliverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;


@RestController
@Transactional
@RequestMapping("/deliver")
public class DeliverController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    DeliverRepo deliverRepo;

    public DeliverController()
    {

    }

    @GetMapping("/ping")
    public String item()
    {
        return "welkom bij deliver";
    }

    @GetMapping("/{productId}")
    @ResponseBody()
    public Deliver getAccount(@PathVariable("productId") long id)
    {
        return deliverRepo.find(id);
    }

    @GetMapping()
    @ResponseBody()
    public List<Deliver> getAccounts()
    {
        return deliverRepo.findAll();
    }

    @PutMapping()
    @ResponseBody()
    public ResponseEntity<String> update(@RequestBody DeliverDTO dto) {
        Deliver deliver = new Deliver(dto);
        deliverRepo.update(deliver);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @ResponseBody()
    public ResponseEntity<String> updateDelivered(@PathVariable("id") long id) {
        Deliver deliver = deliverRepo.find(id);

        //can only accept order once
        if(!deliver.isDelivered()) {
            //here update product amount
            restTemplate.put("http://warehouse-service/product/updateStock", deliver, Deliver.class); //this still has to be tested
        }

        deliver.setDelivered(true);
        deliverRepo.update(deliver);
        return ResponseEntity.ok().build();
    }

    @PostMapping()
    @ResponseBody()
    public ResponseEntity<String> save(@RequestBody DeliverDTO dto) {
        //check if product order already exists
        if(deliverRepo.isOrdered(dto.getProductId())) {
            //only execute if order does not already exist
            Deliver deliver = new Deliver(dto);
            deliverRepo.save(deliver);
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ResponseBody()
    public ResponseEntity<String> delete(@PathVariable("id") long id) {
        deliverRepo.delete(id);
        return ResponseEntity.ok().build();
    }
}
