package th.co.aware.etda.ws.dopa;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import th.co.aware.etda.ws.dopa.entity.Address;
import th.co.aware.etda.ws.dopa.entity.Role;
import th.co.aware.etda.ws.dopa.entity.UserAccount;
import th.co.aware.etda.ws.dopa.repository.RoleRepository;
import th.co.aware.etda.ws.dopa.repository.UserAccountRepository;
import th.co.aware.etda.ws.dopa.service.DOPAService;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class InsertDataTest {

	@Autowired
	private UserAccountRepository userAccountRepo;
	@Autowired
	private RoleRepository roleRepo;
	@Autowired
	private DOPAService service;

	@Test
	public void InsertDatatoPostgresqlTest() {

		UserAccount useraccount = new UserAccount();
		Address address = new Address();
		Role role = new Role();

		role.setId("toto");
		role.setName("Admin");
		role = roleRepo.save(role);

		role.setId("A4");
		role.setName("Generic");
		role = roleRepo.save(role);

		useraccount.setId("A1");
		useraccount.setUsername(service.test("Opal"));
		useraccount.setEmail("wick");
		useraccount.setPhone("053123123");
		useraccount.setPassword("1234");
		useraccount.setExpireDate(new Date());
		useraccount.setEnabled(true);

		address.setId("A2");
		address.setCity("Chiang Mai");
		address.setStreet("Mahidol");

		useraccount.addAddress(address);
		useraccount = userAccountRepo.save(useraccount);

		useraccount
				.setRoles(StreamSupport.stream(roleRepo.findAll().spliterator(), false).collect(Collectors.toList()));

		useraccount = userAccountRepo.save(useraccount);

		Assert.assertTrue(useraccount.getAddresses().size() > 0);

		List<UserAccount> list = StreamSupport.stream(userAccountRepo.findAll().spliterator(), false)
				.collect(Collectors.toList());

		UserAccount userbyUsernameAndEmail = userAccountRepo.findByUsernameAndEmail(useraccount.getUsername(), "wick");
		List<UserAccount> userAccountIncityList = userAccountRepo.findByCity("Chiang Mai");

		System.out.println(userAccountIncityList);
		System.out.println(userbyUsernameAndEmail);
		System.out.println(list);

		userAccountRepo.deleteById("A1");
		roleRepo.deleteAll();

	}

	@Test
	public void addressTest() {
		List<UserAccount> other = userAccountRepo.findByCity("Chiang Mai");
		System.out.println(other);

	}

	@Test
	public void addMoreUser() {
		UserAccount useraccount = new UserAccount();
		useraccount.setId("SE1R");
		useraccount.setUsername("jane");
		useraccount.setEmail("wick");
		useraccount.setPhone("053123123");
		useraccount.setPassword("13456");
		useraccount.setExpireDate(new Date());
		useraccount.setEnabled(true);

		Address address = new Address();
		address.setId("A2333");
		address.setCity("Chiang Mai");
		address.setStreet("Sai Moon");

		useraccount.addAddress(address);
		useraccount = userAccountRepo.save(useraccount);

		useraccount
				.setRoles(StreamSupport.stream(roleRepo.findAll().spliterator(), false).collect(Collectors.toList()));
		useraccount = userAccountRepo.save(useraccount);

	}

	@Test
	public void deleteUser() {
		userAccountRepo.deleteById("SE1R");

	}
	
	@Test
	public void addRole() {
		UserAccount user = userAccountRepo.findByEmail("tanapat.c@aware.co.th");
		//user.setRoles(roleRepo.findByName("ADMIN"));
		user
		.setRoles(StreamSupport.stream(roleRepo.findAll().spliterator(), false).collect(Collectors.toList()));
		userAccountRepo.save(user);
	}

}