package mx.gob.imss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "mx.gob.imss")
public class CtrlArticulosApplication {

	public static void main(String[] args) {

		SpringApplication.run(CtrlArticulosApplication.class, args);
	}
	

}
