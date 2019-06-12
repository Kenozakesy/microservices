package warehouseService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import warehouseService.repositories.ProductRepo;

@SpringBootApplication
@EnableEurekaClient
public class WarehouseServerApplication {

	//should be changed later

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public ProductRepo getProductRepo() { //this causes entity state problems
		return new ProductRepo();
	}

	public static void main(String[] args) {
		SpringApplication.run(WarehouseServerApplication.class, args);
	}

}
