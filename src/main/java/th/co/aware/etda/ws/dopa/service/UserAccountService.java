package th.co.aware.etda.ws.dopa.service;

import th.co.aware.etda.ws.dopa.entity.UserAccount;
import th.co.aware.etda.ws.dopa.web.form.RegisterForm;

public interface UserAccountService {
	
	//void create(RegisterForm form, UserRole userRole);
	void create(RegisterForm form);
	
	UserAccount findByEmail(String email);
}
