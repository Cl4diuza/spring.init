package th.co.aware.etda.ws.dopa.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;


public class CustomUserAccountDetail extends org.springframework.security.core.userdetails.User {
	private static final long serialVersionUID = 1L;

	private String fullname;
	private String role;
	private String id;

	public CustomUserAccountDetail(String username, String password, boolean enabled, boolean accountNonExpired,
            boolean credentialsNonExpired, boolean accountNonLocked,
            Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

	public CustomUserAccountDetail(String username, String password, Collection<? extends GrantedAuthority> authorities,
            String fullname,String role, String userId) {
        super(username, password, authorities);
        this.fullname = fullname;
        this.role = role;
        this.id = userId;
    }

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
}
