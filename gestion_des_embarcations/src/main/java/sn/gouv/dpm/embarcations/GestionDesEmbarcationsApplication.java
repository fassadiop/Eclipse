package sn.gouv.dpm.embarcations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class GestionDesEmbarcationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionDesEmbarcationsApplication.class, args);
	}

}
