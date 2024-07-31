package sn.gouv.dpm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import sn.gouv.dpm.embarcations.repository.PirogueRepository;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"sn.gouv.dpm.gateway", "sn.gouv.dpm.user"})
@ComponentScan(basePackages = {"sn.gouv.dpm.gateway", "sn.gouv.dpm.user"}, excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {PirogueRepository.class}))
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
