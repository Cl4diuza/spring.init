package th.co.aware.etda.ws.dopa.controller;

import javax.validation.Valid;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
//import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import th.co.aware.etda.ws.dopa.service.UserAccountService;
import th.co.aware.etda.ws.dopa.web.form.RegisterForm;
import th.co.aware.etda.ws.dopa.web.validator.RegisterValidator;

@Controller
public class RegisterController {
 
    //private static final Logger log = LoggerFactory.getLogger(RegisterController.class);
    
    @Autowired
    private RegisterValidator registerValidator;
    @Autowired
    private UserAccountService userService;
 
    @PostMapping("/register")
    String register(@Valid @ModelAttribute("registerForm") RegisterForm registerForm, BindingResult result,
            Model model) {
        //log.info(registerForm.toString());
        System.out.println(registerForm.toString());
        registerValidator.validate(registerForm, result);
        if (result.hasErrors()) {
//            List<ObjectError> allErrors = result.getAllErrors();
//            for (ObjectError objectError : allErrors) {
            	 System.out.println("Error");
//            }
            return "index";
        } else {
            userService.create(registerForm);
            System.out.println("Success");
            return "redirect:login";
        }
 
    }
}