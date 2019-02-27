package th.co.aware.etda.ws.dopa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import th.co.aware.etda.ws.dopa.model.CustomUserAccountDetail;
import th.co.aware.etda.ws.dopa.service.PostService;
import th.co.aware.etda.ws.dopa.web.form.PostForm;
import th.co.aware.etda.ws.dopa.web.form.RegisterForm;

@Controller
@RequestMapping
public class IndexController {
	
	@Autowired
    private PostService postService;
 
	@GetMapping("/")
    String index(Model model) {
 
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || (auth != null && auth instanceof AnonymousAuthenticationToken)) {
            model.addAttribute("registerForm", new RegisterForm());
            return "index";
        } else {
            // get current user
            CustomUserAccountDetail currentUser = (CustomUserAccountDetail) auth.getPrincipal();
 
            // create post model
            PostForm form = new PostForm();
            form.setUserId(currentUser.getId());
            model.addAttribute("postForm", form);
 
            // list post
            model.addAttribute("posts", postService.listPost(currentUser.getId()));
 
            return "hello";
        }
 
    }
}