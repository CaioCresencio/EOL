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
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class EolApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ServiceOrderRepository serviceOrderRepository;

	@Autowired
	private LocationRepository locationRepository;
	@Autowired
	PasswordEncoder ps;

	public static void main(String[] args) {
		SpringApplication.run(EolApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		/*User user1 = new User("Gabriel", "biel.muitoloko@gmail.com", "123456","175673", "123");
		userRepository.save(user1);




		ServiceOrder serviceOrder = new ServiceOrder();
		serviceOrder.setClient(user1);
		serviceOrder.setInstaller(user2);
		serviceOrder.setLocation(location);
		serviceOrder.setTypeOrder(TypeOrder.MONO);
		serviceOrderRepository.save(serviceOrder);*/


		User user = new User("Admin", "admin@eol.com", "123456","175673", ps.encode("123"));
		user.addRole(Role.ADMIN);
		User user1 = new User("Caio", "caiocresencio98@gmail.com", "123f456","175673", ps.encode("123"));
		user1.addRole(Role.USER);
		userRepository.save(user);
		userRepository.save(user1);

		User user2 = new User("Instalador", "caio.muitoloko@gmail.com", "123456","175673", "123");
		user2.addRole(Role.INSTALLER);
		userRepository.save(user2);


		User user3 = new User("Instalador 2", "installermuitoloko@gmail.com", "123456","175673", "123");
		user2.addRole(Role.INSTALLER);
		userRepository.save(user3);

		ServiceOrder serviceOrder = new ServiceOrder();
		serviceOrder.setClient(user1);
		ServiceOrder serviceOrder2 = new ServiceOrder();
		serviceOrder.setClient(user1);
		ServiceOrder serviceOrder3 = new ServiceOrder();
		serviceOrder.setClient(user1);


		Location location = new Location("rua","ads","asda","safa","asdaf");
		locationRepository.save(location);

		serviceOrder.setInstaller(user2);
		serviceOrder.setLocation(location);
		serviceOrder.setTypeOrder(TypeOrder.MONO);
		serviceOrderRepository.save(serviceOrder);

		serviceOrder2.setInstaller(user2);
		serviceOrder2.setLocation(location);
		serviceOrder2.setTypeOrder(TypeOrder.MONO);
		serviceOrderRepository.save(serviceOrder2);

		serviceOrder3.setInstaller(user3);
		serviceOrder3.setLocation(location);
		serviceOrder3.setTypeOrder(TypeOrder.MONO);
		serviceOrderRepository.save(serviceOrder3);
	}

}
