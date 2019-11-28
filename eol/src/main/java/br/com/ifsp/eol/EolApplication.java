package br.com.ifsp.eol;

import br.com.ifsp.eol.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EolApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(EolApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		User user = new User("Gabriel", "biel.muitoloko@gmail.com", "123456","175673", "123");
		//userRepository.save(user);
	}
}
