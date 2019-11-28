package br.com.ifsp.eol;

import br.com.ifsp.eol.model.Location;
import br.com.ifsp.eol.model.ServiceOrder;
import br.com.ifsp.eol.model.User;
import br.com.ifsp.eol.model.enums.Role;
import br.com.ifsp.eol.model.enums.TypeOrder;
import br.com.ifsp.eol.repositories.LocationRepository;
import br.com.ifsp.eol.repositories.ServiceOrderRepository;
import br.com.ifsp.eol.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EolApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ServiceOrderRepository serviceOrderRepository;

	@Autowired
	private LocationRepository locationRepository;

	public static void main(String[] args) {
		SpringApplication.run(EolApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		User user1 = new User("Gabriel", "biel.muitoloko@gmail.com", "123456","175673", "123");
		userRepository.save(user1);
		User user2 = new User("Caio", "caio.muitoloko@gmail.com", "123456","175673", "123");
		user2.addRole(Role.INSTALLER);
		userRepository.save(user2);

		Location location = new Location("rua","ads","asda","safa","asdaf");
		locationRepository.save(location);

		ServiceOrder serviceOrder = new ServiceOrder();
		serviceOrder.setClient(user1);
		serviceOrder.setInstaller(user2);
		serviceOrder.setLocation(location);
		serviceOrder.setTypeOrder(TypeOrder.MONO);
		serviceOrderRepository.save(serviceOrder);


	}
}
