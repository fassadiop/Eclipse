package sn.gouv.dpm.proprietaires;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "sn.gouv.dpm.proprietaires.client")
@EnableDiscoveryClient
public class GestionDesProprietairesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionDesProprietairesApplication.class, args);
	}

}
