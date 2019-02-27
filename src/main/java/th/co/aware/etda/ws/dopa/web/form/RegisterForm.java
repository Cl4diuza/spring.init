package th.co.aware.etda.ws.dopa.web.form;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
 
public class RegisterForm {
 
    @Length(min = 5, max = 32)
    @Pattern(regexp=".+@.+\\..+", message="Invalid Email")
    private String email;
 
    @Length(min = 5, max = 32)
    private String name;
 
    @Length(min = 5, max = 32)
    private String password;
 
    @Length(min = 5, max = 32)
    private String rePassword;
    
    private String phone;
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getRePassword() {
        return rePassword;
    }
 
    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
    public String toString() {
        return "RegisterForm [email=" + email + ", name=" + name + ", phone =" + phone + ", password=" + password + ", rePassword="
                + rePassword + "]";
    }
 
}