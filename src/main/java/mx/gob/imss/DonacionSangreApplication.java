package mx.gob.imss;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "mx.gob.imss")
@OpenAPIDefinition(info = @Info(title = "Donacion de Sangre"))
@EnableCaching
public class DonacionSangreApplication {

	public static void main(String[] args) {

		SpringApplication.run(DonacionSangreApplication.class, args);
	}
	

}
