package sn.gouv.dpm.embarcations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GestionDesPermispecheApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionDesPermispecheApplication.class, args);
	}

}
