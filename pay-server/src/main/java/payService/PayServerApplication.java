package payService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import payService.repositories.PaymentRepo;
import payService.repositories.ProductRepo;

@SpringBootApplication
public class PayServerApplication {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public ProductRepo getProductRepo() {
		return new ProductRepo();
	}

	@Bean
	public PaymentRepo getPaymentRepo() {
		return new PaymentRepo();
	}

	public static void main(String[] args) {
		SpringApplication.run(PayServerApplication.class, args);
	}

}
