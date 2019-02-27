package th.co.aware.etda.ws.dopa.web.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import th.co.aware.etda.ws.dopa.entity.UserAccount;
import th.co.aware.etda.ws.dopa.repository.UserAccountRepository;
import th.co.aware.etda.ws.dopa.web.form.RegisterForm;

@Component
public class RegisterValidator implements Validator {
 
    @Autowired
    private UserAccountRepository userRepository;
 
    @Override
    public boolean supports(Class<?> clazz) {
        return RegisterForm.class.equals(clazz);
    }
 
    @Override
    public void validate(Object target, Errors errors) {
        RegisterForm form = (RegisterForm) target;
 
        // Check Password and Re-Password must match.
        if (!form.getPassword().equals(form.getRePassword())) {
            errors.rejectValue("password", null, "Password not same as Re-Password");
            errors.rejectValue("rePassword", null, "Re-Password not same as Password");
        }
 
        // Check Email is not registered.
        UserAccount user = userRepository.findByEmail(form.getEmail());
        if (user != null) {
            errors.rejectValue("email", null, "This email was registered");
        }
    }
 
}