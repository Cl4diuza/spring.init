package th.co.aware.etda.ws.dopa.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import th.co.aware.etda.ws.dopa.entity.Role;
import th.co.aware.etda.ws.dopa.entity.UserAccount;
import th.co.aware.etda.ws.dopa.repository.UserAccountRepository;

@Service("userAccountDetailService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserAccountRepository userRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		System.out.println("email: " + email);
		UserAccount user = userRepository.findByEmail(email);
		List<String> roles = new ArrayList<>();

		if (user == null) {
			throw new UsernameNotFoundException(email);
		}

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		List<Role> rolelist = user.getRoles();
		for (Role tempRole : rolelist) {

			String roleName = tempRole.getName();
			roles.add(roleName);

		}

		String roless = String.join(",", roles);
		System.out.println(roles);

		grantedAuthorities.add(new SimpleGrantedAuthority(roless));

		return new CustomUserAccountDetail(email, user.getPassword(), grantedAuthorities, user.getUsername(), roless, user.getId());
	}

}
