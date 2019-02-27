package th.co.aware.etda.ws.dopa.service;

import java.sql.Timestamp;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import th.co.aware.etda.ws.dopa.entity.UserAccount;
import th.co.aware.etda.ws.dopa.repository.RoleRepository;
import th.co.aware.etda.ws.dopa.repository.UserAccountRepository;
import th.co.aware.etda.ws.dopa.web.form.RegisterForm;

@Service
public class UserAccountServiceImpl implements UserAccountService {
	@Autowired
	private UserAccountRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void create(RegisterForm form) {

		UserAccount user = new UserAccount();
		String randId = UUID.randomUUID().toString().toUpperCase().replaceAll("-","");

		user.setId(randId);
		user.setUsername(form.getName());
		user.setEmail(form.getEmail());
		user.setPhone(form.getPhone());
		user.setPassword(passwordEncoder.encode(form.getPassword()));
		user.setRoles(roleRepository.findByName("USER"));
		user.setExpireDate(new Timestamp(System.currentTimeMillis()));
		user.setEnabled(true);
		userRepository.save(user);
	}

	@Override
	public UserAccount findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}