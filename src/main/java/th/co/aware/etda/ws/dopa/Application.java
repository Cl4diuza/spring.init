package th.co.aware.etda.ws.dopa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
		System.out.println("System Deployed");
	}
}