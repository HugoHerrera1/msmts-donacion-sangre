package mx.gob.imss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "mx.gob.imss")
@EnableCaching
public class DonacionSangreApplication {

	public static void main(String[] args) {

		SpringApplication.run(DonacionSangreApplication.class, args);
	}
	

}
